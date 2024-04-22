package org.example.restaurant_management_system_ui.Services.Reservation;

import Human.Manager;
import Services.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    public Text showMessageToUser;
    public TextField cancelReservationIDInput;

    public void pressCancelReservation(ActionEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnCancelReservation.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void showCancelReservation(MouseEvent mouseEvent) {
        textCancelReservation.setText("Return to reservation page");
    }

    public void hideCancelReservation(MouseEvent mouseEvent) {
        textCancelReservation.setText("");
    }


    public void clickCancelReservation( ) {
        try {
            int reservationId=(Integer.parseInt(cancelReservationIDInput.getText()));
            int i;
            for( i=0;i< Reservation.getReservations().size();i++)
            {
                if(reservationId==Reservation.getReservations().get(i).getReservationId())
                    break;
            }
            if(i==Reservation.getReservations().size())
            {
            showMessageToUser.setText("No such id matches an existing reservation");
            showMessageToUser.setVisible(true);
            }
            else{
                Reservation.cancelReservation(Integer.parseInt(cancelReservationIDInput.getText()));
                showMessageToUser.setText("Reservation cancelled :(");
                showMessageToUser.setVisible(true);
            }
        } catch (IllegalArgumentException ex) {
            showMessageToUser.setText("Invalid input: Input type must be integer");
            showMessageToUser.setVisible(true);
            throw new IllegalArgumentException("Invalid input: Input type must be an integer");
        }
    }

}