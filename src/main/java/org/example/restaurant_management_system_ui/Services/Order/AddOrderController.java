package org.example.restaurant_management_system_ui.Services.Order;

import Human.Manager;
import Restaurant.MenuItem;
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

public class AddOrderController {

    public TextFlow printMenuItemData;
    public Text invalidInput;
    public Button orderButton;
    public TextField tableNo;
    public TextField itemID;
    public Button AddItem;
    public TextFlow printOrderData;
    public Text returnText;
    public ImageView returnImage1;

    public void press( ) throws IOException {
        printOrderData.setVisible(false);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("order.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnText.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void show1( ) {
        returnText.setText("Return");
    }

    public void hide1( ) {
        returnText.setText("");
    }


    boolean x = true;
    public void showData() {
        if (x) {
            x = false;
            for (int j = 0; j < Manager.getMenus().size(); j++) {
                printMenuItemData.getChildren().add(new Text(Manager.getMenuItems().get(j).getMenuSection().getMenu().print()));
                for (int k = 0; k < Manager.getMenuSections().size(); k++) {
                    if (Manager.getMenus().get(j) == Manager.getMenuSections().get(k).getMenu()) {
                        printMenuItemData.getChildren().add(new Text(Manager.getMenuSections().get(k).printSection()));
                    }
                    for (int l = 0; l < Manager.getMenuItems().size(); l++) {
                        if (Manager.getMenuSections().get(k) == Manager.getMenuItems().get(l).getMenuSection()) {
                            printMenuItemData.getChildren().add(new Text(Manager.getMenuItems().get(l).printItem()));
                        }
                    }
                }
            }
        }
    }

    Order order = new Order();
    boolean t = false;
    boolean t1 = false;
    int i;
    int z;

    public void pressAddItem( ) {
        invalidInput.setVisible(false);
        int x = Manager.getMenuItems().size();
        t = false;
        for (int j = 0; j < x; j++) {
            z = itemID.getText().compareTo(String.valueOf(Manager.getMenuItems().get(j).getID()));
            if (z == 0) {
                t = true;
                break;
            }
        }
        if (t) {
            invalidInput.setVisible(true);
            invalidInput.setText("Item added");
            MenuItem mi = Services.Order.addMeal(Integer.parseInt(itemID.getText()));
            order.getMeals().add(mi);
            order.setCost(order.getCost() + mi.getPrice());
        } else  {
            invalidInput.setVisible(true);
            invalidInput.setText("ID number doesn't exist,please enter another number");
        }

        //invalidInput.setVisible(false);
    }
    int y;
    public void pressOrder( ) {
        invalidInput.setVisible(false);
        printOrderData.getChildren().clear();
        for (i = 0; i < Manager.getTables().size(); i++) {
             y = tableNo.getText().compareTo((String.valueOf(Manager.getTables().get(i).getTableNum())));
            if (y == 0&&Manager.getTables().get(i).getReservation().getReservationId()!=0) {
                t1 = true;
                break;
            }
        }
        if (t1 && t) {

            Manager.getTables().get(i).addOrder(order);
            invalidInput.setVisible(true);
            invalidInput.setText("Your order will be ready soon");
            printOrderData.setVisible(true);
            printOrderData.getChildren().add(new Text(Order.print(Manager.getTables().get(i))));
            order = new Order();
        } else if(y==0) {
            invalidInput.setVisible(true);
            invalidInput.setText("Table number doesn't exist,please enter another number");
        }
        else {
            invalidInput.setVisible(true);
            invalidInput.setText("No reservation in this table");
        }
    }
}