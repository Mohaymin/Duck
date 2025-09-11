module com.oas.sdproject.duck {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oas.sdproject.duck to javafx.fxml;
    exports com.oas.sdproject.duck;
}