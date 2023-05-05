package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        SMSController smsController = new SMSController();
        smsController.SendSMS("0974002156");
        Scanner input = new Scanner(System.in);
        int code = input.nextInt();
        System.out.println(smsController.ValidCodeVerify("0974002156", String.format("%d", code)));
        // MailController mailController = new MailController();
        // mailController.sendMail("say859462@yahoo.com.tw");
        // AccountController accounterController = new AccountController();
        // accounterController.regiserAccount("test001@gmail.com", "test001",
        // "0909000222");
        // System.out.println(accounterController.AccountIsCorrect("test001@gmail.com",
        // "test001"));
        // System.out.println(accounterController.reapeatedAccount("ss66112"));
        // accounterController.regiserAccount("test001@gmail.com", "test002",
        // "0986577869");
        // accounterController.disconnectMongoDB();

    }
}
