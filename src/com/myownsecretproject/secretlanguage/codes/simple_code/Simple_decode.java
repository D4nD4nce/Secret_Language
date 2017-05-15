package com.myownsecretproject.secretlanguage.codes.simple_code;

import com.myownsecretproject.secretlanguage.alphabets.LangManager;
import com.myownsecretproject.secretlanguage.alphabets.LangWrapper;
import com.myownsecretproject.secretlanguage.alphabets.languages.Language;
import com.myownsecretproject.secretlanguage.codes.All_codes;

public class Simple_decode extends Simple implements All_codes {

    @Override
    public void setLanguage()
    {
        LangWrapper wrapIn = new LangWrapper(true, 1);
        //
        try {
            this.languageManager = new LangManager(LangManager.FLAG_SET_LANGUAGES_FOR_INPUT, wrapIn, wrapIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        this.singleLanguage = Language.setLanguage(languageManager.getWrapIn().getLstLang().get(0));
    }

    protected void makeCode()
    {
        char c[] = new char [2];
        c[1] = infoHelper.getCurrentSymbol();
        // проверка, является ли первый символ буквой указанного алфавита
        if (singleLanguage.isValidLetter(c[1]))
        {
            if (infoHelper.nextLetter())
            {
                c[2] = infoHelper.getCurrentSymbol();
                // является ли второй символ буквой указанного алфавита
                if (singleLanguage.isValidLetter(c[2])) {
                    infoHelper.setCurrentSymbol(decoding(String.valueOf(c)));
                }
                else {
                    infoHelper.setCurrentSymbol(decoding(String.valueOf(c[1])));
                    // в любом случае записываем в выходной результат все символы
                    infoHelper.setCurrentSymbol(c[2]);
                }
            }
        } else {
            infoHelper.setCurrentSymbol(c[1]);
        }
        //
        while (infoHelper.nextLetter())
        {
            c[1] = infoHelper.getCurrentSymbol();
            // если символ является не декодируемым, то записываем его в результат и переходим к следующему
            if (!singleLanguage.isValidLetter(c[1]))
            {
                infoHelper.setCurrentSymbol(c[1]);
                continue;
            }
            //
            if (infoHelper.nextLetter())
            {
                c[2] = infoHelper.getCurrentSymbol();
                //
                if (singleLanguage.isValidLetter(c[2]))
                {
                    infoHelper.setCurrentSymbol(decoding(String.valueOf(c)));
                    continue;
                }
                //
                infoHelper.setCurrentSymbol(decoding(String.valueOf(c[1])));
                infoHelper.setCurrentSymbol(c[2]);
            }
        }
    }

    private String decoding(String str)
    {
        int d = 0;
        int n = 0;
        //
        if (str.length() > 1)
        {
            d = set(str.charAt(0)) * 10;    // получить десятки, обозначающие местоположение нужной буквы согласно коду
            n = set(str.charAt(1));         // получить единицы, -//--//--//-
        } else {
            n = set(str.charAt(0));         // получить единицы при отсутсвии десятков (первый символ слева-направо)
        }
        // складываем полученные числа кода (десятки + единицы) и получаем число,
        // которое указывает порядковый номер зашифрованной буквы.
        char cResult = singleLanguage.getLstLetters().get(d + n).getSymbol();
        return String.valueOf(cResult);
    }

    private int set(char i)
    {
        return mapKey_indexLetter.get(i);
    }

    @Override
    public void getResult() {

    }
}
