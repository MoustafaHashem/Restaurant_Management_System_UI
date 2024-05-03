package org.example.restaurant_management_system_ui;

import Human.Manager;
import Human.Staff;
import Restaurant.Menu;
import Restaurant.MenuItem;
import Restaurant.MenuSection;
import Restaurant.Table;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(startScene);
        stage.show();
        stage.setTitle(" Gusteau’s Restaurant ");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("/Images/7.png")).toExternalForm()));
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        MediaPlayer media=new MediaPlayer(new Media(new File("src/main/resources/Music/French_Accordion_Traditionell_Musette.mp3").toURI().toString()));
        //M7D4 Y2FL EL O3'NYA >:(
        //MediaPlayer media=new MediaPlayer(new Media(new File("src/main/resources/Music/Le+festib+(mp3cut.net)_out.mp3").toURI().toString()));
        media.setCycleCount(MediaPlayer.INDEFINITE);
        media.setVolume(.1);
        media.play();
        Manager owner = new Manager("Batman  ", 20, "Gotham city", "01229082038", 5000000, "high");
        owner.addEmployee(owner);
        Staff kareem = new Staff("kareem ", 20, "el-obour city", "01097963663", 5, "high");
        owner.addEmployee(kareem);
        Staff mayar = new Staff("mayar ", 20, "el-obour city", "01097963663", 10000, "high");
        owner.addEmployee(mayar);
        owner.addMenu(new Menu("Main menu"));
        owner.addMenuSection(new MenuSection(Manager.getMenus().get(0), "Grilled"));
        owner.addMenuSection(new MenuSection(Manager.getMenus().get(0), "Fried"));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(0), "Chicken", 100));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(0), "Meat", 150));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(0), "Kebab", 300));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(0), "Salmon", 150));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(1), "Fried chicken", 150));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(1), "Fish", 75));
        owner.addMenuItem(new MenuItem(Manager.getMenuSections().get(1), "Meat", 200));
        MenuItem.sortMenuItems();
        for (int i = 0; i < 5; i++) {
            owner.addTable(new Table());
        }
        for (Table t : Manager.getTables()) {
            if (!t.isReserved()) {
                Manager.getAvailableTables().add(t);
            }
        }
        launch();
    }
}