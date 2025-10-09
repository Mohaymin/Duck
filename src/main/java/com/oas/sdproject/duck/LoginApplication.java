package com.oas.sdproject.duck;

import com.oas.sdproject.duck.constants.Dimention;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
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
        Scene scene = new Scene(root, Dimention.VERTICAL_WINDOW_WIDTH, Dimention.VERTICAL_WINDOW_HEIGHT);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.show();
    }
}
