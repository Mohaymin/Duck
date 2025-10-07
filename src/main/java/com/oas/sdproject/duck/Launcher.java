package com.oas.sdproject.duck;

import com.oas.sdproject.duck.constants.DbConnection;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        System.out.println("Preparing to start the database");

        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=" + DbConnection.DATABASE_NAME + ";" +
                "user=" + DbConnection.USERNAME + ";" +
                "password=" + DbConnection.PASSWORD + ";" +
                "encrypt=true;" +
                "trustServerCertificate=true;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
            System.out.println("((((((((((((((((((())))))))))))))))))");
            System.out.println("Connection seems to be successful");
            System.out.println("((((((((((((((((((())))))))))))))))))");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
            Application.launch(DbErrorApplication.class, e.getMessage());
        }

    }
}
