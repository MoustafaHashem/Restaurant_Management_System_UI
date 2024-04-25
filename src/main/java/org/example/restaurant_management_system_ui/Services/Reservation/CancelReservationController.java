package org.example.restaurant_management_system_ui.Services.Reservation;

import Human.Manager;
import Restaurant.Table;
import Services.Reservation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class CancelReservationController {
    public ImageView returnCancelReservation;
    public Text textCancelReservation;
    public Button cancelReservation;
    public Text showMessageToUser;
    public TextField cancelReservationNameInput;

    public void pressCancelReservation( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnCancelReservation.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void showCancelReservation( ) {
        textCancelReservation.setText("Return");
    }

    public void hideCancelReservation( ) {
        textCancelReservation.setText("");
    }


    public void clickCancelReservation( ) {
        try {
            String reservationName= cancelReservationNameInput.getText();
            int i;
            for(i=0; i< Manager.getTables().size(); i++)
            {


                if(reservationName.compareTo(Manager.getTables().get(i).getCustomer().getName())==0)
                    break;
            }
            if(i==Reservation.getReservations().size())
            {
            showMessageToUser.setText("No such name  matches an existing reservation");
            showMessageToUser.setVisible(true);
            }
            else{
                Reservation.cancelReservation(Manager.getTables().get(i).getTableNum());
                showMessageToUser.setText("Reservation cancelled :(");
                showMessageToUser.setVisible(true);

            }
        } catch (IllegalArgumentException ex) {
            showMessageToUser.setText("Invalid input: Input type must be integer");
            showMessageToUser.setVisible(true);
        }
    }

}