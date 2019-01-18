package com.myguisecretproject.secretlang.langs_logic.codes;

import com.myguisecretproject.secretlang.langs_logic.alphabets.Language;
import com.myguisecretproject.secretlang.langs_logic.helper.InfoH;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public abstract class Code
{
    protected Language mainLanguage;
    protected InfoH infoHelper;

    public Code (Language mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public abstract void setAdditionalInfo(boolean encode, CodeAddings addings);

    public abstract void setKey(KeyConstructor key);

    public abstract void getResult();

    public abstract boolean isSingleLang();


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
