package com.myownsecretproject.secretlanguage.codes;

import com.myownsecretproject.secretlanguage.alphabets.LangManager;
import com.myownsecretproject.secretlanguage.codes.caesar_code.Caesar_code;
import com.myownsecretproject.secretlanguage.codes.caesar_code.Caesar_decode;
import com.myownsecretproject.secretlanguage.codes.simple_code.Simple_code;
import com.myownsecretproject.secretlanguage.codes.simple_code.Simple_decode;
import com.myownsecretproject.secretlanguage.helper.InfoH;

import java.util.Scanner;

public abstract class Code implements All_codes {

    private static final int CODE = 1;
    private static final int DECODE = 2;

    protected LangManager languageManager;
    protected InfoH infoHelper;
    //
    public static Code setCode(AllCodesEnum c) throws Exception
    {
        if (code_decode())
        {
            switch (c)
            {
                case CAESAR_CODE:
                    return new Caesar_code();
                case SIMPLE_CODE:
                    return new Simple_code();
                default:
                    throw new Exception("error in creating Code class");
            }
        } else {
            switch (c)
            {
                case CAESAR_CODE:
                    return new Caesar_decode();
                case SIMPLE_CODE:
                    return new Simple_decode();
                default:
                    throw new Exception("error in creating Code class");
            }
        }
    }
    //
    @Override
    public void setInfo()
    {
        setLanguage();
        System.out.println("Write your text");
        Scanner input = new Scanner(System.in);
        String str;

        if (input.hasNextLine() && !(str = input.nextLine()).isEmpty())
        {
            infoHelper = new InfoH(str);
        } else {
            setInfo();
        }
    }
    //
    @Override
    public abstract void setLanguage();
    //
    @Override
    public abstract void setKey();
    //
    @Override
    public abstract void getResult();
    //
    private static boolean code_decode()
    {
        System.out.println("What would you like to do?");
        System.out.println("1. To code");
        System.out.println("2. To decode");
        Scanner input = new Scanner(System.in);
        int chosenNumber;
        //
        if (input.hasNextInt() && isValid_codeDecode(chosenNumber = input.nextInt()))
        {
            return chosenNumber == CODE;
        }
        else {
            return code_decode();
        }
    }

    // проверка, находится ли введенное значение в пределах количества доступных вариантов
    private static boolean isValid_codeDecode(int number)
    {
        return number == CODE || number == DECODE;
    }
    //
    protected void printResult(String str)
    {
        System.out.println(str);
    }
}
