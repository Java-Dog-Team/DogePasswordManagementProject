package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Home_screen {
    private static JFrame windowFrame = new JFrame("Home screen");
    private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private static ImageIcon alarmPicture = new ImageIcon("demo\\src\\main\\java\\com\\example\\alarm_clock1.png");
    private static ImageIcon lockPicture = new ImageIcon("demo\\src\\main\\java\\com\\example\\lock1.png");

    private static JLabel alarm = new JLabel(alarmPicture);
    private static JLabel lock = new JLabel(lockPicture);
    private static JPanel contentPane = new JPanel();

    private static JLabel frame_up = new JLabel(" ");
    private static JLabel frame_left = new JLabel(" ");
    private static JLabel frame_right = new JLabel(" ");
    private static JLabel frame_down = new JLabel(" ");

    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        // 設定視窗大小為螢幕的2/3
        windowFrame.setSize(dimension.width * 2 / 3, dimension.height * 2 / 3);
        // 設定背景顏色
        windowFrame.getContentPane().setBackground(Color.WHITE);
        // container.setLayout(new BorderLayout());
        // 設定關閉可以關掉程式
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane.setLayout(null);

        // 設置左上角小圖片
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
        if (imgURL != null) {
            arrowIcon = new ImageIcon(imgURL);
            windowFrame.setIconImage(arrowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(windowFrame, "Icon image not found.");
        }
        putalarm(windowFrame);
        putlock(windowFrame);
        createUI(windowFrame);
        // container.add(alarm,BorderLayout.WEST);
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setVisible(true);

    }

    private static void putalarm(JFrame windowFrame) {
        int w = alarmPicture.getIconWidth();
        int h = alarmPicture.getIconHeight();
        // 縮小鬧鐘
        alarmPicture.setImage(
                alarmPicture.getImage().getScaledInstance((int) (0.15 * w), (int) (0.15 * h), Image.SCALE_DEFAULT));
        alarm.setBounds(20, 190, 80, 80);
        contentPane.add(alarm);
        windowFrame.add(contentPane);
    }

    private static void putlock(JFrame windowFrame) {
        int w = lockPicture.getIconWidth();
        int h = lockPicture.getIconHeight();
        // 縮小鎖
        lockPicture.setImage(
                lockPicture.getImage().getScaledInstance((int) (0.15 * w), (int) (0.15 * h), Image.SCALE_DEFAULT));
        lock.setBounds(20, 10, 80, 80);
        contentPane.add(lock);
        windowFrame.add(contentPane);
    }

    private static void createUI(JFrame windowFrame) {
        yellow_frame(windowFrame);
    }

    private static void yellow_frame(JFrame windowFrame) {
        // 設定Lebel為不透明
        frame_up.setOpaque(true);
        frame_left.setOpaque(true);
        frame_right.setOpaque(true);
        frame_down.setOpaque(true);
        // 設定Lebel顏色
        frame_up.setBackground(Color.orange);
        frame_left.setBackground(Color.orange);
        frame_right.setBackground(Color.orange);
        frame_down.setBackground(Color.orange);
        // 設定大小
        frame_up.setFont((new Font("", 0, 20)));
        frame_left.setFont((new Font("", 0, 100)));
        frame_right.setFont((new Font("", 0, 100)));
        frame_down.setFont((new Font("", 0, 20)));
        // 加入windowFrame
        windowFrame.add(frame_up, BorderLayout.NORTH);
        windowFrame.add(frame_left, BorderLayout.WEST);
        windowFrame.add(frame_right, BorderLayout.EAST);
        windowFrame.add(frame_down, BorderLayout.SOUTH);
    }
}