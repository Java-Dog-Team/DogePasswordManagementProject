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

class MailController {

    private final String SenderEmail = "sw710407@gmail.com";
    private Map<String, String> Validator = new HashMap<>();// 紀錄使用者的驗證碼 用於驗證馬比對

    public MailController() {

    }

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
    public boolean ValidCodeComparison(String userMail, String userInput) {
        if (Validator.get(userMail).equals(userInput)){
            Validator.remove(userMail);
            return true;
        }
            
        return false;
    }
}