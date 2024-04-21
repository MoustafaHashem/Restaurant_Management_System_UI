package org.example.restaurant_management_system_ui;

import Human.Manager;
import Human.Staff;
import Restaurant.Menu;
import Restaurant.MenuItem;
import Restaurant.MenuSection;
import Restaurant.Table;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartController   {

@FXML
    public ImageView start;
    public ImageView staff;
    public Text text;

    public ImageView Customer;

    public void click() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene sceneServices = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)start.getScene().getWindow();
        mainStage.setScene(sceneServices);

    }

    public void clickStaff() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("staff.fxml"));
        Scene sceneStaff = new Scene(fxmlLoader.load(), 1280, 720, Color.TRANSPARENT);
        Stage mainStage=(Stage)start.getScene().getWindow();
        mainStage.setScene(sceneStaff);

    }

    public void show1() {
        text.setText("Staff page");
    }

    public void hide1() {
        text.setText("");
    }





    public void clickCustomer(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)start.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void showCustomer(MouseEvent mouseEvent) {
        text.setText("Customer page");
    }

    public void hideCustomer(MouseEvent mouseEvent) {
        text.setText("");
    }

}
