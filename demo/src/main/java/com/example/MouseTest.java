package com.example;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.*;
import java.io.File; 

public class MouseTest extends JFrame{
    public JFrame jFrame;
    public Home home;
    public main_page MainPage;
    public JPanel addJPanel=new JPanel();
    public JButton addPasswardButton =new JButton(new ImageIcon("demo\\src\\picture\\addPassward.png"));

    private JLabel testJLabel;
    public MouseTest(JPanel leftPanel){
        super("看門狗系統");
        addJPanel.setBackground(Color.BLACK);
        add(addJPanel,BorderLayout.CENTER);

        testJLabel=new JLabel("test");
        add(testJLabel,BorderLayout.SOUTH);

        MouseHandler handler=new MouseHandler();
        leftPanel.addMouseListener(handler);
        leftPanel.addMouseMotionListener(handler);
        // leftPanel
        // this.home=home_1;
        // this.jFrame=jFrame_1;
        // MainPage=mainPage;
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
            repaint();
        }
        @Override
        public void mousePressed(MouseEvent e){

        }
        @Override
        public void mouseClicked(MouseEvent e){  //實做滑鼠的點擊事件
            Graphics g = getGraphics();
            int x = e.getX();
            int y = e.getY();
            System.out.printf("%d %d%n",x,y);
            if(y>=19 && y<=63 && x<=150){//主頁面
                // MainPage.setAddPasswardButton(jFrame);
                // home.creatAddPasswardButton(jFrame);

                // addPasswardButton.setPreferredSize(new Dimension(57, 54));
                // addJPanel.setLayout(new BorderLayout());
                // addJPanel.add(addPasswardButton,BorderLayout.SOUTH);
                getContentPane().setBackground( new Color(0,0,0,255) );
            }
            else if (y>=95 && y<=142 && x<=150){//密碼產生器

            }
            else if(y>=175 && y<=223 && x<=150){//提醒設定

            }
            else if(y>=253 && y<=301 && x<=150){//主題設定
                DesignPage designPage=new DesignPage(jFrame);
                // MainPage.jFrame.getContentPane().setBackground(Color.BLACK);
                // System.out.printf("%d %d%n",x,y);
            }
            else if(y>=332 && y<=373 && x<=50){//使用教學

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
            
            if(y>=19 && y<=63 && x<=50){
                try{
                    Image image = ImageIO.read(new File("demo\\src\\picture\\home_end.jpg"));
                    
                    g.drawImage(image, 7, 92, getFocusCycleRootAncestor());
                    
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            else if (y>=95 && y<=142 && x<=50){
                    try{
                        Image image = ImageIO.read(new File("demo\\src\\picture\\lock_end.jpg"));
                        
                        g.drawImage(image, 7, 172, getFocusCycleRootAncestor());
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y>=175 && y<=223 && x<=50){
                    try{
                        Image image = ImageIO.read(new File("demo\\src\\picture\\bell_end.jpg"));
                        
                        g.drawImage(image, 7, 250, getFocusCycleRootAncestor());
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y>=253 && y<=301 && x<=50){
                    try{
                        Image image = ImageIO.read(new File("demo\\src\\picture\\sparkles_end.jpg"));
                        
                        g.drawImage(image, 7, 329, getFocusCycleRootAncestor());
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y>=332 && y<=373 && x<=50){
                    try{
                        Image image = ImageIO.read(new File("demo\\src\\picture\\interrogation_end.jpg"));
                        
                        g.drawImage(image, 7, 409, getFocusCycleRootAncestor());
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(x>150){
                repaint(0,0,150,1000);
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
   }
   public static JLabel setPicture(ImageIcon fileName){
        JLabel jLabel=new JLabel(fileName);
        return jLabel;
   }
   public void setJframe(JFrame jFrame){
        this.jFrame=jFrame;
   }
}
