package com.oas.sdproject.duckui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LoginController {
    @javafx.fxml.FXML
    private ImageView icon;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private Button loginButton;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Hyperlink registrationHyperlink;

    protected ImageView getIcon() {
        return icon;
    }

    @javafx.fxml.FXML
    public void onLoginButtonClicked(ActionEvent actionEvent) {
        String email = emailField.getText();
        String password = passwordField.getText();
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        try {
            switchToDashboardScene(actionEvent);
        }
        catch (IOException e) {
            System.out.println("Couldn't load dashboard");
        }
    }

    @javafx.fxml.FXML
    public void onRegistrationLinkClicked(ActionEvent actionEvent) {
        try {
            switchToRegistrationScene(actionEvent);
        } catch (IOException e) {
            System.out.println("Couldn't load registration");
        }
    }

    public void switchToRegistrationScene(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registration-view.fxml")));
        Scene scene2 = new Scene(scene2Parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    public void switchToDashboardScene(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard-view.fxml")));
        Scene scene2 = new Scene(scene2Parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
}
