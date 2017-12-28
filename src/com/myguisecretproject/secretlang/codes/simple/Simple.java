package com.myguisecretproject.secretlang.codes.simple;

import com.myguisecretproject.secretlang.codes.Code;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public abstract class Simple extends Code
{
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
        return null;
    }

    @Override
    public boolean setKey(Stage dialogStage, FXMLLoader loader) {

        Simple_controller controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
        return controller.isKeySettled();
    }
}
