package com.nc.matsoft;

import com.nc.matsoft.database.DBConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) throws SQLException {

        try {
            LogManager.getLogManager().readConfiguration(
                    DBConnection.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        Locale.setDefault(Locale.ENGLISH);

        DBConnection dbConnection = new DBConnection();
        ResultSet queryResult = dbConnection.getResult("SELECT * FROM Twins");
        while (queryResult.next()) {
            System.out.println(queryResult.getString(2) + " " + queryResult.getString(3)+
                    " performed by " + queryResult.getString(4));
        }
        queryResult.close();
        dbConnection.close();
    }
}