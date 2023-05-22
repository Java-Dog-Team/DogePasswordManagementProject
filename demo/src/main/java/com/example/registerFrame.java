package com.example;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registerFrame extends JFrame {
    private static JButton confirm = new JButton("Confirm");
    private static JButton send = new JButton("Send Code");
    private static JLabel email = new JLabel("Enter your account(email):");
    private static JLabel passWord = new JLabel("Enter your password:");
    private static JLabel passWord2 = new JLabel("Enter your password again:");
    private static JLabel phoneLabel = new JLabel("Phone number:");
    private static JTextField phoneText = new JTextField(null, "", 0);// 手機號碼輸入
    private static JTextField emailText = new JTextField(null, "", 0);// mail輸入
    private static JPasswordField passWordText = new JPasswordField(null, "", 0);// 第一次輸入密碼
    private static JPasswordField passWordText2 = new JPasswordField(null, "", 0);// 第二次輸入密碼
    private static JLabel validationCodeLabel = new JLabel("Enter your valid code:");
    private static JTextField validationCodeText = new JTextField(null, "", 0);// 驗證碼輸入欄位
    private static MailController mailController = new MailController();

    public registerFrame() {
        super("Register Your Account");
        setLayout(null);
        // 提示語
        emailText.addFocusListener(new JTextFieldHintListener(emailText, "Email:"));
        passWordText.addFocusListener(new JPasswordFieldHintListener(passWordText, "Password:"));
        passWordText2.addFocusListener(new JPasswordFieldHintListener(passWordText2, "Password again:"));
        // 手機號碼提示語
        phoneText.addFocusListener(new JTextFieldHintListener(phoneText, "Phone number:"));
        validationCodeText.addFocusListener(new JTextFieldHintListener(validationCodeText, "Verification Code:"));
        // 密碼框框文字會顯示
        passWordText.setEchoChar('\0');
        passWordText2.setEchoChar('\0');

        // 確認按鈕事件
        ButtonActionListener handler = new ButtonActionListener();
        confirm.addActionListener(handler);
        send.addActionListener(handler);
        // 各位置設定
        email.setBounds(100, 0, 180, 50);
        emailText.setBounds(100, 40, 300, 30);
        phoneLabel.setBounds(100, 65, 180, 50);
        phoneText.setBounds(100, 105, 300, 30);
        passWord.setBounds(100, 135, 180, 50);
        passWordText.setBounds(100, 170, 300, 30);
        passWord2.setBounds(100, 200, 300, 50);
        passWordText2.setBounds(100, 235, 300, 30);
        validationCodeLabel.setBounds(100, 270, 180, 50);
        validationCodeText.setBounds(100, 305, 300, 30);
        confirm.setBounds(280, 340, 80, 20);
        send.setBounds(110, 340, 150, 20);
        // 字型&大小設定
        email.setFont((new Font("", Font.ITALIC, 15)));
        passWord.setFont((new Font("", Font.ITALIC, 15)));
        passWord2.setFont((new Font("", Font.ITALIC, 15)));
        phoneLabel.setFont((new Font("", Font.ITALIC, 15)));
        validationCodeLabel.setFont(new Font("", Font.ITALIC, 15));
        add(email);
        add(emailText);
        add(phoneLabel);
        add(phoneText);
        add(passWord);
        add(passWordText);
        add(passWord2);
        add(passWordText2);
        add(validationCodeLabel);
        add(validationCodeText);
        add(send);
        add(confirm);
    }

    private void close() {
        this.dispose();
    }

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String EMAIL = emailText.getText().trim();
            String PASSWORD = new String(passWordText.getPassword());
            String PASSWORD2 = new String(passWordText2.getPassword());
            String PHONE = phoneText.getText().trim();
            String VALIDCOD = validationCodeText.getText().trim();
            if ("Password:".equals(PASSWORD) || "Email:".equals(EMAIL) || "Password again:".equals(PASSWORD2)
                    || "Phone number:".equals(PHONE)) {
                JOptionPane.showMessageDialog(null, "Please enter complete information!!", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
                return;
            } else if (!(PASSWORD.equals(PASSWORD2))) {
                JOptionPane.showMessageDialog(null, "Two password are different!!", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 若文字框都有輸入且兩次密碼輸入皆相同
            AccountController accountController = new AccountController();

            // 檢查帳號輸入格式
            if (accountController.emailFormatCheck(EMAIL) == AccountController.INPUT_FORMAT_NOT_CORRECT) {// 若格式不為電子郵件
                JOptionPane.showMessageDialog(null, "Email format is not correct,please enter again", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // 檢查手機號碼輸入格式
            if (accountController.phoneFormatCheck(PHONE) == AccountController.INPUT_FORMAT_NOT_CORRECT) {// 若格式不為手機號碼
                JOptionPane.showMessageDialog(null, "Phone number format is not correct,please enter again", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 檢查帳號是否重複
            if (e.getActionCommand().equals("Send Code")) {
                try {
                    if (accountController.reapeatedAccount(EMAIL) == AccountController.USERNAME_REPEAT) {// 若帳號重複
                        JOptionPane.showMessageDialog(null, "Email is already registered",
                                "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {// 帳號不重複 寄送驗證碼做電子郵件驗證
                        if (mailController.SendRequest() == MailController.OK)
                            mailController.sendMail(EMAIL);
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Your verification code is already send,you can not send again in 5 minutes.",
                                    "SUCCESS",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        JOptionPane.showMessageDialog(null, "Verification code send",
                                "SUCCESS",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    return;
                }
            }
            // 按下確認後檢查驗證碼輸入是否正確 正確的話將使用者資料上傳到資料庫
            if (e.getActionCommand().equals("Confirm")) {
                if (mailController.ValidCodeVerify(VALIDCOD) == AccountController.OK) {
                    try {
                        accountController.regiserAccount(EMAIL, PASSWORD, PHONE);
                        JOptionPane.showMessageDialog(null, "Register success!",
                                "SUCCESS",
                                JOptionPane.INFORMATION_MESSAGE);
                        close();// 關閉註冊葉面
                        return;
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Verification code is not correct",
                            "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
    }
}
