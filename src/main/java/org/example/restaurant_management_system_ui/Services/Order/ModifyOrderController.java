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
import org.example.restaurant_management_system_ui.Services.Order.AddOrderController;

import java.io.IOException;

public class ModifyOrderController {
    public ImageView returnImage1;
    public Text returnText1;
    public TextFlow printMenuList;
    public TextField tableNo;
    public TextField oldMeal;
    public TextField newMeal;
    public Button modifyButton;
    public Text invalidInput;

    public void press(MouseEvent event) throws IOException {
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
            for(int i = 0; i< Manager.getMenuItems().size(); i++)
                printMenuList.getChildren().add(new Text(Manager.getMenuItems().get(i).print()));}
    }
    public void pressButton(ActionEvent actionEvent) {
        int x = Manager.getTables().size();
        boolean t1 = false;
        boolean t2 = false;
        int i;
        for ( i = 0; i < x; i++) {
            int y = tableNo.getText().compareTo((String.valueOf(Manager.getTables().get(i).getTableNum())));
            if (y == 0) {
                t1 = true;
                break;
            }
        }
        int z = oldMeal.getText().compareTo(String.valueOf(Manager.getTables().get(i).getOrder().getMeals().get(0).getID()));
        for (int j = 0; j < x; j++) {
            int a= newMeal.getText().compareTo(String.valueOf(Manager.getMenuItems().get(j).getID()));
            if (a == 0) {
                t2 = true;
                break;
            }
        }

        invalidInput.setVisible(true);
        if(t1 && t2){
            invalidInput.setText("Your order has been modified");
        }
        else{
            invalidInput.setText("Invalid input, please try again");
        }
        Order order = new Order();
        MenuItem mi = Order.addMeal(Integer.parseInt(newMeal.getText()));
        order.getMeals().add(mi);
        Manager.getTables().get(i).addOrder(order);
    }
}
