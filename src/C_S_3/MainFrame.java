package C_S_3;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame {
    private DefaultTableModel tableModel;
    private List<Contact> contacts = new ArrayList<>();
    private ObjectInputStream in;
    private PrintWriter out;
    // 连接数据库

    private Socket socket;

    public MainFrame() {

        String hostname = "localhost"; // 服务器的主机名或IP地址
        int port = 12345; // 服务器监听的端口

        try {
            socket = new Socket(hostname, port);
            System.out.println("已连接到服务器");

            // 获取输入和输出流
            in = new ObjectInputStream(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            //  读取服务器的响应
            //  接收ArrayList对象
            contacts = (ArrayList<Contact>) in.readObject();

            // 打印接收到的ArrayList
            for (Contact contact : contacts) {
                System.out.println(contact.name);
            }


            setTitle("个人通讯录系统");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            tableModel = new DefaultTableModel(new String[]{"姓名", "住址", "电话"}, 0);
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 2));

            JTextField nameField = new JTextField(20);
            JTextField addressField = new JTextField(20);
            JTextField phoneField = new JTextField(20);

            JButton addButton = new JButton("添加");
            JButton updateButton = new JButton("修改");
            JButton deleteButton = new JButton("删除");

            panel.add(new JLabel("姓名:"));
            panel.add(nameField);
            panel.add(new JLabel("住址:"));
            panel.add(addressField);
            panel.add(new JLabel("电话:"));
            panel.add(phoneField);
            panel.add(addButton);
            panel.add(updateButton);
            panel.add(deleteButton);

            add(scrollPane, BorderLayout.CENTER);
            add(panel, BorderLayout.SOUTH);

            refreshTable();
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String address = addressField.getText();
                    String phone = phoneField.getText();
                    addContact(name,address,phone);
                    out.println("添加联系人/" + name + "/" + address + "/" + phone);
                    nameField.setText("");
                    addressField.setText("");
                    phoneField.setText("");
                }
            });

            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        String selectName = (String) tableModel.getValueAt(selectedRow,0);
                        String address = addressField.getText();
                        String phone = phoneField.getText();
                        out.println("修改联系人/" + selectName + "/" + address + "/" + phone);
                        updateContact(selectedRow, nameField.getText(), addressField.getText(), phoneField.getText());
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        String name = (String) tableModel.getValueAt(selectedRow,0);
                        out.println("删除联系人/" + name);
                        deleteContact(selectedRow);
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void addContact(String name, String address, String phone) {
        System.out.println("添加联系人");
        contacts.add(new Contact(name, address, phone));
        refreshTable();
    }

    private void updateContact(int row, String name, String address, String phone) {
        System.out.println("修改联系人");
        System.out.println("name：" + name);
        System.out.println("address：" + address);
        System.out.println("phone：" + phone);
        String nowName = (String) tableModel.getValueAt(row,0);
        for(int i = contacts.size() - 1; i >= 0; i --){
            if(contacts.get(i).name.equals(nowName)){
                contacts.get(i).name = name;
                contacts.get(i).address = address;
                contacts.get(i).phone = phone;
            }
        }
        refreshTable();
    }

    private void deleteContact(int row) {
        System.out.println("删除联系人");
        String name = (String) tableModel.getValueAt(row,0);
        for(int i = contacts.size() - 1; i >= 0; i --){
            if(contacts.get(i).name.equals(name)){
                contacts.remove(i);
            }
        }
        refreshTable();
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Contact contact : contacts) {
            tableModel.addRow(new Object[]{contact.name, contact.address, contact.phone});
        }
    }
}
