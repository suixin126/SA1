package homework1.myFrame;

import javax.swing.*;

public class P0 extends JPanel {
    public P0() {
        setLayout(null);
        // 内容信息
        JLabel jLabel1 = new JLabel("源代码总体结构：");
        JLabel jLabel2 = new JLabel(new ImageIcon("C:\\houduanstudy\\java\\SA\\untitled\\resource\\P0.png"));
        jLabel1.setBounds(0, 0, 300, 40);
        jLabel2.setBounds(400,50,500,600);
        add(jLabel1);
        add(jLabel2);
    }
}
