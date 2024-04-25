package org.example.restaurant_management_system_ui.Services.Order;

import Human.Manager;
import Restaurant.MenuItem;
import Services.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.ResourceBundle;

public class AddOrderController   {

    public ImageView returnImage1;
    public Text returnText1;
    public TextFlow printMenuItemData;
    public Text invalidInput;
    public Button orderButton;
    public TextField tableNo;
    public TextField itemID;
    public Button AddItem;
    public TextFlow printOrderData;

    public void press(MouseEvent event) throws IOException {
        printOrderData.setVisible(false);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("order.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnImage1.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void show1(MouseEvent event) {returnText1.setText("Return");}

    public void hide1(MouseEvent event) {returnText1.setText("");}


    boolean x=true;
    public void showData( ) {
        if(x){
            x=false;
            for(int j=0;j< Manager.getMenuItems().size();j++)
                printMenuItemData.getChildren().add(new Text(Manager.getMenuItems().get(j).print()));}
    }
    Order order = new Order();
    boolean t = false;
    boolean t1 = false;
    int i;
    public void pressAddItem(ActionEvent actionEvent) {
        invalidInput.setVisible(false);
        int x = Manager.getMenuItems().size();
        t = false;
        for (int j = 0; j <x; j++) {
            int z = itemID.getText().compareTo(String.valueOf(Manager.getMenuItems().get(j).getID()));
            if(z==0){
                t=true;
                break;
            }
        }
        if(t){
            invalidInput.setVisible(true);
            invalidInput.setText("Item added.");
            MenuItem mi = Services.Order.addMeal(Integer.parseInt(itemID.getText()));
            order.getMeals().add(mi);
            order.setCost(order.getCost() + mi.getPrice());
        }
        else{
            invalidInput.setVisible(true);
            invalidInput.setText("ID number doesn't exist,please enter another number");
        }
        //invalidInput.setVisible(false);
    }
    public void pressOrder(ActionEvent actionEvent) {
        for ( i = 0; i < Manager.getTables().size(); i++) {
            int y = tableNo.getText().compareTo((String.valueOf(Manager.getTables().get(i).getTableNum())));
            if(y==0){
                t1=true;
                break;
            }
        }
        if(t1 && t) {
            Manager.getTables().get(i).addOrder(order);
            invalidInput.setVisible(true);
            invalidInput.setText("Your order will be ready soon");
        }
        else{
            invalidInput.setVisible(true);
            invalidInput.setText("Table number doesn't exist,please enter another number");
        }
        y = true;
    }
    boolean y = true;
    public void showOrderData(MouseEvent mouseEvent) {
        if(y){
            y = false;
            printOrderData.setVisible(true);
            printOrderData.getChildren().add(new Text(Order.printOrders()));
        }
    }

}
