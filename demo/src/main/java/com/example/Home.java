package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;

public class Home extends main_page {
    public UserInterface userInterface;
    public JPanel passwordPanel;
    public ImageIcon passwardimg = new ImageIcon(SwingTester.class.getResource("home_passward_panel_1.png"));
    public JScrollPane scrollPane = new JScrollPane(passwordPanel);
    public ArrayList<Information> passward = new ArrayList<Information>();
    public JButton addPasswardButton = new JButton(new ImageIcon(SwingTester.class.getResource("addPassward.png")));
    public JLabel picturelabel;
    public JButton addPictureButton = new JButton("+add picture");
    public JFrame addNewPasswardFrame;
    public JTextField appJTextField;
    public JTextField accountJTextField;
    public JPasswordField passwardJTextField;
    public JPasswordField password;
    public Home home = this;
    public JFrame jFrame;

    public Home(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void creatPasswordPanel(JPanel passwardJPanel) throws Exception {
        // 移除當前 Panel 內的所有物件
        passwordPanel = passwardJPanel;
        passwardUpdate();
    }

    public void creatAddPasswardButton(JFrame jFrame,JPanel addJPanel) {
        this.jFrame=jFrame;
        ButtonHandler handler = new ButtonHandler();// 加入密碼的buttonHandler
        // 設定button
        addPasswardButton.setPreferredSize(new Dimension(57, 54));// 大小
        addPasswardButton.addActionListener(handler);// ActionListener
        // 設定 Button 的 pannel
        addJPanel.setLayout(new BorderLayout());
        addJPanel.setBackground(Color.WHITE);
        addJPanel.add(addPasswardButton, BorderLayout.SOUTH);
        addJPanel.setVisible(true);

        JButton logout=new JButton(new ImageIcon(SwingTester.class.getResource("logout.png")));
        JPanel logoutJPanel=new JPanel();
        logoutJPanel.setBackground(Color.WHITE);
        logoutJPanel.setOpaque(true);
        logout.setPreferredSize(new Dimension(30, 30));
        logoutJPanel.add(logout);
        addJPanel.add(logoutJPanel,BorderLayout.NORTH);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new login().createWindow();
            }
        });
    }

    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 彈出加入新密碼的視窗
            addNewPasswardFrame = new JFrame("加入新密碼");
            addNewPasswardFrame.setSize(600, 335);
            // 視窗出現在中間
            addNewPasswardFrame.setLocationRelativeTo(null);
            // 不可調整視窗大小
            addNewPasswardFrame.setResizable(false);
            // 設定視窗背景顏色
            addNewPasswardFrame.getContentPane().setBackground(Color.WHITE);
            // 設置左上角小圖片
            ImageIcon arrowIcon = null;
            java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
            if (imgURL != null) {
                arrowIcon = new ImageIcon(imgURL);
                addNewPasswardFrame.setIconImage(arrowIcon.getImage());
            } else {
                JOptionPane.showMessageDialog(addNewPasswardFrame, "Icon image not found.");
            }

            // 只關閉當前視窗
            addNewPasswardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // 加入密碼照片
            ImageIcon picture = arrowIcon;
            picturelabel = new JLabel(picture);
            picturelabel.setVisible(true);

            // 設定顯示圖片大小
            picturelabel.setPreferredSize(new Dimension(250, 250));
            picturelabel.setBackground(Color.WHITE);
            picturelabel.setOpaque(true);
            addNewPasswardFrame.add(picturelabel, BorderLayout.WEST);

            // APP名稱
            JLabel appJLabel = new JLabel("App's name:");
            appJTextField = new JTextField();
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
            accountJTextField = new JTextField();
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
            passwardJTextField = new JPasswordField();
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

            cancelButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    jFrame.dispose();
                    addNewPasswardFrame.dispose();
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
                        JButton settingButton = new JButton();
                        JButton deleteButton = new JButton();
                        boolean delete = false;
                        ImageIcon settingImageIcon = new ImageIcon(SwingTester.class.getResource("settings_color.png"));
                        ImageIcon deleteImageIcon = new ImageIcon(SwingTester.class.getResource("trash_color.png"));
                        settingButton = new JButton(settingImageIcon);
                        deleteButton = new JButton(deleteImageIcon);
                        int index = passward.size();

                        if (account.isEmpty() && password.isEmpty() && app.isEmpty()) {
                            throw new Exception("Please enter your account's information!");
                        } else if (account.isEmpty()) {
                            throw new Exception("Please enter your account!");
                        } else if (password.isEmpty()) {
                            throw new Exception("Please enter your password!");
                        } else if (app.isEmpty()) {
                            throw new Exception("Please enter your App's name!");
                        }
                        passward.add(new Information(userInterface,home, index, delete, app, account, password, settingButton,deleteButton, picturelabel.getIcon()));
                        userInterface.insertOneUserData(app,account,password,picturelabel.getIcon(),index);
                        passwardUpdate();
                        addNewPasswardFrame.dispose();
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

            addNewPasswardFrame.add(rightJPanel, BorderLayout.EAST);
            addNewPasswardFrame.setVisible(true);
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
        }
    }

    public void passwardUpdate() throws Exception {
        passwordPanel.removeAll();
        passwordPanel.repaint();
        passward = new ArrayList<Information>();
        List<RecordData> newData=userInterface.fetchAllUserData();
        for(RecordData i:newData){
            JButton settingButton = new JButton();
            JButton deleteButton = new JButton();
            boolean delete = false;
            ImageIcon settingImageIcon = new ImageIcon(SwingTester.class.getResource("settings_color.png"));
            ImageIcon deleteImageIcon = new ImageIcon(SwingTester.class.getResource("trash_color.png"));
            settingButton = new JButton(settingImageIcon);
            deleteButton = new JButton(deleteImageIcon);
            passward.add(new Information(userInterface, home, i.getIndex(), 
                    delete, i.getAppName(), i.getUsername(), i.getPassword(), settingButton,deleteButton, 
                    i.getImage()));
        }
        // 放一組帳密的Panel
        // 放所有帳密的Panel
        JPanel apPanel = new JPanel();
        // 設定為垂直滾動
        apPanel.setLayout(new BoxLayout(apPanel, BoxLayout.Y_AXIS));

        apPanel.setBackground(Color.WHITE);
        apPanel.setOpaque(true);
        int cou = 0;
        for (Information i : passward) {
            RecordData OldData = new RecordData(i.getApp(), i.getAccount(), i.getPassward(), i.getImg(), i.getIndex());
            RecordData NewData = new RecordData(i.getApp(), i.getAccount(), i.getPassward(), i.getImg(), cou);
            userInterface.updateOneUserData(OldData, NewData);
            i.setIndex(cou);
            BackgroundPanel newPasswardJPanel = i.setAPPanel();
            apPanel.add(newPasswardJPanel);
            cou++;
        }

        // 調整中間顯示帳密的地方
        for (int k = 0; k < 3 - passward.size(); k++) {
            JPanel newPasswardJPanel = new JPanel();
            // 設定中間卡位Panel的大小
            newPasswardJPanel.setPreferredSize(new Dimension(500, 162));
            newPasswardJPanel.setBackground(Color.WHITE);
            apPanel.add(newPasswardJPanel);
        }
        // 將帳密放入中間
        JScrollPane scrollPane = new JScrollPane(apPanel);
        // 設定沒有編框
        scrollPane.setBorder(null);
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            @Override
            public boolean isVisible() {
                return true;
            }
        };
        // 設定不顯示滾輪
        scrollPane.setVerticalScrollBar(scrollBar);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        // 設定滾動速度
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        // 設定大小
        scrollPane.setPreferredSize(new Dimension(550, 470));
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(scrollPane);
        passwordPanel.revalidate();
    }

}