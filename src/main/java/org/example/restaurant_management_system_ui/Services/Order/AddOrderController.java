package org.example.restaurant_management_system_ui.Services.Order;

import Human.Manager;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class AddOrderController   {

    public ImageView returnImage1;
    public Text returnText1;
    public TextFlow printMenuItemData;

    public void press(MouseEvent event) {
    }

    public void show1(MouseEvent event) {
    }

    public void hide1(MouseEvent event) {
    }


boolean x=true;
    public void showData( ) {
        if(x){
            x=false;
        for(int i=0;i< Manager.getMenuItems().size();i++)
            printMenuItemData.getChildren().add(new Text(Manager.getMenuItems().get(i).print()));}
    }
}
