package com.example.rushingtraining.persistence;

import java.sql.*;

public class ConnectionFactory {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public static Connection createConnection() throws SQLException {
        if(connection == null)
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        return connection;
    }

    public static PreparedStatement createPreparedStatement(String sql) {
        try {
            preparedStatement = createConnection().prepareStatement(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
