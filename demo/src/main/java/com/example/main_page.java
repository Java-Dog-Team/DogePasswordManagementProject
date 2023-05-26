package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class main_page {
    // 上方的Panel
    private static JPanel topPanel = new JPanel();
    // 左方放按鈕的Panel
    private static JPanel leftPanel = new JPanel();
    public static JLabel mainLabel = new JLabel();
    private static MouseTest jFrame;
    private static JLabel topJLabel = new JLabel("WatchDog");
    // 取得螢幕大小
    private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static int w = dimension.width;
    public static int h = dimension.height;
    // 大頭貼
    private static JLabel topMyHeadIconJLabel = new JLabel();
    private static ImageIcon myheadIcon = new ImageIcon();
    // 左方五個選單按鈕圖片
    private static ImageIcon homeIcon = new ImageIcon();
    private static ImageIcon lockIcon = new ImageIcon();
    private static ImageIcon bellIcon = new ImageIcon();
    private static ImageIcon sparklesIcon = new ImageIcon();
    private static ImageIcon interrogationIcon = new ImageIcon();
    // 左方五個選單按鈕
    private static JLabel homeLabel = new JLabel();
    private static JLabel passwordLabel = new JLabel();
    private static JLabel alertLabel = new JLabel();
    private static JLabel themeLabel = new JLabel();
    private static JLabel QALabel = new JLabel();
    // 背景圖片
    private static ImageIcon backGround;
    // 其他功能
    private static Home home;
    private static Reminder reminder;
    private static generatePassword generate;
    private static DesignPage designPage;
    private static UserInterface userInterface = new UserInterface("sw710407@gmail.com");

    private final static String username = "sw710407@gmail.com";
    private final static String phone = "0974002156";

    // public main_page(String username, String phone){
    // this.username=username;
    // this.phone=phone;
    // }
    
    public static void main(String[] args) {
        mainLabel.setLayout(new BorderLayout());
        jFrame = new MouseTest(leftPanel, mainLabel);
        createWindow();
    }

    public static void load() throws Exception {
        List<RecordData> list = userInterface.fetchAllUserData();
        for (RecordData i : list) {
            ImageIcon deleteImageIcon = new ImageIcon("demo\\src\\picture\\trash_color.png");
            ImageIcon settingImageIcon = new ImageIcon("demo\\src\\picture\\settings_color.png");
            JButton settingButton = new JButton(settingImageIcon);
            JButton deleteButton = new JButton(deleteImageIcon);
            home.passward.add(new Information(userInterface, home, i.getIndex(), false, i.getAppName(), i.getUsername(),
                    i.getPassword(), settingButton,
                    deleteButton, i.getImage()));
        }
    }

    public static void createWindow() {

        jFrame.setContentPane(mainLabel);
        mainLabel.setOpaque(true);

        // mainLabel.setBackground(Color.BLACK);
        jFrame.getContentPane().setLayout(new BorderLayout());
        // 設定視窗大小
        jFrame.setSize(1024, 576);
        // 視窗不可調整大小
        jFrame.setResizable(false);
        // 設定關閉視窗即程式結束
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 設置左上角小圖片
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
        if (imgURL != null) {
            arrowIcon = new ImageIcon(imgURL);
            jFrame.setIconImage(arrowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(jFrame, "Icon image not found.");
        }

        setBackground(backGround);
        setTopJLabel(topJLabel);// 設定上方邊條
        setTopJLabelPicture(myheadIcon);// 設定大頭貼
        setFiveButton(homeIcon, lockIcon, bellIcon, sparklesIcon, interrogationIcon);// 設定左邊5個按鈕
        createUI(jFrame);// 放入物件
        // JFrame.setDefaultLookAndFeelDecorated(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        // callMouse();
    }

    private static void createUI(JFrame frame) {
        leftPanel.setLayout(new GridLayout(5, 1));
        topPanel.setLayout(new BorderLayout());
        // 加入上面的標題文字
        topPanel.add(topJLabel, BorderLayout.WEST);
        // 加入大頭貼
        topPanel.add(topMyHeadIconJLabel, BorderLayout.EAST);
        // 加入五個按鈕
        leftPanel.add(homeLabel);
        leftPanel.add(passwordLabel);
        leftPanel.add(alertLabel);
        leftPanel.add(themeLabel);
        leftPanel.add(QALabel);
        // 設定上方邊條背景顏色
        topPanel.setBackground(new Color(230, 217, 148, 255));
        topPanel.setOpaque(true);
        // 設定左方邊條背景顏色
        leftPanel.setBackground(new Color(255, 255, 255, 255));
        leftPanel.setOpaque(true);
        // 設定上方邊條大小
        topPanel.setPreferredSize(new Dimension(w, h / 15));
        mainLabel.add(topPanel, BorderLayout.NORTH);
        mainLabel.add(leftPanel, BorderLayout.WEST);
        home = new Home(userInterface);
        reminder = new Reminder(mainLabel, username, phone);
        generate = new generatePassword(mainLabel);
        designPage = new DesignPage(mainLabel);
        jFrame.setHome(home);
        jFrame.setReminder(reminder);
        jFrame.setGenerate(generate);
        jFrame.setMainLabel(mainLabel);
        jFrame.setDesignPage(designPage);
        try {
            load();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void setTopJLabel(JLabel topJLabel) {
        main_page.topJLabel = topJLabel;
        main_page.topJLabel.setForeground(new Color(32, 41, 107));
        main_page.topJLabel.setPreferredSize(new Dimension(100, h / 20));
        main_page.topJLabel.setFont(new Font(Font.SERIF, 0, 18));
    }

    public static void setTopJLabelPicture(ImageIcon myheadIcon) {
        // 將圖片切成圓形
        Icon img = new ImageIcon("demo\\src\\picture\\dog.png");
        myheadIcon = RoundImageIconObject.getRoundImageIcon(img);
        myheadIcon.setImage(myheadIcon.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
        main_page.topMyHeadIconJLabel = new JLabel(myheadIcon);
        main_page.topMyHeadIconJLabel.setPreferredSize(new Dimension(50, 40));
    }

    public static void setFiveButton(ImageIcon homeIcon, ImageIcon lockIcon, ImageIcon bellIcon, ImageIcon sparklesIcon,
            ImageIcon interrogationIcon) {
        String color = "yellow";
        homeIcon = new ImageIcon("demo\\src\\picture\\調好的圖片\\home_" + color + ".png");
        lockIcon = new ImageIcon("demo\\src\\picture\\調好的圖片\\lock_" + color + ".png");
        bellIcon = new ImageIcon("demo\\src\\picture\\調好的圖片\\bell_" + color + ".png");
        sparklesIcon = new ImageIcon("demo\\src\\picture\\調好的圖片\\sparkles_" + color + ".png");
        interrogationIcon = new ImageIcon("demo\\src\\picture\\調好的圖片\\interrogation_" + color + ".png");

        main_page.homeLabel = new JLabel(homeIcon);
        main_page.passwordLabel = new JLabel(lockIcon);
        main_page.alertLabel = new JLabel(bellIcon);
        main_page.themeLabel = new JLabel(sparklesIcon);
        main_page.QALabel = new JLabel(interrogationIcon);
    }

    public static void setBackground(ImageIcon backGround) {
        if (backGround == null) {
            // 設定背景顏色
            jFrame.getContentPane().setBackground(new Color(255, 255, 255, 255));
        }
    }

    public static JFrame getjFrame() {
        return jFrame;
    }

    public static JLabel getMainLabel() {
        return mainLabel;
    }

}