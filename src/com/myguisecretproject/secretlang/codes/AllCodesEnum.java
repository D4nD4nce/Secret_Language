package com.myguisecretproject.secretlang.codes;

import java.util.ArrayList;
import java.util.List;

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




}
