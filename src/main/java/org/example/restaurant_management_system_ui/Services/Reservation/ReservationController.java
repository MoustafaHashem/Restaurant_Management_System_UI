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
    public ImageView returnReservation;
    public Button makeReservationButton;
    public Button cancelReservationButton;
    public Button changeReservationButton;

    public void showReservation(MouseEvent event) {
        reservationText.setText("Return to main page");
    }

    public void hideReservation(MouseEvent event) {
        reservationText.setText("");
    }

    public void pressReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("start.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnReservation.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void goToMakeReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("makeReservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)makeReservationButton.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void goToCancelReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("cancelReservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)cancelReservationButton.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void goToChangeReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("changeReservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)changeReservationButton.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }
}
