package com.prog3.WalletTd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    private static Connection connection;

    private DatabaseConfiguration() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/gestion_portefeuille",
                    System.getenv("DBUSER"),
                    System.getenv("PASSWORD")
            );
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new DatabaseConfiguration();
            System.out.println("ok");
        }
        return connection;
    }

    public static void main(String[] args) {
      Connection connection1=DatabaseConfiguration.getConnection();
    }
}
