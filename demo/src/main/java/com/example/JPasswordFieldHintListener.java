package com.example;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;

public class JPasswordFieldHintListener implements FocusListener{

    static char defaultChar;
    private String hintText;
    private JPasswordField textField;
    public JPasswordFieldHintListener(JPasswordField textField,String hintText){
        this.textField=textField;
        this.hintText=hintText;
        textField.setText(hintText);
        textField.setForeground(Color.GRAY);
        defaultChar = textField.getEchoChar();
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

    @Override
    public void focusLost(FocusEvent e){
        String temp=new String(textField.getPassword()).trim();
        if(temp.equals("")){
            textField.setForeground(Color.GRAY);
            textField.setText(hintText);
            textField.setEchoChar('\0');
        }
    }
}
