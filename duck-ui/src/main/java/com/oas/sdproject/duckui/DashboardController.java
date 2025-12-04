package com.oas.sdproject.duckui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardController {

    @javafx.fxml.FXML
    private ImageView icon;

    @javafx.fxml.FXML
    private Button createTaskButton;

    protected ImageView getIcon() {
        return icon;
    }

    @javafx.fxml.FXML
    public void onCreateTaskButtonClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("create-task-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("Create New Task");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error creating new task");
        }
    }

    @javafx.fxml.FXML
    public void onLogOutButtonClicked(ActionEvent actionEvent) {
        try {
            switchToLoginScene(actionEvent);
        } catch (IOException e) {
            System.out.println("Couldn't log out");
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
