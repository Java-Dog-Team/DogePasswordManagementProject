package com.example;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class login {
    public static void main(String[] args) {
        createWindow();
    }
    private static void createWindow() {    
        JFrame windowFrame = new JFrame("更改Swing視窗的預設圖示");   
        windowFrame.setLayout(new GridLayout(1,2));
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon arrowIcon = new ImageIcon("dogdog.png");
  
        java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
        if (imgURL != null) {
           arrowIcon = new ImageIcon(imgURL);
           windowFrame.setIconImage(arrowIcon.getImage());
        } else {
           JOptionPane.showMessageDialog(windowFrame, "Icon image not found.");
        }

        createUI(windowFrame);
        putdog(windowFrame);
        windowFrame.setSize(750, 400);      
        windowFrame.setLocationRelativeTo(null);  
        windowFrame.setVisible(true);
    }

    private static void putdog(JFrame windowFrame){

        JLabel dog=new JLabel(new ImageIcon("demo\\src\\main\\java\\com\\example\\dogdog.png"));
        windowFrame.add(dog);
        dog.setBounds(375, 0, 300, 300);
    }
     
    private static void createUI(JFrame windowFrame){      
        JPanel panel = new JPanel();
        LayoutManager layout = new BorderLayout();  
        panel.setLayout(layout);       
        panel.add(new JLabel("hello world!"),BorderLayout.WEST);

        windowFrame.getContentPane().add(panel, BorderLayout.CENTER);  
    }
}
