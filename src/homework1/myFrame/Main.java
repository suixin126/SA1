package homework1.myFrame;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
        panel.setBounds(100,50,1300,1200);
        Border border = new LineBorder(Color.pink,5);
        panel.setBorder(border);
        panel.setLayout(cardLayout);
        frame.getContentPane().add(panel);



        // 创建JButton
        JButton button0 = new JButton("总代码结构");
        JButton button5 = new JButton("选择文件");
        JButton button6 = new JButton("主程序-子程序(KWIC)");
        JButton button7 = new JButton("面向对象(KWIC)");
        JButton button8 = new JButton("事件系统(KWIC)");
        JButton button9 = new JButton("管道-过滤器(KWIC)");

        button0.setBounds(0,0,200,30);
        button5.setBounds(1100,0,200,30);
        button6.setBounds(220,0,200,30);
        button7.setBounds(440,0,200,30);
        button8.setBounds(660,0,200,30);
        button9.setBounds(880,0,200,30);

        frame.add(button0);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        // 方式运转
        final Ways[] ways = new Ways[1];
        // 添加按钮事件
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
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                P0 p0 = new P0();
                panel.add(p0, "p0");
                cardLayout.show(panel, "p0");
            }
        }
        );
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
                ways[0] = new SecondWay();
                P6 p6 = new P6(filePath[0], ways[0]);
                panel.add(p6,"p6");
                cardLayout.show(panel,"p6");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new ThirdWay();
                P7 p7 = new P7(filePath[0], ways[0]);
                panel.add(p7,"p7");
                cardLayout.show(panel,"p7");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ways[0] = new FourthWay();
                P8 p8 = new P8(filePath[0], ways[0]);
                panel.add(p8,"p8");
                cardLayout.show(panel,"p8");
            }
        });

        // 设置窗口可见
        frame.setVisible(true);
    }
}
