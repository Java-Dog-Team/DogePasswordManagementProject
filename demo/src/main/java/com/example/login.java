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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

public class login {
    private static JFrame windowFrame = new JFrame("更改Swing視窗的預設圖示");
    //登入的背景圖片
    private static ImageIcon dogPicture=new ImageIcon("demo\\src\\picture\\white_dog2.png");
    private static JLabel dog=new JLabel(dogPicture);
    //private static Container container = windowFrame.getContentPane();
    //取得螢幕大小
    private static Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    private static JLabel frame_up=new JLabel(" ");
    private static JLabel frame_left=new JLabel(" ");
    private static JLabel frame_right=new JLabel(" ");
    private static JLabel frame_down=new JLabel(" ");
    private static JButton confirm=new JButton("Confirm");
    private static JButton sendVerButton=new JButton("Send verification code");
    private static JLabel loginLabel=new JLabel("Login");
    private static JLabel emailLabel=new JLabel("Account:");
    private static JLabel passwordLabel=new JLabel("Password:");
    private static JLabel vJLabel=new JLabel("Verification code:");
    
    private static JLabel register=new JLabel("Register Account");
    private static JLabel forGot=new JLabel("Forget password");
    private static JTextField emailText=new JTextField(null, "", 0);//email輸入
    
    private static JPasswordField passWord=new JPasswordField(null, "", 0);//密碼輸入
    private static JTextField verificationText=new JTextField(null, "", 0);//驗證碼輸入
    
    public static void main(String[] args) {
        createWindow();
    }
    private static void createWindow() { 
        windowFrame.setTitle("Dog密碼管理系統");
        //設定視窗大小為螢幕的2/3
        windowFrame.setSize(960,600);
        //設定背景顏色
        windowFrame.getContentPane().setBackground( Color.WHITE );
        windowFrame.setLayout(new BorderLayout());
        //視窗不可調整大小
        windowFrame.setResizable(false);
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
        windowFrame.add(dog,BorderLayout.CENTER);
        
        windowFrame.setLocationRelativeTo(null);  
        windowFrame.setVisible(true);
    }

    private static void putdog(JFrame windowFrame){
        int w=dogPicture.getIconWidth();
        int h=dogPicture.getIconHeight();
        //縮小狗狗
        dogPicture.setImage(dogPicture.getImage().getScaledInstance((int)(0.55*w), (int)(0.55*h), Image.SCALE_DEFAULT));
        //視窗下緣和對齊
        dog.setVerticalAlignment(JLabel.BOTTOM);
        //視窗左邊和對齊
        dog.setHorizontalAlignment(JLabel.LEFT);
    }

    private static void createUI(JFrame windowFrame){

        //email提示語
        emailText.addFocusListener(new JTextFieldHintListener(emailText, "Enter your email/phone number:"));
        
        //密碼提示語
        passWord.addFocusListener(new JPasswordFieldHintListener(passWord,"Enter your password:"));
        //密碼框框文字會顯示
        passWord.setEchoChar('\0');
        //驗證碼提示語
        verificationText.addFocusListener(new JTextFieldHintListener(verificationText, "Enter verification code:"));
        
        //各位置設定
        loginLabel.setBounds(610, 90,200,100);
        emailLabel.setBounds(440, 150,90,90);
        emailText.setBounds(530, 180, 319, 30);
        passwordLabel.setBounds(440, 200,200,100);
        passWord.setBounds(540, 235, 310, 30);
        vJLabel.setBounds(438, 260,200,100);
        verificationText.setBounds(600, 295,135,30);
        sendVerButton.setBounds(745, 300, 163, 20);
        confirm.setBounds(630, 340, 80, 20);
        register.setBounds(555, 335, 150, 80);
        forGot.setBounds(690, 335, 150, 80);
        
        //字型&大小設定
        loginLabel.setFont((new Font("",Font.ITALIC,35)));
        emailLabel.setFont((new Font("",Font.ITALIC,20)));
        passwordLabel.setFont((new Font("",Font.ITALIC,20)));
        vJLabel.setFont((new Font("",Font.ITALIC,20)));
        register.setFont((new Font("",Font.ITALIC,12)));
        forGot.setFont((new Font("",Font.ITALIC,12)));

        //事件設定
        MouseHandler Mhandler = new MouseHandler();
        register.addMouseListener(Mhandler);
        register.addMouseMotionListener(Mhandler);
        forGot.addMouseListener(Mhandler);
        forGot.addMouseMotionListener(Mhandler);
        ButtonActionListener Bhandler = new ButtonActionListener();
        confirm.addActionListener(Bhandler);
        sendVerButton.addActionListener(Bhandler);

        //加入windowFrame
        windowFrame.add(loginLabel);
        windowFrame.add(emailLabel);
        windowFrame.add(emailText);
        windowFrame.add(passwordLabel);
        windowFrame.add(passWord);
        windowFrame.add(vJLabel);
        windowFrame.add(verificationText);
        windowFrame.add(sendVerButton);
        windowFrame.add(confirm);
        windowFrame.add(register);
        windowFrame.add(forGot);
        //加上黃色邊框
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

    private static class MouseHandler extends MouseAdapter{
        
        public void mouseClicked(MouseEvent event){
            if(event.getSource()==register){
                registerFrame register=new registerFrame();
                //設定視窗出現位置和大小
                register.setBounds(450, 250,500,450);
                //視窗不可改變大小
                register.setResizable(false);
                //設定背景顏色
                register.getContentPane().setBackground( Color.WHITE );
                register.setVisible(true);
                //只關閉當前視窗
                register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //設置左上角小圖片
                ImageIcon arrowIcon = null;
                java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
                if (imgURL != null) {
                arrowIcon = new ImageIcon(imgURL);
                register.setIconImage(arrowIcon.getImage());
                } else {
                    JOptionPane.showMessageDialog(register, "Icon image not found.");
                }
            }
            if(event.getSource()==forGot){
                forgot_password forGot=new forgot_password();
                //設定視窗出現位置和大小
                forGot.setBounds(450, 250, 500, 450);
                //視窗不可改變大小
                forGot.setResizable(false);
                //設定背景顏色
                forGot.getContentPane().setBackground( Color.WHITE );
                forGot.setVisible(true);
                //只關閉當前視窗
                forGot.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //設置左上角小圖片
                ImageIcon arrowIcon = null;
                java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
                if (imgURL != null) {
                arrowIcon = new ImageIcon(imgURL);
                forGot.setIconImage(arrowIcon.getImage());
                } else {
                    JOptionPane.showMessageDialog(forGot, "Icon image not found.");
                }
            }
        }
    }
    private static class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String ACCOUNT=emailText.getText().trim();
            String PASSWORD=new String(passWord.getPassword());
            String VERIFICATION=verificationText.getText().trim();
            if (e.getSource()==confirm){
                if("Enter your password:".equals(PASSWORD) || "Enter your account(email):".equals(ACCOUNT) || "Enter verification code:".equals(VERIFICATION)){
                    JOptionPane.showMessageDialog(null,"Please enter complete information!!","WARNING",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            else if(e.getSource()==sendVerButton){
                if("Enter your account(email):".equals(ACCOUNT)){
                    JOptionPane.showMessageDialog(null,"Please enter your account!!","WARNING",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
    }
}