package homework1.myFrame;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class P8 extends JPanel {
    public P8(String filePath, Ways ways){
        ArrayList<String> contents = new GetFileContent().getFileContent(filePath);
        setLayout(null);
        // 内容信息
        JLabel jLabel2 = new JLabel("面向对象方法处理前的文件内容：");
        JLabel jLabel2_1 = new JLabel(contents.toString());
        JLabel jLabel2_2 = new JLabel("面向对象方法处理后的文件内容：");
        JLabel jLabel2_3 = new JLabel(contents.toString());
        jLabel2.setBounds(0,0,300,40);
        jLabel2_1.setBounds(0,50,300,40);
        add(jLabel2);
        add(jLabel2_1);

        ways.processWay(filePath);
        jLabel2_2.setBounds(0,100,300,40);
        jLabel2_3.setBounds(0,150,300,40);
        add(jLabel2_2);
        add(jLabel2_3);
        // 代码信息
        JLabel jLabel2_4 = new JLabel("关键函数:");
        JLabel jLabel2_5 = new JLabel("public void input()");
        JLabel jLabel2_6 = new JLabel("public void output()");
        JLabel jLabel2_7 = new JLabel("public void shift()");
        JLabel jLabel2_7_1 = new JLabel("public void sort()");

        jLabel2_4.setBounds(0,340,300,40);
        jLabel2_5.setBounds(0,390,300,40);
        jLabel2_6.setBounds(0,440,300,40);
        jLabel2_7.setBounds(0,490,300,40);
        jLabel2_7_1.setBounds(0,540,300,40);

        jLabel2_4.setFont(new Font("宋体",Font.BOLD,14));
        jLabel2_5.setFont(new Font("宋体",Font.BOLD,14));
        jLabel2_6.setFont(new Font("宋体",Font.BOLD,14));
        jLabel2_7.setFont(new Font("宋体",Font.BOLD,14));
        jLabel2_7_1.setFont(new Font("宋体",Font.BOLD,14));

        jLabel2_4.setForeground(Color.BLUE);
        jLabel2_5.setForeground(Color.BLUE);
        jLabel2_6.setForeground(Color.BLUE);
        jLabel2_7.setForeground(Color.BLUE);
        jLabel2_7_1.setForeground(Color.BLUE);

        add(jLabel2_4);
        add(jLabel2_5);
        add(jLabel2_6);
        add(jLabel2_7);
        add(jLabel2_7_1);

        // 原理信息
        JLabel jLabel2_8 = new JLabel("原理图：");
        JLabel jLabel2_9 = new JLabel(new ImageIcon("C:\\houduanstudy\\java\\SA\\untitled\\resource\\P8.png"));
        jLabel2_8.setBounds(400,0,500,40);
        jLabel2_8.setForeground(Color.RED);
        jLabel2_8.setFont(new Font("宋体",Font.BOLD,22));
        jLabel2_9.setBounds(400,50,800,300);
        add(jLabel2_8);
        add(jLabel2_9);

        // 源程序代码结构
        JLabel jLabel2_10 = new JLabel("源程序代码结构：");
        JLabel jLabel2_11 = new JLabel(new ImageIcon("C:\\houduanstudy\\java\\SA\\untitled\\resource\\P4.png"));
        jLabel2_10.setBounds(400,450,500,40);
        jLabel2_10.setForeground(Color.GREEN);
        jLabel2_10.setFont(new Font("宋体",Font.BOLD,22));
        jLabel2_11.setBounds(400,550,800,300);
        add(jLabel2_10);
        add(jLabel2_11);
    }
}
