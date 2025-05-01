package com.jts.hms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static Connection conn = null;

    // Method to create a new database connection
    public static Connection createConn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection URL
            String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false&serverTimezone=UTC";
            String username = "root"; // Your MySQL username
            String password = "Shanu@0108";     // Your MySQL password (empty in local, or "password" if set)

            // Create connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection created successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to database failed.");
            e.printStackTrace();
        }
        return conn;
    }

    // Method to get existing connection or create a new one if null
    public static Connection getConnection() {
        if (conn == null) {
            conn = createConn();
        }
        return conn;
    }
}
