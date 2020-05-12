package com.solvd.lab.automation.formatter.util;

import com.solvd.lab.automation.formatter.Formatter;

public class TabUtil {

    public static String normalizeTabs(String input) {

        String newInput = "";
        String tab = "";


        for(int i = 0; i < input.length(); i++){

            newInput += input.charAt(i);

            if(input.charAt(i) == '{') {
                tab += "\t";
                newInput += tab;
            }
            else if (input.charAt(i) == ';'){
                newInput += tab;
            }

            else if(input.charAt(i) == '}'){
                tab = (String) tab.subSequence(0,tab.length() - 1);
                newInput += tab;
            }

        }
        return newInput;
    }
}
