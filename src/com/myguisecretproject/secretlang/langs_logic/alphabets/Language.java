package com.myguisecretproject.secretlang.langs_logic.alphabets;

import com.myguisecretproject.secretlang.langs_logic.helper.SymbolH;

import java.util.*;

public abstract class Language {
    protected char letters[];
    protected Map<Character, Integer> lettersMap = new HashMap<>();
    protected List<SymbolH> lstLetters = new ArrayList<>();

    public static Language getLanguage(AllLanguagesEnum lang) {
        switch (lang){
            case RUSSIAN:
                return  new Russian();
            case ENGLISH:
                return new English();
            default:
                // Exception
                System.out.println("error in creating mainLanguage");
                return null;
        }
    }

    public char[] getAlphabet() {
        return this.letters;
    }

    public Map<Character,Integer> getMap() {
        return this.lettersMap;
    }

    public List<SymbolH> getLstLetters() {
        return lstLetters;
    }

    public int getSize() {
        return this.letters.length;
    }

    public boolean isValidLetter(char c) {
        return this.lettersMap.containsKey(c);
    }

    public boolean isValidLetter(int n) {
        return this.lettersMap.containsValue(n);
    }

    public static int getIndex(char i) {
        return (int)i;
    }

    public static char getLetter(int i) {
        return (char)i;
    }
}
