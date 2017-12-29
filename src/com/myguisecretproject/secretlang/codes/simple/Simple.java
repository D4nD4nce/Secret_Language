package com.myguisecretproject.secretlang.codes.simple;

import com.myguisecretproject.secretlang.alphabets.Language;
import com.myguisecretproject.secretlang.codes.Code;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public abstract class Simple extends Code
{
    private final String resPath =
            "";
    //
    private final String code_description =
            "Простейший шифр: каждый символ введенного текста заменяется на цифру в соответствии с ее местов в алфавите." +
                    "Далее цифры 0-9 шифруются любыми буквами, и подставляются вместо введенного текста.";
    //
    private final boolean singleLanguage = true;
    //
    protected Language currentLanguage;
    protected int key;

    @Override
    public void setLanguage() {

    }

    @Override
    public void getResult() {

    }

    @Override
    public String getCodeDescription() {
        return code_description;
    }

    @Override
    public String getResPath() {
        return resPath;
    }

    @Override
    public boolean setKey(Stage dialogStage, FXMLLoader loader) {

        Simple_controller controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
        return controller.isKeySettled();
    }
}
