package org.example.restaurant_management_system_ui.Services.Order;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class OrderController {
    public ImageView returnImage1;
    public Text returnText1;
    public Button makeOrder;

    public void hide1(MouseEvent event) {
    }

    public void show1(MouseEvent event) {
    }

    public void press(MouseEvent event) {
    }

    public void makeOrderPress(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addOrder.fxml"));
        Scene addOrderScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnImage1.getScene().getWindow();
        mainStage.setScene(addOrderScene);
    }
}
