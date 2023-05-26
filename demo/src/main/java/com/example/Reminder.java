package com.example;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Reminder extends main_page {
    public JLabel mainLabel = new JLabel();
    private static Image dogImage = new ImageIcon("demo\\src\\picture\\dogdogdog.png").getImage();
    private static ImageIcon dogIcon = new ImageIcon();
    private static JLabel dog1;
    private static JLabel dog2;
    private static JLabel alarmLabel = new JLabel("Set reminder time");
    private static JLabel directionsLabel = new JLabel("Choose how often you want to be reminded.");
    private static JLabel informLabel = new JLabel("Choose to be notified by phone message or email or both.");

    private static JRadioButton oneMonth;
    private static JRadioButton threeMonth;
    private static JRadioButton sixMonth;
    private static ButtonGroup radioGroup = new ButtonGroup();
    private static JRadioButton email;
    private static JRadioButton phone;
    private static JButton confirm = new JButton("confirm", dogIcon);
    public JButton addPasswardButton = new JButton(new ImageIcon("demo\\src\\picture\\addPassward.png"));

    private String username;
    private String phoneNum;

    public Reminder(JLabel mainLabel, String username, String phoneNum) {

        this.mainLabel = mainLabel;

        this.username = username;
        this.phoneNum = phoneNum;

        // 事件設定
        ButtonActionListener Bhandler = new ButtonActionListener();
        confirm.addActionListener(Bhandler);
        // 圖片設定
        dogImage = dogImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        dogIcon.setImage(dogImage);
        dog1 = new JLabel(dogIcon);
        dog2 = new JLabel(dogIcon);
    }

    public void createReminder(JPanel passwardJPanel) {
        // 移除當前 Panel 內的所有物件
        // 這放要改panel的函式的最前面
        passwardJPanel.removeAll();
        passwardJPanel.repaint();
        // 重置選擇
        oneMonth = new JRadioButton("One week");
        threeMonth = new JRadioButton("Two week");
        sixMonth = new JRadioButton("Three week");

        oneMonth.setActionCommand("1");
        threeMonth.setActionCommand("3");
        sixMonth.setActionCommand("6");

        email = new JRadioButton("By email");
        phone = new JRadioButton("By phone message");

        // passwardJPanel.setBackground(Color.BLACK);
        // passwardJPanel.setLayout(null);
        // passwardJPanel.setBackground(Color.WHITE);
        passwardJPanel.setLayout(null);
        // 字型大小設定
        alarmLabel.setFont((new Font("", Font.BOLD, 35)));
        directionsLabel.setFont((new Font("", Font.ITALIC, 15)));
        informLabel.setFont((new Font("", Font.ITALIC, 15)));
        oneMonth.setFont((new Font("", Font.ITALIC, 15)));
        threeMonth.setFont((new Font("", Font.ITALIC, 15)));
        sixMonth.setFont((new Font("", Font.ITALIC, 15)));
        email.setFont((new Font("", Font.ITALIC, 15)));
        phone.setFont((new Font("", Font.ITALIC, 15)));

        // 位置大小設定
        alarmLabel.setBounds(230, 0, 500, 100);// 80
        directionsLabel.setBounds(230, 80, 300, 30);
        dog1.setBounds(196, 83, 20, 20);
        oneMonth.setBounds(320, 120, 120, 30);
        threeMonth.setBounds(320, 160, 130, 30);
        sixMonth.setBounds(320, 200, 130, 30);
        informLabel.setBounds(200, 205, 500, 100);
        dog2.setBounds(166, 243, 20, 20);
        email.setBounds(320, 275, 200, 30);
        phone.setBounds(320, 310, 200, 30);
        confirm.setBounds(320, 370, 110, 30);

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

        passwardJPanel.add(alarmLabel);
        passwardJPanel.add(dog1);
        passwardJPanel.add(directionsLabel);
        passwardJPanel.add(oneMonth);
        passwardJPanel.add(threeMonth);
        passwardJPanel.add(sixMonth);
        passwardJPanel.add(informLabel);
        passwardJPanel.add(dog2);
        passwardJPanel.add(email);
        passwardJPanel.add(phone);
        passwardJPanel.add(confirm);
        // 這放要改panel的函式的最後面
        passwardJPanel.revalidate();
    }

    private class ButtonActionListener implements ActionListener {

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

            long duration = Integer.valueOf(radioGroup.getSelection().getActionCommand()) * 604800;

            Post(String.valueOf(duration), username, phoneNum);

        }
    }

    // 將資訊上傳給雲端計時器開始計時
    private static void Post(String duration, String username, String phone) {
        String serverUrl = "https://dark-pink-cougar-sari.cyclic.app/schedule";
        try {
            String encodedUrl = serverUrl + "?duration=" + URLEncoder.encode(duration, "UTF-8")
                    + "&username=" + URLEncoder.encode(username, "UTF-8")
                    + "&phone=" + URLEncoder.encode(phone, "UTF-8");

            URL url = new URL(encodedUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // System.out.println("Response: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
