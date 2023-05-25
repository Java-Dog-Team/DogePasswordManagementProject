package com.example;

import javax.swing.Icon;

//紀錄資料格式
public class RecordData {

    private String AppName;
    private String Username;
    private String Password;
    private Icon Image;
    private int Index;

    public RecordData() {
        AppName = "";
        Username = "";
        Password = "";
        Image = null;
        Index = 0;
    }

    public RecordData(String AppName, String Username, String Password, Icon Image, int index) {
        this.AppName = AppName;
        this.Username = Username;
        this.Password = Password;
        this.Image = Image;
        this.Index = index;
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

    public Icon getImage() {
        return this.Image;
    }

    public int getIndex() {
        return this.Index;
    }

    public String toString() {
        return String.format("[Index:%d] [AppName:%s] [Username:%s] [Password:%s]", AppName, Username, Password);
    }
}
