package com.myguisecretproject.secretlang.langs_logic.helper;

public class SymbolH
{
    private char symbol;
    private int position;

    public SymbolH(char cSymbol, int nPosition) {
        this.symbol = cSymbol;
        this.position = nPosition;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol, int position) {
        this.symbol = symbol;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    // private method, position can't be changed after creating object
    private void setPosition(int position) {
        this.position = position;
    }
}
