package com.example;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
//帳號輸入提示語
public class JTextFieldHintListener implements FocusListener{
    private String hintText;
    private JTextField textField;
    public JTextFieldHintListener(JTextField textField,String hintText){
        this.textField=textField;
        this.hintText=hintText;
        textField.setText(hintText);
        textField.setForeground(Color.GRAY);
    }

    @Override
    public void focusGained(FocusEvent e){
        String temp=textField.getText();
        if(temp.equals(hintText)){
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e){
        String temp=textField.getText();
        if(temp.equals("")){
            textField.setForeground(Color.GRAY);
            textField.setText(hintText);
        }
    }
}
