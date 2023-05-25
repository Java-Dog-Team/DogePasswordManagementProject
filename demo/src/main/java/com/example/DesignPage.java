package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class DesignPage extends main_page{
    //背景圖片
    public JLabel mainLabel=new JLabel();
    //圖片設定
    private static Image pinkImage=new ImageIcon("demo\\src\\picture\\pink.png").getImage();
    private static ImageIcon pinkIcon=new ImageIcon();
    private static JLabel pink;
    private static Image blackImage=new ImageIcon("demo\\src\\picture\\black.png").getImage();
    private static ImageIcon blackIcon=new ImageIcon();
    private static JLabel black;
    private static Image blueImage=new ImageIcon("demo\\src\\picture\\blue.png").getImage();
    private static ImageIcon blueIcon=new ImageIcon();
    private static JLabel blue;
    private static Image greenImage=new ImageIcon("demo\\src\\picture\\green.png").getImage();
    private static ImageIcon greenIcon=new ImageIcon();
    private static JLabel green;
    private static Image yellowImage=new ImageIcon("demo\\src\\picture\\yellow.png").getImage();
    private static ImageIcon yellowIcon=new ImageIcon();
    private static JLabel yellow;

    private static JRadioButton pinkButton;
    private static JRadioButton blackButton;
    private static JRadioButton blueButton;
    private static JRadioButton greenButton;
    private static JRadioButton yellowButton;
    private static ButtonGroup radioGroup=new ButtonGroup();

    private static JButton confirm=new JButton("Confirm");
    private static JPanel changeLeftJPanel;
    

    private static ImageIcon backGround=new ImageIcon("demo\\src\\picture\\background.png");
    private static String[] colors={"黑色","紅色","藍色","綠色","自訂圖片"};
    private static Color[] c={new Color(0,0,0,255),new Color(255,0,0,255),new Color(0,0,255,255),new Color(0,255,0,255)};
    private static JComboBox<String> backGroundComboBox=new JComboBox<String>(colors);
    public DesignPage(JLabel mainLabel){
        this.mainLabel=mainLabel;
        //事件設定
        ButtonActionListener Bhandler = new ButtonActionListener();
        confirm.addActionListener(Bhandler);

        //圖片設定
        pinkImage=pinkImage.getScaledInstance(130, 110, Image.SCALE_DEFAULT);
        pinkIcon.setImage(pinkImage);
        pink=new JLabel(pinkIcon);
        blackImage=blackImage.getScaledInstance(130, 110, Image.SCALE_DEFAULT);
        blackIcon.setImage(blackImage);
        black=new JLabel(blackIcon);
        blueImage=blueImage.getScaledInstance(130, 110, Image.SCALE_DEFAULT);
        blueIcon.setImage(blueImage);
        blue=new JLabel(blueIcon);
        greenImage=greenImage.getScaledInstance(130, 110, Image.SCALE_DEFAULT);
        greenIcon.setImage(greenImage);
        green=new JLabel(greenIcon);
        yellowImage=yellowImage.getScaledInstance(130, 110, Image.SCALE_DEFAULT);
        yellowIcon.setImage(yellowImage);
        yellow=new JLabel(yellowIcon);
    }
    public void createBackground(JPanel passwardJPanel,JPanel leftJPanel){
        passwardJPanel.removeAll();
        passwardJPanel.repaint();
        JPanel newPanel=new JPanel();
        passwardJPanel.setLayout(null);

        pinkButton=new JRadioButton("PINK");
        blackButton=new JRadioButton("BLACK");
        blueButton=new JRadioButton("BLUE");
        greenButton=new JRadioButton("GREEN");
        yellowButton=new JRadioButton("YELLOW");

        radioGroup.add(pinkButton);
        radioGroup.add(blackButton);
        radioGroup.add(blueButton);
        radioGroup.add(greenButton);
        radioGroup.add(yellowButton);

        pinkButton.setBackground(Color.WHITE);
        blackButton.setBackground(Color.WHITE);
        blueButton.setBackground(Color.WHITE);
        greenButton.setBackground(Color.WHITE);
        yellowButton.setBackground(Color.WHITE);
        yellowButton.setSelected(true);

        
        pink.setBounds(80, 80,130,110);
        pinkButton.setBounds(115, 200,80,20);
        black.setBounds(320, 80,130,110);
        blackButton.setBounds(350, 200,80,20);
        blue.setBounds(560, 80,130,110);
        blueButton.setBounds(595, 200,80,20);
        green.setBounds(80, 270,130,110);
        greenButton.setBounds(110, 390,80,20);
        yellow.setBounds(320, 270,130,110);
        yellowButton.setBounds(350, 390,80,20);
        confirm.setBounds(345,420,90,30);

        passwardJPanel.add(pink);
        passwardJPanel.add(pinkButton);
        passwardJPanel.add(black);
        passwardJPanel.add(blackButton);
        passwardJPanel.add(blue);
        passwardJPanel.add(blueButton);
        passwardJPanel.add(green);
        passwardJPanel.add(greenButton);
        passwardJPanel.add(yellow);
        passwardJPanel.add(yellowButton);
        passwardJPanel.add(confirm);


        passwardJPanel.setBackground(Color.WHITE);
        passwardJPanel.setOpaque(true);
        //leftJPanel.setBackground(Color.BLACK);
        // changeLeftJPanel=new JPanel();
        changeLeftJPanel=leftJPanel;
        leftJPanel.setOpaque(true);
        passwardJPanel.revalidate();
    }

    // public void setLeftPanel(Color c){
    //     leftJPanel.setBackground(Color.PINK);
    // }
    private static class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(pinkButton.isSelected()){
                System.out.print("null");
                ImageIcon pink_bell=new ImageIcon("demo\\src\\picture\\pink_bell.png");
                // main_page mainPage=new main_page();
                // mainPage.changeFiveButton(pink_bell,pink_bell,pink_bell,pink_bell,pink_bell);
                // JPanel passwardJPanel=new JPanel();
                // JPanel leftJPanel=new JPanel();
                // passwardJPanel.setBackground(Color.PINK);
                // leftJPanel.setBackground(Color.PINK);
                // this.createBackground(passwardJPanel,leftJPanel);
                
                
            }
            
        }
    }
    // private static class ActionListener{
    //     public void actionPerformed(ActionEvent e){
            
            
    //     }
    // }
}
