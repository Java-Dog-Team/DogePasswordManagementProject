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
import javax.swing.Icon;

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
    
    public ImageIcon homeIcon=new ImageIcon("demo\\src\\picture\\home.png");
    public ImageIcon lockIcon=new ImageIcon("demo\\src\\picture\\lock.png");
    public ImageIcon bellIcon=new ImageIcon("demo\\src\\picture\\bell.png");
    public ImageIcon sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles.png");
    public ImageIcon interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation.png");

    public MouseTest mouseTest;
    public String color;
    public JPanel topPanel;
    public ImageIcon myheadIcon;

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
    public void createBackground(MouseTest mouseTest,JPanel passwardJPanel,JPanel leftJPanel,JPanel topPanel){
        passwardJPanel.removeAll();
        passwardJPanel.repaint();
        JPanel newPanel=new JPanel();
        passwardJPanel.setLayout(null);
        this.mouseTest=mouseTest;
        this.color=mouseTest.getColor();
        this.topPanel=topPanel;

        Icon img = new ImageIcon("demo\\src\\picture\\dog.png");
        myheadIcon = RoundImageIconObject.getRoundImageIcon(img);
        myheadIcon.setImage(myheadIcon.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));


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
        changeLeftJPanel=leftJPanel;
        leftJPanel.setOpaque(true);
        passwardJPanel.revalidate();
    }

    // public void setLeftPanel(Color c){
    //     leftJPanel.setBackground(Color.PINK);
    // }
    private class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            topPanel.removeAll();
            topPanel.repaint();
            JLabel topJLabel = new JLabel("WatchDog");;
            JLabel topMyHeadIconJLabel;
            topJLabel.setPreferredSize(new Dimension(100, h / 20));
            topJLabel.setFont(new Font(Font.SERIF, 0, 18));
            if(blackButton.isSelected()){
                // 設定上方邊條背景顏色
                topPanel.setBackground(new Color(0, 0, 0, 255));
                topPanel.setOpaque(true);

                topJLabel.setForeground(new Color(255, 255, 255));

                topMyHeadIconJLabel = new JLabel(myheadIcon);
                topMyHeadIconJLabel.setPreferredSize(new Dimension(50, 40));
                // 加入上面的標題文字
                topPanel.add(topJLabel, BorderLayout.WEST);
                // 加入大頭貼
                topPanel.add(topMyHeadIconJLabel, BorderLayout.EAST);

                color="black";
                mouseTest.setColor(color);                    
                setleftPanel();
            }
            else if(pinkButton.isSelected()){
                color="pink";
                mouseTest.setColor(color);                    
                setleftPanel();
            }
            else if(blueButton.isSelected()){
                color="blue";
                mouseTest.setColor(color);                    
                setleftPanel();
            }
            else if(greenButton.isSelected()){
                color="green";
                mouseTest.setColor(color);                    
                setleftPanel();
            }
            else if(yellowButton.isSelected()){
                color="yellow";
                mouseTest.setColor(color);                    
                setleftPanel();
            }
            topPanel.revalidate();
        }
        public void setleftPanel(){
            changeLeftJPanel.removeAll();
            changeLeftJPanel.repaint();

            homeIcon=new ImageIcon("demo\\src\\picture\\調好的圖片\\home_"+color+".png");
            lockIcon=new ImageIcon("demo\\src\\picture\\調好的圖片\\lock_"+color+".png");
            bellIcon=new ImageIcon("demo\\src\\picture\\調好的圖片\\bell_"+color+".png");
            sparklesIcon=new ImageIcon("demo\\src\\picture\\調好的圖片\\sparkles_"+color+".png");
            interrogationIcon=new ImageIcon("demo\\src\\picture\\調好的圖片\\interrogation_"+color+".png");

            JLabel homeLabel=new JLabel(homeIcon);
            JLabel passwordLabel=new JLabel(lockIcon);
            JLabel alertLabel=new JLabel(bellIcon);
            JLabel themeLabel=new JLabel(sparklesIcon);
            JLabel QALabel=new JLabel(interrogationIcon);
            //更新五個按鈕
            changeLeftJPanel.add(homeLabel);
            changeLeftJPanel.add(passwordLabel);
            changeLeftJPanel.add(alertLabel);
            changeLeftJPanel.add(themeLabel);
            changeLeftJPanel.add(QALabel);

            changeLeftJPanel.revalidate();
    }
    // private static class ActionListener{
    //     public void actionPerformed(ActionEvent e){
            
            
    //     }
    // }
}
}
