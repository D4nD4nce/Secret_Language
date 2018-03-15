package com.myguisecretproject.secretlang.langs_logic.codes.caesar;

import com.myguisecretproject.secretlang.langs_logic.alphabets.Language;
import com.myguisecretproject.secretlang.langs_logic.codes.Code;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public abstract class Caesar extends Code
{
    public static final String code_name =
            "Шифр Цезаря";
    //
    private final String code_description =
            "Код, который якобы был придуман и использовался еще самим Юлием Цезарем:" +
                    "при переводе текста символы сдвигаются в соответствии с выбранным алфавитом";
    //
    private final String resPath =
            "../resources/set_key.fxml";
    //

    //

    //
    private final boolean singleLanguage = true;
    //
    protected Language currentLanguage;
    protected int key;

    @Override
    public void setLanguage() {

    }

    @Override
    public void getResult() {

    }

    @Override
    public String getCodeDescription() {
        return code_description;
    }

    @Override
    public String getResPath() {
        return resPath;
    }

    @Override
    public boolean setKey(Stage dialogStage, FXMLLoader loader)
    {
        Caesar_controller controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
        return controller.isKeySettled();
    }

    @Override
    public boolean isSingleLang() {
        return singleLanguage;
    }
}
