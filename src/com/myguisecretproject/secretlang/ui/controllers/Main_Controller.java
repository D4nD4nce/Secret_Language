/*
 *
 * 1. Set input/output langugages
 * 2. Set kind of code
 * 3. Set input text
 * 4. Set key
 *
 */

package com.myguisecretproject.secretlang.ui.controllers;

import com.myguisecretproject.secretlang.langs_logic.alphabets.AllLanguagesEnum;
import com.myguisecretproject.secretlang.langs_logic.codes.AllCodesEnum;
import com.myguisecretproject.secretlang.langs_logic.codes.Code;
import com.myguisecretproject.secretlang.langs_logic.helper.Code_Fabric;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Main_Controller implements Initializable {

    @FXML public Button testBut;
    @FXML public Button setKey_button;
    @FXML public Label label_test_1;
    @FXML public CheckBox checkBox_isOkKey;
    @FXML public CheckBox checkBox_singleLang;

    @FXML public ListView<String> list_codes;
    @FXML public ListView<String> lang_from;
    @FXML public ListView<String> lang_to;

    @FXML public RadioButton radioBut_toCode;
    @FXML public RadioButton radioBut_toDecode;
    @FXML public TextArea code_description;

    @FXML public VBox languages_box;
    @FXML public TextArea inputText_area;
    @FXML public HBox setKey_box;
    @FXML public HBox down_mainButton_box;

    private boolean bKeyAnswer = false;
    private boolean singleLang = false;

    private List<AllCodesEnum> allCodesEnum;
    private List<String> codesNames;
    private List<String> languages;
    private Code currentCode;
    //public ComboBox checkList;

    // main for checkbox for setting kind of code. others panels depend on it
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        codesNames = new ArrayList<>();
        languages = AllLanguagesEnum.getLanguages();
        allCodesEnum = Arrays.asList(AllCodesEnum.values());
        for (AllCodesEnum enumCode : AllCodesEnum.values()) {
            codesNames.add(enumCode.getCodeName());
        }
        ObservableList<String> items_codeValues = FXCollections.observableArrayList(codesNames);            // set codes names
        list_codes.setItems(items_codeValues);
        items_codeValues = FXCollections.observableArrayList(languages);                                    // set all languages
        lang_from.setItems(items_codeValues);
        updateKeyCheckbox();                                                                                // обновление чекбокса, показывающего, задан ключ для шифра или нет.
        updateTextArea();                                                                                   // обновление панели с текстом описания выбранного шифра
        checkBox_singleLang.setSelected(true);                                                              // чекбокс выбора одного-двух языков объявляется выбранным и неактивным (функция пока не доступна)
        checkBox_singleLang.setDisable(true);
        updateLangs();
        ToggleGroup butGroup = new ToggleGroup();                                                           // создание группы радиобаттонов, в которой выбрать можно только один элемент
        radioBut_toCode.setToggleGroup(butGroup);
        radioBut_toCode.setSelected(true);
        radioBut_toDecode.setToggleGroup(butGroup);
        disableAllFields(true);
    }

    // реакция на выбор текущего шифра
    @FXML
    public void code_chosen(MouseEvent actionEvent) {
        // получение строки с именем текущего класса // debug
        String str = list_codes.getSelectionModel().getSelectedItem();
        label_test_1.setText(str);

        // получение позиции выбранной строки
        int pos = list_codes.getSelectionModel().getSelectedIndex();
        // проверка, находится ли полученное значение позиции внутри заданного предела
        if ((pos < 0) || (pos >= AllCodesEnum.values().length)) return;
        //
        // создание объекта кода в соответствии с выбранной позицией
        currentCode = new Code_Fabric(AllCodesEnum.values()[pos], radioBut_toCode.isSelected()).getCode();
        // вывод описания выбранного шифра в соответствующее поле
        updateTextArea();
        // обновление полей single/multiple languages
        singleLang = currentCode.isSingleLang();
        updateLangs();

        // ряд полей объявляется активными только после выбора шифра
        if (inputText_area.isDisabled())
            disableAllFields(false);
        //
    }

    // нажатие кнопки Set key
    @FXML
    public void openSetKeyWindow(ActionEvent act) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(currentCode.getResPath()));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("set key");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);

            bKeyAnswer = currentCode.setKey(stage, fxmlLoader);
            updateKeyCheckbox();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // выбор чекбокса single/multiple languages
    @FXML
    public void cBoxSingleLang(ActionEvent act) {
//        singleLang = checkBox_singleLang.isSelected();
//        updateLangs();
    }

    // апдейт чекбокса (ключ задан, не задан)
    private void updateKeyCheckbox() {
        checkBox_isOkKey.setSelected(bKeyAnswer);
    }

    // апдейт текста (поле с описанием выбранного шифра)
    private void updateTextArea() {
        if (currentCode != null)
            code_description.setText(currentCode.getCodeDescription());
    }

    // апдейт чекбокса выбора языков
    private void updateLangs() {
        checkBox_singleLang.setSelected(singleLang);
        lang_to.setDisable(singleLang);
    }

    // изменение активности ряда полей (объявляются неактивными до тех пор, пока не будет выбран один из шифров)
    private void disableAllFields(boolean bFlag) {
        languages_box.setDisable(bFlag);
        inputText_area.setDisable(bFlag);
        setKey_box.setDisable(bFlag);
        down_mainButton_box.setDisable(bFlag);
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