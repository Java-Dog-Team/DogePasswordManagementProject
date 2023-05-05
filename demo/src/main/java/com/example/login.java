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

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login {
    private static JFrame windowFrame = new JFrame("更改Swing視窗的預設圖示");
    //登入的背景圖片
    private static ImageIcon dogPicture=new ImageIcon("demo\\src\\main\\java\\com\\example\\white_dog2.png");
    private static JLabel dog=new JLabel(dogPicture);
    private static Container container = windowFrame.getContentPane();
    //取得螢幕大小
    private static Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    
    public static void main(String[] args) {
        createWindow();
    }
    private static void createWindow() {    
        //設定視窗大小為螢幕的2/3
        windowFrame.setSize(dimension.width*2/3, dimension.height*2/3);
        //設定背景顏色
        windowFrame.getContentPane().setBackground( Color.WHITE );
        container.setLayout(new BorderLayout());
        //設定關閉可以關掉程式
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //設置左上角小圖片
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
        if (imgURL != null) {
           arrowIcon = new ImageIcon(imgURL);
           windowFrame.setIconImage(arrowIcon.getImage());
        } else {
           JOptionPane.showMessageDialog(windowFrame, "Icon image not found.");
        }

        putdog(windowFrame);
        createUI(windowFrame);
        //顯示圖片
        container.add(dog,BorderLayout.CENTER);
        //windowFrame.setSize(750, 400);      

        windowFrame.setLocationRelativeTo(null);  
        windowFrame.setVisible(true);
    }

    private static void putdog(JFrame windowFrame){
        int w=dogPicture.getIconWidth();
        int h=dogPicture.getIconHeight();
        //縮小狗狗
        dogPicture.setImage(dogPicture.getImage().getScaledInstance((int)(0.65*w), (int)(0.65*h), Image.SCALE_DEFAULT));
        //視窗下緣和對齊
        dog.setVerticalAlignment(JLabel.BOTTOM);
        //視窗左邊和對齊
        dog.setHorizontalAlignment(JLabel.LEFT);
        // dog.setLayout(new BorderLayout());
        // dog.setIcon(dogPicture);
        //dog.setSize(w/2, h/2);

    }

    private static void createUI(JFrame windowFrame){
        //int w=dogPicture.getIconWidth();
        //int h=dogPicture.getIconHeight();
        //JLabel label=new JLabel("Login");
        JLabel label1=new JLabel("Login");
        JLabel label2=new JLabel("Account:");
        JLabel label3=new JLabel("Password:");
        JTextField accountText=new JTextField(null, "", 0);//帳號輸入
        accountText.addFocusListener(new JTextFieldHintListener(accountText, "Enter your account(email):"));
        JPasswordField text2=new JPasswordField(null, null, 0);//密碼輸入
        
        text2.addFocusListener(new JPasswordFieldHintListener(text2,"Enter your password:"));
        //text2.setEchoChar('\0');
        //text2.addFocusListener(new JTextFieldHintListener(text2, "Enter your password:"));
        // label.setSize(w/2, h/2);
        label1.setBounds(620, 90,200,100);
        label2.setBounds(450, 150,90,90);
        accountText.setBounds(540, 180, 319, 30);
        
        label3.setBounds(450, 200,200,100);
        text2.setBounds(560, 235, 300, 30);

        label1.setFont((new Font("",Font.ITALIC,35)));
        label2.setFont((new Font("",Font.ITALIC,20)));
        label3.setFont((new Font("",Font.ITALIC,20)));
        windowFrame.add(label1);
        windowFrame.add(label2);
        windowFrame.add(accountText);
        windowFrame.add(label3);
        windowFrame.add(text2);
        //windowFrame.add(text,BorderLayout.SOUTH);
    }
}
