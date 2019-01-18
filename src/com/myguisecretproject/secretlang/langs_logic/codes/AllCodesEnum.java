package com.myguisecretproject.secretlang.langs_logic.codes;

import com.myguisecretproject.secretlang.langs_logic.codes.caesar.Caesar;
import com.myguisecretproject.secretlang.langs_logic.codes.simple.Simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum AllCodesEnum {
    CAESAR_CODE     (AllCodesInfo.caesar_name, AllCodesInfo.caesar_description, AllCodesInfo.caesar_key_path),
    SIMPLE_CODE     (AllCodesInfo.simple_name, AllCodesInfo.simple_description, AllCodesInfo.simple_key_path),
    EXAMPLE_CODE    (AllCodesInfo.example_name, AllCodesInfo.example_description, AllCodesInfo.example_key_path);

    private String codeName;
    private String codeDescription;
    private String resPath;

    AllCodesEnum (String codeName, String codeDescription, String resPath) {
        this.codeName = codeName;
        this.codeDescription = codeDescription;
        this.resPath = resPath;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getCodeDescription() {
        return codeDescription;
    }

    public String getResPath() {
        return resPath;
    }

    public static List<String> getEnumsList() {
        List<String> codesList = new ArrayList<>();
        for (int i = 0; i < AllCodesEnum.values().length; ++i) {
            codesList.add(AllCodesEnum.values()[i].name());
        }
        return codesList;
    }
}
