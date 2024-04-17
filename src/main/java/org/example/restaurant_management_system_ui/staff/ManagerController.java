package org.example.restaurant_management_system_ui.staff;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class ManagerController {
    public Button addEmployee;
    public Button removeEmployee;
    public Button setSalary;
    public Button setRank;
    public Button addMenu;
    public Button addMenuSection;
    public Button addMenuITem;
    public Button addTable;
    public Button profile;
    public ImageView logout;
    public Text logoutText;
    public Button add;
    public MenuButton employeeList;
    public TextFlow printEmployeeData;
    public Button remove;
    public TextField rankFieldAdd;
    public TextField salaryFieldAdd;
    public TextField phoneFieldAdd;
    public TextField addressFieldAdd;
    public TextField ageFieldAdd;
    public TextField nameFieldAdd;

    public TextField iDFieldRemove;
    public TextField IDFieldRank;


    public TextField iDFieldSalary;

    public Text addErrorMessage;
    public Button addM;
    public TextField titleMi;
    public MenuButton menuItemList;
    public TextFlow printMenuItemData;
    public MenuButton chooseMenuSection;
    public TextField titleM;
    public MenuButton menuList;
    public TextFlow printMenuData;
    public TextField titleMS;
    public MenuButton menuSectionList;
    public TextFlow printMenuSectionData;
    public MenuButton chooseMenu;
    public MenuButton tableList;
    public TextFlow printTableData;
    public TextField newPassword;
    public Button change;
    public TextField price;
    public Button update;
    public TextField IDUpdatePrice;
    public Text addErrorMessage1;
    public TextField newPrice;
    public Button removeTable;
    public Button addTableToArrayList;
    public TextFlow mangerProfileData;
    public Button setNewRank;

    public TextField rankFieldRank;
    public Button setNewSalary;
    public TextField salaryFieldSalary;
    public Button addMI;
    public Button addMS;

    public void addEmployeePress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addEmployee.fxml"));
        Scene addEmployeeScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(addEmployeeScene);
    }

    public void removeEmployeePress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("removeEmployee.fxml"));
        Scene removeEmployeeScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(removeEmployeeScene);
    }

    public void setSalaryPress() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("setSalary.fxml"));
        Scene setSalaryScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(setSalaryScene);
    }
    public void setRankPress( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("setRank.fxml"));
        Scene setRankScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(setRankScene);
    }

    public void addMenuPress( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addMenu.fxml"));
        Scene addMenuScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(addMenuScene);
    }

    public void addMenuSectionPress( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addMenuSection.fxml"));
        Scene addMenuSectionScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(addMenuSectionScene);
    }

    public void addMenuItemPress( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addMenuItem.fxml"));
        Scene addMenuItemScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(addMenuItemScene);
    }

    public void addTablePress( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addTable.fxml"));
        Scene addTableScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(addTableScene);
    }

    public void profilePress( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("profile.fxml"));
        Scene profileScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)addEmployee.getScene().getWindow();
        mainStage.setScene(profileScene);
        // add manager data
    }
    public void pressLogout( ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("staff.fxml"));
        Scene staffScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)logout.getScene().getWindow();
        mainStage.setScene(staffScene);

    }
    public void show1( ) {
        logoutText.setText("Logout");
    }
    public void hide1( ) {
        logoutText.setText("");
    }

    public void chooseEmployee( ) {
    }
    public void menuChoosed( ) {
    }
    public void menuSectionChoosed( ) {
    }
    public void chooseMenuItem( ) {
    }
    public void chooseTable( ) {
    }
    public void addPress( ) {
    }
    public void removePress( ) {
    }
    public void setNewSalaryPress( ) {
    }
    public void setNewRankPress( ) {
    }
    public void addMPress(ActionEvent actionEvent) {
    }
    public void chooseMenu( ) {
    }
    public void addMSPress( ) {
    }
    public void chooseMenuSection( ) {
    }
    public void addMIPress( ) {
    }
    public void updatePress( ) {
    }
    public void removeTablePress( ) {
    }
    public void addTableToArrayListPress( ) {
    }
    public void changePress( ) {
    }










}
