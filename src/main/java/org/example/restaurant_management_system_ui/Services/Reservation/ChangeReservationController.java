package org.example.restaurant_management_system_ui.Services.Reservation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class ChangeReservationController {
    public ImageView returnChangeReservation;
    public Text textChangeReservation;

    public void pressChangeReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnChangeReservation.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void showChangeReservation(MouseEvent mouseEvent) {
        textChangeReservation.setText("Return to reservation page");
    }

    public void hideChangeReservation(MouseEvent mouseEvent) {
        textChangeReservation.setText("");
    }


}
