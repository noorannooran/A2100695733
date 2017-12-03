package com.example.nooran.a2100695733.utilities;

import android.widget.EditText;

/**
 * Created by nooran on 2017-12-02.
 */

public class Validator {
    public Validator() {}

    public static boolean isEmpty(String value)
    {
        value = value.trim();
        if (value.length()== 0)
            return false;
        return true;
    }
    public static boolean isFloat(String value)
    {
        try{
            Float.parseFloat(value);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
    public static boolean isInt(String value)
    {
        try{
            Integer.parseInt(value);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
    public static String stringVal(EditText text)
    {
        return text.getText().toString();
    }
    public static String validString(EditText editText)
    {
        String text = stringVal(editText);
        if(isEmpty(text))
            return "none";
        return text;
    }
    public static float validFloat(EditText editText)
    {
        String text = stringVal(editText);
        if(isEmpty(text))
            return 0f;
        if(isFloat(text))
            return Float.parseFloat(text);
        return 0f;

    }
    public static int validInt(EditText editText)
    {
        String text = stringVal(editText);
        if(isEmpty(text))
            return 0;
        if(isInt(text))
            return Integer.parseInt(text);
        return 0;
    }


}
