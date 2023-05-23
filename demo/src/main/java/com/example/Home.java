package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.jar.JarFile;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.sound.midi.Track;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;

public class Home extends main_page{
    public JLabel mainLabel=new JLabel();
    public static JPanel passwordPanel;
    public ImageIcon passwardimg=new ImageIcon("demo\\src\\picture\\home_passward_panel_1.png");
    public static JScrollPane scrollPane=new JScrollPane(passwordPanel);
    public static ArrayList<MouseTestHome> passward=new ArrayList<MouseTestHome>();
    public JButton addPasswardButton =new JButton(new ImageIcon("demo\\src\\picture\\addPassward.png"));
    public JLabel picturelabel;
    public JButton addPictureButton=new JButton("+add picture");
    public JFrame addNewPasswardFrame;
    public JTextField appJTextField;
    public JTextField accountJTextField;
    public JPasswordField passwardJTextField;
    public JPasswordField password;
    public Home(JLabel mainLabel){
        this.mainLabel=mainLabel;
    }
    public void creatPasswordPanel(JPanel passwardJPanel){
        //移除當前 Panel 內的所有物件
        passwardJPanel.removeAll();
        passwordPanel=passwardJPanel;
        // passwordPanel.setOpaque(true);
        // passwordPanel.setBackground(Color.WHITE);
        // JLabel testJLabel=new JLabel("testRRRRRRRRRRR");
        // passwordPanel.add(testJLabel,BorderLayout.CENTER);
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
    public class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            //彈出加入新密碼的視窗
            addNewPasswardFrame=new JFrame("加入新密碼");
            addNewPasswardFrame.setSize(600, 335);
            //視窗出現在中間
            addNewPasswardFrame.setLocationRelativeTo(null);
            //不可調整視窗大小
            addNewPasswardFrame.setResizable(false);
            //設定視窗背景顏色
            addNewPasswardFrame.getContentPane().setBackground(Color.WHITE);
            //設置左上角小圖片
            ImageIcon arrowIcon = null;
            java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
            if (imgURL != null) {
                arrowIcon = new ImageIcon(imgURL);
                addNewPasswardFrame.setIconImage(arrowIcon.getImage());
            } else {
                JOptionPane.showMessageDialog(addNewPasswardFrame, "Icon image not found.");
            }

            //只關閉當前視窗
            addNewPasswardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            //加入密碼照片
            ImageIcon picture=arrowIcon;
            picturelabel = new JLabel(picture);
            picturelabel.setVisible(true);

            //設定顯示圖片大小
            picturelabel.setPreferredSize(new Dimension(250, 250));
            picturelabel.setBackground(Color.WHITE);
            picturelabel.setOpaque(true);
            addNewPasswardFrame.add(picturelabel,BorderLayout.WEST);
            
            //APP名稱
            JLabel appJLabel=new JLabel("App's name:");
            appJTextField=new JTextField();
            JPanel appJPanel=new JPanel();
            JPanel apptxJPanel=new JPanel();
            
            appJLabel.setBackground(Color.WHITE);
            appJLabel.setOpaque(true);
            appJPanel.setPreferredSize(new Dimension(100, 20));
            appJPanel.setLayout(new BorderLayout());
            appJPanel.add(appJLabel,BorderLayout.NORTH);
            appJTextField.setPreferredSize(new Dimension(250, 23));
            apptxJPanel.add(appJTextField,BorderLayout.WEST);
            apptxJPanel.setPreferredSize(new Dimension(250, 25));
            apptxJPanel.setBackground(Color.WHITE);
            apptxJPanel.setOpaque(true);
            appJPanel.setBackground(Color.WHITE);
            appJPanel.setOpaque(true);
            appJPanel.add(apptxJPanel,BorderLayout.WEST);

            //帳號
            JLabel accountJLabel=new JLabel("Account:");
            accountJTextField=new JTextField();
            JPanel accountJPanel=new JPanel();
            JPanel txJPanel=new JPanel();
            
            accountJLabel.setBackground(Color.WHITE);
            accountJLabel.setOpaque(true);
            accountJPanel.setPreferredSize(new Dimension(100, 20));
            accountJPanel.setLayout(new BorderLayout());
            accountJPanel.add(accountJLabel,BorderLayout.NORTH);
            accountJTextField.setPreferredSize(new Dimension(250, 23));
            txJPanel.add(accountJTextField,BorderLayout.WEST);
            txJPanel.setPreferredSize(new Dimension(250, 25));
            txJPanel.setBackground(Color.WHITE);
            txJPanel.setOpaque(true);
            accountJPanel.setBackground(Color.WHITE);
            accountJPanel.setOpaque(true);
            accountJPanel.add(txJPanel,BorderLayout.WEST);

            //密碼
            JLabel passwardJLabel=new JLabel("password:");
            passwardJTextField=new JPasswordField();
            JPanel psJPanel=new JPanel();
            JPanel passwardJPanel=new JPanel();

            passwardJLabel.setBackground(Color.WHITE);
            passwardJLabel.setOpaque(true);
            passwardJPanel.setPreferredSize(new Dimension(100, 20));
            passwardJPanel.setLayout(new BorderLayout());
            passwardJPanel.add(passwardJLabel,BorderLayout.NORTH);
            passwardJTextField.setPreferredSize(new Dimension(250, 23));
            psJPanel.add(passwardJTextField,BorderLayout.WEST);
            psJPanel.setPreferredSize(new Dimension(250, 25));
            psJPanel.setBackground(Color.WHITE);
            psJPanel.setOpaque(true);
            passwardJPanel.setBackground(Color.WHITE);
            passwardJPanel.setOpaque(true);
            passwardJPanel.add(psJPanel,BorderLayout.WEST);
            
            //新增圖片按鈕
            JPanel addPictureJPanel=new JPanel();
            JLabel label1=new JLabel();
            JPanel btJPanel=new JPanel();

            addPictureButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    addPicture(addPictureButton);
                }
            });
            addPictureJPanel.setLayout(new BorderLayout());
            addPictureJPanel.setBackground(Color.WHITE);
            addPictureJPanel.setOpaque(true);
            addPictureButton.setPreferredSize(new Dimension(105, 25));
            btJPanel.setPreferredSize(new Dimension(105, 30));
            btJPanel.setBackground(Color.WHITE);
            btJPanel.setOpaque(true);
            btJPanel.add(addPictureButton,BorderLayout.WEST);
            addPictureJPanel.add(label1,BorderLayout.NORTH);
            addPictureJPanel.add(btJPanel,BorderLayout.WEST);
            //確認 || 取消新增帳密
            JButton confirmButton=new JButton("confirm");
            JButton cancelButton=new JButton("cancel");
            JPanel confirmOrCancelJPanel=new JPanel();
            JPanel ccPanel=new JPanel();
            
            confirmOrCancelJPanel.setLayout(new GridLayout(2,1));
            confirmOrCancelJPanel.setBackground(Color.WHITE);
            confirmOrCancelJPanel.setOpaque(true);
            confirmOrCancelJPanel.setPreferredSize(new Dimension(160, 15));
            //設置調整button位置的panel
            ccPanel.setLayout(new GridLayout(1,3));
            ccPanel.setBackground(Color.WHITE);
            ccPanel.setOpaque(true);
            ccPanel.setPreferredSize(new Dimension(160, 25));
            //設置button大小
            confirmButton.setPreferredSize(new Dimension(80, 25));
            cancelButton.setPreferredSize(new Dimension(80, 25));
            //調整button位置
            ccPanel.add(new Label());
            ccPanel.add(confirmButton);
            ccPanel.add(cancelButton);

            confirmOrCancelJPanel.add(new Label());
            confirmOrCancelJPanel.add(ccPanel,BorderLayout.EAST);
            
            cancelButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    addNewPasswardFrame.dispose();
                }
            });
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        char[] passwordChars = passwardJTextField.getPassword();
                        String password = new String(passwordChars);
                        String account=accountJTextField.getText();
                        String app=appJTextField.getText();
                        if(account.isEmpty() && password.isEmpty() && app.isEmpty()){
                            throw new Exception("Please enter your account's information!");
                        }
                        else if (account.isEmpty()){
                            throw new Exception("Please enter your account!");
                        }
                        else if(password.isEmpty()){
                            throw new Exception("Please enter your password!");
                        }
                        else if(app.isEmpty()){
                            throw new Exception("Please enter your App's name!");
                        }
                        passward.add(new MouseTestHome(app,account,password,picturelabel.getIcon()));
                        passwardUpdate();
                        addNewPasswardFrame.dispose();
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            //右方所有東西的統整
            JPanel rightJPanel=new JPanel();
            rightJPanel.setPreferredSize(new Dimension(300, 300));
            rightJPanel.setBackground(Color.WHITE);
            rightJPanel.setOpaque(true);
            rightJPanel.setLayout(new GridLayout(6,1));
            
            rightJPanel.add(label1);
            rightJPanel.add(appJPanel);
            rightJPanel.add(accountJPanel);
            rightJPanel.add(passwardJPanel);
            rightJPanel.add(addPictureJPanel,BorderLayout.WEST);
            rightJPanel.add(confirmOrCancelJPanel,BorderLayout.EAST);

            addNewPasswardFrame.add(rightJPanel,BorderLayout.EAST);
            addNewPasswardFrame.setVisible(true);
        }
    }
    public void addPicture(JButton button){
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        //過濾讀取文件類型
        FileNameExtensionFilter filter=new FileNameExtensionFilter("jpg","png");
        chooser.setFileFilter(filter);
        int returnVal=chooser.showOpenDialog(button);
        
        if(returnVal==JFileChooser.APPROVE_OPTION){
            //取得選擇的File
            File[] files=chooser.getSelectedFiles();
            if(files==null || files.length==0){
                return;
            }
            //檢查選擇檔案類型
            File F=chooser.getSelectedFile();
            //取得檔案名稱
            String fileName=F.getName();
            String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
            if(!(prefix.equals("jpg")) && !(prefix.equals("png"))){
                JOptionPane.showMessageDialog(new JDialog(),"Please select an image file type of jpg or png!");
                return;
            }
            FileInputStream input=null;
            FileOutputStream output=null;
            //放上傳檔案的路徑
            String path="C:\\Users\\user\\OneDrive\\桌面\\DogePasswordManagementProject\\DogePasswordManagementProject\\demo\\src\\picture";
            try{
                for(File f:files){
                    File dir=new File(path);
                    //目標資料夾
                    File[] fs=dir.listFiles();
                    HashSet<String> set = new HashSet<String>();
                    for(File file:fs){
                        set.add(file.getName());
                    }
                    //判斷是否已有該文件
                    if(set.contains(f.getName())){
                        JOptionPane.showMessageDialog(new JDialog(),f.getName() + "This file already exists.");
                        return;
                    }
                    //取得選擇文件的絕對路徑
                    String absolutePath=chooser.getSelectedFile().getAbsolutePath();
                    //選擇的圖片
                    ImageIcon img=new ImageIcon(absolutePath);
                    picturelabel.setIcon(img);
                    picturelabel.getIcon();
                    input=new FileInputStream(f);
                    byte[] buffer=new byte[1024];
                    File des = new File(path,f.getName());
                    output=new FileOutputStream(des);
                    int len=0;
                    while(-1 != (len = input.read(buffer))){
                        output.write(buffer,0,len);
                    }
                    output.close();
                    input.close();
                }
                JOptionPane.showMessageDialog(null, "upload success!","Hint",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "upload failed QAQ", "Hint", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "upload failed QAQ", "Hint", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    public void passwardUpdate(){
        passwordPanel.removeAll();
        passwordPanel.repaint();
        // JLabel testJLabel=new JLabel("testRRRRRRRRRRR");
        // passwordPanel.add(testJLabel,BorderLayout.CENTER);

        //放一組帳密的Panel
        JLabel label=new JLabel();
        //放所有帳密的Panel
        JPanel apPanel=new JPanel();
        //設定為垂直滾動
        apPanel.setLayout(new BoxLayout(apPanel, BoxLayout.Y_AXIS));
        
        apPanel.setBackground(Color.WHITE);
        apPanel.setOpaque(true);

        // for(int i=0;i<1000;i++)
        //     apPanel.add(new JLabel(passwardimg));
        
        for(MouseTestHome i:passward){
            BackgroundPanel newPasswardJPanel=new BackgroundPanel(passwardimg.getImage());
            ImageIcon img=RoundImageIconObject.getRoundImageIcon(i.getImg());//app的圖片
            JLabel imgJLabel;//放app圖片的label
            // JLabel app=new JLabel(i.getApp());//app名稱
            JLabel accountWithApp=new JLabel(i.getApp() + "'s account:");//帳號部分的開頭
            JTextField account=new JTextField(i.getAccount());//帳號
            JLabel passwardWithApp=new JLabel(i.getApp() + "'s password:");//密碼部分的開頭
            password=new JPasswordField(i.getPassward());//密碼
            JPanel passwordJPanel=new JPanel();
            JLabel passwardLabel=new JLabel();//放密碼的label
            JLabel accountLabel=new JLabel();//放帳號的label
            ImageIcon setapImageIcon=new ImageIcon("demo\\src\\picture\\settings_color.png");
            ImageIcon deleteImageIcon=new ImageIcon("demo\\src\\picture\\trash_color.png");
            ImageIcon eyeImageIcon=new ImageIcon("demo\\src\\picture\\eye-crossed_23.png");
            JButton setapButton=new JButton();
            JButton deleteButton=new JButton();
            JButton eyeButton=new JButton();
            setapButton.setBorder(null);
            deleteButton.setBorder(null);
            setapButton.setBackground(Color.WHITE);
            setapButton=new JButton(setapImageIcon);
            deleteButton=new JButton(deleteImageIcon);
            eyeButton=new JButton(eyeImageIcon);
            // setapButton.setPreferredSize(new Dimension(25,25));
            // deleteButton.setPreferredSize(new Dimension(25, 25));
            setapButton.setBounds(5, 20, 25, 25);
            deleteButton.setBounds(5, 77, 25, 25);
            eyeButton.setPreferredSize(new Dimension(25, 25));
            eyeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    char echoChar = password.getEchoChar();
                    if (echoChar == 0) {
                        password.setEchoChar('*');
                    } else {
                        password.setEchoChar((char) 0);
                    }
                }
            });
            //設定密碼隱藏時用甚麼字元顯示
            password.setEchoChar('*');
            //設定文字框不能輸入
            account.setEditable(false);
            password.setEditable(false);
            //設定JLable文字大小
            accountWithApp.setFont(new Font("Arial", Font.BOLD, 15));
            passwardWithApp.setFont(new Font("Arial", Font.BOLD, 15));

            account.setBackground(Color.WHITE);
            password.setBackground(Color.WHITE);
            accountLabel.setBackground(Color.WHITE);
            passwardLabel.setBackground(Color.WHITE);
            //將帳號放入帳號的label
            accountLabel.setLayout(new GridLayout(2,2));
            accountLabel.add(new Label());
            accountLabel.add(new Label());
            accountLabel.add(accountWithApp);
            accountLabel.add(account);
            //將密碼放入密碼的label
            passwardLabel.setLayout(new GridLayout(2,2));
            passwordJPanel.setPreferredSize(new Dimension(100, 23));
            password.setPreferredSize(new Dimension(90, 23));
            passwordJPanel.setLayout(new BorderLayout());
            passwardLabel.add(passwardWithApp);
            passwordJPanel.add(password,BorderLayout.CENTER);
            passwordJPanel.add(eyeButton,BorderLayout.EAST);
            passwardLabel.add(passwordJPanel);
            passwardLabel.add(new Label());
            passwardLabel.add(new Label());
            // //設定一個 passward panel 大小
            // newPasswardJPanel.setPreferredSize(new Dimension(500, 10));
            //設定圖片大小
            img.setImage(img.getImage().getScaledInstance(135, 125, Image.SCALE_DEFAULT));
            imgJLabel=new JLabel(img);
            //放帳密的 panel
            JPanel apJPanel=new JPanel();
            apJPanel.setPreferredSize(new Dimension(150, 70));
            apJPanel.setLayout(new GridLayout(2,1));
            apJPanel.add(accountLabel);
            apJPanel.add(passwardLabel);
            apJPanel.setBackground(Color.WHITE);
            newPasswardJPanel.setLayout(new BorderLayout());
            JLabel[] label1=new JLabel[7];
            for(int j=0;j<2;j++){
                label1[j]=new JLabel();
                label1[j].setVisible(true);
                label1[j].setPreferredSize(new Dimension(100,162));
            }
            for(int j=2;j<4;j++){
                label1[j]=new JLabel();
                label1[j].setVisible(true);
                label1[j].setPreferredSize(new Dimension(500,23));
            }
            //加入功能按鈕
            // label1[0].setLayout(new GridLayout(5,5));
            // for(int j=0;j<5;j++)
            //     label1[0].add(label1[2]);

            label1[0].add(setapButton);

            // for(int j=0;j<9;j++)
            //     label1[0].add(label1[2]);

            label1[0].add(deleteButton);

            // for(int j=0;j<9;j++)
            //     label1[0].add(label1[2]);
            newPasswardJPanel.add(label1[2],BorderLayout.NORTH);
            newPasswardJPanel.add(imgJLabel,BorderLayout.WEST);
            newPasswardJPanel.add(apJPanel,BorderLayout.CENTER);
            newPasswardJPanel.add(label1[0],BorderLayout.EAST);
            newPasswardJPanel.add(label1[3],BorderLayout.SOUTH);
            newPasswardJPanel.setBackground(Color.WHITE);
            apPanel.add(newPasswardJPanel);
        }
        // 調整中間顯示帳密的地方
        for(int k=0;k<3-passward.size();k++){
            JPanel newPasswardJPanel=new JPanel();
            //設定中間卡位Panel的大小
            newPasswardJPanel.setPreferredSize(new Dimension(500,162));
            newPasswardJPanel.setBackground(Color.WHITE);
            apPanel.add(newPasswardJPanel);
        }
        //將帳密放入中間
        JScrollPane scrollPane = new JScrollPane(apPanel);
        //設定沒有編框
        scrollPane.setBorder(null);
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            @Override
            public boolean isVisible() {
                return true;
            }
        };
        //設定不顯示滾輪
        scrollPane.setVerticalScrollBar(scrollBar);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //設定滾動速度
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        //設定大小
        scrollPane.setPreferredSize(new Dimension(550, 470));
        passwordPanel.add(scrollPane,BorderLayout.CENTER);
        passwordPanel.revalidate();
    }

}
