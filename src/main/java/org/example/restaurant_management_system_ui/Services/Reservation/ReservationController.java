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
    public Button makeReservationButton;
    public Button cancelReservationButton;
    public Button changeReservationButton;
    public ImageView returnImage;
    public Text returnText;

    public void show1(MouseEvent event) {
        returnText.setText("Return");
    }

    public void hide1(MouseEvent event) {
        returnText.setText("");
    }

    public void press(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void goToMakeReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("makeReservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) makeReservationButton.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void goToCancelReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("cancelReservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) cancelReservationButton.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void goToChangeReservation(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("changeReservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) changeReservationButton.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }
}
