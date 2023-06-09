package com.example;

import java.security.SecureRandom;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

//java mail api
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//Email驗證碼寄送、驗證
public class MailController {

    private final String SenderEmail = "sw710407@gmail.com";
    private String ValidCode = null;
    private final Timer timer = new Timer();
    private final String APIKey = "dfmiylxxxzixdkds";// 電子郵件API金鑰
    public static final int MAIL_VALIDCODE_CORRECT = 0;// 電子郵件驗證碼正確
    public static final int MAIL_VALIDCODE_INCORRECT = 1;// 電子郵件驗證碼錯誤
    // 檢查是否可以寄送驗證碼
    public static final int OK = 2;
    public static final int REJECT = 3;
    private boolean flag = true;// 驗證是否可以傳送驗證碼

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

    // 寄送驗證碼(email)
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
                return new PasswordAuthentication(SenderEmail, APIKey);
            }
        });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(SenderEmail));

            message.setFrom(new InternetAddress("sw710407@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userMail));

            message.setSubject("Doge Password Management ");

            String validCode = generateValidCode();

            message.setText("歡迎使用Doge密碼管理系統，這是您的驗證碼:" + validCode + "，請在5分鐘內使用");
            ValidCode = validCode;
            Transport.send(message);

            flag = false;// 禁止短時間內寄送驗證碼
            System.out.println("電子郵件驗證碼寄送成功!");

            timer.schedule(new Expried(), 5 * 60 * 1000);// 啟動計時器 5分鐘後讓驗證碼失效

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public int SendRequest() {
        if (flag == true)
            return OK;
        return REJECT;
    }

    // 驗證驗證碼是否正確
    public int ValidCodeVerify(String userInput) {
        // System.out.println(ValidCode);
        try {
            if (ValidCode.equals(userInput)) {
                ValidCode = null;
                flag = true;
                return MAIL_VALIDCODE_CORRECT;
            }
        } catch (Exception e) {// 找不到該電子郵件的驗證碼
            return MAIL_VALIDCODE_INCORRECT;
        }

        return MAIL_VALIDCODE_INCORRECT;
    }

    class Expried extends TimerTask {
        public void run() {
            ValidCode = null;
            System.out.println("電子郵件驗證碼已過時效!");
            flag = true;
        }
    }
}
