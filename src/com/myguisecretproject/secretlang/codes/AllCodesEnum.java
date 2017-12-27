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


//    public static AllCodesEnum choose()
//    {
//        System.out.println("1. Caesar_code - coding text by resetting letters with letters from some steps in the same language");
//        System.out.println("2. Simple_code - coding text by table and a key. " +
//                "Table has all numbered letters of the chosen language. You should match numbers 0-9 with another random letters");
//        System.out.println("Choose your code (print number):");
//        Scanner input = new Scanner(System.in);
//        int chosenNumber;
//        //
//        if (input.hasNextInt() && isValidCode(chosenNumber = input.nextInt()))
//        {
//            return AllCodesEnum.values()[chosenNumber - 1];
//        }
//        else {
//            return choose();
//        }
//    }
//    // проверка, находится ли введенное значение в пределах количества доступных вариантов
//    private static boolean isValidCode(int number)
//    {
//        return (1 <= number && number <= AllCodesEnum.values().length);
//    }
}
