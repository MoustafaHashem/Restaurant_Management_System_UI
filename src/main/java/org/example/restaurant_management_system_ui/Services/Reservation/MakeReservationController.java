package org.example.restaurant_management_system_ui.Services.Reservation;

import Human.Manager;
import Services.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.awt.Label;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import static org.example.restaurant_management_system_ui.Services.Reservation.ChangeReservationController.isInteger;
import static org.example.restaurant_management_system_ui.Services.Reservation.ChangeReservationController.isString;

public class MakeReservationController {

    //set error text to (Your Reservation ID is: **) when there is no error


    public ImageView returnMakeReservation;

    public Text textMakeReservation;
    public Button submitReservationInputButton;
    public MenuButton availableTablesList;
    public TextField nameInput;
    public TextField ageInput;
    public TextField addressInput;
    public TextField phoneInput;
    public TextField numberOfPeopleInput;
    public DatePicker dateInput;
    public Text showMessageToUser;
    public Text dateText;
    public Text availableTablesText;


    public void pressMakeReservation() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnMakeReservation.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void showMakeReservation() {
        textMakeReservation.setText("Return ");
    }

    public void hideMakeReservation() {
        textMakeReservation.setText("");
    }

    boolean x = true;

    public void addAvailableTablesList() {
        if (x) {
            availableTablesList.getItems().clear();
            for (int i = 0; i < Manager.getAvailableTables().size(); i++)
                availableTablesList.getItems().add(new MenuItem("Table " + Manager.getAvailableTables().get(i).getTableNum()));
            x = false;
        }
    }

    //    public AtomicReference<String> pressAvailableTablesList() {
//        x=true;
//        String[] menuButtonItems = new String[Manager.getAvailableTables().size()];
//        for(int i=0;i<Manager.getAvailableTables().size();i++)
//        {
//            menuButtonItems[i]=availableTablesList.getItems().get(i).toString();
//        }
//          AtomicReference<String> returnValue = null;
//        for (String s : menuButtonItems) {
//            availableTablesList.setOnAction(e -> {
//             returnValue.set(s);
//            });
//        }
//        return returnValue;
//    }
//    public LocalDate getDateInputFromDatePicker()
//    {
//        AtomicReference<LocalDate> date = null;
//        dateInput = new DatePicker(LocalDate.now());
//        dateInput.setOnAction(event -> {
//             date.set(dateInput.getValue());
//        });
//        return date.get();
//    }
    public LocalDate getDateInputFromDatePicker() {
        return dateInput.getValue();
    }

public void pressAvailableTablesList() {
        x=true;

        for (int i = 0; availableTablesList.getItems().size() > i; i++) {
            int finalI = i;
            availableTablesList.getItems().get(finalI).setOnAction(event -> availableTablesList.setText(availableTablesList.getItems().get(finalI).getText()));
        }
}

        public void submitReservationInput () throws IllegalArgumentException {
            if (Objects.equals(nameInput.getText(), "") || Objects.equals(addressInput.getText(), "") || getDateInputFromDatePicker() == null || Objects.equals(phoneInput.getText(), "") || Objects.equals(ageInput.getText(), "") || Objects.equals(numberOfPeopleInput.getText(), "")) {
                showMessageToUser.setText("All fields must be filled first in order to change a reservation");
                showMessageToUser.setVisible(true);
            }
            else if (!isInteger(numberOfPeopleInput.getText())) {
                showMessageToUser.setText("Invalid input type: input must be a positive integer");
                showMessageToUser.setVisible(true);
            }
            else if(!isInteger(ageInput.getText())) {
                showMessageToUser.setText("Invalid input type: input must be a positive integer");
                showMessageToUser.setVisible(true);
            }
            else if(!isString(nameInput.getText())) {
                showMessageToUser.setText("Invalid input type: input must be a name (String)");showMessageToUser.setVisible(true);
            }
            else if(!isInteger(phoneInput.getText())) {
                showMessageToUser.setText("Invalid input type: input must be a phone number (positive integers)");
                showMessageToUser.setVisible(true);
            }
            else  {
                x = true;
                try {
                    int TN = Integer.parseInt(String.valueOf(availableTablesList.getText().charAt(6)));
                    if (Reservation.makeReservation(TN, nameInput.getText(), Integer.parseInt(ageInput.getText()), addressInput.getText(), phoneInput.getText(), getDateInputFromDatePicker(), Integer.parseInt(numberOfPeopleInput.getText())) == -1) {
                        showMessageToUser.setText("No available tables at the moment to make a reservation");
                        showMessageToUser.setVisible(true);
                    }
                    showMessageToUser.setText("Reservation made successfully ;)");
                    showMessageToUser.setVisible(true);
                    availableTablesList.setText("availableTablesList");
                } catch (IllegalArgumentException ex) {
                    showMessageToUser.setText("Invalid input type: please re-enter data");
                    showMessageToUser.setVisible(true);
                }
            }
        }
}