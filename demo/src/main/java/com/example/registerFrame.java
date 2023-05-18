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

public class registerFrame extends JFrame{
    //private static Container container = this.getContentPane();
    private static JButton check = new JButton("Confirm");
    private static JLabel email = new JLabel("Enter your account(email):");
    private static JLabel passWord = new JLabel("Enter your password:");
    private static JLabel passWord2 = new JLabel("Enter your password again:");
    //帳號輸入
    private static JTextField emailText=new JTextField(null, "", 0);
    private static JPasswordField passWordText=new JPasswordField(null, "", 0);
    private static JPasswordField passWordText2=new JPasswordField(null, "", 0);
    public registerFrame(){
        super("Register Your Account");
        //Container container = this.getContentPane();
        setLayout(new BorderLayout());
        //setBackground(Color.PINK);
      
        //container.setBackground(Color.BLACK);
        
        emailText.addFocusListener(new JTextFieldHintListener(emailText, "Email:"));
        passWordText.addFocusListener(new JPasswordFieldHintListener(passWordText,"Password:"));
        passWordText2.addFocusListener(new JPasswordFieldHintListener(passWordText2,"Password again:"));

        //密碼框框文字會顯示
        passWordText.setEchoChar('\0');
        passWordText2.setEchoChar('\0');
        
        email.setBounds(100,0,180,50);
        emailText.setBounds(100, 40,300,30);
        passWord.setBounds(100, 70,180, 50);
        passWordText.setBounds(100,160,300,30);
        passWord2.setBounds(100, 160, 300, 50);
        passWordText2.setBounds(100, 210,310,30);
        check.setBounds(100, 230, 40, 40);

        email.setFont((new Font("",Font.ITALIC,15)));
        passWord.setFont((new Font("",Font.ITALIC,15)));
        passWord2.setFont((new Font("",Font.ITALIC,15)));

        

        add(email);
        add(emailText);
        add(passWord);
        add(passWordText);
        
        add(passWord2);
        // this.add(passWordText2);
        add(passWordText2);
        add(check);
    }
    // private static void input(JFrame registerFrame){
    //     //帳號提示語
        
    // }
            
}
