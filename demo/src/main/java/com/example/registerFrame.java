package com.example;

import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class registerFrame extends JFrame{
    private static JButton confirm = new JButton("Confirm");
    private static JLabel email = new JLabel("Enter your account(email):");
    private static JLabel passWord = new JLabel("Enter your password:");
    private static JLabel passWord2 = new JLabel("Enter your password again:");
    
    private static JTextField emailText=new JTextField(null, "", 0);//帳號輸入
    private static JPasswordField passWordText=new JPasswordField(null, "", 0);//第一次輸入密碼
    private static JPasswordField passWordText2=new JPasswordField(null, "", 0);//第二次輸入密碼
    public registerFrame(){
        super("Register Your Account");
        setLayout(null);
        
        //提示語
        emailText.addFocusListener(new JTextFieldHintListener(emailText, "Email:"));
        passWordText.addFocusListener(new JPasswordFieldHintListener(passWordText,"Password:"));
        passWordText2.addFocusListener(new JPasswordFieldHintListener(passWordText2,"Password again:"));

        //密碼框框文字會顯示
        passWordText.setEchoChar('\0');
        passWordText2.setEchoChar('\0');
        
        //確認按鈕事件
        ButtonActionListener handler = new ButtonActionListener();
        confirm.addActionListener(handler);

        email.setBounds(100,0,180,50);
        emailText.setBounds(100, 40,300,30);
        passWord.setBounds(100, 70,180, 50);
        passWordText.setBounds(100,110,300,30);
        passWord2.setBounds(100, 140, 300, 50);
        passWordText2.setBounds(100, 180,300,30);
        confirm.setBounds(210, 220, 80, 20);

        email.setFont((new Font("",Font.ITALIC,15)));
        passWord.setFont((new Font("",Font.ITALIC,15)));
        passWord2.setFont((new Font("",Font.ITALIC,15)));

        add(email);
        add(emailText);
        add(passWord);
        add(passWordText);
        add(passWord2);
        add(passWordText2);
        add(confirm);
    }
    private static class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String ACCOUNT=emailText.getText().trim();
            // if("Email:".equals(ACCOUNT) ){
            //     JOptionPane.showMessageDialog(null,"Please enter your account!!","WARNING",JOptionPane.WARNING_MESSAGE);
            //     return;
            // }
            if("Email:".equals(ACCOUNT)){
                JOptionPane.showMessageDialog(null,"Please enter your account!!","WARNING",JOptionPane.WARNING_MESSAGE);
                return;
            }
            System.out.println(ACCOUNT);
            // System.out.println(emailText.getText()=="Email:");


        }
    }
}
