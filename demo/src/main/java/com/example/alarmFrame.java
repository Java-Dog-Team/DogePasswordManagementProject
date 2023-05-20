package com.example;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class alarmFrame{
    private static JLabel alarmLabel = new JLabel("Set reminder time");
    private static JRadioButton oneMonth=new JRadioButton("One month");
    private static JRadioButton threeMonth=new JRadioButton("Three month");
    private static JRadioButton sixMonth=new JRadioButton("Six month");
    public static void main(String[] args) {
        createWindow();
    }
    private static void createWindow() {  
        JFrame alarm = new JFrame("Time reminder setting");
        //設定視窗大小為螢幕的2/3
        alarm.setSize(600,500);
        //設定背景顏色
        alarm.getContentPane().setBackground( Color.WHITE );
        //視窗不可調整大小
        alarm.setResizable(false);
        //設定關閉可以關掉程式
        alarm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alarm.setLayout(null);
        //設置左上角小圖片
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
    private static void createUI(JFrame alarm){
        
        alarmLabel.setFont((new Font("",Font.ITALIC,35)));
        oneMonth.setFont((new Font("",Font.ITALIC,15)));
        threeMonth.setFont((new Font("",Font.ITALIC,15)));
        sixMonth.setFont((new Font("",Font.ITALIC,15 )));

        alarmLabel.setBounds(150, 0,500,100);
        oneMonth.setBounds(110, 80, 130, 20);
        threeMonth.setBounds(110, 120, 130, 20);
        sixMonth.setBounds(110, 160, 130, 20);


        alarm.add(alarmLabel);
        alarm.add(oneMonth);
        alarm.add(threeMonth);
        alarm.add(sixMonth);
    }
}
