package com.nc.matsoft.database;

import com.nc.matsoft.exception.NullConnectionException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    static private Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    private Connection connection;
    private Statement statement;

    private Connection connect() {
        String user = "oladushka";
        String pwd = "o1234";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, "Oracle JDBC Driver is not found", e);
        }

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Connection Failed", e);
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
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
        return resultSet;
    }

    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }}
