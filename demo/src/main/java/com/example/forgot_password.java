package com.example;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;
public class forgot_password extends JFrame{
    private static JButton confirm = new JButton("Confirm");
    private static JButton sendNewpassword = new JButton("Send new password");
    private static JLabel email = new JLabel("Enter your account(email):");
    private static JLabel passWord = new JLabel("Enter your password:");
    
    //帳號輸入
    private static JTextField emailText=new JTextField(null, "", 0);
    private static JPasswordField passWordText=new JPasswordField(null, "", 0);
    public forgot_password(){
        super("Reset Your Password");
        setLayout(null);
        emailText.addFocusListener(new JTextFieldHintListener(emailText, "Email:"));
        passWordText.addFocusListener(new JPasswordFieldHintListener(passWordText,"Password:"));

        //密碼框框文字會顯示
        passWordText.setEchoChar('\0');

        email.setFont((new Font("",Font.ITALIC,15)));
        passWord.setFont((new Font("",Font.ITALIC,15)));

        email.setBounds(100,0,180,50);
        emailText.setBounds(100, 40,300,30);
        sendNewpassword.setBounds(170, 90, 150, 20);
        passWord.setBounds(100, 115, 180, 50);
        passWordText.setBounds(100, 155, 300, 30);
        confirm.setBounds(210, 200, 80, 20);
        
        add(email);
        add(emailText);
        add(sendNewpassword);
        add(passWord);
        add(passWordText);
        add(confirm);
    }
}
