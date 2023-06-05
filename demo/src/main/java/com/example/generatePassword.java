package com.example;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class generatePassword extends main_page {

    public JLabel mainLabel = new JLabel();

    private static Image dogImage = new ImageIcon(
            SwingTester.class.getResource("dogdogdog.png")).getImage();
    private static ImageIcon dogIcon = new ImageIcon();
    private static JLabel dog1;
    private static JLabel dog2;

    private static JLabel titleLabel = new JLabel("Random Password Generation");
    private static JLabel numberLabel = new JLabel("Choose the number of password digits you need");
    private static JLabel symbolsLabel = new JLabel("Tick the symbols you need");
    private static JTextField outPut = new JTextField("");
    private static JSlider numberslider = new JSlider(8, 20, 10);
    private static JCheckBox engLowBox;
    private static JCheckBox engUpperBox;
    private static JCheckBox numberBox;
    private static JCheckBox specialBox;
    private static JButton confirm = new JButton("Confirm");
    private static JButton copy = new JButton("Copy");
    private static String outputString = "";
    private static int totalDigits = 10;

    public generatePassword(JLabel mainLabel) {
        this.mainLabel = mainLabel;
        // 事件設定 拿slider的數字
        numberslider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                totalDigits = numberslider.getValue();
                System.out.print(totalDigits);
            }
        });
        // 事件設定
        ButtonActionListener Bhandler = new ButtonActionListener();
        confirm.addActionListener(Bhandler);
        copy.addActionListener(Bhandler);
        // 圖片設定
        dogImage = dogImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        dogIcon.setImage(dogImage);
        dog1 = new JLabel(dogIcon);
        dog2 = new JLabel(dogIcon);

    }

    public void createGenerate(JPanel passwardJPanel) {
        // 移除當前 Panel 內的所有物件
        // 這放要改panel的函式的最前面
        passwardJPanel.removeAll();
        passwardJPanel.repaint();
        // 重置
        numberslider.setValue(10);
        engLowBox = new JCheckBox("Lowercase English Letters");
        engUpperBox = new JCheckBox("Upper Case English Letters");
        numberBox = new JCheckBox("Number symbol");
        specialBox = new JCheckBox("Special symbol");
        outPut.setText("");

        passwardJPanel.setBackground(Color.WHITE);
        passwardJPanel.setLayout(null);

        // slider設定
        numberslider.setPaintTicks(true);// 顯示slider
        numberslider.setMinorTickSpacing(1);// 5一小格
        numberslider.setBackground(Color.WHITE);
        numberslider.setPaintLabels(true);// 添加數字標籤
        numberslider.setPaintLabels(true);

        // slider下的數字
        Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
        // labelTable.put(6, new JLabel("6"));
        // labelTable.put(7, new JLabel("7"));
        labelTable.put(8, new JLabel("8"));
        labelTable.put(9, new JLabel("9"));
        labelTable.put(10, new JLabel("10"));
        labelTable.put(11, new JLabel("11"));
        labelTable.put(12, new JLabel("12"));
        labelTable.put(13, new JLabel("13"));
        labelTable.put(14, new JLabel("14"));
        labelTable.put(15, new JLabel("15"));
        labelTable.put(16, new JLabel("16"));
        labelTable.put(17, new JLabel("17"));
        labelTable.put(18, new JLabel("18"));
        labelTable.put(19, new JLabel("19"));
        labelTable.put(20, new JLabel("20"));
        // 顯示數字
        numberslider.setLabelTable(labelTable);

        // checkbox設定
        engLowBox.setBackground(Color.WHITE);
        engUpperBox.setBackground(Color.WHITE);
        numberBox.setBackground(Color.WHITE);
        specialBox.setBackground(Color.WHITE);

        // JTextfield設定
        outPut.setEditable(false);

        // 字型設定
        titleLabel.setFont((new Font("", Font.BOLD, 30)));
        numberLabel.setFont((new Font("", Font.ITALIC, 20)));
        symbolsLabel.setFont((new Font("", Font.ITALIC, 20)));
        engLowBox.setFont((new Font("", Font.BOLD, 15)));
        engUpperBox.setFont((new Font("", Font.BOLD, 15)));
        numberBox.setFont((new Font("", Font.BOLD, 15)));
        specialBox.setFont((new Font("", Font.BOLD, 15)));

        titleLabel.setBounds(160, 0, 500, 100);
        dog1.setBounds(135, 80, 20, 20);
        numberLabel.setBounds(165, 80, 500, 30);
        numberslider.setBounds(205, 115, 350, 65);
        symbolsLabel.setBounds(260, 185, 350, 30);
        dog2.setBounds(230, 185, 20, 20);
        engLowBox.setBounds(300, 220, 350, 30);
        engUpperBox.setBounds(300, 250, 350, 30);
        numberBox.setBounds(300, 280, 350, 30);
        specialBox.setBounds(300, 310, 350, 30);
        confirm.setBounds(336, 355, 80, 25);
        outPut.setBounds(185, 400, 380, 30);
        copy.setBounds(580, 403, 65, 25);

        passwardJPanel.add(titleLabel);
        passwardJPanel.add(numberLabel);
        passwardJPanel.add(dog1);
        passwardJPanel.add(numberslider);
        passwardJPanel.add(symbolsLabel);
        passwardJPanel.add(dog2);
        passwardJPanel.add(engLowBox);
        passwardJPanel.add(engUpperBox);
        passwardJPanel.add(numberBox);
        passwardJPanel.add(specialBox);
        passwardJPanel.add(confirm);
        passwardJPanel.add(outPut);
        passwardJPanel.add(copy);
        // 這放要改panel的函式的最後面
        passwardJPanel.revalidate();
    }

    private static void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    private static class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == confirm) {
                RandomPasswordGenerator generator = new RandomPasswordGenerator();
                if (!(engLowBox.isSelected()) && !(engUpperBox.isSelected()) && !(numberBox.isSelected())
                        && !(specialBox.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Please choose at least one symbol.", "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (engLowBox.isSelected()) {
                    if (!(engUpperBox.isSelected()) && !(numberBox.isSelected()) && !(specialBox.isSelected())) {// 英文小寫
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.LowerCase);
                        outPut.setText(outputString);

                    } else if (engUpperBox.isSelected() && !(numberBox.isSelected()) && !(specialBox.isSelected())) {// 英文小寫+大寫
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.LowerCase,
                                RandomPasswordGenerator.UpperCase);
                        outPut.setText(outputString);
                    } else if (!(engUpperBox.isSelected()) && numberBox.isSelected() && !(specialBox.isSelected())) {// 英文小寫+數字
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.LowerCase,
                                RandomPasswordGenerator.Digits);
                        outPut.setText(outputString);
                    } else if (!(engUpperBox.isSelected()) && !(numberBox.isSelected()) && specialBox.isSelected()) {// 英文小寫+特殊字元
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.LowerCase,
                                RandomPasswordGenerator.Special);
                        outPut.setText(outputString);
                    } else if (engUpperBox.isSelected() && !(numberBox.isSelected()) && specialBox.isSelected()) {// 英文小寫+大寫+特殊字元
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.LowerCase,
                                RandomPasswordGenerator.UpperCase, RandomPasswordGenerator.Special);
                        outPut.setText(outputString);
                    } else if (engUpperBox.isSelected() && numberBox.isSelected() && !(specialBox.isSelected())) {// 英文小寫+大寫+數字
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.LowerCase,
                                RandomPasswordGenerator.UpperCase, RandomPasswordGenerator.Digits);
                        outPut.setText(outputString);
                    } else if (!(engUpperBox.isSelected()) && numberBox.isSelected() && specialBox.isSelected()) {// 英文小寫+特殊字元+數字
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.LowerCase,
                                RandomPasswordGenerator.Special, RandomPasswordGenerator.Digits);
                        outPut.setText(outputString);
                    } else {// 英文小寫+大寫+數字+特殊字元
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.LowerCase,
                                RandomPasswordGenerator.UpperCase, RandomPasswordGenerator.Digits,
                                RandomPasswordGenerator.Special);
                        outPut.setText(outputString);
                    }
                } else if (engUpperBox.isSelected()) {
                    if (!(engLowBox.isSelected()) && !(numberBox.isSelected()) && !(specialBox.isSelected())) {// 英文大寫
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.UpperCase);
                        outPut.setText(outputString);
                    } else if (!(engLowBox.isSelected()) && numberBox.isSelected() && !(specialBox.isSelected())) {// 英文大寫+數字
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.UpperCase,
                                RandomPasswordGenerator.Digits);
                        outPut.setText(outputString);
                    } else if (!(engLowBox.isSelected()) && !(numberBox.isSelected()) && specialBox.isSelected()) {// 英文大寫+特殊字元
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.UpperCase,
                                RandomPasswordGenerator.Special);
                        outPut.setText(outputString);
                    } else if (!(engLowBox.isSelected()) && numberBox.isSelected() && specialBox.isSelected()) {// 英文大寫+特殊字元+數字
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.UpperCase,
                                RandomPasswordGenerator.Special, RandomPasswordGenerator.Digits);
                        outPut.setText(outputString);
                    }
                } else if (numberBox.isSelected()) {
                    if (!(engLowBox.isSelected()) && !(engUpperBox.isSelected()) && !(specialBox.isSelected())) {// 數字
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.Digits);
                        outPut.setText(outputString);
                    } else if (!(engLowBox.isSelected()) && !(engUpperBox.isSelected()) && specialBox.isSelected()) {// 數字+特殊字元
                        outputString = "";
                        outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.Digits,
                                RandomPasswordGenerator.Special);
                        outPut.setText(outputString);
                    }
                } else {
                    outputString = "";
                    outputString = generator.PasswordGenerate(totalDigits, RandomPasswordGenerator.Special);
                    outPut.setText(outputString);
                }
            } else {
                if (outPut.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "There is no output.", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    String text = outPut.getText();
                    copyToClipboard(text);
                }

            }
        }
    }
}
