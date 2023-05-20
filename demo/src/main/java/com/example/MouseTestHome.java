package com.example;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.*;
import java.io.File; 

public class MouseTestHome extends JPanel{
    public JFrame jFrame;
    public MouseTestHome()
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
   
}
