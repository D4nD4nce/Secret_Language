package com.myownsecretproject.secretlanguage;

import com.myownsecretproject.secretlanguage.codes.AllCodesEnum;
import com.myownsecretproject.secretlanguage.codes.Code;

public class General {

    public static void main(String[] args) {

        final String space = "-------------------";
        System.out.println("Welcome, young capt!");
        System.out.println(space);
        AllCodesEnum code = AllCodesEnum.choose();
        System.out.println(space);
        Code codingOperator = null;
        //
        try {
            codingOperator = Code.setCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        if (codingOperator != null) {
            codingOperator.setInfo();
            System.out.println(space);
            codingOperator.setKey();
            System.out.println(space);
            codingOperator.getResult();
        }
    }
}
