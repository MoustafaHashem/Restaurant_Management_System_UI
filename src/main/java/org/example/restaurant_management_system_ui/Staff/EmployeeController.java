package org.example.restaurant_management_system_ui.Staff;


import Human.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

import static org.example.restaurant_management_system_ui.Staff.StaffController.ii;

public class EmployeeController {
    public ImageView logout;
    public Text logoutText;
    public Button change;
    public TextField IDNewPassword;
    public Text addErrorMessage;
    public TextField newPassword;
    public TextFlow orderData;
    public Button printIDOrder;
    public TextField IDOrder;
    public Button printAllOrder;

    public TextFlow reservationData;
    public Button printIDReservation;
    public Button printAllReservation;
    public TextField IDReservation;
    public Button profileButton;
    public Button reservationButton;
    public Button orderButtonPress;
    public TextFlow profileDateText;
    public ImageView showData;

    public void show1() {
        logoutText.setText("Logout");
    }

    public void hide1() {
        logoutText.setText("");
    }

    public void changePress() {
        profileDateText.getChildren().clear();
        String oldPassword = Manager.getEmployees().get(ii).getPassword();
        Manager.getEmployees().get(ii).setPassword(newPassword.getText());
        String newPassword1 = Manager.getEmployees().get(ii).getPassword();
        if (oldPassword == newPassword1) {
            addErrorMessage.setText("Invalid input. please try again.");
            addErrorMessage.setVisible(true);
        } else {
            Manager.getEmployees().get(ii).setPassword(newPassword.getText());
            System.out.println(Manager.getEmployees().get(ii).getPassword());
            addErrorMessage.setText("Changed done");
            addErrorMessage.setVisible(true);
            profileDateText.getChildren().add(new Text(Manager.getEmployees().get(ii).print()));
        }
    }

    public void printIDOrderPress() {
    }

    public void printAllOrderPress() {
    }

    public void printIDReservationPress() {
    }

    public void printAllReservationPress() {
    }

    public void profileButtonPress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("print.fxml"));
        Scene printScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) logout.getScene().getWindow();
        mainStage.setScene(printScene);
    }

    public void reservationButtonPress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("printReservations.fxml"));
        Scene printReservationsScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) logout.getScene().getWindow();
        mainStage.setScene(printReservationsScene);
    }

    public void orderButtonPress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("printOrders.fxml"));
        Scene printOrdersScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) logout.getScene().getWindow();
        mainStage.setScene(printOrdersScene);
    }

    public void logoutClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("staff.fxml"));
        Scene staffScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) logout.getScene().getWindow();
        mainStage.setScene(staffScene);
    }
}