package com.oas.sdproject.duckui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegistrationController {
    @javafx.fxml.FXML
    private ImageView duckIcon;
    @javafx.fxml.FXML
    private TextField firstNameField;
    @javafx.fxml.FXML
    private TextField lastNameField;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private PasswordField confirmPasswordField;
    @javafx.fxml.FXML
    private Button registerButton;
    @javafx.fxml.FXML
    private Button backButton;

    protected ImageView getIcon() {
        return duckIcon;
    }

    @javafx.fxml.FXML
    public void onRegisterButtonClicked(ActionEvent actionEvent) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmedPassword = confirmPasswordField.getText();
        if (!(password.equals(confirmedPassword))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration Error");
            alert.setHeaderText("Passwords do not match");
            alert.setContentText("Please re-enter your password.");
            alert.showAndWait();

            // Clear the fields so user can re-enter
            passwordField.clear();
            confirmPasswordField.clear();
            return; // stop further processing
        }

        try {
            switchToLoginScene(actionEvent);
        } catch (IOException e) {
            System.out.println("Couldn't load login");
        }

        System.out.println("Name: " + firstName + " " +lastName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    @javafx.fxml.FXML
    public void onBackButtonClicked(ActionEvent actionEvent) {
        try {
            switchToLoginScene(actionEvent);
        } catch (IOException e) {
            System.out.println("Couldn't load login");
        }
    }

    public void switchToLoginScene(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        Scene scene2 = new Scene(scene2Parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
}
