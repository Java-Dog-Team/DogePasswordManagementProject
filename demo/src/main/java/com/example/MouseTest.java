package com.example;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.*;
import java.io.File; 

public class MouseTest extends JPanel{
    public JFrame jFrame;
    public MouseTest()
   {
      addMouseListener(new MouseAdapter(){
         public void mouseEntered(MouseEvent e){  //當滑鼠游標進入物件範圍
            int x = e.getX();  //擷取發生事件的 X 座標
            int y = e.getY();  //擷取發生事件的 Y 座標
            
         }
      });
      addMouseListener(new MouseAdapter(){
         public void mouseExited(MouseEvent e){   //當滑鼠游標進入物件範圍
            int x = e.getX();
            int y = e.getY();
            repaint();
         }
      });
      addMouseListener(new MouseAdapter(){
         public void mousePressed(MouseEvent e){  //實做滑鼠的點擊事件
            Graphics g = getGraphics();
            int x = e.getX();
            int y = e.getY();
            
            if(y>=24 && y<=74){//主頁面
                Home home=new Home(jFrame);
            }
            else if (y>=115 && y<=175){//密碼產生器

            }
            else if(y>=215 && y<=270){//提醒設定

            }
            else if(y>=305 && y<=360){//主題設定
                DesignPage designPage=new DesignPage(jFrame);
                // MainPage.jFrame.getContentPane().setBackground(Color.BLACK);
                // System.out.printf("%d %d%n",x,y);
            }
            else if(y>=410 && y<=460){//使用教學

            }
            // System.out.printf("%d %d%n",x,y);
         }
      });
      addMouseListener(new MouseAdapter(){
         public void mouseReleased(MouseEvent e){  //實做滑鼠的放開事件
            Graphics g = getGraphics();
            int x = e.getX();
            int y = e.getY();
            
         }
      });
      addMouseMotionListener(new MouseMotionAdapter(){
         public void mouseMoved(MouseEvent e){  //實做滑鼠的移動事件
            Graphics g = getGraphics();
            int x = e.getX();
            int y = e.getY();
            
            if(y>=24 && y<=74 && x<=50){
                try{
                    Image image = ImageIO.read(new File("demo\\src\\picture\\home_end.jpg"));
                    
                    g.drawImage(image, 0, 24, getFocusCycleRootAncestor());
                    
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            else if(y<=24 && y>=74){
                repaint();
            }
            else if (y>=115 && y<=175 && x<=50){
                    try{
                        Image image = ImageIO.read(new File("demo\\src\\picture\\lock_end.jpg"));
                        
                        g.drawImage(image, 0, 120, getFocusCycleRootAncestor());
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y<=115 && y>=175){
                repaint();
            }
            else if(y>=215 && y<=270 && x<=50){
                    try{
                        Image image = ImageIO.read(new File("demo\\src\\picture\\bell_end.jpg"));
                        
                        g.drawImage(image, 0, 218, getFocusCycleRootAncestor());
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                
            }
            else if(y<=215 && y>=270){
                repaint();
            }
            else if(y>=305 && y<=360 && x<=50){
                    try{
                        Image image = ImageIO.read(new File("demo\\src\\picture\\sparkles_end.jpg"));
                        
                        g.drawImage(image, 0, 310, getFocusCycleRootAncestor());
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y<=305 && y>=360){
                repaint();
            }
            else if(y>=410 && y<=460 && x<=50){
                    try{
                        Image image = ImageIO.read(new File("demo\\src\\picture\\interrogation_end.jpg"));
                        
                        g.drawImage(image, 0, 407, getFocusCycleRootAncestor());
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            else if(y<=410 && y>=460){
                repaint();
            }
         }
      });
   }
   public static JLabel setPicture(ImageIcon fileName){
        JLabel jLabel=new JLabel(fileName);
        return jLabel;
   }
   public void setJframe(JFrame jFrame){
        this.jFrame=jFrame;
   }
}
