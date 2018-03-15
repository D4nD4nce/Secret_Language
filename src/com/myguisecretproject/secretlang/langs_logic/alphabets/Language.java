package com.myguisecretproject.secretlang.langs_logic.alphabets;

import com.myguisecretproject.secretlang.langs_logic.helper.SymbolH;

import java.util.List;
import java.util.Map;

public abstract class Language
{
    protected char letters[];
    protected Map<Character, Integer> lettersMap;
    protected List<SymbolH> lstLetters;

    public static Language setLanguage(AllLanguagesEnum lang)
    {
        switch (lang){
            case RUSSIAN:
                return  new Russian();
            case ENGLISH:
                return new English();
            default:
                // Exception
                System.out.println("error in creating language");
                return null;
        }
    }

    public char[] getAlphabet()
    {
        return this.letters;
    }

    public Map<Character,Integer> getMap()
    {
        return this.lettersMap;
    }

    public List<SymbolH> getLstLetters()
    {
        return lstLetters;
    }

    public int getSize()
    {
        return this.letters.length;
    }

    public boolean isValidLetter(char c)
    {
        return this.lettersMap.containsKey(c);
    }

    public boolean isValidLetter(int n)
    {
        return this.lettersMap.containsValue(n);
    }

    public static int getIndex(char i){
        return (int)i;
    }

    public static char getLetter(int i){
        return (char)i;
    }
}
