package com.myguisecretproject.secretlang.codes.simple;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Simple_controller implements Initializable
{
    private Stage dialogStage;
    private boolean isOkay = false;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void setDialogStage(Stage dialogStage)
    {
        this.dialogStage = dialogStage;
    }

    public boolean isKeySettled()
    {
        return isOkay;
    }

}