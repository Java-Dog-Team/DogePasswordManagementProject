package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public JLabel mainLabel=new JLabel();
    public static JPanel passwordPanel=new JPanel();
    public static JScrollPane scrollPane=new JScrollPane(passwordPanel);
    public static ArrayList<MouseTestHome> passward=new ArrayList<MouseTestHome>();
    public JButton addPasswardButton =new JButton(new ImageIcon("demo\\src\\picture\\addPassward.png"));
    public Home(JLabel mainLabel){
        // System.out.print(jFrame);
        this.mainLabel=mainLabel;
        // creatPasswordPanel();
        // super.mainLabel.setBackground(Color.BLACK);
        // creatAddPasswardButton();
        // creatPasswordPanel();
    }
    public void creatPasswordPanel(JLabel testJLabel){
        testJLabel.setBackground(Color.BLACK);
    }
    public void creatAddPasswardButton(JPanel addJPanel){
        ButtonHandler handler=new ButtonHandler();//加入密碼的buttonHandler
        //設定button
        addPasswardButton.setPreferredSize(new Dimension(57, 54));//大小
        addPasswardButton.addActionListener(handler);//ActionListener
        //設定 Button 的 pannel
        addJPanel.setLayout(new BorderLayout());
        addJPanel.setBackground(Color.WHITE);
        addJPanel.add(addPasswardButton,BorderLayout.SOUTH);
        addJPanel.setVisible(true);
        // this.mainLabel.add(addJPanel,BorderLayout.EAST);
    }
    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //彈出加入新密碼的視窗
            JFrame addNewPasswardFrame=new JFrame("加入新密碼");
            addNewPasswardFrame.setSize(300, 300);
            addNewPasswardFrame.setLocationRelativeTo(null);//視窗出現在中間
            addNewPasswardFrame.setResizable(false);
            addNewPasswardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//只關閉當前視窗
            JLabel label = new JLabel("新窗口");
            addNewPasswardFrame.add(label);
            addNewPasswardFrame.setVisible(true);
        }
    }
}
