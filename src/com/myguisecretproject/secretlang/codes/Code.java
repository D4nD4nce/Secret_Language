package com.myguisecretproject.secretlang.codes;

import com.myguisecretproject.secretlang.helper.InfoH;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public abstract class Code
{
    protected InfoH infoHelper;

//    @Override
//    public void setInfo()
//    {
//        setLanguage();
//        System.out.println("Write your text");
//        Scanner input = new Scanner(System.in);
//        String str;
//
//        if (input.hasNextLine() && !(str = input.nextLine()).isEmpty())
//        {
//            infoHelper = new InfoH(str);
//        } else {
//            setInfo();
//        }
//    }

    //
    public abstract void setLanguage();
    //
    public abstract void getResult();
    //
    public abstract void getCodeName();
    //
    public abstract void getCodeDescription();
    //
    public abstract String getResPath();
    //
    public abstract void setKey(Stage dialogStage, FXMLLoader loader);


//    //
//    private static boolean code_decode()
//    {
//        System.out.println("What would you like to do?");
//        System.out.println("1. To code");
//        System.out.println("2. To decode");
//        Scanner input = new Scanner(System.in);
//        int chosenNumber;
//        //
//        if (input.hasNextInt() && isValid_codeDecode(chosenNumber = input.nextInt()))
//        {
//            return chosenNumber == CODE;
//        }
//        else {
//            return code_decode();
//        }
//    }
//
//    // проверка, находится ли введенное значение в пределах количества доступных вариантов
//    private static boolean isValid_codeDecode(int number)
//    {
//        return number == CODE || number == DECODE;
//    }
//    //
//    protected void printResult(String str)
//    {
//        System.out.println(str);
//    }
}
