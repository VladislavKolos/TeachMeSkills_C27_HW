package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresUtil {
    private static final String URL = "jdbc:postgresql://localhost:5051/TMS_C27";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgresql";
    private static PostgresUtil instance;

    private PostgresUtil() {
        init();
    }

    public static PostgresUtil getInstance() {
        if (instance == null) {
            instance = new PostgresUtil();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private void init() {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Exception loading driver...");
        }
    }
}

