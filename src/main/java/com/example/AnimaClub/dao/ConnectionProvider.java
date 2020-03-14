package com.example.AnimaClub.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private final static String URL = "jdbc:postgresql://localhost:5432/animaclub";
    private final static String USER = "postgres";
    private final static String PASSWORD = "lpsselcelc";
    private static Connection connection;

    public static Connection provide() throws SQLException{
        if (connection == null){
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connexion effective");
        }
        return connection;
    }
}
