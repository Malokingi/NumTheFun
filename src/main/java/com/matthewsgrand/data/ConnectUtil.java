package com.matthewsgrand.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
    private static final String user = "mwg";
    private static final String password = "password";
    private static final String url = "jdbc:postgresql://localhost:5432/" + user;
    private static Connection con;

    public static synchronized Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url, user, password);
            } catch (final ClassNotFoundException e) {
                System.err.println("Failed to find Class.");
                e.printStackTrace();
            } catch (final SQLException e) {
                System.err.println("Failed something SQL-related in ConnectUtil");
                e.printStackTrace();
                return null;
            }
        }
        return con;
    }
}