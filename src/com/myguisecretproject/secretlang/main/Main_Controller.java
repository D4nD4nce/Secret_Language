/*
 *
 * 1. Set input/output langugages
 * 2. Set kind of code
 * 3. Set input text
 * 4. Set key
 *
 */

package com.myguisecretproject.secretlang.main;

import com.myguisecretproject.secretlang.codes.AllCodesEnum;
import com.myguisecretproject.secretlang.codes.Code;
import com.myguisecretproject.secretlang.helper.Code_Fabric;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Main_Controller implements Initializable
{
    @FXML public Button testBut;
    @FXML public Button setKey_button;
    @FXML public Label label_test_1;
    @FXML public CheckBox checkBox_isOkKey;
    @FXML public ListView<String> list_codes;
    @FXML public ListView<String> lang_from;
    @FXML public ListView<String> lang_to;
    @FXML public  RadioButton radioBut_toCode;
    @FXML public  RadioButton radioBut_toDecode;

    private boolean answer = false;
    //public ComboBox checkList;

    public Main_Controller()
    {}

    // main for checkbox for setting kind of code. others panels depend on it
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        List<String> lst_names = new ArrayList<>();
        List<String> lst_descriptions = new ArrayList<>();

        //HashMap<String,Integer> mapCode_names = new HashMap<>();
        //HashMap<String,Integer> mapCode_descriptions = new HashMap<>();
        int enumCount = AllCodesEnum.values().length;
        //
        for (int b = 0; b < enumCount; ++b)
        {
            AllCodesEnum enumCode = AllCodesEnum.values()[b];
            lst_names.add(AllCodesEnum.getCodeValue(AllCodesEnum.flag_codeName, enumCode));
            //mapCode_names.put(AllCodesEnum.getCodeValue(AllCodesEnum.flag_codeName, enumCode), enumCode.ordinal());
        }
        //
        for (int v = 0; v < enumCount; ++v)
        {
            AllCodesEnum enumCode = AllCodesEnum.values()[v];
            lst_descriptions.add(AllCodesEnum.getCodeValue(AllCodesEnum.flag_codeDescription, enumCode));
            //mapCode_descriptions.put(AllCodesEnum.getCodeValue(AllCodesEnum.flag_codeDescription, enumCode), enumCode.ordinal());
        }
        //
        ObservableList<String> items_codeValues = FXCollections.observableArrayList (lst_names);
        list_codes.setItems(items_codeValues);

        updateKeyCheckbox();
        ToggleGroup butGroup = new ToggleGroup();
        radioBut_toCode.setToggleGroup(butGroup);
        radioBut_toCode.setSelected(true);
        radioBut_toDecode.setToggleGroup(butGroup);
    }

    @FXML
    public void sayHelloWorld(MouseEvent actionEvent)
    {
        String str = list_codes.getSelectionModel().getSelectedItem();
        label_test_1.setText(str);
    }

    @FXML
    public void openSetKeyWindow(ActionEvent act)
    {
        Code makeCode = new Code_Fabric(AllCodesEnum.CAESAR_CODE, true).getCode();
        //
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(makeCode.getResPath()));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("set key");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);

            answer = makeCode.setKey(stage, fxmlLoader);
            updateKeyCheckbox();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateKeyCheckbox()
    {
        checkBox_isOkKey.setSelected(answer);
    }
}



// initialize

//        HashMap<String,Integer> myMap = new HashMap<>();
//        myMap.put("var", 1);
//        myMap.put("this", 2);
//        myMap.put("check", 3);
//          ObservableList<HashMap> items1 = FXCollections.observableArrayList(myMap);
//          checkList.setItems(items);
//          checkList.getItems().setAll(items1);

//        checkList.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>()
//        {
//            @Override public ListCell<Color> call(ListView<Color> p)
//            {
//                return new ListCell<Color>()
//                {
//                    private final Rectangle rectangle;
//                    {
//                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//                        rectangle = new Rectangle(10, 10);
//                    }
//
//                    @Override protected void updateItem(Color item, boolean empty) {
//                        super.updateItem(item, empty);
//
//                        if (item == null || empty) {
//                            setGraphic(null);
//                        } else {
//                            rectangle.setFill(item);
//                            setGraphic(rectangle);
//                        }
//                    }
//                };
//            }
//        });