package com.example;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.*;
import java.io.File; 

public class MouseTest extends JFrame{
    public JFrame jFrame;
<<<<<<< HEAD
    public Home home;
    public Reminder reminder;
=======
>>>>>>> c7ee0d4d2e60efd3f3543f23a3301c6f0cf2dedc
    public JPanel addJPanel=new JPanel();
    public JPanel addJPanel1=new JPanel();
    public JButton addPasswardButton =new JButton(new ImageIcon("demo\\src\\picture\\addPassward.png"));

    public JLabel mainLabel;
<<<<<<< HEAD
    private JLabel testJLabel=new JLabel("");
    private JLabel testJLabel1=new JLabel("");
=======
    private JPanel passwardJPanel=new JPanel();
>>>>>>> c7ee0d4d2e60efd3f3543f23a3301c6f0cf2dedc
    public JLabel smallLabel=new JLabel();
    public JLabel rightJLabel=new JLabel();
    public JPanel leftPanel=new JPanel();

    public ImageIcon homeIcon=new ImageIcon("demo\\src\\picture\\home.png");
    public ImageIcon lockIcon=new ImageIcon("demo\\src\\picture\\lock.png");
    public ImageIcon bellIcon=new ImageIcon("demo\\src\\picture\\bell.png");
    public ImageIcon sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles.png");
    public ImageIcon interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation.png");

    //其他功能
    public Home home;
    public Reminder remider;

