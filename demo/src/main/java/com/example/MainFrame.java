package com.example;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("滾動條示例");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 創建容器Panel
        JPanel containerPanel = new JPanel(new BorderLayout());

        // 創建內部Panel
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

        // 向內部Panel添加一些組件
        for (int i = 1; i <= 20; i++) {
            innerPanel.add(new JLabel("Label " + i));
        }

        // 創建JScrollPane並將內部Panel添加到其中
        JScrollPane scrollPane = new JScrollPane(innerPanel);

        // 設置滾動條顯示策略
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // 將JScrollPane添加到容器Panel的中央位置
        containerPanel.add(scrollPane, BorderLayout.CENTER);

        // 將容器Panel添加到主Frame中
        add(containerPanel, BorderLayout.CENTER);

        // pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
