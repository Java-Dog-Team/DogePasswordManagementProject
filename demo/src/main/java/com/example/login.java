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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login {
    private static JFrame windowFrame = new JFrame("歡迎使用看門狗");
    //登入的背景圖片
    private static ImageIcon dogPicture=new ImageIcon("demo\\src\\picture\\white_dog2.png");
    private static JLabel dog=new JLabel(dogPicture);
    private static Container container = windowFrame.getContentPane();
    //取得螢幕大小
    private static Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    private static JLabel frame_up=new JLabel(" ");
    private static JLabel frame_left=new JLabel(" ");
    private static JLabel frame_right=new JLabel(" ");
    private static JLabel frame_down=new JLabel(" ");
    private static JPanel panelLeft=new JPanel();//
    private static JPanel panelRight=new JPanel();
    public static void main(String[] args) {
        createWindow();
    }
    private static void createWindow() {    
        //設定視窗大小為螢幕的2/3
        windowFrame.setSize(dimension.width*2/3, dimension.height*2/3);
        //設定背景顏色
        windowFrame.getContentPane().setBackground( Color.WHITE );
        //container.setLayout(new BorderLayout());
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
        //container.add(dog,BorderLayout.CENTER);
        
        windowFrame.setLocationRelativeTo(null);  
        windowFrame.setVisible(true);
    }

    private static void putdog(JFrame windowFrame){
        int w=dogPicture.getIconWidth();
        int h=dogPicture.getIconHeight();
        //縮小狗狗
        dogPicture.setImage(dogPicture.getImage().getScaledInstance((int)(0.55*w), (int)(0.55*h), Image.SCALE_DEFAULT));
        panelLeft.add(dog);
        container.add(panelLeft,BorderLayout.WEST);
        
        //視窗下緣和對齊
        //dog.setVerticalAlignment(JLabel.BOTTOM);
        //視窗左邊和對齊
        //dog.setHorizontalAlignment(JLabel.LEFT);
    }

    private static void createUI(JFrame windowFrame){
        JButton confirm=new JButton("Confirm");
        JLabel Login=new JLabel("Login");
        JLabel Account=new JLabel("Account:");
        JLabel Password=new JLabel("Password:");
        JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(6,1));
        //帳號輸入
        JTextField accountText=new JTextField(null, "", 0);
        //帳號提示語
        accountText.addFocusListener(new JTextFieldHintListener(accountText, "Enter your account(email):"));
        //密碼輸入
        JPasswordField passWord=new JPasswordField(null, "", 0);
        //密碼提示語
        passWord.addFocusListener(new JPasswordFieldHintListener(passWord,"Enter your password:"));
        //密碼框框文字會顯示
        passWord.setEchoChar('\0');
        
        //各位置設定
        // confirm.setBounds(615, 300, 80, 20);
        // label1.setBounds(610, 90,200,100);
        // label2.setBounds(440, 150,90,90);
        // accountText.setBounds(530, 180, 319, 30);
        // label3.setBounds(440, 200,200,100);
        // passWord.setBounds(550, 235, 300, 30);

        // Login.setFont((new Font("",Font.ITALIC,35)));
        // Account.setFont((new Font("",Font.ITALIC,20)));
        // Password.setFont((new Font("",Font.ITALIC,20)));
        
        // panel.add(confirm);
        // panel.add(Login);
        // panel.add(Account);
        // panel.add(accountText);
        // panel.add(Password);
        // panel.add(passWord);

        // windowFrame.add(panel,BorderLayout.EAST);

        panelRight.add(confirm);

        //加入windowFrame
        // windowFrame.add(confirm,BorderLayout.CENTER);
        // windowFrame.add(Login);
        // windowFrame.add(Account);
        // windowFrame.add(accountText);
        // windowFrame.add(Password);
        // windowFrame.add(passWord);
        // windowFrame.add(panel);
        windowFrame.add(panelRight,BorderLayout.EAST);
        yellow_frame(windowFrame);
        
    }
    //加上黃色邊框
    private static void yellow_frame(JFrame windowFrame){
        //設定Lebel為不透明
        frame_up.setOpaque(true); 
        frame_left.setOpaque(true); 
        frame_right.setOpaque(true); 
        frame_down.setOpaque(true);
        //設定Lebel顏色
        frame_up.setBackground(Color.orange);
        frame_left.setBackground(Color.orange);
        frame_right.setBackground(Color.orange);
        frame_down.setBackground(Color.orange);
        //設定大小
        frame_up.setFont((new Font("",0,20)));
        frame_left.setFont((new Font("",0,100)));
        frame_right.setFont((new Font("",0,100)));
        frame_down.setFont((new Font("",0,20)));
        //加入windowFrame
        windowFrame.add(frame_up,BorderLayout.NORTH);
        windowFrame.add(frame_left,BorderLayout.WEST);
        windowFrame.add(frame_right,BorderLayout.EAST);
        windowFrame.add(frame_down,BorderLayout.SOUTH);
    }
}
