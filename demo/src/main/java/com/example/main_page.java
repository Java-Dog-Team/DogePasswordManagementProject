package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class main_page{
    private static JFrame jFrame=new JFrame("看門狗系統");
    private static JLabel topJLabel=new JLabel();
    //取得螢幕大小
    private static Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    private static int w=dimension.width;
    private static int h=dimension.height;
    public static void main(String[] args) {
        createWindow();
    }
    
    public static void createWindow(){
        //設定視窗大小為螢幕的2/3
        System.out.printf("%d %d",dimension.width*2/3, dimension.height*2/3);
        jFrame.setSize(w*2/3, h*2/3);
        //設定背景顏色
        jFrame.getContentPane().setBackground( new Color(255,255,255,255) );
        
        //設置左上角小圖片
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
        if (imgURL != null) {
            arrowIcon = new ImageIcon(imgURL);
            jFrame.setIconImage(arrowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(jFrame, "Icon image not found.");
        }

        
        setTopJLabel(topJLabel);
        // createUI(jFrame,topJLabel);   
        jFrame.setLocationRelativeTo(null);  
        jFrame.setVisible(true);
    }

    private static void createUI(JFrame frame,JLabel topJLabel){      
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());       
        panel.add(topJLabel,BorderLayout.CENTER);
        panel.setBackground(new Color(236,217,113,150));
        panel.setSize(w, h);
        frame.getContentPane().add(panel, BorderLayout.NORTH);    
    }

    public static void setTopJLabel(JLabel topJLabel) {
        main_page.topJLabel = new JLabel("WatchDog");
        main_page.topJLabel.setForeground(new Color(0,0,0));
        main_page.topJLabel.setPreferredSize(new Dimension(w, h/20));
        main_page.topJLabel.setFont(new Font(Font.SERIF, 0, 18));
        main_page.topJLabel.setBackground(new Color(255,220,53,150));
        main_page.topJLabel.setOpaque(true);
        
        main_page.jFrame.getContentPane().add(main_page.topJLabel,BorderLayout.NORTH);
    }
}