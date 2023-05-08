package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.EnglishSequenceData;
import org.passay.IllegalSequenceRule;
import org.passay.PasswordGenerator;
import org.passay.Rule;
import org.passay.WhitespaceRule;

public class RandomPasswordGenerator {

    // 常數
    public static int UpperCase = 0;// 欲生成含有大寫字母的密碼
    public static int LowerCase = 1;// 小寫字母
    public static int Digits = 2;// 數字
    public static int Special = 3;// 特殊符號

    // length upperCase lowerCase digits symbols dictionary uncertainChar
    // 避免生成以生成過的密碼
    private Map<Integer, EnglishCharacterData> charMap = new HashMap<>();

    public RandomPasswordGenerator() {
        charMap.put(Special, EnglishCharacterData.Special);
        charMap.put(Digits, EnglishCharacterData.Digit);
        charMap.put(LowerCase, EnglishCharacterData.LowerCase);
        charMap.put(UpperCase, EnglishCharacterData.UpperCase);
    }

    // 生成特定長度 特定條件的密碼
    public String PasswordGenerate(int length, int... param) {// 參數:長度為必須參數 後面的參數

        List<Rule> list = new ArrayList<>();
        System.err.println(length);
        for (int data : param) {
            CharacterRule tmp = new CharacterRule(charMap.get(data), 1);
            list.add(tmp);
        }

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
        // 還要考慮避免生成已經生成過的密碼 避免生成過多的特殊字元
        return new PasswordGenerator().generatePassword(length, rules);

    }

}
