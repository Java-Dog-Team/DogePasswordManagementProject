package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Home extends main_page{
    public JFrame jFrame=new JFrame("Home");
    public static JPanel passwordPanel=new JPanel();
    public static JScrollPane scrollPane=new JScrollPane(passwordPanel);
    public static ArrayList<MouseTestHome> passward=new ArrayList<MouseTestHome>();
    public JButton addPasswardButton =new JButton(new ImageIcon("demo\\src\\picture\\addPassward.png"));
    public Home(JLabel mainLabel){
        // System.out.print(jFrame);
        super.mainLabel.setOpaque(true);
        JLabel testJLabel=new JLabel("testRRRRRRRRRRR");
        mainLabel.add(testJLabel,BorderLayout.SOUTH);
        // super.mainLabel.setBackground(Color.BLACK);
        // creatAddPasswardButton();
        // creatPasswordPanel();
    }
    public static void creatPasswordPanel(){
        
    }
    public void creatAddPasswardButton(JFrame jFrame){
        JPanel addJPanel=new JPanel();
        addPasswardButton.setPreferredSize(new Dimension(57, 54));
        addJPanel.setLayout(new BorderLayout());
        addJPanel.setBackground(Color.WHITE);
        addJPanel.add(addPasswardButton,BorderLayout.SOUTH);
        jFrame.getContentPane().add(addJPanel,BorderLayout.EAST);

    }
}
