package org.example.restaurant_management_system_ui.Services;

import Human.Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import Services.Bill;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class PaymentController {
    public Text costText;
    public Text text1;
    public Text text2;
    public Button checkoutButton;
    public TextField promocode;
    public TextField tableNumber;
    public AnchorPane anchor;
    public Text addErrorMessage;


    public ImageView returnImage;
    public Text returnText;
    public ImageView returnImage1;
    public Text returnText1;


    public void show1( ) {
        returnText1.setText("Return");
    }

    public void hide1( ) {
        returnText1.setText("");
    }

    public void press( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene sceneServices = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnImage.getScene().getWindow();
        mainStage.setScene(sceneServices);
    }

    public void buttonPress() {
       // text3.setVisible(false);
        text1.setVisible(false);
        text2.setVisible(false);
        addErrorMessage.setVisible(false);

        costText.setVisible(false);
        double cost ;
        try {
            int tableNum = Integer.parseInt(tableNumber.getText());
            int i;
            int size = Manager.getTables().size();
            for (i = 0; i < size; i++) {
                if (tableNum == Manager.getTables().get(i).getTableNum()) {
                    break;
                }
            }
            if (i == size||(Manager.getTables().get(i).getReservation().getReservationId()==0)) {
                addErrorMessage.setVisible(true);
            } else {

                cost = Bill.payment(tableNum, promocode.getText());

                costText.setText(Double.toString(cost));

                costText.setVisible(true);

                text1.setVisible(true);
                text2.setVisible(true);
            }
        } catch (Exception e) {
            addErrorMessage.setVisible(true);
        }
    }

    public void pressReturnImage( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene sceneServices = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnImage1.getScene().getWindow();
        mainStage.setScene(sceneServices);
    }
}
