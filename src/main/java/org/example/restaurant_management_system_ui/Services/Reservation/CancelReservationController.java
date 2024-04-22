package org.example.restaurant_management_system_ui.Services.Reservation;

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

public class CancelReservationController {
    public ImageView returnCancelReservation;
    public Text textCancelReservation;
    public Button cancelReservation;

    public void pressCancelReservation(ActionEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnCancelReservation.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void showCancelReservation(MouseEvent mouseEvent) {
        textCancelReservation.setText("Return to reservation page");
    }

    public void hideCancelReservation(MouseEvent mouseEvent) {
        textCancelReservation.setText("");
    }


    public void clickCancelReservation(ActionEvent actionEvent) {

    }
}
