package com.nc.matsoft;

import com.nc.matsoft.database.DBConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static private Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static String query = "SELECT * FROM Twins";
    public static void main(String[] args) throws SQLException {
        try {
            LogManager.getLogManager().readConfiguration(
                    DBConnection.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString()); //Logger doesn't exist...
        }

        Locale.setDefault(Locale.ENGLISH);
        String user = "oladushka";
        String pwd = "o1234";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        DBConnection dbConnection = new DBConnection(url, user, pwd);
        ResultSet queryResult = dbConnection.getResult(query);
        while (queryResult.next()) {
            String msg = queryResult.getString(2) + " " + queryResult.getString(3)+
                    " performed by " + queryResult.getString(4);
            System.out.println(msg);
            LOGGER.log(Level.INFO, msg);
        }
        queryResult.close();
        dbConnection.close();
    }
}