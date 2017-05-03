package com.myownsecretproject.secretlanguage.codes.caesar_code;

import com.myownsecretproject.secretlanguage.alphabets.languages.Language;
import com.myownsecretproject.secretlanguage.codes.All_codes;
import com.myownsecretproject.secretlanguage.codes.Code;

import java.util.Map;
import java.util.Scanner;

public abstract class Caesar extends Code implements All_codes {

    protected Language currentLanguage;
    protected int key;

    @Override
    public abstract void setInfoHelper(String str);

    public int getKey() {
        return key;
    }

    // сдвиг пока только вправо (положительное число)
    @Override
    public void setKey() {
        int maxNumber = currentLanguage.getSize() - 1;
        Scanner input = new Scanner(System.in);
        System.out.println("set the key (numbers only 1-" + maxNumber + ")");
        //
        int nKey;
        //
        if (input.hasNextInt() && checkNumber(nKey = input.nextInt(), maxNumber))
        {
           this.key = nKey;
        }
        else {
            setKey();
        }
    }

    private boolean checkNumber(int n, int max)
    {
        return 1 <= n && n <= max;
    }

    protected void makeCode()
    {
        char c = infoHelper.getCurrentSymbol();
        infoHelper.setCurrentSymbol(currentLanguage.isValidLetter(c) ? moveLetter(c) : c);
        //
        while (infoHelper.nextLetter())
        {
            char h = infoHelper.getCurrentSymbol();
            infoHelper.setCurrentSymbol(currentLanguage.isValidLetter(h) ? moveLetter(h) : h);
        }
    }

    private char moveLetter(char c)
    {
        char letters[] = currentLanguage.getAlphabet();
        Map<Character, Integer> map = currentLanguage.getMap();
        int codeIndex = getIndex(map.get(c));
        return letters[codeIndex];
    }

    protected abstract int getIndex(int i);

    @Override
    public abstract void getResult();
}
