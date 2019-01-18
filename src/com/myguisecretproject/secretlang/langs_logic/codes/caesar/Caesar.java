package com.myguisecretproject.secretlang.langs_logic.codes.caesar;

import com.myguisecretproject.secretlang.langs_logic.alphabets.Language;
import com.myguisecretproject.secretlang.langs_logic.codes.Code;
import com.myguisecretproject.secretlang.langs_logic.codes.CodeAddings;
import com.myguisecretproject.secretlang.langs_logic.codes.KeyConstructor;
import com.myguisecretproject.secretlang.ui.controllers.Caesar_controller;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public abstract class Caesar extends Code
{
    protected int key;

    public Caesar(Language language) {
        super(language);
    }

    @Override
    public void setAdditionalInfo(boolean encode, CodeAddings addings) {

    }

    @Override
    public void setKey(KeyConstructor key) {
        this.key = key.getCaesarKey();
    }

    @Override
    public void getResult() {

    }

    @Override
    public boolean isSingleLang() {
        return true;
    }
}
