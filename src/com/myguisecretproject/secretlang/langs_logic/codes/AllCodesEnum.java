package com.myguisecretproject.secretlang.langs_logic.codes;

import com.myguisecretproject.secretlang.langs_logic.codes.caesar.Caesar;
import com.myguisecretproject.secretlang.langs_logic.codes.simple.Simple;

import java.util.List;

public enum AllCodesEnum
{
    CAESAR_CODE,
    SIMPLE_CODE,
    EXAMPLE_CODE;

    public static void getCodesList(List<String> codesList)
    {
        for (int i = 0; i < AllCodesEnum.values().length; ++i)
        {
            codesList.add(AllCodesEnum.values()[i].name());
        }
    }
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
                return Caesar.code_name;
            case SIMPLE_CODE:
                return Simple.code_name;
            case EXAMPLE_CODE:
                return AllCodesEnum.Example_code_name;
        }
        //
        return null;
    }
}
