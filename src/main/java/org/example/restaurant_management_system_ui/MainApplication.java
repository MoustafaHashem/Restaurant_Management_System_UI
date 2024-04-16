package org.example.restaurant_management_system_ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(startScene);
        stage.show();
        stage.setTitle(" Gusteau’s Restaurant ");
        stage.getIcons().add(new Image(getClass().getResource("/Images/7.png").toExternalForm()));
        stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch();
    }
}