/*
 *
 * 1. Set kind of code
 * 2. Set input/output langugages
 * 3. Set input text
 * 4. Set key
 *
 */

package com.myguisecretproject.secretlang.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/main_win.fxml"));
        primaryStage.setTitle("First_frame");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
