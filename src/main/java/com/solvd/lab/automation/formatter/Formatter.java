package com.solvd.lab.automation.formatter;

import com.solvd.lab.automation.formatter.util.*;
import com.solvd.lab.automation.formatter.util.SQL.SQL;

public class Formatter {
    public static void main(String[] args) {
        String fileName = "file.pdf";
        String fileType = "pdf";
        String input = "public class NoSuchTransport extends Exception{public NoSuchTransport(String message) {super(message);if(aaa){aaa+b=5;return b;}}}";
        String userName = "Anastasiya";
        int licenseID = 1;

        String[] licenses = {"gnu", "apache"};
        String agreement = "some agreement for license";

        for (String license : licenses) {
            SQL.insertLicense(license, agreement);
        }
        SQL.insertFile(fileName, fileType, userName, licenseID);
        input = TabUtil.normalizeTabs(input);
        input = BraceUtil.normalizeSharpBraces(input);
        input = StatementUtil.normalizeIfs(input);
        input = StatementUtil.normalizeFors(input);
        input = OperatorUtil.normalizePlus(input);
        input = OperatorUtil.normalizeMinus(input);
        input = OperatorUtil.normalizeMultiply(input);
        input = OperatorUtil.normalizeDivide(input);
        input = OperatorUtil.normalizeEq(input);
        input = SpaceUtil.normalizeSpaces(input);
        input = StatementUtil.normalizeSemicolons(input);

        System.out.println(input);

    }
}
