package com.myguisecretproject.secretlang.codes.caesar;

import com.myguisecretproject.secretlang.codes.Code;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Caesar extends Code
{
    private String resPath = "../resources/set_Caesar_key.fxml";

    @Override
    public void setLanguage() {

    }

    @Override
    public void getResult() {

    }

    @Override
    public void getCodeName() {

    }

    @Override
    public void getCodeDescription() {

    }

    @Override
    public String getResPath() {
        return resPath;
    }

    @Override
    public void setKey(Stage dialogStage, FXMLLoader loader)
    {
        Caesar_controller controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
        //return code;
    }
}
