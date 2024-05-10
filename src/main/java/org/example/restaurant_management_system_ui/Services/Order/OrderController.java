package org.example.restaurant_management_system_ui.Services.Order;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class OrderController {

    public Button makeOrder;
    public Button changeOrder;
    public ImageView returnImage;
    public Text returnText;
    public AnchorPane changeorder;

    public void hide1( ) {
        returnText.setText("");
    }

    public void show1( ) {
        returnText.setText("Return");
    }

    public void press( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void makeOrderPress( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addOrder.fxml"));
        Scene addOrderScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(addOrderScene);
    }

    public void changeOrderPress( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("modifyOrder.fxml"));
        Scene modifyOrderScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(modifyOrderScene);
    }
}

