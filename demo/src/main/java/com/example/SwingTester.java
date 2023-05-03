package com.example;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SwingTester {
   public static void main(String[] args) {
      createWindow();   
   }

   private static void createWindow() {    
      JFrame frame = new JFrame("更改Swing視窗的預設圖示");           
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ImageIcon arrowIcon = null;

      //設置左上角小圖片
      java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
      if (imgURL != null) {
         arrowIcon = new ImageIcon(imgURL);
         frame.setIconImage(arrowIcon.getImage());
      } else {
         JOptionPane.showMessageDialog(frame, "Icon image not found.");
      }

      createUI(frame);
      frame.setSize(560, 200);      
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
   }
   

   private static void createUI(JFrame frame){      
      JPanel panel = new JPanel();
      LayoutManager layout = new FlowLayout();  
      panel.setLayout(layout);       
      panel.add(new JLabel("Welcome to Tw511.com!"));

      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }
}