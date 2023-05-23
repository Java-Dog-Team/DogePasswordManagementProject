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
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
    public JTextField accountJTextField;
    public JPasswordField passwardJTextField;
    public Home(JLabel mainLabel){
        this.mainLabel=mainLabel;
    }
    public void creatPasswordPanel(JPanel passwardJPanel){
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
    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //彈出加入新密碼的視窗
            addNewPasswardFrame=new JFrame("加入新密碼");
            addNewPasswardFrame.setSize(600, 300);
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
            JLabel passwardJLabel=new JLabel("passward:");
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
            ccPanel.setLayout(new GridLayout(1,3));
            ccPanel.setBackground(Color.WHITE);
            ccPanel.setOpaque(true);
            ccPanel.setPreferredSize(new Dimension(160, 25));
            confirmButton.setPreferredSize(new Dimension(80, 25));
            cancelButton.setPreferredSize(new Dimension(80, 25));
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
                    // char[] passwordChars = passwardJTextField.getPassword();
                    // String password = new String(passwordChars);
                    // passward.add(new MouseTestHome(accountJTextField.getText(),password,picturelabel.getIcon()));
                    passwardUpdate();
                    addNewPasswardFrame.dispose();
                }
            });
            //右方所有東西的統整
            JPanel rightJPanel=new JPanel();
            rightJPanel.setPreferredSize(new Dimension(300, 300));
            rightJPanel.setBackground(Color.WHITE);
            rightJPanel.setOpaque(true);
            rightJPanel.setLayout(new GridLayout(5,1));
            
            rightJPanel.add(label1);
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
<<<<<<< Updated upstream
        JLabel testJLabel=new JLabel("testRRRRRRRRRRR");
        passwordPanel.add(testJLabel,BorderLayout.CENTER);
        // JLabel label=new JLabel(passwardimg);
        // passwordPanel.add(label);
        // for(MouseTestHome i:passward){
        //     JLabel newPasswardJLabel=new JLabel(passwardimg);
        //     JPanel newPasswardJPanel=new JPanel();
        //     ImageIcon img=RoundImageIconObject.getRoundImageIcon(i.getImg());
        //     JLabel imgJLabel;
        //     JLabel account=new JLabel(i.getAccount());
        //     JLabel passward=new JLabel(i.getPassward());
        //     //設定一個 passward panel 大小
        //     newPasswardJLabel.setPreferredSize(new Dimension(500, 162));
        //     newPasswardJPanel.setPreferredSize(new Dimension(500, 162));
        //     //設定圖片大小
        //     img.setImage(img.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
        //     imgJLabel=new JLabel(img);
        //     //放帳密的 panel
        //     JPanel apJPanel=new JPanel();
        //     apJPanel.setPreferredSize(new Dimension(150, 160));
        //     apJPanel.setLayout(new GridLayout(2,1));
        //     apJPanel.add(account);
        //     apJPanel.add(passward);
        //     passwordPanel.add(imgJLabel,BorderLayout.WEST);
        //     passwordPanel.add(apJPanel,BorderLayout.CENTER);
        // }
=======
        passwordPanel=new JPanel();
        for(MouseTestHome i:passward){
            JLabel newPasswardJLabel=new JLabel(passwardimg);
            JPanel newPasswardJPanel=new JPanel();
            ImageIcon img=RoundImageIconObject.getRoundImageIcon(i.getImg());
            JLabel imgJLabel;
            JLabel account=new JLabel(i.getAccount());
            JLabel passward=new JLabel(i.getPassward());
            //設定一個 passward panel 大小
            newPasswardJLabel.setPreferredSize(new Dimension(500, 162));
            newPasswardJPanel.setPreferredSize(new Dimension(500, 162));
            //設定圖片大小
            img.setImage(img.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
            imgJLabel=new JLabel(img);
            //放帳密的 panel
            JPanel apJPanel=new JPanel();
            apJPanel.setPreferredSize(new Dimension(150, 160));
            apJPanel.setLayout(new GridLayout(2,1));
            apJPanel.add(account);
            apJPanel.add(passward);
            passwordPanel.add(imgJLabel,BorderLayout.WEST);
            passwordPanel.add(apJPanel,BorderLayout.CENTER);
        }
>>>>>>> Stashed changes
    }
}
