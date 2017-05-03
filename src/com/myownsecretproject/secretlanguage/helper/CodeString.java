package com.myownsecretproject.secretlanguage.helper;

class CodeString extends SymbolH
{
    private String strCode;

    CodeString(char cSymbol, int nPosition) {
        super(cSymbol, nPosition);
        this.strCode = "";
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public boolean isCodeChanged()
    {
        return !strCode.isEmpty();
    }
}