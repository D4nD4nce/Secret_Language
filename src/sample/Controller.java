package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML public Button testBut;
    @FXML public Label helloWorld;
    @FXML public ListView<String> list;

    public Controller()
    {

    }

    public void sayHelloWorld(ActionEvent actionEvent)
    {
        helloWorld.setText("Hello World!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> items = FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App");
        list.setItems(items);
    }
}
