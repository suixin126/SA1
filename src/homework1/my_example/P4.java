package homework1.my_example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

import static homework1.my_example.Main.getContent;

public class P4 extends JPanel {

    public P4(String filePath,Ways ways){
        setLayout(null);
        // 内容信息
        JLabel jLabel2 = new JLabel("面向对象方法处理前的文件内容：");
        JLabel jLabel2_1 = new JLabel(Arrays.toString(getContent(filePath)));
        JLabel jLabel2_2 = new JLabel("面向对象方法处理后的文件内容：");
        JLabel jLabel2_3 = new JLabel(Arrays.toString(getContent(filePath)));
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
        JLabel jLabel2_5 = new JLabel("public void input(String fileName)");
        JLabel jLabel2_6 = new JLabel("public void output(String fileName)");
        JLabel jLabel2_7 = new JLabel("public void mySort()");

        jLabel2_4.setBounds(0,300,300,40);
        jLabel2_5.setBounds(0,350,300,40);
        jLabel2_6.setBounds(0,400,300,40);
        jLabel2_7.setBounds(0,450,300,40);

        jLabel2_4.setFont(new Font("宋体",Font.BOLD,14));
        jLabel2_5.setFont(new Font("宋体",Font.BOLD,14));
        jLabel2_6.setFont(new Font("宋体",Font.BOLD,14));
        jLabel2_7.setFont(new Font("宋体",Font.BOLD,14));

        jLabel2_4.setForeground(Color.BLUE);
        jLabel2_5.setForeground(Color.BLUE);
        jLabel2_6.setForeground(Color.BLUE);
        jLabel2_7.setForeground(Color.BLUE);

        add(jLabel2_4);
        add(jLabel2_5);
        add(jLabel2_6);
        add(jLabel2_7);

        // 原理信息
        JLabel jLabel2_8 = new JLabel("原理图：");
        JLabel jLabel2_9 = new JLabel(new ImageIcon("C:\\houduanstudy\\java\\SA\\untitled\\resource\\P2.png"));
        jLabel2_8.setBounds(400,0,500,40);
        jLabel2_8.setForeground(Color.RED);
        jLabel2_8.setFont(new Font("宋体",Font.BOLD,22));
        jLabel2_9.setBounds(400,50,800,300);
        add(jLabel2_8);
        add(jLabel2_9);

        // 源程序代码结构
        JLabel jLabel2_10 = new JLabel("源程序代码结构：");
        JLabel jLabel2_11 = new JLabel(new ImageIcon("C:\\houduanstudy\\java\\SA\\untitled\\resource\\P2.png"));
        jLabel2_10.setBounds(400,450,500,40);
        jLabel2_10.setForeground(Color.GREEN);
        jLabel2_10.setFont(new Font("宋体",Font.BOLD,22));
        jLabel2_11.setBounds(400,550,800,300);
        add(jLabel2_10);
        add(jLabel2_11);
    }

}
