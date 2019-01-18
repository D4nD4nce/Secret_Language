package com.myguisecretproject.secretlang.langs_logic.codes.simple;

import com.myguisecretproject.secretlang.langs_logic.alphabets.Language;
import com.myguisecretproject.secretlang.langs_logic.codes.Code;
import com.myguisecretproject.secretlang.langs_logic.codes.CodeAddings;
import com.myguisecretproject.secretlang.langs_logic.codes.KeyConstructor;
import com.myguisecretproject.secretlang.ui.controllers.Simple_controller;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public abstract class Simple extends Code
{
    protected int key;

    public Simple(Language mainLanguage) {
        super(mainLanguage);
    }

    @Override
    public void setAdditionalInfo(boolean encode, CodeAddings addings) {

    }

    @Override
    public void setKey(KeyConstructor key) {

    }

    @Override
    public void getResult() {

    }

    @Override
    public boolean isSingleLang() {
        return true;
    }
}
