package com.myguisecretproject.secretlang.codes.caesar;

import com.myguisecretproject.secretlang.alphabets.Language;
import com.myguisecretproject.secretlang.codes.Code;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Caesar extends Code
{
    private final String resPath =
            "../resources/set_Caesar_key.fxml";
    //
    private final String code_description =
            "Код, который якобы был придуман и использовался еще самим Юлием Цезарем: при переводе текста символы попарно меняются местами";
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
    public boolean setKey(Stage dialogStage, FXMLLoader loader)
    {
        Caesar_controller controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
        return controller.isKeySettled();
    }
}
