package com.example;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.*;
import java.io.File; 

public class MouseTest extends JPanel{
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
         }
      });
      addMouseListener(new MouseAdapter(){
         public void mousePressed(MouseEvent e){  //實做滑鼠的點擊事件
            Graphics g = getGraphics();
            int x = e.getX();
            int y = e.getY();
            if(y>=24 && y<=74){
                try{
                    Image image = ImageIO.read(new File("demo\\src\\picture\\home_end.jpg"));
                    g.drawImage(image, 0, 24, getFocusCycleRootAncestor());
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            else if (y>=115 && y<=175){
                try{
                    Image image = ImageIO.read(new File("demo\\src\\picture\\lock_end.jpg"));
                    g.drawImage(image, 0, 120, getFocusCycleRootAncestor());
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            else if(y>=215 && y<=270){
                try{
                    Image image = ImageIO.read(new File("demo\\src\\picture\\bell_end.jpg"));
                    g.drawImage(image, 0, 218, getFocusCycleRootAncestor());
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            else if(y>=305 && y<=360){
                try{
                    Image image = ImageIO.read(new File("demo\\src\\picture\\sparkles_end.jpg"));
                    g.drawImage(image, 0, 310, getFocusCycleRootAncestor());
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            else if(y>=410 && y<=460){
                try{
                    Image image = ImageIO.read(new File("demo\\src\\picture\\interrogation_end.jpg"));
                    g.drawImage(image, 0, 407, getFocusCycleRootAncestor());
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
            System.out.printf("%d %d%n",x,y);
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
            
         }
      });
   }
   public static JLabel setPicture(ImageIcon fileName){
        JLabel jLabel=new JLabel(fileName);
        return jLabel;
   }
}
