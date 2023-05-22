package com.example;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class Reminder extends main_page{
    public JLabel mainLabel=new JLabel();
    private static Image dogImage=new ImageIcon("demo\\src\\picture\\dogdogdog.png").getImage();
    private static ImageIcon dogIcon=new ImageIcon();
    private static JLabel dog1;
    private static JLabel dog2;
    private static JLabel alarmLabel = new JLabel("Set reminder time");
    private static JLabel directionsLabel = new JLabel("Choose how often you want to be reminded.");
    private static JLabel informLabel = new JLabel("Choose to be notified by phone message or email or both.");
    private static JRadioButton oneMonth=new JRadioButton("One month");
    private static JRadioButton threeMonth=new JRadioButton("Three month");
    private static JRadioButton sixMonth=new JRadioButton("Six month");
    private static ButtonGroup radioGroup=new ButtonGroup();
    private static JRadioButton email=new JRadioButton("By email");
    private static JRadioButton phone=new JRadioButton("By phone message");
    private static JButton confirm=new JButton("confirm", dogIcon);
    public JButton addPasswardButton =new JButton(new ImageIcon("demo\\src\\picture\\addPassward.png"));
    
    public Reminder(JLabel mainLabel){
        this.mainLabel=mainLabel;
    }
    public void createReminder(JPanel passwardJPanel){
        passwardJPanel.setBackground(Color.ORANGE);

        //字型大小設定
        alarmLabel.setFont((new Font("",Font.ITALIC,35)));
        directionsLabel.setFont((new Font("",Font.ITALIC,15)));
        informLabel.setFont((new Font("",Font.ITALIC,15)));
        oneMonth.setFont((new Font("",Font.ITALIC,15)));
        threeMonth.setFont((new Font("",Font.ITALIC,15)));
        sixMonth.setFont((new Font("",Font.ITALIC,15 )));
        email.setFont((new Font("",Font.ITALIC,15 )));
        phone.setFont((new Font("",Font.ITALIC,15 )));

        //位置大小設定
        alarmLabel.setBounds(150, 0,500,100);
        directionsLabel.setBounds(150, 80,300,30);
        dog1.setBounds(116, 83,20,20);
        oneMonth.setBounds(240, 120, 120, 30);
        threeMonth.setBounds(240, 160, 130, 30);
        sixMonth.setBounds(240, 200, 130, 30);
        informLabel.setBounds(120, 205,500,100);
        dog2.setBounds(86, 243,20,20);
        email.setBounds(240, 275, 200, 30);
        phone.setBounds(240, 310, 200, 30);
        confirm.setBounds(240, 370, 110, 30);
    
        //背景顏色設定
        oneMonth.setBackground(null);
        threeMonth.setBackground(null);
        sixMonth.setBackground(null);
        email.setBackground(null);
        phone.setBackground(null);
         
        //radioGroup擇一選擇
        radioGroup.add(oneMonth);
        radioGroup.add(threeMonth);
        radioGroup.add(sixMonth);

        // rPanel.add(alarmLabel);
        // rPanel.add(dog1);
        // rPanel.add(directionsLabel);
        // rPanel.add(oneMonth);
        // rPanel.add(threeMonth);
        // rPanel.add(sixMonth);
        // rPanel.add(informLabel);
        // rPanel.add(dog2);
        // rPanel.add(email);
        // rPanel.add(phone);
        // rPanel.add(confirm);
    }
    // public void creatAddPasswardButton(JPanel addJPanel){
    //     ButtonHandler handler=new ButtonHandler();//加入密碼的buttonHandler
    //     //設定button
    //     addPasswardButton.setPreferredSize(new Dimension(57, 54));//大小
    //     addPasswardButton.addActionListener(handler);//ActionListener
    //     //設定 Button 的 pannel
    //     addJPanel.setLayout(new BorderLayout());
    //     addJPanel.setBackground(Color.WHITE);
    //     addJPanel.add(addPasswardButton,BorderLayout.SOUTH);
    //     addJPanel.setVisible(true);
    //     this.mainLabel.add(addJPanel,BorderLayout.EAST);
    // }
    // private class ButtonHandler implements ActionListener{
    //     @Override
    //     public void actionPerformed(ActionEvent e){
    //         //彈出加入新密碼的視窗
    //         JFrame addNewPasswardFrame=new JFrame("加入新密碼");
    //         addNewPasswardFrame.setSize(300, 300);
    //         addNewPasswardFrame.setLocationRelativeTo(null);//視窗出現在中間
    //         addNewPasswardFrame.setResizable(false);
    //         addNewPasswardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//只關閉當前視窗
    //         JLabel label = new JLabel("新窗口");
    //         addNewPasswardFrame.add(label);
    //         addNewPasswardFrame.setVisible(true);
    //     }
    // }
}
