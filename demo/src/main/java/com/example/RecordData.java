package com.example;

//紀錄資料格式
public class RecordData {

    private String AppName;
    private String Username;
    private String Password;

    public RecordData() {
        AppName = "";
        Username = "";
        Password = "";
    }

    public RecordData(String AppName, String Username, String Password) {
        this.AppName = AppName;
        this.Username = Username;
        this.Password = Password;
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

    public String toString() {
        return String.format("%s %s %s", AppName, Username, Password);
    }
}
