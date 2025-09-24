module com.oas.sdproject.duck {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot.autoconfigure;


    opens com.oas.sdproject.duck to javafx.fxml;
    exports com.oas.sdproject.duck;
}