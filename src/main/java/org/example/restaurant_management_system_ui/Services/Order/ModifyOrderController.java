package org.example.restaurant_management_system_ui.Services.Order;

import Human.Manager;
import Restaurant.MenuItem;
import Services.Order;
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

public class ModifyOrderController {
    public TextFlow printMenuList;
    public TextField tableNo;
    public TextField newMeal;
    public Button modifyButton;
    public Text invalidInput;
    public TextField oldMeal;
    public TextFlow printOrderData;
    public Button removeButton;
    public TextField removeItem;
    public ImageView returnImage;
    public Text returnText;

    public void press(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("order.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage = (Stage) returnImage.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void show1(MouseEvent event) {
        returnText.setText("Return");
    }

    public void hide1(MouseEvent event) {
        returnText.setText("");
    }

    boolean x = true;

    public void showData() {
        if (x) {
            x = false;
            for (int j = 0; j < Manager.getMenus().size(); j++) {
                printMenuList.getChildren().add(new Text(Manager.getMenuItems().get(j).getMenuSection().getMenu().print()));
                for (int k = 0; k < Manager.getMenuSections().size(); k++) {
                    if (Manager.getMenus().get(j) == Manager.getMenuSections().get(k).getMenu()) {
                        printMenuList.getChildren().add(new Text(Manager.getMenuSections().get(k).printSection()));
                    }
                    for (int l = 0; l < Manager.getMenuItems().size(); l++) {
                        if (Manager.getMenuSections().get(k) == Manager.getMenuItems().get(l).getMenuSection()) {
                            printMenuList.getChildren().add(new Text(Manager.getMenuItems().get(l).printItem()));
                        }
                    }
                }
            }
        }
    }

    boolean t1 = false;
    boolean t2 = false;
    Order order = new Order();

    public void pressButton(ActionEvent actionEvent) {
        invalidInput.setVisible(false);
        int x = Manager.getTables().size();
        int i, j;
        for (i = 0; i < x; i++) {
            int y = tableNo.getText().compareTo((String.valueOf(Manager.getTables().get(i).getTableNum())));
            if (y == 0) {
                t1 = true;
                break;
            } else {
                invalidInput.setVisible(true);
                invalidInput.setText("Invalid input, please try again");
            }
        }if(i==x) {
            invalidInput.setText("Invalid input, please try again");
        }
        else{order = Manager.getTables().get(i).getOrder();
        for (j = 0; j < Manager.getMenuItems().size(); j++) {
            int a = oldMeal.getText().compareTo(String.valueOf(order.getMeals().get(j).getID()));
            if (a == 0) {
                t2 = true;
                break;
            } else {
                invalidInput.setVisible(true);
                invalidInput.setText("Your old meal wasn't ordered, please enter a meal you ordered");
            }
        }
        for ( j = 0; j < Manager.getMenuItems().size(); j++) {
            int a = newMeal.getText().compareTo(String.valueOf(order.getMeals().get(j).getID()));
            if (a != 0) {
                invalidInput.setVisible(true);
                invalidInput.setText("Id item doesn't exist, please try again");
                break;
            }
        }
        invalidInput.setVisible(true);
        if (t1 && t2) {
            Manager.getTables().get(i).getOrder().setCost(Manager.getTables().get(i).getOrder().getCost() - order.getMeals().get(j).getPrice());
            Manager.getTables().get(i).getOrder().getMeals().remove(j);
            MenuItem mi = Order.addMeal(Integer.parseInt(newMeal.getText()));
            Manager.getTables().get(i).getOrder().getMeals().add(mi);
            Manager.getTables().get(i).getOrder().setCost(Manager.getTables().get(i).getOrder().getCost() + mi.getPrice());
            printOrderData.getChildren().clear();
            printOrderData.getChildren().add(new Text(Order.print(Manager.getTables().get(i))));
            invalidInput.setText("Your order has been modified");
        } else {
            invalidInput.setText("Invalid input, please try again");
        }}
    }

    public void pressRemoveButton(ActionEvent actionEvent) {
        invalidInput.setVisible(false);
        int x = Manager.getTables().size();
        int i, j;
        for (i = 0; i < x; i++) {
            int y = tableNo.getText().compareTo((String.valueOf(Manager.getTables().get(i).getTableNum())));
            if (y == 0) {
                t1 = true;
                break;
            } else {
                invalidInput.setVisible(true);
                invalidInput.setText("Invalid input, please try again");
            }
        }
        if(i==x) {
            invalidInput.setText("Invalid input, please try again");
        }
        else{ order = Manager.getTables().get(i).getOrder();
        for (j = 0; j < Manager.getMenuItems().size(); j++) {
            int a = removeItem.getText().compareTo(String.valueOf(order.getMeals().get(j).getID()));
            if (a == 0) {
                t2 = true;
                break;
            } else {
                invalidInput.setVisible(true);
                invalidInput.setText("Your old meal wasn't ordered, please enter a meal you ordered");
            }
        }
        invalidInput.setVisible(true);
        if (t1 && t2) {
            Manager.getTables().get(i).getOrder().setCost(Manager.getTables().get(i).getOrder().getCost() - order.getMeals().get(j).getPrice());
            Manager.getTables().get(i).getOrder().getMeals().remove(j);
            printOrderData.getChildren().clear();
            printOrderData.getChildren().add(new Text(Order.print(Manager.getTables().get(i))));
            invalidInput.setText("Your order has been modified");
        } else {
            invalidInput.setText("Invalid input, please try again");
        }}
    }
}
