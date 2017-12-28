package com.myguisecretproject.secretlang.codes.caesar;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Caesar_controller implements Initializable
{

    private Stage dialogStage;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
