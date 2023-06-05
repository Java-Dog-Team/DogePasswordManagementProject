package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTest extends JFrame {
    public JFrame jFrame;
    public JPanel addJPanel = new JPanel();
    public JButton addPasswardButton = new JButton(new ImageIcon(SwingTester.class.getResource("addPassward.png")));

    public JLabel mainLabel;
    private JPanel passwardJPanel = new JPanel();
    public JLabel smallLabel = new JLabel();
    public JLabel rightJLabel = new JLabel();
    public JPanel leftPanel = new JPanel();

    // 主題的顏色
    public String color = "yellow";

    public ImageIcon homeIcon = new ImageIcon(SwingTester.class.getResource("home_" + color + ".png"));
    public ImageIcon lockIcon = new ImageIcon(SwingTester.class.getResource("lock_" + color + ".png"));
    public ImageIcon bellIcon = new ImageIcon(SwingTester.class.getResource("bell_" + color + ".png"));
    public ImageIcon sparklesIcon = new ImageIcon(SwingTester.class.getResource("sparkles_" + color + ".png"));
    public ImageIcon interrogationIcon = new ImageIcon(
            SwingTester.class.getResource("interrogation_" + color + ".png"));

    // 其他功能
    public Home home;
    public Reminder remider;
    public generatePassword generate;
    public DesignPage designPage;

    public String homePath;
    public String lockPath;
    public String bellPath;
    public String sparklesPath;
    public String interrogationPath;

    public MouseTest mouseTest = this;
    public JPanel topJPanel;
    public JButton logout;

    public MouseTest(JPanel leftPanel, JPanel topJPanel, JLabel mainLabel, JPanel addJPanel, JPanel passwardJPanel) {
        super("看門狗系統");

        this.leftPanel = leftPanel;
        this.topJPanel = topJPanel;
        this.addJPanel = addJPanel;
        this.passwardJPanel = passwardJPanel;
        MouseHandler handler = new MouseHandler();
        leftPanel.addMouseListener(handler);
        leftPanel.addMouseMotionListener(handler);

        addJPanel.setPreferredSize(new Dimension(60, 500));
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) { // 當滑鼠游標進入物件範圍

        }

        @Override
        public void mouseExited(MouseEvent e) { // 當滑鼠游標進入物件範圍
            leftPanel.removeAll();
            leftPanel.repaint();

            homeIcon = new ImageIcon(SwingTester.class.getResource("home_" + color + ".png"));
            lockIcon = new ImageIcon(SwingTester.class.getResource("lock_" + color + ".png"));
            bellIcon = new ImageIcon(SwingTester.class.getResource("bell_" + color + ".png"));
            sparklesIcon = new ImageIcon(SwingTester.class.getResource("sparkles_" + color + ".png"));
            interrogationIcon = new ImageIcon(SwingTester.class.getResource("interrogation_" + color + ".png"));

            setleftPanel();

            leftPanel.revalidate();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            addJPanel.setLayout(new BorderLayout());
            if (y >= 27 && y <= 73 && x <= 150) {// 主頁面
                addJPanel.removeAll();
                addJPanel.repaint();
                try {
                    home.creatPasswordPanel(passwardJPanel);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                home.creatAddPasswardButton(mouseTest, addJPanel);
                setAddJPanel();
                addJPanel.revalidate();
            } else if (y >= 122 && y <= 168 && x <= 150) {// 密碼產生器
                addJPanel.removeAll();
                addJPanel.repaint();
                generate.createGenerate(passwardJPanel);
                setAddJPanel();
                addJPanel.revalidate();
            } else if (y >= 218 && y <= 270 && x <= 150) {// 提醒設定
                addJPanel.removeAll();
                addJPanel.repaint();
                setAddJPanel();
                remider.createReminder(passwardJPanel);
                addJPanel.revalidate();
            } else if (y >= 315 && y <= 365 && x <= 150) {// 主題設定
                addJPanel.removeAll();
                addJPanel.repaint();
                setAddJPanel();
                designPage.createBackground(mouseTest, passwardJPanel, leftPanel, topJPanel);
                addJPanel.revalidate();
            } else if (y >= 411 && y <= 461 && x <= 150) {// 使用教學

                try {
                    // 連結至PPT
                    openURL("https://drive.google.com/file/d/1nEg_0tgEGU-DkFiRfaCIfHsoSGFrrXb4/view?usp=sharing");
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }

        }

        public void openURL(String url) throws IOException, URISyntaxException {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI(url));
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) { // 實做滑鼠的點擊事件
            int x = e.getX();
            int y = e.getY();

        }

        @Override
        public void mouseReleased(MouseEvent e) { // 實做滑鼠的放開事件

        }

        @Override
        public void mouseMoved(MouseEvent e) { // 實做滑鼠的移動事件
            int x = e.getX();
            int y = e.getY();
            // 偵測滑鼠到左側選單按鈕，讓選單彈出
            if (y >= 27 && y <= 73 && x <= 50) {// 主畫面
                try {
                    homeIcon = new ImageIcon(SwingTester.class.getResource("home_end_" + color + ".png"));
                    lockIcon = new ImageIcon(SwingTester.class.getResource("lock_" + color + ".png"));
                    bellIcon = new ImageIcon(SwingTester.class.getResource("bell_" + color + ".png"));
                    sparklesIcon = new ImageIcon(SwingTester.class.getResource("sparkles_" + color + ".png"));
                    interrogationIcon = new ImageIcon(SwingTester.class.getResource("interrogation_" + color + ".png"));
                    setleftPanel();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (y >= 122 && y <= 168 && x <= 50) {// 密碼產生器
                try {
                    homeIcon = new ImageIcon(SwingTester.class.getResource("home_" + color + ".png"));
                    lockIcon = new ImageIcon(SwingTester.class.getResource("lock_end_" + color + ".png"));
                    bellIcon = new ImageIcon(SwingTester.class.getResource("bell_" + color + ".png"));
                    sparklesIcon = new ImageIcon(SwingTester.class.getResource("sparkles_" + color + ".png"));
                    interrogationIcon = new ImageIcon(SwingTester.class.getResource("interrogation_" + color + ".png"));

                    setleftPanel();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (y >= 218 && y <= 270 && x <= 50) {// 提醒設定
                try {
                    homeIcon = new ImageIcon(SwingTester.class.getResource("home_" + color + ".png"));
                    lockIcon = new ImageIcon(SwingTester.class.getResource("lock_" + color + ".png"));
                    bellIcon = new ImageIcon(SwingTester.class.getResource("bell_end_" + color + ".png"));
                    sparklesIcon = new ImageIcon(SwingTester.class.getResource("sparkles_" + color + ".png"));
                    interrogationIcon = new ImageIcon(SwingTester.class.getResource("interrogation_" + color + ".png"));

                    setleftPanel();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (y >= 315 && y <= 365 && x <= 50) {// 主題設定
                try {
                    homeIcon = new ImageIcon(SwingTester.class.getResource("home_" + color + ".png"));
                    lockIcon = new ImageIcon(SwingTester.class.getResource("lock_" + color + ".png"));
                    bellIcon = new ImageIcon(SwingTester.class.getResource("bell_" + color + ".png"));
                    sparklesIcon = new ImageIcon(SwingTester.class.getResource("sparkles_end_" + color + ".png"));
                    interrogationIcon = new ImageIcon(SwingTester.class.getResource("interrogation_" + color + ".png"));
                    setleftPanel();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (y >= 411 && y <= 461 && x <= 50) {// 使用教學
                try {
                    homeIcon = new ImageIcon(SwingTester.class.getResource("home_" + color + ".png"));
                    lockIcon = new ImageIcon(SwingTester.class.getResource("lock_" + color + ".png"));
                    bellIcon = new ImageIcon(SwingTester.class.getResource("bell_" + color + ".png"));
                    sparklesIcon = new ImageIcon(SwingTester.class.getResource("sparkles_" + color + ".png"));
                    interrogationIcon = new ImageIcon(
                            SwingTester.class.getResource("interrogation_end_" + color + ".png"));

                    setleftPanel();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (((y <= 27 || y >= 73) || (y <= 122 || y >= 168) || (y <= 218 || y >= 270)
                    || (y <= 315 || y >= 365) || (y <= 411 || y >= 461)) && x >= 143) {
                leftPanel.removeAll();
                leftPanel.repaint();
                homeIcon = new ImageIcon(SwingTester.class.getResource("home_" + color + ".png"));
                lockIcon = new ImageIcon(SwingTester.class.getResource("lock_" + color + ".png"));
                bellIcon = new ImageIcon(SwingTester.class.getResource("bell_" + color + ".png"));
                sparklesIcon = new ImageIcon(SwingTester.class.getResource("sparkles_" + color + ".png"));
                interrogationIcon = new ImageIcon(SwingTester.class.getResource("interrogation_" + color + ".png"));
                setleftPanel();
                leftPanel.revalidate();
            }
        }

        public void setleftPanel() {
            leftPanel.removeAll();
            leftPanel.repaint();

            JLabel homeLabel = new JLabel(homeIcon);
            JLabel passwordLabel = new JLabel(lockIcon);
            JLabel alertLabel = new JLabel(bellIcon);
            JLabel themeLabel = new JLabel(sparklesIcon);
            JLabel QALabel = new JLabel(interrogationIcon);
            // 更新五個按鈕
            leftPanel.add(homeLabel);
            leftPanel.add(passwordLabel);
            leftPanel.add(alertLabel);
            leftPanel.add(themeLabel);
            leftPanel.add(QALabel);

            leftPanel.revalidate();
        }
    }

    public void setAddJPanel() {
        JButton logout = new JButton(new ImageIcon(SwingTester.class.getResource("logout.png")));
        JPanel logoutJPanel = new JPanel();
        logoutJPanel.setBackground(Color.WHITE);
        logoutJPanel.setOpaque(true);
        logout.setPreferredSize(new Dimension(30, 30));
        logoutJPanel.add(logout);
        addJPanel.add(logoutJPanel, BorderLayout.NORTH);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mouseTest.dispose();

                new login().run();
            }
        });
    }

    public void setup() throws Exception {
        addJPanel.removeAll();
        addJPanel.repaint();
        home.creatPasswordPanel(passwardJPanel);
        home.creatAddPasswardButton(mouseTest, addJPanel);
        setAddJPanel();
        addJPanel.revalidate();
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public void setReminder(Reminder reminder) {
        this.remider = reminder;
    }

    public void setGenerate(generatePassword generate) {
        this.generate = generate;
    }

    public void setDesignPage(DesignPage designPage) {
        this.designPage = designPage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setMainLabel(JLabel mainLabel) {
        this.mainLabel = mainLabel;
        passwardJPanel.setBackground(Color.WHITE);
        passwardJPanel.setOpaque(true);
        this.mainLabel.add(passwardJPanel, BorderLayout.CENTER);
    }

}
