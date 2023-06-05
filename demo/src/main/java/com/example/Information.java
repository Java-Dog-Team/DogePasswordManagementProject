package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Information {
    public JButton settingButton;
    public JButton deleteButton;
    public boolean delete;
    public ImageIcon passwardimg = new ImageIcon(SwingTester.class.getResource("home_passward_panel_1.png"));
    public JButton addPictureButton = new JButton("+add picture");
    public Home home;
    public JFrame settingFrame = new JFrame();
    public JTextField appJTextField;
    public JTextField accountJTextField;
    public JPasswordField passwardJTextField;
    public JPasswordField password;
    public JLabel picturelabel;
    public upLoadData upLoadData;
    public UserInterface userInterface;
    public RecordData recordData1;
    public RecordData recordData2;

    public Information(UserInterface userInterface, Home home, int index, boolean delete, String app, String account,String passward,JButton settingButton, JButton deleteButton, Icon img) {
        this.userInterface = userInterface;
        this.home = home;
        this.settingButton = settingButton;
        this.deleteButton = deleteButton;
        this.delete = delete;
        this.upLoadData = new upLoadData(index, app, account, passward, img);
        setDeleteButton(this.deleteButton);
        setSettingButton(this.settingButton);
    }

    public Icon getImg() {
        return upLoadData.getImg();
    }

    public void setImg(Icon img) {
        upLoadData.setImg(img);
    }

    public String getAccount() {
        return upLoadData.getAccount();
    }

    public void setAccount(String account) {
        upLoadData.setAccount(account);
    }

    public String getPassward() {
        return upLoadData.getPassword();
    }

    public void setPassward(String passward) {
        upLoadData.setPassword(passward);
    }

    public String getApp() {
        return upLoadData.getApp();
    }

    public void setApp(String app) {
        upLoadData.setApp(app);
    }

    public JButton getSettingButton() {
        return settingButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public int getIndex() {
        return upLoadData.getIndex();
    }

    public void setIndex(int index) {
        upLoadData.setIndex(index);
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public void setDeleteButton(JButton deleteButton) {
        ActionListener listener = new ActionListener() {
            String app = getApp();
            String name = getAccount();
            String pass = getPassward();
            int index = getIndex();
            public void actionPerformed(ActionEvent e) {
                try {
                    userInterface.deleteOneUserData(app, name, pass, index);
                } catch (Exception ex) {
                    System.out.print(ex);
                }
                try {
                    home.passwardUpdate();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        };
        deleteButton.addActionListener(listener);
    }

    public void setSettingButton(JButton settingButton) {
        ButtonHandler handler = new ButtonHandler();// 加入密碼的buttonHandler
        // 設定button
        settingButton.addActionListener(handler);
    }

    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            recordData1 = new RecordData(getApp(), getAccount(), getPassward(), getImg(), getIndex());
            // 彈出加入新密碼的視窗
            settingFrame = new JFrame("設定新密碼");
            settingFrame.setSize(600, 335);
            // 視窗出現在中間
            settingFrame.setLocationRelativeTo(null);
            // 不可調整視窗大小
            settingFrame.setResizable(false);
            // 設定視窗背景顏色
            settingFrame.getContentPane().setBackground(Color.WHITE);
            // 設置左上角小圖片
            ImageIcon arrowIcon = null;
            java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
            if (imgURL != null) {
                arrowIcon = new ImageIcon(imgURL);
                settingFrame.setIconImage(arrowIcon.getImage());
            } else {
                JOptionPane.showMessageDialog(settingFrame, "Icon image not found.");
            }

            // 只關閉當前視窗
            settingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // 加入密碼照片
            picturelabel = new JLabel(getImg());
            picturelabel.setVisible(true);

            // 設定顯示圖片大小
            picturelabel.setPreferredSize(new Dimension(250, 250));
            picturelabel.setBackground(Color.WHITE);
            picturelabel.setOpaque(true);
            settingFrame.add(picturelabel, BorderLayout.WEST);

            // APP名稱
            JLabel appJLabel = new JLabel("App's name:");
            appJTextField = new JTextField(getApp());
            JPanel appJPanel = new JPanel();
            JPanel apptxJPanel = new JPanel();

            appJLabel.setBackground(Color.WHITE);
            appJLabel.setOpaque(true);
            appJPanel.setPreferredSize(new Dimension(100, 20));
            appJPanel.setLayout(new BorderLayout());
            appJPanel.add(appJLabel, BorderLayout.NORTH);
            appJTextField.setPreferredSize(new Dimension(250, 23));
            apptxJPanel.add(appJTextField, BorderLayout.WEST);
            apptxJPanel.setPreferredSize(new Dimension(250, 25));
            apptxJPanel.setBackground(Color.WHITE);
            apptxJPanel.setOpaque(true);
            appJPanel.setBackground(Color.WHITE);
            appJPanel.setOpaque(true);
            appJPanel.add(apptxJPanel, BorderLayout.WEST);

            // 帳號
            JLabel accountJLabel = new JLabel("Account:");
            accountJTextField = new JTextField(getAccount());
            JPanel accountJPanel = new JPanel();
            JPanel txJPanel = new JPanel();

            accountJLabel.setBackground(Color.WHITE);
            accountJLabel.setOpaque(true);
            accountJPanel.setPreferredSize(new Dimension(100, 20));
            accountJPanel.setLayout(new BorderLayout());
            accountJPanel.add(accountJLabel, BorderLayout.NORTH);
            accountJTextField.setPreferredSize(new Dimension(250, 23));
            txJPanel.add(accountJTextField, BorderLayout.WEST);
            txJPanel.setPreferredSize(new Dimension(250, 25));
            txJPanel.setBackground(Color.WHITE);
            txJPanel.setOpaque(true);
            accountJPanel.setBackground(Color.WHITE);
            accountJPanel.setOpaque(true);
            accountJPanel.add(txJPanel, BorderLayout.WEST);

            // 密碼
            JLabel passwardJLabel = new JLabel("password:");
            passwardJTextField = new JPasswordField(getPassward());
            JPanel psJPanel = new JPanel();
            JPanel passwardJPanel = new JPanel();

            passwardJLabel.setBackground(Color.WHITE);
            passwardJLabel.setOpaque(true);
            passwardJPanel.setPreferredSize(new Dimension(100, 20));
            passwardJPanel.setLayout(new BorderLayout());
            passwardJPanel.add(passwardJLabel, BorderLayout.NORTH);
            passwardJTextField.setPreferredSize(new Dimension(250, 23));
            psJPanel.add(passwardJTextField, BorderLayout.WEST);
            psJPanel.setPreferredSize(new Dimension(250, 25));
            psJPanel.setBackground(Color.WHITE);
            psJPanel.setOpaque(true);
            passwardJPanel.setBackground(Color.WHITE);
            passwardJPanel.setOpaque(true);
            passwardJPanel.add(psJPanel, BorderLayout.WEST);

            // 新增圖片按鈕
            JPanel addPictureJPanel = new JPanel();
            JLabel label1 = new JLabel();
            JPanel btJPanel = new JPanel();

            addPictureButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
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
            btJPanel.add(addPictureButton, BorderLayout.WEST);
            addPictureJPanel.add(label1, BorderLayout.NORTH);
            addPictureJPanel.add(btJPanel, BorderLayout.WEST);
            // 確認 || 取消新增帳密
            JButton confirmButton = new JButton("confirm");
            JButton cancelButton = new JButton("cancel");
            JPanel confirmOrCancelJPanel = new JPanel();
            JPanel ccPanel = new JPanel();

            confirmOrCancelJPanel.setLayout(new GridLayout(2, 1));
            confirmOrCancelJPanel.setBackground(Color.WHITE);
            confirmOrCancelJPanel.setOpaque(true);
            confirmOrCancelJPanel.setPreferredSize(new Dimension(160, 15));
            // 設置調整button位置的panel
            ccPanel.setLayout(new GridLayout(1, 3));
            ccPanel.setBackground(Color.WHITE);
            ccPanel.setOpaque(true);
            ccPanel.setPreferredSize(new Dimension(160, 25));
            // 設置button大小
            confirmButton.setPreferredSize(new Dimension(80, 25));
            cancelButton.setPreferredSize(new Dimension(80, 25));
            // 調整button位置
            ccPanel.add(new Label());
            ccPanel.add(confirmButton);
            ccPanel.add(cancelButton);

            confirmOrCancelJPanel.add(new Label());
            confirmOrCancelJPanel.add(ccPanel, BorderLayout.EAST);

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    settingFrame.dispose();
                }
            });
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        char[] passwordChars = passwardJTextField.getPassword();
                        String password = new String(passwordChars);
                        String account = accountJTextField.getText();
                        String app = appJTextField.getText();
                        ImageIcon settingImageIcon = new ImageIcon(SwingTester.class.getResource("settings_color.png"));
                        ImageIcon deleteImageIcon = new ImageIcon(SwingTester.class.getResource("trash_color.png"));
                        Icon img = picturelabel.getIcon();
                        settingButton = new JButton(settingImageIcon);
                        deleteButton = new JButton(deleteImageIcon);

                        if (account.isEmpty() && password.isEmpty() && app.isEmpty()) {
                            throw new Exception("Please enter your account's information!");
                        } else if (app.isEmpty()) {
                            throw new Exception("Please enter your App's name!");
                        } else if (account.isEmpty()) {
                            throw new Exception("Please enter your account!");
                        } else if (password.isEmpty()) {
                            throw new Exception("Please enter your password!");
                        }

                        // 更新要儲存的值
                        setApp(app);
                        setAccount(account);
                        setPassward(password);
                        setImg(img);
                        setDeleteButton(deleteButton);
                        setSettingButton(settingButton);
                        recordData2 = new RecordData(app, account, password, img, getIndex());
                        userInterface.updateOneUserData(recordData1, recordData2);
                        // 重新畫中間panel
                        home.passwardUpdate();
                        settingFrame.dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            // 右方所有東西的統整
            JPanel rightJPanel = new JPanel();
            rightJPanel.setPreferredSize(new Dimension(300, 300));
            rightJPanel.setBackground(Color.WHITE);
            rightJPanel.setOpaque(true);
            rightJPanel.setLayout(new GridLayout(6, 1));

            rightJPanel.add(label1);
            rightJPanel.add(appJPanel);
            rightJPanel.add(accountJPanel);
            rightJPanel.add(passwardJPanel);
            rightJPanel.add(addPictureJPanel, BorderLayout.WEST);
            rightJPanel.add(confirmOrCancelJPanel, BorderLayout.EAST);

            settingFrame.add(rightJPanel, BorderLayout.EAST);
            settingFrame.setVisible(true);
        }
    }

    public void addPicture(JButton button) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        // 過濾讀取文件類型
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(button);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // 取得選擇的File
            File[] files = chooser.getSelectedFiles();
            if (files == null || files.length == 0) {
                return;
            }
            // 檢查選擇檔案類型
            File F = chooser.getSelectedFile();
            // 取得檔案名稱
            String fileName = F.getName();
            String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (!(prefix.equals("jpg")) && !(prefix.equals("png"))) {
                JOptionPane.showMessageDialog(new JDialog(), "Please select an image file type of jpg or png!");
                return;
            }
            // 取得選擇文件的絕對路徑
            String absolutePath = chooser.getSelectedFile().getAbsolutePath();
            // 選擇的圖片
            ImageIcon img = new ImageIcon(absolutePath);
            picturelabel.setIcon(img);
            JOptionPane.showMessageDialog(null, "upload success!", "Hint", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return;
        }
        return;
    }

    public BackgroundPanel setAPPanel() {
        BackgroundPanel newPasswardJPanel = new BackgroundPanel(passwardimg.getImage());
        ImageIcon img = RoundImageIconObject.getRoundImageIcon(getImg());// app的圖片
        JLabel imgJLabel;// 放app圖片的label
        JLabel accountWithApp = new JLabel(getApp() + "'s account:");// 帳號部分的開頭
        JTextField account = new JTextField(getAccount());// 帳號
        JLabel passwardWithApp = new JLabel(getApp() + "'s password:");// 密碼部分的開頭
        password = new JPasswordField(getPassward());// 密碼
        JPanel passwordJPanel = new JPanel();
        JLabel passwardLabel = new JLabel();// 放密碼的label
        JLabel accountLabel = new JLabel();// 放帳號的label
        ImageIcon eyeImageIcon = new ImageIcon(SwingTester.class.getResource("eye-crossed_23.png"));
        JButton settingButton = getSettingButton();
        JButton deleteButton = getDeleteButton();
        JButton eyeButton = new JButton();
        eyeButton = new JButton(eyeImageIcon);
        settingButton.setBounds(5, 20, 25, 25);
        deleteButton.setBounds(5, 77, 25, 25);
        eyeButton.setPreferredSize(new Dimension(25, 25));
        eyeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char echoChar = password.getEchoChar();
                if (echoChar == 0) {
                    password.setEchoChar('*');
                } else {
                    password.setEchoChar((char) 0);
                }
            }
        });
        // 設定密碼隱藏時用甚麼字元顯示
        password.setEchoChar('*');
        // 設定文字框不能輸入
        account.setEditable(false);
        password.setEditable(false);
        // 設定JLable文字大小
        accountWithApp.setFont(new Font("Arial", Font.BOLD, 15));
        passwardWithApp.setFont(new Font("Arial", Font.BOLD, 15));

        account.setBackground(Color.WHITE);
        password.setBackground(Color.WHITE);
        accountLabel.setBackground(Color.WHITE);
        passwardLabel.setBackground(Color.WHITE);
        // 將帳號放入帳號的label
        accountLabel.setLayout(new GridLayout(2, 2));
        accountLabel.add(new Label());
        accountLabel.add(new Label());
        accountLabel.add(accountWithApp);
        accountLabel.add(account);
        // 將密碼放入密碼的label
        passwardLabel.setLayout(new GridLayout(2, 2));
        passwordJPanel.setPreferredSize(new Dimension(100, 23));
        password.setPreferredSize(new Dimension(90, 23));
        passwordJPanel.setLayout(new BorderLayout());
        passwardLabel.add(passwardWithApp);
        passwordJPanel.add(password, BorderLayout.CENTER);
        passwordJPanel.add(eyeButton, BorderLayout.EAST);
        passwardLabel.add(passwordJPanel);
        passwardLabel.add(new Label());
        passwardLabel.add(new Label());
        // 設定圖片大小
        img.setImage(img.getImage().getScaledInstance(135, 125, Image.SCALE_DEFAULT));
        imgJLabel = new JLabel(img);
        // 放帳密的 panel
        JPanel apJPanel = new JPanel();
        apJPanel.setPreferredSize(new Dimension(150, 70));
        apJPanel.setLayout(new GridLayout(2, 1));
        apJPanel.add(accountLabel);
        apJPanel.add(passwardLabel);
        apJPanel.setBackground(Color.WHITE);
        newPasswardJPanel.setLayout(new BorderLayout());
        JLabel[] label1 = new JLabel[7];
        for (int j = 0; j < 2; j++) {
            label1[j] = new JLabel();
            label1[j].setVisible(true);
            label1[j].setPreferredSize(new Dimension(100, 162));
        }
        for (int j = 2; j < 4; j++) {
            label1[j] = new JLabel();
            label1[j].setVisible(true);
            label1[j].setPreferredSize(new Dimension(500, 23));
        }
        // 加入刪除、設定帳密功能按鈕
        label1[0].add(settingButton);
        label1[0].add(deleteButton);

        newPasswardJPanel.add(label1[2], BorderLayout.NORTH);
        newPasswardJPanel.add(imgJLabel, BorderLayout.WEST);
        newPasswardJPanel.add(apJPanel, BorderLayout.CENTER);
        newPasswardJPanel.add(label1[0], BorderLayout.EAST);
        newPasswardJPanel.add(label1[3], BorderLayout.SOUTH);
        newPasswardJPanel.setBackground(Color.WHITE);
        return newPasswardJPanel;
    }
}