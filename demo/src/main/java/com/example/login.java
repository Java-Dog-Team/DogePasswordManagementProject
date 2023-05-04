package com.example;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class login {
    private static JFrame windowFrame = new JFrame("更改Swing視窗的預設圖示");
    //登入的背景圖片
    private static ImageIcon dogPicture=new ImageIcon("demo\\src\\main\\java\\com\\example\\yellow_dog.jpeg");
    private static JLabel dog=new JLabel(dogPicture,JLabel.CENTER);
    private static Container container = windowFrame.getContentPane();
    public static void main(String[] args) {
        createWindow();
    }
    private static void createWindow() {    
        
        //取得螢幕大小
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        //設定視窗大小為螢幕的2/3
        windowFrame.setSize(dimension.width*2/3, dimension.height*2/3);
        
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
        
        windowFrame.setSize(750, 400);      

        windowFrame.setLocationRelativeTo(null);  
        windowFrame.setVisible(true);
    }

    private static void putdog(JFrame windowFrame){
        int w=dogPicture.getIconWidth();
        int h=dogPicture.getIconHeight();
        dogPicture.setImage(dogPicture.getImage().getScaledInstance(w/2, h/2, Image.SCALE_DEFAULT));
        // dog.setLayout(new BorderLayout());
        // dog.setIcon(dogPicture);
        dog.setSize(w/2, h/2);
        
        //圖片應該會在中間阿QAQ
        container.add(dog,BorderLayout.CENTER);
    }

    private static void createUI(JFrame windowFrame){      
        JPanel panel = new JPanel();
        LayoutManager layout = new BorderLayout();  
        panel.setLayout(layout);       
        panel.add(new JLabel("hello world!"));

        windowFrame.getContentPane().add(panel, BorderLayout.CENTER);  
    }
}
