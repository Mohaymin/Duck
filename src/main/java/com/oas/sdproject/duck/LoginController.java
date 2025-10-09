package com.oas.sdproject.duck;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController {

    @javafx.fxml.FXML
    private ImageView icon;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private Button loginButton;
    @javafx.fxml.FXML
    private PasswordField passwordField;

    protected ImageView getIcon() {
        return icon;
    }

    @javafx.fxml.FXML
    public void onLoginButtonClicked(ActionEvent actionEvent) {
        String email = emailField.getText();
        String password = passwordField.getText();
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
}
