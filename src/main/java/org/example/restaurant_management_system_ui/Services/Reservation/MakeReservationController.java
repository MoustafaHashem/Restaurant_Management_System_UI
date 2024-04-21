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

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

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
    boolean x=true;
    public void addAvailableTablesList( ) {
        if(x) {
            availableTablesList.getItems().clear();
            for (int i = 0; i < Manager.getAvailableTables().size(); i++)
                availableTablesList.getItems().add(new MenuItem("Table "+ Manager.getAvailableTables().get(i).getTableNum()));
            x=false;
        }
    }
    public AtomicReference<String> pressAvailableTablesList() {
        x=true;
        String[] menuButtonItems = new String[Manager.getAvailableTables().size()];
        for(int i=0;i<Manager.getAvailableTables().size();i++)
        {
            menuButtonItems[i]=availableTablesList.getItems().get(i).toString();
        }
          AtomicReference<String> returnValue = null;
        for (String s : menuButtonItems) {
            availableTablesList.setOnAction(e -> {
             returnValue.set(s);
            });
        }
        return returnValue;
    }

    public void submitReservationInput(ActionEvent actionEvent) {
        try{
            Reservation.makeReservation(pressAvailableTablesList(),nameInput.getText(),ageInput.getText(),addressInput.getText(),phoneInput.getText(),,numberOfPeopleInput.getText())
        }
    }




}
