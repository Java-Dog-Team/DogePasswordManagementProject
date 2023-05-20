package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.EnglishSequenceData;
import org.passay.IllegalSequenceRule;
import org.passay.PasswordGenerator;
import org.passay.Rule;
import org.passay.WhitespaceRule;

//密碼產生器
public class RandomPasswordGenerator {

    // 常數
    public static int UpperCase = 0;// 欲生成含有大寫字母的密碼
    public static int LowerCase = 1;// 小寫字母
    public static int Digits = 2;// 數字
    public static int Special = 3;// 特殊符號

    private Map<Integer, CharacterRule> charMap = new HashMap<>();

    public RandomPasswordGenerator() {
        charMap.put(Special, new CharacterRule(new CharacterData() {
            @Override
            public String getErrorCode() {
                return null;
            }

            @Override
            public String getCharacters() {
                return "@$*^#!&%";
            }
        }, 1));
        charMap.put(Digits, new CharacterRule(EnglishCharacterData.Digit, 1));
        charMap.put(LowerCase, new CharacterRule(EnglishCharacterData.LowerCase, 1));
        charMap.put(UpperCase, new CharacterRule(EnglishCharacterData.UpperCase, 1));
    }

    // 生成特定長度 特定條件的密碼
    public String PasswordGenerate(int length, int... param) {// 參數:長度為必須參數 後面的參數

        List<Rule> list = new ArrayList<>();

        for (int data : param) {
            CharacterRule tmp = charMap.get(data);
            list.add(tmp);
        }
        if (list.isEmpty())
            list.add(charMap.get(UpperCase));

        list.add(new WhitespaceRule());// 避免生成具有空白字元的密碼

        // 避免生成具有字典序性的或者容易混淆的字元密碼
        list.add(new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false));
        list.add(new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false));
        list.add(new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false));

        List<CharacterRule> rules = new ArrayList<CharacterRule>();

        for (Rule rule : list) {
            if (rule instanceof CharacterRule) {
                CharacterRule cr = (CharacterRule) rule;
                rules.add(cr);
            }

        }

        String pass = new PasswordGenerator().generatePassword(length, rules);

        return pass;

    }

}
