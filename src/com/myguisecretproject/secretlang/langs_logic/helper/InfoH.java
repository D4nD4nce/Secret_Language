package com.myguisecretproject.secretlang.langs_logic.helper;

import java.util.LinkedList;
import java.util.List;

public class InfoH
{
    // original input String
    private String inputString;

    // needed to keep coded and decoded symbols
    private List<SymbolH> lstIn;
    private List<SymbolH> lstOut;

    // current workable symbol
    private SymbolH currentSymbol;

    // changeable constructor with flags generally for decoding
    public InfoH(String string)
    {
        this.inputString = string;
        //this.masWords = string.split(" ");
        this.lstIn = new LinkedList<>();
        this.lstOut = new LinkedList<>();
        //
        this.currentSymbol = initialize(string.toCharArray(), lstIn);
    }

    private SymbolH initialize (char[] masLetters, List<SymbolH> lst)
    {
        for (int i = 0; i < masLetters.length; i++)
        {
            SymbolH s = new SymbolH(masLetters[i], i);
            lst.add(i, s);
        }
        //
        return lst.get(0);
    }

    public char getCurrentSymbol()
    {
        return currentSymbol.getSymbol();
    }

    public int getCurrnetPosition()
    {
        return currentSymbol.getPosition();
    }

    public void setCurrentSymbol(char c)
    {
        SymbolH s = new SymbolH(c, lstOut.size());
        lstOut.add(s);
    }

    public void setCurrentSymbol(String str)
    {
        char[] mass = str.toCharArray();
        //
        for(int i = 0; i < mass.length; i++)
        {
            SymbolH s = new SymbolH(mass[i], lstOut.size());
            lstOut.add(s);
        }
    }

    public boolean nextLetter()
    {
        if (isLast(currentSymbol, lstIn))
            return false;
        //
        int i = currentSymbol.getPosition() + 1;
        this.currentSymbol = lstIn.get(i);
        return true;
    }

    public boolean previousLetter()
    {
        if (isFirst(currentSymbol, lstIn))
            return false;
        //
        int i = currentSymbol.getPosition() - 1;
        this.currentSymbol = lstIn.get(i);
        return true;
    }

    public int getInSize()
    {
        return lstIn.size();
    }

    public int getOutSize()
    {
        return lstOut.size();
    }

    private boolean isFirst(SymbolH s, List<SymbolH> lst)
    {
        try {
            //
            if (lst.indexOf(s) != s.getPosition())
                throw new Exception("Error: InfoHelper: index doesn't match the list (isFirst)");
            //
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        return s.getPosition() == 0;
    }

    public boolean isLast(SymbolH s, List<SymbolH> lst)
    {
        try {
            //
            if (lst.indexOf(s) != s.getPosition())
                throw new Exception("Error: InfoHelper: index doesn't match the list (isLast)");
            //
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        return s.getPosition() == lst.size() - 1;
    }

    public String getResult()
    {
        String result = "Your text: " + inputString + "\n" + "Result: ";
        StringBuilder stringBuilder = new StringBuilder();
        //
        for (int i = 0; i < lstOut.size(); i++)
        {
            SymbolH resultSymbol = lstOut.get(i);
            stringBuilder.append(resultSymbol.getSymbol());
        }
        //
        return result + stringBuilder.toString();
    }
}
