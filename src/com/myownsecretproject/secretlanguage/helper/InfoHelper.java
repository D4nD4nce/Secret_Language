package com.myownsecretproject.secretlanguage.helper;

import com.myownsecretproject.secretlanguage.alphabets.languages.Language;

import java.util.LinkedList;
import java.util.List;

public class InfoHelper {
    private Language language;

    private String strOldInfo;
    private String masOldWords[];
    private char masOldLetters[];
    private List<CodeString> lstLetters;

    private CodeString currentSymbol;

    // flags to change letters moving
    //private int letterFlag;
    public static final int FLAG_GET_VALID_LETTER = 100;
    public static final int FLAG_GET_LETTER_NO_CHECK = 101;

    // flags to check result of moving letters
    //private int letterChangedFlag;
    public static final int FLAG_IS_OK_SYMBOL = 10;
    public static final int FLAG_IS_INVALID_SYMBOL = 11;
    public static final int FLAG_IS_LAST_SYMBOL = 12;
    public static final int FLAG_IS_VALID_LETTER_CHANGED = 13;
    public static final int FLAG_IS_VALID_LETTER_SAME = 14;

    // flags to change output
    private int outputFlag;
    public static final int FLAG_OUTPUT_DEFAULT = 0;
    public static final int FLAG_OUTPUT_SPACES = 1;

    public InfoHelper(String string, Language lang, int flags) {
        this.outputFlag = flags;
        this.language = lang;
        this.strOldInfo = string;
        this.masOldWords = string.split(" ");
        this.masOldLetters = string.toCharArray();
        this.lstLetters = new LinkedList<>();
        initialize(this.masOldLetters, this.lstLetters);
        this.currentSymbol = lstLetters.get(0);
    }

    private void initialize(char[] mas, List<CodeString> list)
    {
        for (int i = 0; i < mas.length; i++)
        {
            CodeString l = new CodeString(mas[i], i);
            list.add(i, l);
        }
    }

    public char getCurrentSymbol()
    {
        return currentSymbol.getSymbol();
    }

    public boolean setCurrentSymbol(char c)
    {
        if (!isLetterValid(c))
            return false;
        //
        currentSymbol.setStrCode(String.valueOf(c));
        return true;
    }

    public boolean setCurrentSymbol(String str)
    {
        if (str.trim().isEmpty())
            return false;
        //
        currentSymbol.setStrCode(str);
        return true;
    }

    public int nextLetter(int flags)
    {
        if (isLast(currentSymbol))
            return FLAG_IS_LAST_SYMBOL;
        //
        CodeString oldSymbol = currentSymbol;
        int i = currentSymbol.getPosition();
        CodeString newSymbol;
        //
        switch (flags)
        {
            case FLAG_GET_VALID_LETTER:
                do {
                    i++;
                    newSymbol = lstLetters.get(i);
                    //
                    if (isLast(i))
                        break;
                    //
                } while (!isLetterValid(newSymbol));
                //
                this.currentSymbol = isLetterValid(newSymbol) ? newSymbol : oldSymbol;
                return currentSymbol != oldSymbol ? FLAG_IS_VALID_LETTER_CHANGED : FLAG_IS_VALID_LETTER_SAME;

            case FLAG_GET_LETTER_NO_CHECK:
                i++;
                currentSymbol = lstLetters.get(i);
                return isLetterValid(currentSymbol) ? FLAG_IS_OK_SYMBOL : FLAG_IS_INVALID_SYMBOL;

            default:
                // error
                return 0;
        }
    }

    // return true if the letter was changed to next
    public boolean nextLetter()
    {
        if (isLast(currentSymbol))
            return false;
        //
        CodeString oldLetter = currentSymbol;
        int i = currentSymbol.getPosition();
        CodeString newLetter;

        do {
            i++;
            newLetter = lstLetters.get(i);
            //
            if (isLast(i))
                break;
            //
        } while (!isLetterValid(newLetter));

        this.currentSymbol = isLetterValid(newLetter) ? newLetter : oldLetter;
        return currentSymbol != oldLetter;
    }

    // return true if the letter was changed to previous
    public boolean previousLetter()
    {
        if (isFirst(currentSymbol))
            return false;
        //
        CodeString oldLetter = currentSymbol;
        int i = currentSymbol.getPosition();
        CodeString newLetter;

        do {
            i--;
            newLetter = lstLetters.get(i);
            //
            if (isFirst(i))
                break;
            //
        } while (!isLetterValid(newLetter));

        this.currentSymbol = isLetterValid(newLetter) ? newLetter : oldLetter;
        return currentSymbol != oldLetter;
    }

    public String getResult()
    {
        String result = "Your text: " + strOldInfo + "\n" + "Result: ";
        StringBuilder stringBuilder = new StringBuilder();
        //
        for (int i = 0; i < lstLetters.size(); i++)
        {
            CodeString newCode = lstLetters.get(i);
            //
            if (newCode.isCodeChanged())
            {
                switch (outputFlag)
                {
                    case FLAG_OUTPUT_DEFAULT:
                        stringBuilder.append(newCode.getStrCode());
                        break;
                    case FLAG_OUTPUT_SPACES:
                        stringBuilder.append(newCode.getStrCode());
                        stringBuilder.append(' ');
                        break;
                    default:
                        stringBuilder.append(newCode.getStrCode());
                        break;
                }
            }
            else {
                stringBuilder.append(newCode.getSymbol());
            }
        }
        //
        return result + stringBuilder.toString();
    }

    public boolean isFirst (int n)
    {
        return n == 0;
    }

    private boolean isFirst (CodeString l)
    {
        if (lstLetters.indexOf(l) != l.getPosition())
        {
            System.out.println("Error: InfoHelper: index doesn't match the list (isFirst)");
            return false;
        }

        return isFirst(l.getPosition());
    }

    public boolean isLast (int n)
    {
        return n == lstLetters.size() - 1;
    }

    private boolean isLast (CodeString l)
    {
        if (lstLetters.indexOf(l) != l.getPosition())
        {
            System.out.println("Error: InfoHelper: index doesn't match the list (isLast)");
            return false;
        }

        return isLast(l.getPosition());
    }

    private boolean isLetterValid(char c)
    {
        return language.isValidLetter(c);
    }

    private boolean isLetterValid(CodeString l)
    {
        if (lstLetters.indexOf(l) != l.getPosition())
        {
            System.out.println("Error: InfoHelper: index doesn't match the list (isLetterValid)");
            return false;
        }

        return isLetterValid(l.getSymbol());
    }
}