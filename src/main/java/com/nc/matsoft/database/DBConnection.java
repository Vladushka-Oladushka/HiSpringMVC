package com.nc.matsoft.database;

import com.nc.matsoft.exception.NullConnectionException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    static private Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    private Connection connection;
    private Statement statement;
    private String url;

    public DBConnection(String url) {
        this.url = url;
    }

    private Connection connect() {
        String user = "oladushka";
        String pwd = "o1234";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Oracle JDBC Driver is not found", e);
        }

        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Connection Failed", e);
        }

        if (connection != null) {
            return connection;
        } else {
            NullConnectionException e = new NullConnectionException("DBConnection.connect()");
            LOGGER.log(Level.SEVERE, "Connection is null", e);
            throw e;
        }
    }

    public ResultSet getResult(String query) {
        ResultSet resultSet = null;
        try {
            statement = connect().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
        return resultSet;
    }

    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }}
