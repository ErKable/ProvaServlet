package org.example.ConnessioneDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB {

    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USERNAME = System.getenv("USERNAME");
    private static final String PASSWORD = System.getenv("PASSWORD");
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver MySQL Caricati");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Errore nel caricamento del driver JDBC", e);
        }
    }
    //costruttore privato
    private ConnessioneDB(){};

    //metodo getInstance
    public static Connection getConnection() throws SQLException {
        if(connection == null)
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}
