package com.myguisecretproject.secretlang.helper;

import com.myguisecretproject.secretlang.codes.AllCodesEnum;
import com.myguisecretproject.secretlang.codes.Code;
import com.myguisecretproject.secretlang.codes.caesar.Caesar_code;
import com.myguisecretproject.secretlang.codes.caesar.Caesar_decode;
import com.myguisecretproject.secretlang.codes.simple.Simple;
import com.myguisecretproject.secretlang.codes.simple.Simple_code;
import com.myguisecretproject.secretlang.codes.simple.Simple_decode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_Fabric
{
    private Code code;
    //private Map<Integer, Code> codeMap;

    public Code_Fabric(AllCodesEnum c, boolean decode)
    {
        if (decode)
        {
            switch (c)
            {
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
            switch (c)
            {
                case CAESAR_CODE:
                    code = new Caesar_decode();
                    break;
                case EXAMPLE_CODE:
                    code = new Simple_decode();
                    break;
                case SIMPLE_CODE:
                    break;
            }
        }
    }

    public Code getCode()
    {
        return code;
    }
}
