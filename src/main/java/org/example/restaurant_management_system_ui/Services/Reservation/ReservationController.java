package org.example.restaurant_management_system_ui.Services.Reservation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class ReservationController {
    public Text reservationText;
    public ImageView returnMakeReservation;
    public Button makeReservationButton;

    public void showMakeReservation(MouseEvent event) {
        reservationText.setText("Return to main page");
    }

    public void hideMakeReservation(MouseEvent event) {
        reservationText.setText("");
    }

    public void pressMakeReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("start.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnMakeReservation.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }
}
