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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class login {
    private static JFrame windowFrame = new JFrame("歡迎使用看門狗");
    //登入的背景圖片
    private static ImageIcon dogPicture=new ImageIcon("demo\\src\\picture\\white_dog3.png");
    private static JLabel dog=new JLabel(dogPicture);
    private static JPanel panelBack=new JPanel();
    private static JPanel panelLeft=new JPanel();//
    private static JPanel panelRight=new JPanel();

    //private static Container container = windowFrame.getContentPane();
    //取得螢幕大小
    private static Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    private static JLabel frame_upL=new JLabel(" ");
    private static JLabel frame_upR=new JLabel(" ");
    private static JLabel frame_left=new JLabel(" ");
    private static JLabel frame_right=new JLabel(" ");
    private static JLabel frame_downL=new JLabel(" ");
    private static JLabel frame_downR=new JLabel(" ");
    private static GridBagConstraints c;   
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
        //把frame分成兩部分 放兩個Panel
        windowFrame.setLayout(new GridLayout(1,2));
        
        //設置左上角小圖片
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
        if (imgURL != null) {
           arrowIcon = new ImageIcon(imgURL);
           windowFrame.setIconImage(arrowIcon.getImage());
        } else {
           JOptionPane.showMessageDialog(windowFrame, "Icon image not found.");
        }

        panelLeft.setBorder(new LineBorder(Color.BLUE));//暫時先加邊框顏色 好區別
        panelRight.setBorder(new LineBorder(Color.RED));//暫時先加邊框顏色 好區別

        //設定背景顏色
        panelLeft.setBackground(Color.WHITE);
        panelRight.setBackground(Color.WHITE);

        //設定兩個Panel的排版方式
        panelLeft.setLayout(new BorderLayout());
        panelRight.setLayout(new BorderLayout());
        //邊框
        yellow_frame(windowFrame);

        //調整狗狗圖片大小 加入左邊的Panel
        putdog(windowFrame);
        createUI(windowFrame);
        
        //Panel加入windowFrame
        windowFrame.add(panelLeft);
        windowFrame.add(panelRight);

        windowFrame.setLocationRelativeTo(null);  
        windowFrame.setVisible(true);
        
    }

    private static void putdog(JFrame windowFrame){
        int w=dogPicture.getIconWidth();
        int h=dogPicture.getIconHeight();
        //縮小狗狗
        dogPicture.setImage(dogPicture.getImage().getScaledInstance((int)(0.6*w), (int)(0.6*h), Image.SCALE_DEFAULT));
        panelLeft.add(dog,BorderLayout.CENTER);
    }

    private static void createUI(JFrame windowFrame){
        //panelRight.setLayout(new GridLayout(6, 1));
        JButton confirm=new JButton("Confirm");
        JLabel Login=new JLabel("Login");
        JLabel Account=new JLabel("Account:");
        JLabel Password=new JLabel("Password:");
        
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
        
        
        Login.setBorder(new LineBorder(Color.BLACK));
        Login.setPreferredSize(new Dimension(400, 50));

        Account.setBorder(new LineBorder(Color.BLACK));
        Account.setPreferredSize(new Dimension(500, 50));

        Login.setFont((new Font("",Font.ITALIC,35)));
        Account.setFont((new Font("",Font.ITALIC,20)));
        Password.setFont((new Font("",Font.ITALIC,20)));
        

        // panelRight.add(Login,BorderLayout.CENTER);
        // panelRight.add(Account);
        // panelRight.add(accountText);
        // panelRight.add(Password);
        // panelRight.add(passWord);
        // panelRight.add(confirm);
    }
    //加上黃色邊框
    private static void yellow_frame(JFrame windowFrame){
        //黃色邊框(上(panelLeft))
        frame_upL.setOpaque(true); 
        frame_upL.setBackground(Color.orange);
        frame_upL.setFont((new Font("",0,20)));
        panelLeft.add(frame_upL,BorderLayout.NORTH);

        //黃色邊框(上(panelRight))
        frame_upR.setOpaque(true); 
        frame_upR.setBackground(Color.orange);
        frame_upR.setFont((new Font("",0,20)));
        panelRight.add(frame_upR,BorderLayout.NORTH);

        //黃色邊框(左)
        frame_left.setOpaque(true); 
        frame_left.setBackground(Color.orange);
        frame_left.setFont((new Font("",0,100)));
        panelLeft.add(frame_left,BorderLayout.WEST);

        //黃色邊框(右)
        frame_right.setOpaque(true); 
        frame_right.setBackground(Color.orange);
        frame_right.setFont((new Font("",0,100)));
        panelRight.add(frame_right,BorderLayout.EAST);

        //黃色邊框(下(panelLeft))
        frame_downL.setOpaque(true); 
        frame_downL.setBackground(Color.orange);
        frame_downL.setFont((new Font("",0,20)));
        panelLeft.add(frame_downL,BorderLayout.SOUTH);

        //黃色邊框(下(panelRight))
        frame_downR.setOpaque(true); 
        frame_downR.setBackground(Color.orange);
        frame_downR.setFont((new Font("",0,20)));
        panelRight.add(frame_downR,BorderLayout.SOUTH);
    }
}

