package com.example;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;
//密碼輸入提示語
public class JPasswordFieldHintListener implements FocusListener{

    static char defaultChar;
    private String hintText;
    private JPasswordField textField;
    public JPasswordFieldHintListener(JPasswordField textField,String hintText){
        this.textField=textField;
        this.hintText=hintText;
        textField.setText(hintText);
        textField.setForeground(Color.GRAY);
        //默認的密碼隱藏符號
        defaultChar = textField.getEchoChar();
    }

    @Override
    public void focusLost(FocusEvent e){
        String temp=new String(textField.getPassword()).trim();
        if(temp.equals("")){
            textField.setEchoChar('\0');
            textField.setForeground(Color.GRAY);
            textField.setText(hintText);
            
        }
    }

    @Override
    public void focusGained(FocusEvent e){
        String temp=new String(textField.getPassword()).trim();
        if(temp.equals(hintText)){
            textField.setText("");
            textField.setEchoChar(defaultChar);
            textField.setForeground(Color.BLACK);
        }
    }

    
}
