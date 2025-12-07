package com.oas.sdproject.duckui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oas.sdproject.duckui.utils.Constants;
import com.oas.sdproject.duckui.utils.TextUtilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

    private final HttpClient httpClient = HttpClient.newHttpClient();

    protected ImageView getIcon() {
        return duckIcon;
    }

    @FXML
    public void onRegisterButtonClicked(ActionEvent actionEvent) throws IOException, InterruptedException {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmedPassword = confirmPasswordField.getText();
        if (!(password.equals(confirmedPassword))) {
            showAlert(
                    "Registration Error",
                    "Passwords do not match",
                    "Please re-enter your password."
            );

            // Clear the fields so user can re-enter
            passwordField.clear();
            confirmPasswordField.clear();
            return; // stop further processing
        }

        if (!TextUtilities.isValidEmailFormat(email)) {
            showAlert(
                    "Registration Error",
                    "Email is in incorrect format",
                    "Please recheck for any error in the email and try again."
            );
            return;
        }

        // register
        UserPost userPost = new UserPost(firstName, lastName, email, password);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(userPost);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.BASE_URL + "/auth/register"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            switchToDashboardScene(actionEvent);
        } else {
            showAlert(
                    "Error during registration",
                    "Could not complete registration process",
                    "Please check the details and try again"
                    );
        }
    }

    public void switchToDashboardScene(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard-view.fxml")));
        Scene scene2 = new Scene(scene2Parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
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

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private static final class UserPost {
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public UserPost() {}

        public UserPost(String firstName, String lastName, String email, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
