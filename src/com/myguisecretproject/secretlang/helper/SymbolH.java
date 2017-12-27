package com.myguisecretproject.secretlang.helper;

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

    private void setPosition(int position) {
        this.position = position;
    }
}
