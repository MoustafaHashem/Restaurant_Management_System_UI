package org.example.restaurant_management_system_ui.Services.Reservation;

import Human.Manager;
import Services.Reservation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class ChangeReservationController {
    public TextField reservationNameInput;
    public DatePicker dateInput;
    public TextField numberOfPeopleInput;
    public Text dateText;
    public Button changeButton;
    public Text showMessageToUser;
    public ImageView returnImage;
    public Text returnText;

    public void press( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void show1( ) {
        returnText.setText("Return");
    }

    public void hide1() {
        returnText.setText("");
    }

    public LocalDate getDateInputFromDatePicker() {
        return dateInput.getValue();
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            return false;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isString(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (!((c <= 90 && c >= 65) || (c <= 122 && c >= 97))) {
                return false;
            }
        }
        return true;
    }

    public void presschangeButton() {
        if (Objects.equals(reservationNameInput.getText(), "") || Objects.equals(numberOfPeopleInput.getText(), "") || getDateInputFromDatePicker() == null) {
            showMessageToUser.setText("All fields must be filled first in order to change a reservation");
            showMessageToUser.setVisible(true);
        } else {
            if (!isInteger(numberOfPeopleInput.getText())) {
                showMessageToUser.setText("Invalid input type: input must be a positive integer");
                showMessageToUser.setVisible(true);
            }
            if (!isString(reservationNameInput.getText())) {
                showMessageToUser.setText("Invalid input type: input must be a name (String)");
                showMessageToUser.setVisible(true);
            }
        }
        int i;
        String reservationName = reservationNameInput.getText();
        for (i = 0; i < Manager.getTables().size(); i++) {
            if (reservationName.compareToIgnoreCase(Manager.getTables().get(i).getCustomer().getName()) == 0)
                break;
        }


        if (i == Manager.getTables().size()) {
            showMessageToUser.setText("No such name matches an existing reservation");
            showMessageToUser.setVisible(true);
        } else {
            if ((getDateInputFromDatePicker().compareTo(LocalDate.now()) < 0)) {
                showMessageToUser.setText("Date desired to change the reservation to must be after current date (not a passed date)");
                showMessageToUser.setVisible(true);
            } else {
                {int RID = Manager.getTables().get(i).getReservation().getReservationId();
                    Reservation.changeReservation(RID, getDateInputFromDatePicker(), Integer.parseInt(numberOfPeopleInput.getText()));
                    showMessageToUser.setText("Reservation changed successfully");
                    showMessageToUser.setVisible(true);
                }
            }
        }
    }
}
