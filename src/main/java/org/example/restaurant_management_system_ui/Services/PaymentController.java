package org.example.restaurant_management_system_ui.Services;

import Human.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    public Text text3;
    public Text reservationnametext;
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
        Scene sceneServices = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnImage.getScene().getWindow();
        mainStage.setScene(sceneServices);
    }

    public void buttonPress( ) {
        text3.setVisible(false);
        text1.setVisible(false);
        text2.setVisible(false);
        addErrorMessage.setVisible(false);
        reservationnametext.setVisible(false);
        costText.setVisible(false);
        double cost=0;
        try {
            int tableNum = Integer.parseInt(tableNumber.getText());
            int i;
            int size = Manager.getTables().size();
            for (i = 0; i < size; i++) {
                if (tableNum == Manager.getTables().get(i).getTableNum()) {
                    break;
                }
            }
            if (i == size) {
                addErrorMessage.setVisible(true);
            }
            else {
                String s=Manager.getTables().get(i).getCustomer().getName();
                cost = Bill.payment(tableNum,promocode.getText());
                reservationnametext.setText(s);
                costText.setText(Double.toString(cost));
                reservationnametext.setVisible(true);
                costText.setVisible(true);
                text3.setVisible(true);
                text1.setVisible(true);
                text2.setVisible(true);
            }
        } catch (Exception e) {
            addErrorMessage.setVisible(true);
        }


    }
}
