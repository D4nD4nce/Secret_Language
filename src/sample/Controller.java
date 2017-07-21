package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {
    public Label helloWorld;
    public ListView<String> list;
    public ListView<String> listCheck;

    public Controller()
    {

        ObservableList<String> items = FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App");
        //listCheck.setItems(items);
        listCheck = new ListView<>(items);
        listCheck.setPrefWidth(100);
        listCheck.setPrefHeight(70);
    }

    public void sayHelloWorld(ActionEvent actionEvent)
    {
        helloWorld.setText("Hello World!");
    }

    public void initializeList()
    {
        list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App");
        list.setItems(items);
        list.setPrefWidth(100);
        list.setPrefHeight(70);
    }
}
