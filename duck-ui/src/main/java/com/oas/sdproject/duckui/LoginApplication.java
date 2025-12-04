package com.oas.sdproject.duckui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;

public class LoginApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        super.init();
        applicationContext = new SpringApplicationBuilder(DuckUiApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        applicationContext.publishEvent(new StageReadyEvent(stage));

        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login-view.fxml"));
        Parent root = fxmlLoader.load();

        LoginController controller = fxmlLoader.getController();

        // add rounded corners to the icon
        ImageView iconImage = controller.getIcon();
        final int iconEdgeSize = 160;
        iconImage.setFitWidth(iconEdgeSize);
        iconImage.setFitHeight(iconEdgeSize);
        Rectangle clip = new Rectangle(iconEdgeSize, iconEdgeSize);
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        iconImage.setClip(clip);

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/images/ic_duck.png")));
        Scene scene = new Scene(root, 400, 600);
        //stage.setTitle("Login");
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}
