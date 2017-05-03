package com.myownsecretproject.secretlanguage.codes.simple_code;

import com.myownsecretproject.secretlanguage.alphabets.LangManager;
import com.myownsecretproject.secretlanguage.alphabets.LangWrapper;
import com.myownsecretproject.secretlanguage.alphabets.languages.Language;
import com.myownsecretproject.secretlanguage.codes.All_codes;

public class Simple_decode extends Simple implements All_codes {

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

    }

    @Override
    public void getResult() {

    }
}
