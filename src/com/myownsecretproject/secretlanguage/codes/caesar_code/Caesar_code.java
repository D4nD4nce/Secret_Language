package com.myownsecretproject.secretlanguage.codes.caesar_code;

import com.myownsecretproject.secretlanguage.alphabets.LangManager;
import com.myownsecretproject.secretlanguage.alphabets.LangWrapper;
import com.myownsecretproject.secretlanguage.alphabets.languages.Language;
import com.myownsecretproject.secretlanguage.codes.All_codes;

public class Caesar_code extends Caesar implements All_codes {

    public Caesar_code()
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
        return (i + key) >= size ? (i + key - size) : (i + key);
    }

    @Override
    public void getResult()
    {
        makeCode();
        String result = infoHelper.getResult() + "\n" + "Key: " + key;
        super.printResult(result);
    }
}