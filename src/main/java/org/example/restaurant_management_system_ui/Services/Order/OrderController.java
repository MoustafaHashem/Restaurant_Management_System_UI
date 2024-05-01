package org.example.restaurant_management_system_ui.Services.Order;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    public void hide1(MouseEvent event) {
        returnText.setText("");
    }

    public void show1(MouseEvent event) {
        returnText.setText("Return");
    }

    public void press(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void makeOrderPress(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addOrder.fxml"));
        Scene addOrderScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(addOrderScene);
    }

    public void changeOrderPress(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("modifyOrder.fxml"));
        Scene modifyOrderScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(modifyOrderScene);
    }
}

