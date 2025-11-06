module com.oas.sdproject.duckui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oas.sdproject.duckui to javafx.fxml;
    exports com.oas.sdproject.duckui;
}