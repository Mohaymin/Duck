package com.oas.sdproject.duck;

import com.oas.sdproject.duck.constants.Dimention;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DbErrorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DbErrorApplication.class.getResource("db-error-view.fxml"));
        Parent root = fxmlLoader.load();

        Parameters parameters = getParameters();
        String parameterValue = parameters.getUnnamed().getFirst();

        String message = parameterValue.isEmpty() ? "Couldn't connect to database" : "Encountered following error while" +
                " connecting to database:\n" + parameterValue;

        DbErrorController controller = fxmlLoader.getController();
        Label errorTextLabel = controller.getErrorText();
        errorTextLabel.setText(message);

        Scene scene = new Scene(root, Dimention.SMALL_WINDOW_WIDTH, Dimention.SMALL_WINDOW_HEIGHT);
        stage.setTitle("Database Error!");
        stage.setScene(scene);
        stage.show();
    }
}
