module com.oas.sdproject.duckui {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires javafx.graphics;
    requires javafx.base;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens com.oas.sdproject.duckui to javafx.fxml;
    exports com.oas.sdproject.duckui;
}