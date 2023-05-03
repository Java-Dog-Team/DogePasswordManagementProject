package com.example;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;

public class login {
    private static JFrame windowFrame = new JFrame("更改Swing視窗的預設圖示");
    private static ImageIcon dogPicture=new ImageIcon("demo\\src\\main\\java\\com\\example\\dog.png");
    private static JLabel dog=new JLabel();
    public static void main(String[] args) {
        createWindow();
    }
    private static void createWindow() {    
           
        
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon arrowIcon = null;

        //設置左上角小圖片
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
        int w=dogPicture.getIconWidth();
        int h=dogPicture.getIconHeight();
        dogPicture.setImage(dogPicture.getImage().getScaledInstance(h/400*w, 400, Image.SCALE_DEFAULT));
        dog.setIcon(dogPicture);
        dog.setSize(h/400*w, 400);
        windowFrame.add(dog,BorderLayout.EAST);
    }
    private void formComponentResized(java.awt.event.ComponentEvent evt) {
        Dimension newSize = evt.getComponent().getSize();
        windowFrame.remove(dog);
        int w=dogPicture.getIconWidth();
        int h=dogPicture.getIconHeight();
        dogPicture.setImage(dogPicture.getImage().getScaledInstance((int)(h/newSize.getHeight()*w), (int)newSize.getHeight(), Image.SCALE_DEFAULT));
        dog.setIcon(dogPicture);
        dog.setSize((int)(h/newSize.getHeight()*w), (int)newSize.getHeight());
        windowFrame.add(dog,BorderLayout.EAST);
    }

     
    private static void createUI(JFrame windowFrame){      
        JPanel panel = new JPanel();
        LayoutManager layout = new BorderLayout();  
        panel.setLayout(layout);       
        panel.add(new JLabel("hello world!"),BorderLayout.WEST);

        windowFrame.getContentPane().add(panel, BorderLayout.CENTER);  
    }
}
