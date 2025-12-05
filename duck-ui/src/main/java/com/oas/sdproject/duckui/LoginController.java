package com.oas.sdproject.duckui;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class LoginController {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final String API_BASE_URL = "http://localhost:8080/api/auth";
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

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    protected void handleLoginAction() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
//            messageLabel.setText("Username and password required.");
            System.out.println("Username and password required");
            return;
        }

        try {
            UserPost loginUser = new UserPost(email, password);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(loginUser);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_BASE_URL + "/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
//                messageLabel.setText("Login Successful! Welcome, " + username + ".");
                System.out.println("Login successful! Welcome, " + email + ".");
                // TODO: Load the main CRUD application view here
            } else if (response.statusCode() == 401) {
//                messageLabel.setText("Login Failed: Invalid Credentials.");
                System.out.println("Login Failed: Invalid Credentials.");
            } else {
//                messageLabel.setText("Error: " + response.body());
                System.out.println("Error: " + response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
//            messageLabel.setText("Network Error: Could not connect to API.");
            System.out.println("Network Error: Could not connect to API.");
        }
    }

    class UserPost {
        private String email;
        private String password;

        public UserPost(String email, String password) {
            this.email = email;
            this.password = password;
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
