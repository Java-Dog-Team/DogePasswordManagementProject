package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class alarmFrame {
    private static Image dogImage = new ImageIcon(SwingTester.class.getResource("dogdogdog.png")).getImage();
    private static ImageIcon dogIcon = new ImageIcon();
    private static JLabel dog1;
    private static JLabel dog2;
    private static JLabel alarmLabel = new JLabel("Set reminder time");
    private static JLabel directionsLabel = new JLabel("Choose how often you want to be reminded.");
    private static JLabel informLabel = new JLabel("Choose to be notified by phone message or email or both.");
    private static JRadioButton oneMonth = new JRadioButton("One month");
    private static JRadioButton threeMonth = new JRadioButton("Three month");
    private static JRadioButton sixMonth = new JRadioButton("Six month");
    private static ButtonGroup radioGroup = new ButtonGroup();
    private static JRadioButton email = new JRadioButton("By email");
    private static JRadioButton phone = new JRadioButton("By phone message");
    private static JButton confirm = new JButton("confirm", dogIcon);

    public static void run(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame alarm = new JFrame("Time reminder setting");
        // 設定視窗大小為螢幕的2/3
        alarm.setSize(600, 500);
        // 設定背景顏色
        alarm.getContentPane().setBackground(Color.WHITE);
        // 視窗不可調整大小
        alarm.setResizable(false);
        // 設定關閉可以關掉程式
        alarm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alarm.setLayout(null);
        // 圖片設定
        dogImage = dogImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        dogIcon.setImage(dogImage);
        dog1 = new JLabel(dogIcon);
        dog2 = new JLabel(dogIcon);
        // 事件設定
        ButtonActionListener Bhandler = new ButtonActionListener();
        confirm.addActionListener(Bhandler);

        // 設置左上角小圖片
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
        if (imgURL != null) {
            arrowIcon = new ImageIcon(imgURL);
            alarm.setIconImage(arrowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(alarm, "Icon image not found.");
        }
        alarm.setLocationRelativeTo(null);
        alarm.setVisible(true);
        createUI(alarm);
    }

    private static void createUI(JFrame alarm) {
        // 字型大小設定
        alarmLabel.setFont((new Font("", Font.ITALIC, 35)));
        directionsLabel.setFont((new Font("", Font.ITALIC, 15)));
        informLabel.setFont((new Font("", Font.ITALIC, 15)));
        oneMonth.setFont((new Font("", Font.ITALIC, 15)));
        threeMonth.setFont((new Font("", Font.ITALIC, 15)));
        sixMonth.setFont((new Font("", Font.ITALIC, 15)));
        email.setFont((new Font("", Font.ITALIC, 15)));
        phone.setFont((new Font("", Font.ITALIC, 15)));

        // 位置大小設定
        alarmLabel.setBounds(150, 0, 500, 100);
        directionsLabel.setBounds(150, 80, 300, 30);
        dog1.setBounds(116, 83, 20, 20);
        oneMonth.setBounds(240, 120, 120, 30);
        threeMonth.setBounds(240, 160, 130, 30);
        sixMonth.setBounds(240, 200, 130, 30);
        informLabel.setBounds(120, 205, 500, 100);
        dog2.setBounds(86, 243, 20, 20);
        email.setBounds(240, 275, 200, 30);
        phone.setBounds(240, 310, 200, 30);
        confirm.setBounds(240, 370, 110, 30);

        // 背景顏色設定
        oneMonth.setBackground(null);
        threeMonth.setBackground(null);
        sixMonth.setBackground(null);
        email.setBackground(null);
        phone.setBackground(null);

        // radioGroup擇一選擇
        radioGroup.add(oneMonth);
        radioGroup.add(threeMonth);
        radioGroup.add(sixMonth);

        alarm.add(alarmLabel);
        alarm.add(dog1);
        alarm.add(directionsLabel);
        alarm.add(oneMonth);
        alarm.add(threeMonth);
        alarm.add(sixMonth);
        alarm.add(informLabel);
        alarm.add(dog2);
        alarm.add(email);
        alarm.add(phone);
        alarm.add(confirm);
    }

    private static class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!(oneMonth.isSelected()) && !(threeMonth.isSelected()) && !(sixMonth.isSelected())
                    && !(email.isSelected()) && !(phone.isSelected())) {
                JOptionPane.showMessageDialog(null, "您沒有選擇任何選項", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (!(oneMonth.isSelected()) && !(threeMonth.isSelected()) && !(sixMonth.isSelected())) {
                JOptionPane.showMessageDialog(null, "請選擇您想要多久提醒一次更換密碼", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (!(email.isSelected()) && !(phone.isSelected())) {
                JOptionPane.showMessageDialog(null, "請選擇要以手機簡訊或是電子郵件傳送提醒", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }

        }
    }
}
