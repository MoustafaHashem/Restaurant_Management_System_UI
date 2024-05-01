package org.example.restaurant_management_system_ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    @FXML
    public ImageView start;
    public ImageView staff;
    public Text text;

    public ImageView Customer;

    public void click() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene sceneServices = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) start.getScene().getWindow();
        mainStage.setScene(sceneServices);
    }

    public void clickStaff() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("staff.fxml"));
        Scene sceneStaff = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) start.getScene().getWindow();
        mainStage.setScene(sceneStaff);
    }

    public void show1() {
        text.setText("Staff page");
    }

    public void hide1() {
        text.setText("");
    }
}
