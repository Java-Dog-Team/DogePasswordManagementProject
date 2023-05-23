package com.example;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
public class generatePassword extends main_page{
    public JLabel mainLabel=new JLabel();
    private static JLabel titleLabel=new JLabel("Random Password Generation");
    private static JLabel numberLabel=new JLabel("Choose the number of password digits you need");
    private static JSlider numberslider=new JSlider(6, 20);
    public generatePassword(JLabel mainLabel){
        this.mainLabel=mainLabel;
        
    }
    public void createGenerate(JPanel passwardJPanel){
        //移除當前 Panel 內的所有物件
        //這放要改panel的函式的最前面
        passwardJPanel.removeAll();
        passwardJPanel.repaint();
        
        passwardJPanel.setBackground(Color.WHITE);
        passwardJPanel.setLayout(null);

        //slider設定
        numberslider.setPaintTicks(true);// 顯示slider
        numberslider.setMinorTickSpacing(1);// 5一小格
        //numberslider.setPaintTrack(true);//顯示數軸
        numberslider.setPaintLabels(true);//添加數字標籤
        
        titleLabel.setFont((new Font("",Font.BOLD,30)));
        numberLabel.setFont((new Font("",Font.ITALIC,15)));

        titleLabel.setBounds(160, 0,500,100);
        numberLabel.setBounds(220, 80,500,30);
        numberslider.setBounds(210, 150,350,30);

        passwardJPanel.add(titleLabel);
        passwardJPanel.add(numberLabel);
        passwardJPanel.add(numberslider);
         //這放要改panel的函式的最後面
         passwardJPanel.revalidate();
    }
}
