package com.example;

import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {
    public static void main(String[] args) throws Exception {
        // new login().createWindow();
        UserInterface tmp = new UserInterface("sw710407@gmail.com");

        // Icon icon = new ImageIcon("demo\\src\\main\\java\\com\\example\\dog.png");
        // tmp.updateOneUserData("DC", "HI", "PASS", icon, 0);

        List<RecordData> finalResult = tmp.fetchAllUserData();

        // // 建立 JFrame 物件作為圖片顯示視窗
        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // // 建立 JLabel 並設定圖片
        Icon icon = finalResult.get(0).getImage();
        ImageIcon bufferedImage = (ImageIcon) (icon);
        JLabel label = new JLabel(bufferedImage);

        // // 將 JLabel 加入 JFrame
        frame.getContentPane().add(label);

        // // 設定 JFrame 的大小
        frame.setSize(bufferedImage.getIconWidth(), bufferedImage.getIconHeight());

        // // 顯示 JFrame
        frame.setVisible(true);
    }
}
