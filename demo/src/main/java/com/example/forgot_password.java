package com.example;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class forgot_password extends JFrame{
    private static JButton confirm = new JButton("Confirm");
    private static JButton sendVerification = new JButton("Send verification code");
    private static JLabel email_phone = new JLabel("Enter your email/phone number:");
    private static JLabel vJLabel = new JLabel("Enter verification code:");
    private static JLabel passWord = new JLabel("Enter your new password:");
    
    //帳號輸入
    private static JTextField email_phoneText=new JTextField(null, "", 0);
    private static JTextField verificationText=new JTextField(null, "", 0);
    private static JPasswordField passWordText=new JPasswordField(null, "", 0);
    public forgot_password(){
        super("Reset Your Password");
        //提示語
        setLayout(null);
        email_phoneText.addFocusListener(new JTextFieldHintListener(email_phoneText, "Enter email/phone number:"));
        passWordText.addFocusListener(new JPasswordFieldHintListener(passWordText,"New password:"));
        verificationText.addFocusListener(new JTextFieldHintListener(verificationText, "Verification code:"));

        //密碼框框文字會顯示
        passWordText.setEchoChar('\0');

        //字型&大小設定
        email_phone.setFont((new Font("",Font.ITALIC,15)));
        passWord.setFont((new Font("",Font.ITALIC,15)));
        vJLabel.setFont((new Font("",Font.ITALIC,15)));

        //各位置設定
        email_phone.setBounds(100,0,250,50);
        email_phoneText.setBounds(100, 40,300,30);
        sendVerification.setBounds(165, 90, 163, 20);
        vJLabel.setBounds(100, 115, 180, 50);
        verificationText.setBounds(260, 125, 120, 30);
        passWord.setBounds(100, 155, 180, 50);
        passWordText.setBounds(100, 195, 300, 30);
        confirm.setBounds(210, 245, 80, 20);
        
        //事件設定
        ButtonActionListener Bhandler = new ButtonActionListener();
        sendVerification.addActionListener(Bhandler);
        confirm.addActionListener(Bhandler);

        //加進視窗
        add(email_phone);
        add(email_phoneText);
        add(sendVerification);
        add(vJLabel);
        add(verificationText);
        add(passWord);
        add(passWordText);
        add(confirm);
    }
    private static class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String ACCOUNT=email_phoneText.getText().trim();
            String vCode=verificationText.getText().trim();
            String PASSWORD=new String(passWordText.getPassword());
            //跳出提醒
            if(e.getSource()==sendVerification){
                if("Enter email/phone number:".equals(ACCOUNT)){
                    JOptionPane.showMessageDialog(null,"Please enter your email or phone number.","WARNING",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            else if(e.getSource()==confirm){
                if("New password:".equals(PASSWORD) && !("Enter email/phone number:".equals(ACCOUNT)) && !("Verification code:".equals(vCode))){
                    JOptionPane.showMessageDialog(null,"Please enter new password!!","WARNING",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else if(("Verification code:".equals(vCode)) && (!("Enter email/phone number:".equals(ACCOUNT)))){
                    JOptionPane.showMessageDialog(null,"Please enter verification code","WARNING",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please enter your email or phone number.","WARNING",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
            }
        }
    }
}
