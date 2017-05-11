package com.myownsecretproject.secretlanguage.codes.caesar_code;

import com.myownsecretproject.secretlanguage.alphabets.LangManager;
import com.myownsecretproject.secretlanguage.alphabets.LangWrapper;
import com.myownsecretproject.secretlanguage.alphabets.languages.Language;

public class Caesar_decode extends Caesar {

    public Caesar_decode()
    {}

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
        this.currentLanguage = Language.setLanguage(languageManager.getWrapIn().getLstLang().get(0));
    }

    @Override
    protected int getIndex(int i)
    {
        int size = currentLanguage.getSize();
        return (i - key) < 0 ? (i - key + size) : (i - key);
    }

    @Override
    public void getResult()
    {
        makeCode();
        String result = infoHelper.getResult() + "\n" + "Key: " + key;
        super.printResult(result);
    }
}
