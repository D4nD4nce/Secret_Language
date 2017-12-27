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
    public abstract void setLanguage();

    @Override
    public void setKey()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(resPath));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("set key");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
