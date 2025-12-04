package com.oas.sdproject.duckui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InsightsController {
    @javafx.fxml.FXML
    private LineChart<String, Number> completedChart;
    @javafx.fxml.FXML
    private CategoryAxis dateAxis;
    @javafx.fxml.FXML
    private NumberAxis completedAxis;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private BarChart<String, Number> statusChart;
    @javafx.fxml.FXML
    private CategoryAxis statusAxis;
    @javafx.fxml.FXML
    private NumberAxis totalAxis;


    @javafx.fxml.FXML
    private void initialize() {
        Series<String, Number> completionData = new Series<>();
        completionData.setName("Project");
        completionData.getData().add(new XYChart.Data<>("Jan", 15));
        completionData.getData().add(new XYChart.Data<>("Feb", 8));
        completionData.getData().add(new XYChart.Data<>("March", 18));
        completionData.getData().add(new XYChart.Data<>("April", 13));
        completionData.getData().add(new XYChart.Data<>("May", 24));
        completionData.getData().add(new XYChart.Data<>("June", 16));
        completionData.getData().add(new XYChart.Data<>("July", 13));
        completionData.getData().add(new XYChart.Data<>("Aug", 12));
        completionData.getData().add(new XYChart.Data<>("Sept", 15));
        completionData.getData().add(new XYChart.Data<>("Oct", 14));
        completionData.getData().add(new XYChart.Data<>("Nov", 17));
        completionData.getData().add(new XYChart.Data<>("Dec", 4));

        completedChart.getData().add(completionData);

        Series<String, Number> statusData = new Series<>();
        statusData.setName("Project");
        statusData.getData().add(new XYChart.Data<>("To-Do", 15));
        statusData.getData().add(new XYChart.Data<>("In Progress", 8));
        statusData.getData().add(new XYChart.Data<>("Awaiting Review", 18));
        statusData.getData().add(new XYChart.Data<>("Completed", 13));


        statusChart.getData().add(statusData);
    }

    @javafx.fxml.FXML
    public void onBackButtonClicked(ActionEvent actionEvent) {
        try {
            switchToDashboardScene(actionEvent);
        } catch (IOException e) {
            System.out.println("Couldn't load login");
        }
    }

    public void switchToDashboardScene(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard-view.fxml")));
        Scene scene2 = new Scene(scene2Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();

    }
}
