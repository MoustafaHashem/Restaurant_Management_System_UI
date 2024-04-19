package org.example.restaurant_management_system_ui;

import Human.Manager;
import Human.Staff;
import Restaurant.Menu;
import Restaurant.MenuItem;
import Restaurant.MenuSection;
import Restaurant.Table;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {

@FXML
    public ImageView start;
    public ImageView staff;
    public Text staffMenu;
    public ImageView Customer;

    public void click() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("services.fxml"));
        Scene sceneServices = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)start.getScene().getWindow();
        mainStage.setScene(sceneServices);

    }

    public void clickStaff() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("staff.fxml"));
        Scene sceneStaff = new Scene(fxmlLoader.load(), 1280, 720, Color.TRANSPARENT);
        Stage mainStage=(Stage)start.getScene().getWindow();
        mainStage.setScene(sceneStaff);

    }

    public void show1() {
        staffMenu.setText("Staff page");
    }

    public void hide1() {
        staffMenu.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Manager owner=new Manager("Moustafa Ahmed Hashem",20,"el-obour city","01097963663",10000,"high");
        owner.addEmployee(owner);
        Staff kareem=new Staff("kareem ",20,"el-obour city","01097963663",10000,"high");
        owner.addEmployee(kareem);
        Staff mayar=new Staff("mayar ",20,"el-obour city","01097963663",10000,"high");
        owner.addEmployee(mayar);
        owner.addMenu(new Menu("main menu"));
        owner.addMenuSection(new MenuSection(Manager.getMenus().get(0),"Grilled"));
        owner.addMenuSection(new MenuSection(Manager.getMenus().get(0),"Fried" ));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(0),"chicken",100));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(0),"meat",150));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(0),"kebab",300));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(1),"fried chicken",150));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(1),"fish",75));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(1),"meat",200));
        for (int i=0;i<5;i++) {
            owner.addTable(new Table());
        }

    }

    public void clickCustomer(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("reservation.fxml"));
        Scene reservationScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)start.getScene().getWindow();
        mainStage.setScene(reservationScene);
    }

    public void showCustomer(MouseEvent mouseEvent) {
        staffMenu.setText("Customer page");
    }

    public void hideCustomer(MouseEvent mouseEvent) {
        staffMenu.setText("");
    }
}
