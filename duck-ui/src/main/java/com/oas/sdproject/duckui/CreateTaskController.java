package com.oas.sdproject.duckui;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CreateTaskController {

    @javafx.fxml.FXML
    private Label addLabel;
    @javafx.fxml.FXML
    private ImageView duckIcon;
    @javafx.fxml.FXML
    private TextField taskTitle;
    @javafx.fxml.FXML
    private TextArea taskDesc;

    @javafx.fxml.FXML
    private ChoiceBox<String> priorityChoiceBox;

    @javafx.fxml.FXML
    private DatePicker dueDatePicker;

    @javafx.fxml.FXML
    private Button addTaskButton;

    @javafx.fxml.FXML
    private Button cancelButton;

    protected javafx.scene.image.ImageView getIcon() {
        return duckIcon;
    }

    public void initialize() {
        // Populate with items
        priorityChoiceBox.getItems().addAll("Low", "Medium", "High");
    }




    @javafx.fxml.FXML
    public void onCancelButtonClicked(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
        catch (Exception e) {
            System.out.println("b");
        }

    }
}
