package com.myguisecretproject.secretlang.main;

import com.myguisecretproject.secretlang.langs_logic.codes.AllCodesInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 *
 * 1. Set kind of code
 * 2. Set input/output langugages
 * 3. Set input text
 * 4. Set key
 *
 *
 * unique:
 * 1. code class
 * 2. key
 * 3. fxml for key
 * 4. controller for fxml
 * 5. enum
 *
 */

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(AllCodesInfo.main_win_path));
        primaryStage.setTitle("General frame");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
