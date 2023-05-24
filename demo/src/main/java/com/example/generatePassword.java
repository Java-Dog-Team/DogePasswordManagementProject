package com.example;
import java.awt.Component;
import java.util.Hashtable;
import java.util.Dictionary;
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
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.security.SecureRandom;
public class generatePassword extends main_page{

    public JLabel mainLabel=new JLabel();
    private static String english[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
    "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private static String number[]={"1","2","3","4","5","6","7","8","9","0"};
    private static String special[]={"_","-","~","#","^","*","/","%",".","+",":",";","="};
    private static Image dogImage=new ImageIcon("demo\\src\\picture\\dogdogdog.png").getImage();
    private static ImageIcon dogIcon=new ImageIcon();
    private static JLabel dog1;
    private static JLabel dog2;

    private static JLabel titleLabel=new JLabel("Random Password Generation");
    private static JLabel numberLabel=new JLabel("Choose the number of password digits you need");
    private static JLabel symbolsLabel=new JLabel("Tick the symbols you need");
    private static JTextField outPut=new JTextField("");
    private static JSlider numberslider=new JSlider(8, 20,10);
    private static JCheckBox engLowBox=new JCheckBox("Lowercase English Letters");
    private static JCheckBox engUpperBox=new JCheckBox("Upper Case English Letters");
    private static JCheckBox numberBox=new JCheckBox("Number symbol");
    private static JCheckBox specialBox=new JCheckBox("Special symbol");
    private static JButton confirm=new JButton("confirm", dogIcon);
    private static String outputString="";
    private static int totalDigits=10;
    private static int englowDigits=0;
    private static int engUpperDigits=0;
    private static int numDigits=0;
    private static int speDigits=0;
    private static SecureRandom random= new SecureRandom();
    //private ChangeListener changeListener;// 監聽器
    
    public generatePassword(JLabel mainLabel){
        this.mainLabel=mainLabel;
        //事件設定 拿slider的數字
        numberslider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent event) {
                totalDigits=numberslider.getValue();
                System.out.print(totalDigits);

            }
        });
        //事件設定
        ButtonActionListener Bhandler = new ButtonActionListener();
        confirm.addActionListener(Bhandler);
        //圖片設定
        dogImage=dogImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        dogIcon.setImage(dogImage);
        dog1=new JLabel(dogIcon);
        dog2=new JLabel(dogIcon);
        
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
        numberslider.setBackground(Color.WHITE);
        //numberslider.setPaintTrack(true);//顯示數軸
        numberslider.setPaintLabels(true);//添加數字標籤
        //numberslider.setPaintTicks(true);
        numberslider.setPaintLabels(true);
        //slider.setPaintLabels(true);
        //slider下的數字
        Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
        // labelTable.put(6, new JLabel("6"));
        // labelTable.put(7, new JLabel("7"));
        labelTable.put(8, new JLabel("8"));
        labelTable.put(9, new JLabel("9"));
        labelTable.put(10, new JLabel("10"));
        labelTable.put(11, new JLabel("11"));
        labelTable.put(12, new JLabel("12"));
        labelTable.put(13, new JLabel("13"));
        labelTable.put(14, new JLabel("14"));
        labelTable.put(15, new JLabel("15"));
        labelTable.put(16, new JLabel("16"));
        labelTable.put(17, new JLabel("17"));
        labelTable.put(18, new JLabel("18"));
        labelTable.put(19, new JLabel("19"));
        labelTable.put(20, new JLabel("20"));
        //顯示數字
        numberslider.setLabelTable(labelTable);

        //checkbox設定
        engLowBox.setBackground(Color.WHITE);
        engUpperBox.setBackground(Color.WHITE);
        numberBox.setBackground(Color.WHITE);
        specialBox.setBackground(Color.WHITE);
        
        //JTextfield設定
        outPut.setEditable(false);

        //字型設定
        titleLabel.setFont((new Font("",Font.BOLD,30)));
        numberLabel.setFont((new Font("",Font.ITALIC,20)));
        symbolsLabel.setFont((new Font("",Font.ITALIC,20)));
        engLowBox.setFont((new Font("",Font.BOLD,15)));
        engUpperBox.setFont((new Font("",Font.BOLD,15)));
        numberBox.setFont((new Font("",Font.BOLD,15)));
        specialBox.setFont((new Font("",Font.BOLD,15)));

        titleLabel.setBounds(160, 0,500,100);
        dog1.setBounds(135, 80,20,20);
        numberLabel.setBounds(165, 80,500,30);
        numberslider.setBounds(205, 115,350,65);
        symbolsLabel.setBounds(260, 185,350,30);
        dog2.setBounds(230, 185,20,20);
        engLowBox.setBounds(300, 220,350,30);
        engUpperBox.setBounds(300, 250,350,30);
        numberBox.setBounds(300, 280,350,30);
        specialBox.setBounds(300, 310,350,30);
        confirm.setBounds(320, 350, 110, 30);
        outPut.setBounds(185, 400, 380, 30);
    

        passwardJPanel.add(titleLabel);
        passwardJPanel.add(numberLabel);
        passwardJPanel.add(dog1);
        passwardJPanel.add(numberslider);
        passwardJPanel.add(symbolsLabel);
        passwardJPanel.add(dog2);
        passwardJPanel.add(engLowBox);
        passwardJPanel.add(engUpperBox);
        passwardJPanel.add(numberBox);
        passwardJPanel.add(specialBox);
        passwardJPanel.add(confirm);
        passwardJPanel.add(outPut);
        //這放要改panel的函式的最後面
        passwardJPanel.revalidate();
    }
    
    public void assign(int mode){
        switch(mode){
            englowDigits=0;
            engUpperDigits=0;
            numDigits=0;
            speDigits=0;
            case 1://只有英文小寫
                englowDigits=totalDigits;
            
            case 2://只有英文大寫
                engUpperDigits=totalDigits;

            case 3://只有數字
                numDigits=totalDigits;

            case 4://只有特殊字元
                speDigits=totalDigits;

            case 5://英文小寫+大寫
                for(;englowDigits!=0&&englowDigits!=totalDigits;){
                    englowDigits=random.nextInt(totalDigits);  
                }
                engUpperDigits=totalDigits-englowDigits;
            case 6://英文小寫+數字
            for(;englowDigits!=0&&englowDigits!=totalDigits;){
                englowDigits=random.nextInt(totalDigits);
            }
            numDigits=totalDigits-englowDigits;

            case 7://英文小寫+特殊字元
                for(;englowDigits!=0&&englowDigits!=totalDigits;){
                    englowDigits=random.nextInt(totalDigits);
                }
                speDigits=totalDigits-englowDigits;

            case 8://英文大寫+數字
                for(;engUpperDigits!=0&&engUpperDigits!=totalDigits;){
                    engUpperDigits=random.nextInt(totalDigits);
                }
                numDigits=totalDigits-engUpperDigits;

            case 9://英文大寫+特殊字元
                for(;engUpperDigits!=0&&engUpperDigits!=totalDigits;){
                    engUpperDigits=random.nextInt(totalDigits);
                }
                speDigits=totalDigits-engUpperDigits;

            case 10://數字+特殊字元
                for(;numDigits!=0&&numDigits!=totalDigits;){
                    numDigits=random.nextInt(totalDigits);
                }
                speDigits=totalDigits-numDigits;

            case 11://英文小寫+大寫+數字
                for(;englowDigits!=0&&englowDigits<totalDigits-2;){
                    englowDigits=random.nextInt(totalDigits-3)+1;
                }
                for(;(engUpperBox!=0) && (engUpperBox<totalDigits-2);){
                    engUpperBox=random.nextInt(totalDigits-3)+1;
                    
                }

            case 12://英文小寫+大寫+特殊字元

            case 13://英文小寫+大寫+數字+特殊字元
        }

    }
    
    
    private static class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(!(engLowBox.isSelected())&&!(engUpperBox.isSelected())&&!(numberBox.isSelected())&&!(specialBox.isSelected())){
                JOptionPane.showMessageDialog(null,"您沒有選擇任何選項","WARNING",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(engLowBox.isSelected()){
                if(!(numberBox.isSelected())&&!(specialBox.isSelected())){//只要英文
                    // SecureRandom random= new SecureRandom();
                    // outputString="";
                    // outPut.setText(outputString);
                    // for(int i=0;i<passWord;i++){
                    //     outputString=outputString+english[random.nextInt(52)];
                    // }
                    // outPut.setText(outputString);
                    
                }
                else if(numberBox.isSelected()&&!(specialBox.isSelected())){//要英文跟數字
                    // SecureRandom random= new SecureRandom();
                    // outputString="";
                    // outPut.setText(outputString);
                    // int howmanyE=random.nextInt(passWord)+1;
                    // for(int i=0;i<passWord;i++){
                    //     outputString=outputString+english[random.nextInt(52)];
                    // }
                    // outPut.setText(outputString);
                }
            }
            
        }
    }
}
