package com.solvd.lab.automation.formatter.util;

public class StatementUtil {
    public static String normalizeIfs(String input) {

        if (input.contains("if(")){
            input = input.replace("if(", "if (");
        }

        return input;
    }

    public static String normalizeFors(String input) {

        if (input.contains("for(")){
            input = input.replace("for(", "for" + " " + "(");
        }

        return input;
    }

    public static String normalizeSemicolons(String input) {
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ';') {
                input = input.subSequence(0, i + 1) + "\n" + input.subSequence(i + 1, input.length());
            }
        }
        return input;
    }
}
