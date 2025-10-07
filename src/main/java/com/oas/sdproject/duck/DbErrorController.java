package com.oas.sdproject.duck;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DbErrorController {
    @FXML
    private Label errorText;
    @FXML
    private Button closeButton;

    public Label getErrorText() {
        return errorText;
    }

    @FXML
    protected void onHelloButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
