package com.example;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.*;
import java.io.File; 

public class MouseTestHome extends JPanel{
   public JPanel jPanel;
   public String app;
   public String account;
   public String passward;
   public Icon img;
   public MouseTestHome(String app,String account,String passward,Icon img){
         this.app=app;
         this.account=account;
         this.passward=passward;
         this.img=img;
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
         
      }
      @Override
      public void mousePressed(MouseEvent e){

      }
      @Override
      public void mouseClicked(MouseEvent e){  //實做滑鼠的點擊事件
         Graphics g = getGraphics();
         int x = e.getX();
         int y = e.getY();   
         
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
         
      }
   }
   public Icon getImg() {
       return img;
   }
   public String getAccount() {
       return account;
   }
   public String getPassward() {
       return passward;
   }
   public String getApp() {
       return app;
   }
   
}
