package org.example.restaurant_management_system_ui.Services.Reservation;

import Services.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;
import java.time.LocalDate;

public class ChangeReservationController {
    public ImageView returnChangeReservation;
    public Text textChangeReservation;
    public TextField reservationIdInput;
    public DatePicker dateInput;
    public TextField numberOfPeopleInput;
    public Text dateText;
    public Button changeButton;
    public Text showMessageToUser;

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

    public LocalDate getDateInputFromDatePicker() {
        LocalDate date = null;
        dateInput.setOnAction(event -> {
            dateText.setText(dateInput.getValue().toString());
        });
        return LocalDate.parse(dateText.getText());
    }

    public void presschangeButton(ActionEvent actionEvent) {
        try {
            int reservationId=(Integer.parseInt(reservationIdInput.getText()));
            int i;
            for(i=0; i< Reservation.getReservations().size(); i++)
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
                if((getDateInputFromDatePicker().compareTo(LocalDate.now())<0))
                {
                    showMessageToUser.setText("Date desired to change the reservation to must be after current date (not a passed date)");
                    showMessageToUser.setVisible(true);
                }
                else{
                    {
                        Reservation.changeReservation(Integer.parseInt(reservationIdInput.getText()), getDateInputFromDatePicker(), Integer.parseInt(numberOfPeopleInput.getText()));
                        showMessageToUser.setText("Reservation changed successfully");
                        showMessageToUser.setVisible(true);
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            showMessageToUser.setText("Invalid input type");
            showMessageToUser.setVisible(true);
            throw new IllegalArgumentException("Invalid input type");
        }
    }
}
