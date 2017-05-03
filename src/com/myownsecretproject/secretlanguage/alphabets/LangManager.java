package com.myownsecretproject.secretlanguage.alphabets;

import java.util.LinkedList;
import java.util.List;

public class LangManager {

    // flags to coordinate work of codes if there are more then one language for input or output
    private int inOutFlags;
    public static final int FLAG_SET_LANGUAGES_FOR_INPUT = 1;
    public static final int FLAG_SET_LANGUAGES_FOR_OUTPUT = 2;
    public static final int FLAG_SET_LANGUAGES_FOR_BOTH = 3;

    // wraps for parameters for languages
    private LangWrapper langIn;
    private LangWrapper langOut;

    public LangManager(int inOut, LangWrapper wrapIn, LangWrapper wrapOut) throws Exception
    {
        switch (this.inOutFlags = inOut)
        {
            case FLAG_SET_LANGUAGES_FOR_INPUT:
                langIn = takeLanguages(wrapIn, "input");
                break;
            case FLAG_SET_LANGUAGES_FOR_OUTPUT:
                langOut = takeLanguages(wrapOut, "output");
                break;
            case FLAG_SET_LANGUAGES_FOR_BOTH:
                langIn = takeLanguages(wrapIn, "input");
                langOut = takeLanguages(wrapOut, "output");
                break;
            default:
                throw new Exception("LangManager:constructor:wrong number in switch flags");
        }
    }

    private LangWrapper takeLanguages(LangWrapper w, String str)
    {
        if (w.isNeedToChoose())
        {
            w.printWhatToChoose(str);
            List<AllLanguagesEnum> lstResult = new LinkedList<>();
            //
            for(int i = 0; i < w.getNumberToChoose(); i++)
                lstResult.add(AllLanguagesEnum.choose());
            //
            return new LangWrapper(false, w.getNumberToChoose(), lstResult);
        }
        //
        return w;
    }

    public int getInOutFlags() {
        return inOutFlags;
    }

    public LangWrapper getWrapIn() {
        return langIn;
    }

    public LangWrapper getWrapOut() {
        return langOut;
    }
}