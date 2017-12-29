package com.myguisecretproject.secretlang.codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum AllCodesEnum
{
    CAESAR_CODE, SIMPLE_CODE, EXAMPLE_CODE;

    public static void getCodesList(List<String> codesList)
    {
        for (int i = 0; i < AllCodesEnum.values().length; ++i)
        {
            codesList.add(AllCodesEnum.values()[i].name());
        }
    }

    //public static final int flag_codeName          = 1;
    //public static final int flag_codeDescription   = 2;
    //
    private static final String Caesar_code_name=
            "Шифр Цезаря";
    //
    private static final String Simple_code_name =
            "Шифр простой подстановки";

    //
    private static final String Example_code_name =
            "Тестовый шифр";
    private static final String Example_code_description =
            "Тестовое описание. Данная позиция используется для наполнения и отладки программы";
    //
    public static String getCodeValue(AllCodesEnum enumCode)
    {
        switch (enumCode)
        {
            case CAESAR_CODE:
                return AllCodesEnum.Caesar_code_name;
            case SIMPLE_CODE:
                return AllCodesEnum.Simple_code_name;
            case EXAMPLE_CODE:
                return AllCodesEnum.Example_code_name;
        }
        //
        return null;
    }
}
