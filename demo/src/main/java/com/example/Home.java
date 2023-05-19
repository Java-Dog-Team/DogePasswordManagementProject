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
import javax.swing.JScrollPane;

public class Home extends main_page{
    public JFrame jFrame;
    public static JPanel passwordPanel=new JPanel();
    public static JScrollPane scrollPane=new JScrollPane(passwordPanel);
    public static JScrall
    public Home(JFrame jFrame){
        this.jFrame=jFrame;
        creatPasswordPanel();
    }
    public static void creatPasswordPanel(){
        
    }
}
