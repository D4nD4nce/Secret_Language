package com.myownsecretproject.secretlanguage.codes.simple_code;

import com.myownsecretproject.secretlanguage.alphabets.LangManager;
import com.myownsecretproject.secretlanguage.alphabets.LangWrapper;
import com.myownsecretproject.secretlanguage.alphabets.languages.Language;
import com.myownsecretproject.secretlanguage.codes.All_codes;

public class Simple_code extends Simple implements All_codes {

    @Override
    public void setInfoHelper(String str) {
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
        char c = infoHelper.getCurrentSymbol();
        //
        if(singleLanguage.isValidLetter(c))
        {
            infoHelper.setCurrentSymbol(moving(c));
        } else {
            infoHelper.setCurrentSymbol(c);
        }
        //
        while (infoHelper.nextLetter())
        {
            char h = infoHelper.getCurrentSymbol();
            //
            if(singleLanguage.isValidLetter(h))
            {
                infoHelper.setCurrentSymbol(moving(h));
            } else {
                infoHelper.setCurrentSymbol(h);
            }
        }
    }

    private String moving(char h)
    {
        StringBuilder str = new StringBuilder();
        int currentIndex = singleLanguage.getMap().get(h);
        int a = currentIndex / 10;
        int b = currentIndex % 10;
        //
        if (a > 0)
        {
            str.append(coding(a));
        }
        //
        str.append(coding(b));
        return str.toString();
    }

    private char coding(int n)
    {
        return lstKey.get(n).getSymbol();
    }

    @Override
    public void getResult()
    {
        makeCode();
        StringBuilder result = new StringBuilder();
        result.append("key:\n");
        //
        for (int i = 0; i < singleLanguage.getSize(); i++)
        {
            char h = singleLanguage.getAlphabet()[i];
            result.append(h);
            result.append(" = ");
            result.append(moving(h));
            result.append("\n");
        }
        //
        result.append(infoHelper.getResult());
        super.printResult(result.toString());
    }
}
