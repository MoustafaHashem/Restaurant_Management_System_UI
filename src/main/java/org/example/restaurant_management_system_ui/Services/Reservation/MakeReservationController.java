package org.example.restaurant_management_system_ui.Services.Reservation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class MakeReservationController {

    //set error text to (Your Reservation ID is: **) when there is no error


    public ImageView returnMakeReservation;

    public Text textMakeReservation;


    public void pressMakeReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnMakeReservation.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void showMakeReservation(MouseEvent mouseEvent) {
        textMakeReservation.setText("Return to reservation page");
    }

    public void hideMakeReservation(MouseEvent mouseEvent) {
        textMakeReservation.setText("");
    }

}
