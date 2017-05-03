package com.myownsecretproject.secretlanguage.alphabets;

import java.util.List;

public class LangWrapper {

    public static final int FLAG_SET_ALL_lANGUAGES = 1000;
    public static final int FLAG_SET_NOTHING = 1001;

    private boolean needToChoose;
    private int numberToChoose;
    private List<AllLanguagesEnum> lstLang;

    public LangWrapper(boolean choose_or_not, int count, List<AllLanguagesEnum> lst)
    {
        this.needToChoose = choose_or_not;
        this.numberToChoose = count;
        this.lstLang = lst;
    }

    public LangWrapper(boolean choose_or_not, int count)
    {
        this.needToChoose = choose_or_not;
        this.numberToChoose = count;
    }

    public boolean isNeedToChoose() {
        return needToChoose;
    }

    public int getNumberToChoose() {
        return numberToChoose;
    }

    public List<AllLanguagesEnum> getLstLang() {
        return lstLang;
    }

    public void printWhatToChoose(String str)
    {
        String language = numberToChoose > 1 ? "s." : ".";
        System.out.println("Now you should choose " + numberToChoose + " " + str + " language" + language);
    }
}
