package com.myguisecretproject.secretlang.alphabets;

import com.myguisecretproject.secretlang.helper.SymbolH;

import java.util.HashMap;
import java.util.LinkedList;

public class English extends Language
{
    public English() {

        this.letters = new char[26];
        this.lettersMap = new HashMap<>();
        this.lstLetters = new LinkedList<>();
        int b = 0;

        for(char i = 'a'; i <= 'z'; i++)
        {
            this.letters[b] = i;
            int index = b;
            this.lettersMap.put(i,index);
            SymbolH s = new SymbolH(i, index);
            this.lstLetters.add(index, s);
            b++;
        }
    }
}
