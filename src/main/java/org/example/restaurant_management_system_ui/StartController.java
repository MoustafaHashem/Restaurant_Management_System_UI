package org.example.restaurant_management_system_ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

@FXML
    public ImageView start;
    public ImageView staff;

    public void click() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene sceneServices = new Scene(fxmlLoader2.load(), 1280, 720);
        Stage mainStage=(Stage)start.getScene().getWindow();
        mainStage.setScene(sceneServices);
    }

    public void clickStaff() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(MainApplication.class.getResource("staff.fxml"));
        Scene sceneServices = new Scene(fxmlLoader2.load(), 1280, 720);
        Stage mainStage=(Stage)start.getScene().getWindow();
        mainStage.setScene(sceneServices);
    }
}