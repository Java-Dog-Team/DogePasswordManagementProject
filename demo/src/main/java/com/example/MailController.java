package com.example;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailController {

    private final String SenderEmail = "sw710407@gmail.com";
    private Map<String, String> Validator = new HashMap<>();// 紀錄使用者的驗證碼 用於驗證馬比對

    public static final int MAIL_VALIDCODE_CORRECT = 0;// 電子郵件驗證碼正確
    public static final int MAIL_VALIDCODE_INCORRECT = 1;// 電子郵件驗證碼錯誤

    public MailController() {

    }

    // 驗證碼產生method
    private String generateValidCode() {

        SecureRandom random = new SecureRandom();

        String validCode = "";// 儲存產生的驗證碼

        String digits;

        for (int i = 0; i < 6; i++) {
            digits = String.format("%d", random.nextInt(10));
            validCode = validCode + digits;
        }
        return validCode;

    }

    public void sendMail(String userMail) {

        Properties props = new Properties();

        // Setting mail proctocol detail
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SenderEmail, "dfmiylxxxzixdkds");
            }
        });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("sw710407@gmail.com"));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userMail));

            message.setSubject("Doge Password Management ");
            String validCode = generateValidCode();
            message.setText("Here is your validation code : " + validCode);
            Transport.send(message);

            System.out.println("電子郵件驗證碼寄送成功!");

            Validator.put(userMail, validCode);// 將新使用者的驗證碼存錄HashMap中

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    // 驗證驗證碼是否正確
    public int ValidCodeVerify(String userMail, String userInput) {
        try {
            if (Validator.get(userMail).equals(userInput)) {
                Validator.remove(userMail);// 該使用者驗證碼已通過 將其刪除
                return MAIL_VALIDCODE_CORRECT;
            }
        } catch (Exception e) {// 找不到該電子郵件的驗證碼
            return MAIL_VALIDCODE_INCORRECT;
        }

        return MAIL_VALIDCODE_INCORRECT;
    }

}