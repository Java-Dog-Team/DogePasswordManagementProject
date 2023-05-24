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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DesignPage extends main_page{
    //背景圖片
    public JLabel mainLabel=new JLabel();
    private static ImageIcon backGround=new ImageIcon("demo\\src\\picture\\background.png");
    private static String[] colors={"黑色","紅色","藍色","綠色","自訂圖片"};
    private static Color[] c={new Color(0,0,0,255),new Color(255,0,0,255),new Color(0,0,255,255),new Color(0,255,0,255)};
    private static JComboBox<String> backGroundComboBox=new JComboBox<String>(colors);
    public DesignPage(JLabel mainLabel){
        this.mainLabel=mainLabel;
    }
    public void createBackground(JPanel passwardJPanel){
        passwardJPanel.removeAll();
        passwardJPanel.repaint();
        passwardJPanel.revalidate();
    }
}
