package com.example;

import java.awt.image.BufferedImage;

//紀錄資料格式
public class RecordData {

    private String AppName;
    private String Username;
    private String Password;
    private BufferedImage image;

    public RecordData() {
        AppName = "";
        Username = "";
        Password = "";
        image = null;
    }

    public RecordData(String AppName, String Username, String Password, BufferedImage image) {
        this.AppName = AppName;
        this.Username = Username;
        this.Password = Password;
        this.image = image;
    }

    public String getAppName() {
        return this.AppName;
    }

    public String getUsername() {
        return this.Username;
    }

    public String getPassword() {
        return this.Password;
    }

    public BufferedImage getImage() {
        return this.image;
    }
    
    public String toString() {
        return String.format("%s %s %s", AppName, Username, Password);
    }
}