    public MouseTest(JPanel leftPanel,JLabel mainLabel){
        super("看門狗系統");

        this.leftPanel=leftPanel;
        MouseHandler handler=new MouseHandler();
        leftPanel.addMouseListener(handler);
        leftPanel.addMouseMotionListener(handler);

        addJPanel.setPreferredSize(new Dimension(60, 500));
   }
   private class MouseHandler implements MouseListener,MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e){

        }
        @Override
        public void mouseEntered(MouseEvent e){  //當滑鼠游標進入物件範圍
            int x = e.getX();  //擷取發生事件的 X 座標
            int y = e.getY();  //擷取發生事件的 Y 座標
            
        }
        @Override
        public void mouseExited(MouseEvent e){   //當滑鼠游標進入物件範圍
            int x = e.getX();
            int y = e.getY();
            leftPanel.removeAll();
            leftPanel.repaint();

            homeIcon=new ImageIcon("demo\\src\\picture\\home.png");
            lockIcon=new ImageIcon("demo\\src\\picture\\lock.png");
            bellIcon=new ImageIcon("demo\\src\\picture\\bell.png");
            sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles.png");
            interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation.png");

            setleftPanel();
            
            leftPanel.revalidate();
        }
        @Override
        public void mousePressed(MouseEvent e){

        }
        @Override
        public void mouseClicked(MouseEvent e){  //實做滑鼠的點擊事件
            Graphics g = getGraphics();
            int x = e.getX();
            int y = e.getY();
            // System.out.printf("%d %d%n",x,y);
            if(y>=27 && y<=73 && x<=150){//主頁面
                home.creatPasswordPanel(passwardJPanel);
                home.creatAddPasswardButton(addJPanel);
            }
            else if (y>=122 && y<=168 && x<=150){//密碼產生器

            }
            else if(y>=218 && y<=270 && x<=150){//提醒設定
<<<<<<< HEAD
                 reminder.createReminder(testJLabel);
                //  reminder.creatAddPasswardButton(addJPanel);
                //home.creatPasswordPanel(testJLabel);
                //home.creatAddPasswardButton(addJPanel);
=======
                remider.createReminder(passwardJPanel);
>>>>>>> c7ee0d4d2e60efd3f3543f23a3301c6f0cf2dedc
            }
            else if(y>=315 && y<=365 && x<=150){//主題設定
                // DesignPage designPage=new DesignPage(jFrame);
                // MainPage.jFrame.getContentPane().setBackground(Color.BLACK);
                // System.out.printf("%d %d%n",x,y);
            }
            else if(y>=411 && y<=461 && x<=50){//使用教學

            }
            
        }
        @Override
        public void mouseReleased(MouseEvent e){  //實做滑鼠的放開事件
            Graphics g = getGraphics();
            int x = e.getX();
            int y = e.getY();
            
        }
        @Override
        public void mouseMoved(MouseEvent e){  //實做滑鼠的移動事件
            Graphics g = getGraphics();
            int x = e.getX();
            int y = e.getY();
           //偵測滑鼠到左側選單按鈕，讓選單彈出
            if(y>=27 && y<=73 && x<=50){//主畫面
                try{
                    homeIcon=new ImageIcon("demo\\src\\picture\\home_end.jpg");
                    lockIcon=new ImageIcon("demo\\src\\picture\\lock.png");
                    bellIcon=new ImageIcon("demo\\src\\picture\\bell.png");
                    sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles.png");
                    interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation.png");
                    setleftPanel();
                    // Image image = ImageIO.read(new File("demo\\src\\picture\\home_end.jpg"));
                    // g.drawImage(image, 7, 111, getFocusCycleRootAncestor());
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            else if (y>=122 && y<=168 && x<=50){//密碼產生器
                    try{
                        homeIcon=new ImageIcon("demo\\src\\picture\\home.png");
                        lockIcon=new ImageIcon("demo\\src\\picture\\lock_end.jpg");
                        bellIcon=new ImageIcon("demo\\src\\picture\\bell.png");
                        sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles.png");
                        interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation.png");

                        setleftPanel();
                        // Image image = ImageIO.read(new File("demo\\src\\picture\\lock_end.jpg"));
                        // g.drawImage(image, 8, 208, getFocusCycleRootAncestor());
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y>=218 && y<=270 && x<=50){//提醒設定
                    try{
                        homeIcon=new ImageIcon("demo\\src\\picture\\home.png");
                        lockIcon=new ImageIcon("demo\\src\\picture\\lock.png");
                        bellIcon=new ImageIcon("demo\\src\\picture\\bell_end.jpg");
                        sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles.png");
                        interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation.png");

                        setleftPanel();
                        // Image image = ImageIO.read(new File("demo\\src\\picture\\bell_end.jpg"));
                        // g.drawImage(image, 7, 302, getFocusCycleRootAncestor());
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y>=315 && y<=365 && x<=50){//主題設定
                    try{
                        homeIcon=new ImageIcon("demo\\src\\picture\\home.png");
                        lockIcon=new ImageIcon("demo\\src\\picture\\lock.png");
                        bellIcon=new ImageIcon("demo\\src\\picture\\bell.png");
                        sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles_end.jpg");
                        interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation.png");

                        setleftPanel();
                        // Image image = ImageIO.read(new File("demo\\src\\picture\\sparkles_end.jpg"));
                        // g.drawImage(image, 8, 400, getFocusCycleRootAncestor());
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y>=411 && y<=461 && x<=50){//使用教學
                    try{
                        homeIcon=new ImageIcon("demo\\src\\picture\\home.png");
                        lockIcon=new ImageIcon("demo\\src\\picture\\lock.png");
                        bellIcon=new ImageIcon("demo\\src\\picture\\bell.png");
                        sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles.png");
                        interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation_end.jpg");

                        setleftPanel();
                        // Image image = ImageIO.read(new File("demo\\src\\picture\\interrogation_end.jpg"));
                        // g.drawImage(image, 8, 495, getFocusCycleRootAncestor());
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(((y<=27 || y>=73) || (y<=122 || y>=168) || (y<=218 || y>=270) || (y<=315 || y>=365) || (y<=411 || y>=461)) && x>=143){
                leftPanel.removeAll();
                leftPanel.repaint();

                homeIcon=new ImageIcon("demo\\src\\picture\\home.png");
                lockIcon=new ImageIcon("demo\\src\\picture\\lock.png");
                bellIcon=new ImageIcon("demo\\src\\picture\\bell.png");
                sparklesIcon=new ImageIcon("demo\\src\\picture\\sparkles.png");
                interrogationIcon=new ImageIcon("demo\\src\\picture\\interrogation.png");

                setleftPanel();
                
                leftPanel.revalidate();
            }
            
            // else if(y<=93 && y>=143){
            //     repaint(7,92,150,55);
            // }
            // else if(y<=172 && y>=221){
            //     repaint(7,172,150,55);
            // }
            // else if(y<=250 && y>=300){
            //     repaint(7,250,150,55);
            // }
            // else if(y<=331 && y>=379){
            //     repaint(7,329,150,55);
            // }
            // else if(y<=409 && y>=456){
            //     repaint(7,409,150,55);
            // }
        }
        public void setleftPanel(){
            leftPanel.removeAll();
            leftPanel.repaint();

            JLabel homeLabel=new JLabel(homeIcon);
            JLabel passwordLabel=new JLabel(lockIcon);
            JLabel alertLabel=new JLabel(bellIcon);
            JLabel themeLabel=new JLabel(sparklesIcon);
            JLabel QALabel=new JLabel(interrogationIcon);
            //更新五個按鈕
            leftPanel.add(homeLabel);
            leftPanel.add(passwordLabel);
            leftPanel.add(alertLabel);
            leftPanel.add(themeLabel);
            leftPanel.add(QALabel);

            leftPanel.revalidate();
        }
   }
<<<<<<< HEAD
   public void setHome(Home home) {
       this.home = home;
   }
   public void setReminder(Reminder reminder){
        this.reminder=reminder;
   }
   public void setMainLabel(JLabel mainLabel) {
       this.mainLabel = mainLabel;
       testJLabel.setOpaque(true);
       testJLabel.setBackground(Color.WHITE);
       addJPanel.setVisible(false);
       this.mainLabel.add(testJLabel,BorderLayout.CENTER);
       this.mainLabel.add(addJPanel,BorderLayout.EAST);
   }
=======
    public void setHome(Home home) {
        this.home = home;
    }
    public void setReminder(Reminder reminder) {
        this.remider = reminder;
    }
    public void setMainLabel(JLabel mainLabel) {
        JLabel testJLabel=new JLabel("test!!!!");
        this.mainLabel = mainLabel;
        // this.mainLabel.setLayout(BorderLayout());
        // passwardJPanel.setOpaque(true);
        passwardJPanel.setBackground(Color.BLACK);
        passwardJPanel.add(testJLabel,BorderLayout.CENTER);
        addJPanel.setVisible(false);
        this.mainLabel.add(passwardJPanel,BorderLayout.CENTER);
        this.mainLabel.add(addJPanel,BorderLayout.EAST);
    }
    
>>>>>>> c7ee0d4d2e60efd3f3543f23a3301c6f0cf2dedc
}
