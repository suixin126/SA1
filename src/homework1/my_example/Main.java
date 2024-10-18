package homework1.my_example;


import homework1.my_example.demo1.FirstWay;
import homework1.my_example.demo2.SecondWay;
import homework1.my_example.demo3.ThirdWay;
import homework1.my_example.demo4.FourthWay;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        final String[] filePath = new String[1];
        CardLayout cardLayout = new CardLayout();
        // 创建一个新的JFrame窗口
        JFrame frame = new JFrame("体系结构风格");
        frame.setSize(1500, 1000); // 设置窗口大小
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
        frame.setLayout(null);

        // 显示内容界面
        JPanel panel = new JPanel();
        panel.setBounds(100,100,1300,900);
        Border border = new LineBorder(Color.pink,5);
        panel.setBorder(border);
        panel.setLayout(cardLayout);
        frame.getContentPane().add(panel);



        // 创建JButton
        JButton button1 = new JButton("主程序-子程序(MySort)");
        JButton button2 = new JButton("面向对象(MySort)");
        JButton button3 = new JButton("事件系统(MySort)");
        JButton button4 = new JButton("管道-过滤器(MySort)");
        JButton button5 = new JButton("选择文件");
        JButton button6 = new JButton("主程序-子程序(KWIC)");
        JButton button7 = new JButton("面向对象(KWIC)");
        JButton button8 = new JButton("事件系统(KWIC)");
        JButton button9 = new JButton("管道-过滤器(KWIC)");

        button1.setBounds(220, 0, 200, 30); // 设置按钮的位置和大小
        button2.setBounds(440, 0, 200, 30); // 设置按钮的位置和大小
        button3.setBounds(660, 0, 200, 30); // 设置按钮的位置和大小
        button4.setBounds(880, 0, 200, 30); // 设置按钮的位置和大小
        button5.setBounds(1100,30,200,30);
        button6.setBounds(220,50,200,30);
        button7.setBounds(440,50,200,30);
        button8.setBounds(660,50,200,30);
        button9.setBounds(880,50,200,30);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        // 方式运转
        final Ways[] ways = new Ways[1];
        // 添加按钮事件
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new FirstWay();
                P1 p1 = new P1(filePath[0], ways[0]);
                panel.add(p1,"p1");
                cardLayout.show(panel,"p1");
            }
        });
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new SecondWay();
                P2 p2 = new P2(filePath[0], ways[0]);
                panel.add(p2,"p2");
                cardLayout.show(panel,"p2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new ThirdWay();
                P3 p3 = new P3(filePath[0], ways[0]);
                panel.add(p3,"p3");
                cardLayout.show(panel,"p3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new FirstWay();
                P4 p4 = new P4(filePath[0], ways[0]);
                panel.add(p4,"p4");
                cardLayout.show(panel,"p4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("选择文件");
                int returnValue = fileChooser.showOpenDialog(frame);

                if(returnValue == JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();
                    filePath[0] = selectedFile.getPath();
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new FirstWay();
                P5 p5 = new P5(filePath[0], ways[0]);
                panel.add(p5,"p5");
                cardLayout.show(panel,"p5");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new FirstWay();
                P6 p6 = new P6(filePath[0], ways[0]);
                panel.add(p6,"p6");
                cardLayout.show(panel,"p6");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new FirstWay();
                P7 p7 = new P7(filePath[0], ways[0]);
                panel.add(p7,"p7");
                cardLayout.show(panel,"p7");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new FirstWay();
                P8 p8 = new P8(filePath[0], ways[0]);
                panel.add(p8,"p8");
                cardLayout.show(panel,"p8");
            }
        });

        // 设置窗口可见
        frame.setVisible(true);
    }
    // 获取文件内容
    public static String[] getContent(String fileName){
        String[] words = new String[0];
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            words = line.split(" ");
        }catch (Exception e){
            e.printStackTrace();
        }
        return words;
    }
}
