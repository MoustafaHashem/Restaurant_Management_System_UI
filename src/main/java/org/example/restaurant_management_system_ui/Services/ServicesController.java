package org.example.restaurant_management_system_ui.Services;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class ServicesController {
    public Button reservation;
    public Button order;
    public Button payment;
    public ImageView returnImage;
    public Text returnText;

    public void reservationPress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void orderPress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("order.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void paymentPress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("payment.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void press() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void show1() {
        returnText.setText("Return");
    }

    public void hide1() {
        returnText.setText("");
    }
}
