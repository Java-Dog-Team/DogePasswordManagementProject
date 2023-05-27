package com.example;

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

    public MailController() {

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
                return new PasswordAuthentication("sw710407@gmail.com", "dfmiylxxxzixdkds");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sw710407@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userMail));
            message.setSubject("Doge pswd management!!");
            message.setText("Here is your validation code : 0487");
            Transport.send(message);
            System.out.println("Send success!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}