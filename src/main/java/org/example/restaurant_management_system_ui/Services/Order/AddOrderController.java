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
            for(int i=0;i< Manager.getMenuItems().size();i++)
                printMenuItemData.getChildren().add(new Text(Manager.getMenuItems().get(i).print()));}
    }

    public void pressOrder(ActionEvent actionEvent) {
        int x = Manager.getTables().size();
        boolean t1= false;
        boolean t2 = false;
        int a=-1;
        for (int i = 0; i <= x; i++) {
            int y = tableNo.getText().compareTo((String.valueOf(Manager.getTables().get(i).getTableNum())));
            if(y==0){
                t1=true;
                a=i;
                break;
            }
        }
        for (int j = 0; j <=x; j++) {
            int z = itemID.getText().compareTo(String.valueOf(Manager.getMenuItems().get(j).getID()));
            if(z==0){
                t2=true;
                break;
            }
        }

        invalidInput.setVisible(true);
        if (t1 && t2 ) {

            invalidInput.setText("You're order will be ready soon.");
//            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("bill.fxml"));
//            Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
//            Stage mainStage=(Stage)returnImage1.getScene().getWindow();
//            mainStage.setScene(startScene);
        }
        else {
            invalidInput.setText("Table number or ID doesn't exist, please enter another number");
        }

        Order order = new Order();
        MenuItem mi = Services.Order.addMeal(Integer.parseInt(itemID.getText()));
        order.getMeals().add(mi);
        Manager.getTables().get(a).addOrder(order);

    }

}
