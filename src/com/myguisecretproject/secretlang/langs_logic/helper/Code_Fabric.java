package com.myguisecretproject.secretlang.langs_logic.helper;

import com.myguisecretproject.secretlang.langs_logic.codes.AllCodesEnum;
import com.myguisecretproject.secretlang.langs_logic.codes.Code;
import com.myguisecretproject.secretlang.langs_logic.codes.caesar.Caesar_code;
import com.myguisecretproject.secretlang.langs_logic.codes.caesar.Caesar_decode;
import com.myguisecretproject.secretlang.langs_logic.codes.simple.Simple_code;
import com.myguisecretproject.secretlang.langs_logic.codes.simple.Simple_decode;

public class Code_Fabric {

    private Code code;
    //private Map<Integer, Code> codeMap;

    public Code_Fabric(AllCodesEnum c, boolean decode) {
        if (decode) {
            switch (c) {
                case CAESAR_CODE:
                    code = new Caesar_code();
                    break;
                case SIMPLE_CODE:
                    code = new Simple_code();
                    break;
                case EXAMPLE_CODE:
                    break;
            }
        } else {
            switch (c) {
                case CAESAR_CODE:
                    code = new Caesar_decode();
                    break;
                case SIMPLE_CODE:
                    code = new Simple_decode();
                    break;
                case EXAMPLE_CODE:
                    break;
            }
        }
    }

    public Code getCode() {
        return code;
    }
}
