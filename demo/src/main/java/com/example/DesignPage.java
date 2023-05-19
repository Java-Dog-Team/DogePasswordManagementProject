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
    public JFrame jFrame;
    private static ImageIcon backGround=new ImageIcon("demo\\src\\picture\\background.png");
    private static String[] colors={"黑色","紅色","藍色","綠色","自訂圖片"};
    private static Color[] c={new Color(0,0,0,255),new Color(255,0,0,255),new Color(0,0,255,255),new Color(0,255,0,255)};
    private static JComboBox<String> backGroundComboBox=new JComboBox<String>(colors);
    public DesignPage(JFrame jFrame){
        this.jFrame=jFrame;
        changeBack();
    }
    public void changeBack(){
        backGround.setImage(backGround.getImage().getScaledInstance(super.w*2/3, super.h*2/3, Image.SCALE_DEFAULT));
        
        // super.setBackground(backGround);
        // JLabel backLabel=new JLabel(backGround);
        // backLabel.setBounds(0, 0, super.w*2/3, super.h*2/3);
        // this.jFrame.add(backLabel,BorderLayout.SOUTH);
        // super.createWindow();
        backGroundComboBox.addItemListener(
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e){
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        jFrame.getContentPane().setBackground( c[backGroundComboBox.getSelectedIndex()] );
                    }
                }
            }
        );
        jFrame.add(backGroundComboBox);
    }
}
