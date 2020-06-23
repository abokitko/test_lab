package com.solvd.lab.automation.formatter.util.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQL {
    private static final String user = "root";
    private static final String url = "jdbc:mysql://localhost:3306/formatter?useUnicode=true&serverTimezone=UTC";
    private static final String password = "12345";

    private static Connection con;
    private static Statement stmt;

    public SQL() {
    }

    private static void executeQuery(String query) {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            System.out.println(query);
            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch (SQLException se) { }
            try { stmt.close(); } catch (SQLException se) { }
        }
    }

    public static void insertLicense(String type, String agreement) {
        try {
            createLicenseTableIfNotExists();
            String query = String.format("INSERT INTO license (type, agreement) VALUES (\"%s\", \"%s\");",
                    type, agreement);
            executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createLicenseTableIfNotExists() {
        String query = "CREATE TABLE IF NOT EXISTS license"
                + "  (id         INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "   type       varchar(40),"
                + "   agreement        varchar(140));";

        executeQuery(query);
    }

    public static void insertFile(String filename, String filetype, String username, int lincenseID) {
        try {
            createFileTableIfNotExists();
            String query = String.format("INSERT INTO file (filename, filetype, user, license_id) VALUES (\"%s\", \"%s\", \"%s\", %d);",
                    filename, filetype, username, lincenseID);
            executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createFileTableIfNotExists() {
        String query = "CREATE TABLE IF NOT EXISTS file"
                + "  (id         INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "   filename       varchar(40),"
                + "   filetype        varchar(40),"
                + "   license_id     INTEGER,"
                + "   user     varchar(40),"
                + "   FOREIGN KEY (license_id) REFERENCES  license(id));";
        executeQuery(query);
    }


}
