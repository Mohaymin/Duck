package com.oas.sdproject.duckui;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DuckUiApplication {
    public static void main(String[] args) {
        Application.launch(LoginApplication.class, args);
    }
}
