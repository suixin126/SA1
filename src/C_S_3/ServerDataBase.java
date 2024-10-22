package C_S_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServerDataBase {
    // JDBC驱动名及数据库URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db1?useSSL=false&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置修改
    static final String USER = "root";
    static final String PASS = "123456";

    static List<Contact> contacts_server = new ArrayList<>();

    public static void main(String[] args) {
        // 连接数据库
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行查询
            stmt = conn.createStatement();
            String sql = "SELECT name, address, phone FROM contact";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while (rs.next()) {

                // 通过字段检索
                String name  = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                Contact contact = new Contact(name,address,phone);
                contacts_server.add(contact);

                // 输出数据
                System.out.print("名字: " + name);
                System.out.print("，地址: " + address);
                System.out.println("，电话: " + phone);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        int port = 1234; // 服务器监听的端口
        boolean isExist = false; // 是否存在
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                // 接受客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端已连接");

                // 获取输入和输出流
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(contacts_server);
                out.flush();

                // 读取客户端发送的消息
                String message;
                while ((message = in.readLine()) != null){
                    System.out.println("收到客户端消息：" + message);
                    String[] str = message.split("/");
                    String way = str[0];

                    if(way.equals("添加联系人")){
                        String name = str[1];
                        String address = str[2];
                        String phone = str[3];

                        // 判断是否存在
                        for (Contact contact:
                             contacts_server) {
                            isExist = false;
                            if(contact.name.equals(name)){
                                isExist = true;
                                break;
                            }
                        }

                        if(!isExist) {
                            contacts_server.add(new Contact(name,address,phone));
                            String sql = "INSERT INTO contact (name, address, phone) VALUES (?, ?, ?)";
                            PreparedStatement pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1, name);
                            pstmt.setString(2, address);
                            pstmt.setString(3, phone); // 注意：在实际应用中，密码应该加密存储

                            // 执行插入操作
                            int rowsAffected = pstmt.executeUpdate();
                            if (rowsAffected > 0) {
                                System.out.println("A new user was inserted successfully!");
                            }
                            pstmt.close();
                        }
                    }

                    if(way.equals("删除联系人")){
                        String name = str[1];
                        String sql = "DELETE FROM contact WHERE name = ?";

                        PreparedStatement preparedStatement = conn.prepareStatement(sql);

                        preparedStatement.setString(1, name);

                        int rowsDeleted = preparedStatement.executeUpdate();

                        if (rowsDeleted > 0) {
                            System.out.println("A row with the specified column value was deleted.");
                        }
                        preparedStatement.close();
                    }

                    if(way.equals("修改联系人")){
                        String name = str[1];
                        String address = str[2];
                        String phone = str[3];

                        String sql = "UPDATE contact SET address = ?, phone = ? WHERE name = ?";

                        PreparedStatement preparedStatement = conn.prepareStatement(sql);

                        preparedStatement.setString(1, address);
                        preparedStatement.setString(2, phone); // Assuming column2 is of type INT
                        preparedStatement.setString(3, name);

                        int rowsUpdated = preparedStatement.executeUpdate();

                        if (rowsUpdated > 0) {
                            System.out.println("A row with the specified condition was updated.");
                        } else {
                            System.out.println("No row was updated.");
                        }
                        preparedStatement.close();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("ServerDataBase连接断开");
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
