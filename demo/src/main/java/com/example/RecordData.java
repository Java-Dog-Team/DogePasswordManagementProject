package com.example;

public class RecordData {
    
    private String AppName;
    private String Username;
    private String Password;

    public RecordData(){
        AppName="";
        Username="";
        Password="";
    }

    public RecordData(String AppName,String Username,String Password){
        this.AppName=AppName;
        this.Username=Username;
        this.Password=Password;
    }
    

}
