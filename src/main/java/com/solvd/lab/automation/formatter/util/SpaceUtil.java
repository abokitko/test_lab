package com.solvd.lab.automation.formatter.util;

public class SpaceUtil {
    public static String normalizeSpaces(String input) {

        for(int i = 0; i < input.length(); i++){
            if (Character.isWhitespace(input.charAt(i)) == false && input.charAt(i + 1) == '{') {
                input = input.subSequence(0, i + 1) + " " + input.subSequence(i + 1, input.length());
            }
        }

        return input;
    }
}
