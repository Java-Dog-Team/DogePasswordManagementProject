package com.example;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Image;

//讓圖片隨視窗大小變動
public class CustomImgPanel extends JPanel{
    private int width = 0;
    private int height = 0;
    private String imgPath = "";
    /**
     *
     * @param _width 整型,窗口的宽度
     * @param _height 整型,窗口的高度
     * @param _imgPath 图片的URL,可用相对路径
     */
    public CustomImgPanel(int _width,int _height,String _imgPath){
        width = _width;
        height = _height;
        imgPath = _imgPath;
        setSize(width,height);
        setVisible(true);
    }
    /**
     *
     * @param _width 浮点型,窗口的宽度
     * @param _height 浮点型,窗口的高度
     * @param _imgPath  字符串,图片的URL,可用相对
     */
    public CustomImgPanel(double _width,double _height,String _imgPath){
        width = (int)_width;
        height = (int)_height;
        imgPath = _imgPath;
        setSize(width,height);
        setVisible(true);
    }
    

    @Override
    public void paintComponent(Graphics gs) {
        Graphics2D g = (Graphics2D) gs;
        super.paintComponent(g);
        //画背景图片
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgPath));
        g.drawImage(image, 0, 0,width,height, this);
    }
    
}

