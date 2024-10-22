package C_S_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server{

    private static List<Contact> contacts_server = new ArrayList<>();
    private static String message;
    private static String way;
    private static int size = 0;

    private static List<String> messages = new ArrayList<>();

    static class ServerThread extends Thread{
        private ServerSocket serverSocket;
        public ServerThread(int port) throws IOException {
            this.serverSocket = new ServerSocket(port);
        }
        public void run(){
            try{
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
                    while ((message = in.readLine()) != null){
                        System.out.println("收到客户端消息：" + message);
                        messages.add(message);
                        size ++;
                        String[] str = message.split("/");
                        way = str[0];
                        if(way.equals("添加联系人")){
                            String name = str[1];
                            String address = str[2];
                            String phone = str[3];
                        }

                        if(way.equals("删除联系人")){
                            String name = str[1];
                        }

                        if(way.equals("修改联系人")){
                            String name = str[1];
                            String address = str[2];
                            String phone = str[3];
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                System.out.println("连接断开");
            }
        }
    }

    static class ClientThread extends Thread{
        private String serverAddress;
        private int serverPort;
        private volatile boolean running = true;

        public ClientThread(String serverAddress, int serverPort) {
            this.serverAddress = serverAddress;
            this.serverPort = serverPort;
        }
        @Override
        public void run(){
            try{
                Socket socket = new Socket("localhost",1234);

                ObjectInputStream cIn = new ObjectInputStream(socket.getInputStream());
                PrintWriter cOut = new PrintWriter(socket.getOutputStream(),true);

                contacts_server = (ArrayList<Contact>)cIn.readObject();

                while (true){
                    if(messages.size() != 0){
                        System.out.println(messages.get(messages.size() - 1));
                        cOut.println(messages.get(messages.size() - 1));
                    }
                    Thread.sleep(3000);
                }
            }catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("作为客户端连接断开");
            }
        }
    }

    public static void main(String[] args) {
        int serverPort = 12345;
        int clientPort = 1234;
        String address = "localhost";
        try{
            Thread clientThread = new ClientThread(address,clientPort);
            clientThread.start();

            Thread serverThread = new ServerThread(serverPort);
            serverThread.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
