package com.myownsecretproject.secretlanguage.codes.simple_code;

import com.myownsecretproject.secretlanguage.alphabets.languages.Language;
import com.myownsecretproject.secretlanguage.codes.All_codes;
import com.myownsecretproject.secretlanguage.codes.Code;
import com.myownsecretproject.secretlanguage.helper.SymbolH;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class Simple extends Code implements All_codes {

    protected Language singleLanguage;
    protected List<SymbolH> lstKey;

    public Simple() {
        lstKey = new LinkedList<>();
    }

    @Override
    public abstract void setInfoHelper(String str);

    public List<SymbolH> getKey() {
        return lstKey;
    }

    @Override
    public void setKey() {
        System.out.println("Now you should write code: alphabet will be changed to numbers and these numbers will be changed to this code");
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
                SymbolH s = new SymbolH(temp.charAt(0), i);
                lstKey.add(i, s);
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
        return singleLanguage.isValidLetter(c);
    }

    @Override
    public abstract void getResult();
}
