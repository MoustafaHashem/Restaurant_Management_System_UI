package org.example.restaurant_management_system_ui.Staff;


import Human.Manager;
import Services.Order;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;
import java.util.Objects;

import static org.example.restaurant_management_system_ui.Staff.StaffController.ii;

public class EmployeeController {
    public ImageView logout;
    public Text logoutText;
    public Button change;

    public Text addErrorMessage;
    public TextField newPassword;
    public TextFlow orderData;
    public Button printIDOrder;
    public TextField tableNumber;
    public Button printAllOrder;

    public TextFlow reservationData;
    public Button printIDReservation;
    public Button printAllReservation;
    public TextField reservationName;
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
        if (oldPassword.compareTo(newPassword1) == 0) {
            addErrorMessage.setText("The password entered is the same as the last, please enter a new password");
            addErrorMessage.setVisible(true);
        } else {
            Manager.getEmployees().get(ii).setPassword(newPassword.getText());
            //System.out.println(Manager.getEmployees().get(ii).getPassword());
            addErrorMessage.setText("Changed done");
            addErrorMessage.setVisible(true);
            profileDateText.getChildren().add(new Text(Manager.getEmployees().get(ii).print()));
        }
    }

    public void printOrderPress() { //need testing

        orderData.getChildren().clear();
        addErrorMessage.setVisible(false);
        try {
            int tableNum = Integer.parseInt(tableNumber.getText());
            int i;
            int size = Manager.getTables().size();
            for (i = 0; i < size; i++) {
                if (tableNum == Manager.getTables().get(i).getTableNum()) {
                    break;
                }
            }
            if (Objects.equals(tableNumber.getText(), "")){
                addErrorMessage.setVisible(true);
                addErrorMessage.setText("Please enter a table number");
            }
            else if (i == size) {
                addErrorMessage.setVisible(true);
                addErrorMessage.setText("Table doesn't exist, please enter another number");
            }
            else orderData.getChildren().add(new Text((Manager.getTables().get(i).getOrder().print())));
        } catch (Exception e) {
            addErrorMessage.setVisible(true);
        }
    }

    public void printAllOrderPress() { //need testing
        orderData.getChildren().clear();
        addErrorMessage.setVisible(false);
        orderData.getChildren().add(new Text(Order.printOrders()));
    }

    public void printReservationNamePress() {
        reservationData.getChildren().clear();
        addErrorMessage.setVisible(false);
        try {
            String name = reservationName.getText();
            int size = Manager.getTables().size();
            int i;
            for (i = 0; i < size; i++) {
                if (name.compareToIgnoreCase(Manager.getTables().get(i).getCustomer().getName()) == 0) break;
            }
            if (Objects.equals(reservationName.getText(), "")) {
                addErrorMessage.setVisible(true);
                addErrorMessage.setText("Please enter reservation name");
            }
            else if (i == size){
                addErrorMessage.setVisible(true);
                addErrorMessage.setText("Reservation doesn't exist, please try again");
            }
            else
                reservationData.getChildren().add(new Text(("Reservation Name: " + Manager.getTables().get(i).getCustomer().getName()
                        + "\nReservation ID: " + Manager.getTables().get(i).getReservation().getReservationId()
                        + "\nNumber of people: " + Manager.getTables().get(i).getReservation().getNumberOfPeople()
                        + "\nReservation date: " + Manager.getTables().get(i).getReservation().getDate()
                        + "\n************************************************************\n")));
        } catch (Exception e) {
            addErrorMessage.setVisible(true);
        }
    }

    public void printAllReservationPress() { //need testing
        addErrorMessage.setVisible(false);
        reservationData.getChildren().clear();
        StringBuilder accumulator = new StringBuilder();
        int i;
        int size = Manager.getTables().size();
        for (i = 0; i < size; i++) {
            if (Manager.getTables().get(i).isReserved()) {
                accumulator.append("Reservation Name: ").append(Manager.getTables().get(i).getCustomer().getName()).append("\nReservation ID: ").append(Manager.getTables().get(i).getReservation().getReservationId()).append("\nNumber of people: ").append(Manager.getTables().get(i).getReservation().getNumberOfPeople()).append("\nReservation date: ").append(Manager.getTables().get(i).getReservation().getDate()).append("\n************************************************************\n");
            }
        }
        reservationData.getChildren().add(new Text(accumulator.toString()));
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

    boolean x = true;

    public void showDataEntered() {
        if (x) {
            profileDateText.getChildren().add(new Text(Manager.getEmployees().get(ii).print()));
            x = false;
        }
    }
}