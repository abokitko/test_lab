package com.solvd.lab.automation.formatter.util;

public class BraceUtil {
    public static String normalizeSharpBraces(String input) {

        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                input = input.subSequence(0, i + 1) + "\n" + input.subSequence(i + 1, input.length());
            }
        }

        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '}') {
                input = input.subSequence(0, i + 1) + "\n" + input.subSequence(i + 1, input.length());
            }
        }


        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')' && input.charAt(i + 1) == '{') {
                input = input.subSequence(0, i + 1) + " " + input.subSequence(i + 1, input.length());
            }
        }

       return input;
    }
}
