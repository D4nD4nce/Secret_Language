package com.myownsecretproject.secretlanguage.codes.simple_code;

import com.myownsecretproject.secretlanguage.alphabets.languages.Language;
import com.myownsecretproject.secretlanguage.codes.All_codes;
import com.myownsecretproject.secretlanguage.codes.Code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Simple extends Code implements All_codes {

    protected Language singleLanguage;
    protected Map<Integer, Character> mapKey_indexNumber;
    protected Map<Character, Integer> mapKey_indexLetter;

    public Simple() {
        mapKey_indexNumber = new HashMap<>();
        mapKey_indexLetter = new HashMap<>();
    }

    @Override
    public abstract void setLanguage();

    public Map<Integer, Character> getKey_indexNumber()
    {
        return mapKey_indexNumber;
    }

    @Override
    public void setKey() {
        System.out.println("Now you should write code: alphabet will be changed to numbers " +
                "and these numbers will be changed to this code");
        keySetter(0);
    }

    private void keySetter(int step)
    {
        for (int i = step; i <= 9; i++)
        {
            System.out.println("Set code letter for " + i);
            Scanner input = new Scanner(System.in);
            String temp;

            if (input.hasNext() && isValidKey(temp = input.next().trim()))
            {
                char c = temp.charAt(0);
                mapKey_indexNumber.put(i, c);
                mapKey_indexLetter.put(c, i);
            } else {
                keySetter(i);
                break;
            }
        }
    }

    private boolean isValidKey(String str)
    {
        if (str.length() > 1)
            return false;
        //
        char c = str.charAt(0);
        //
        if (mapKey_indexLetter.containsKey(c))
            return false;
        //
        return singleLanguage.isValidLetter(c);
    }

    @Override
    public abstract void getResult();
}
