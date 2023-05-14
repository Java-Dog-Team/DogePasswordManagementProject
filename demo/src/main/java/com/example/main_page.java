package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class main_page{
    private static JFrame jFrame=new JFrame("看門狗系統");
    private static JLabel topJLabel=new JLabel();
    //取得螢幕大小
    private static Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    private static int w=dimension.width;
    private static int h=dimension.height;
    //大頭貼
    private static JLabel topMyHeadIconJLabel=new JLabel();
    private static ImageIcon myheadIcon=new ImageIcon();
    public static void main(String[] args) {
        createWindow();
    }
    
    public static void createWindow(){
        jFrame.getContentPane().setLayout(new BorderLayout());
        //設定視窗大小為螢幕的2/3
        jFrame.setSize(w*2/3, h*2/3);
        //設定背景顏色
        jFrame.getContentPane().setBackground( new Color(255,255,255,255) );
        
        //設定關閉視窗即程式結束
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //設置左上角小圖片
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = SwingTester.class.getResource("dogdog.png");
        if (imgURL != null) {
            arrowIcon = new ImageIcon(imgURL);
            jFrame.setIconImage(arrowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(jFrame, "Icon image not found.");
        }

        setTopJLabel(topJLabel);
        setTopJLabelPicture(myheadIcon);
        createUI(jFrame);   
        // JFrame.setDefaultLookAndFeelDecorated(true);
        jFrame.setLocationRelativeTo(null);  
        jFrame.setVisible(true);
    }

    private static void createUI(JFrame frame){      
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());    
        //加入上面的標題文字   
        panel.add(topJLabel,BorderLayout.WEST);
        //加入大頭貼
        panel.add(topMyHeadIconJLabel,BorderLayout.EAST);
        // 設定上方邊條背景顏色
        panel.setBackground(new Color(230,217,148,255));
        panel.setOpaque(true);;
        // 設定上方邊條大小
        panel.setPreferredSize(new Dimension(w, h/15));
        frame.add(panel, BorderLayout.NORTH);    
    }

    public static void setTopJLabel(JLabel topJLabel) {
        main_page.topJLabel = new JLabel("WatchDog");
        main_page.topJLabel.setForeground(new Color(32,41,107));
        main_page.topJLabel.setPreferredSize(new Dimension(100, h/20));
        main_page.topJLabel.setFont(new Font(Font.SERIF, 0, 18));
        // main_page.topJLabel.setSize(10, h/20);
        // main_page.topJLabel.setBackground(new Color(255,220,53,150));
        // main_page.topJLabel.setOpaque(true);
        
        // main_page.jFrame.getContentPane().add(main_page.topJLabel,BorderLayout.NORTH);
    }
    public static void setTopJLabelPicture(ImageIcon myheadIcon){
        // myheadIcon= RoundImageIconObject.getRoundImageIcon("C:\\Users\\user\\OneDrive\\桌面\\DogePasswordManagementProject\\DogePasswordManagementProject\\demo\\src\\main\\java\\com\\example\\dogdog.png");
        //將圖片切成圓形
        myheadIcon= RoundImageIconObject.getRoundImageIcon("dog.png");
        myheadIcon.setImage(myheadIcon.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
        main_page.topMyHeadIconJLabel=new JLabel(myheadIcon);
        main_page.topMyHeadIconJLabel.setPreferredSize(new Dimension(50, 40));
    }
    
}