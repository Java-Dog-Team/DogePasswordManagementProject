package com.example;

import javax.swing.Icon;

public class upLoadData {
    private int index;
    private String app;
    private String account;
    private String password;
    private Icon img;
    public upLoadData(int index,String app,String account,String password,Icon img){
        setAccount(account);
        setApp(app);
        setImg(img);
        setIndex(index);
        setPassword(password);
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public void setApp(String app) {
        this.app = app;
    }
    public void setImg(Icon img) {
        this.img = img;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAccount() {
        return account;
    }
    public String getApp() {
        return app;
    }
    public int getIndex() {
        return index;
    }
    public String getPassword() {
        return password;
    }
    public Icon getImg() {
        return img;
    }
}
