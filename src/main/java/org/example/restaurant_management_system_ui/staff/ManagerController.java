package org.example.restaurant_management_system_ui.staff;



import Human.Manager;
import Human.Staff;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class ManagerController implements Initializable {
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
}
boolean y=true;
    public void showDataButtonPress( ) {
        if(y){
            y=false;
          mangerProfileData.getChildren().add(new Text(Manager.getEmployees().get(0).print()));
        }
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
        for(int i=0;employeeList.getItems().size()>i;i++){
            int finalI = i;
            employeeList.getItems().get(finalI).setOnAction(event ->{
                printEmployeeData.getChildren().clear();
            printEmployeeData.getChildren().add(new Text(Manager.getEmployees().get(finalI+1).print()));
        });
        }

    }
    public void chooseMenu( ) {
        for(int i=0;menuList.getItems().size()>i;i++){
            int finalI = i;
            menuList.getItems().get(finalI).setOnAction(event ->{
                printMenuData.getChildren().clear();
                printMenuData.getChildren().add(new Text(Manager.getMenus().get(finalI).print()));
            });
        }
    }
    public void  chooseMenuSection( ) {
        for(int i=0;menuSectionList.getItems().size()>i;i++){
            int finalI = i;
            menuSectionList.getItems().get(finalI).setOnAction(event ->{
                printMenuSectionData.getChildren().clear();
                printMenuSectionData.getChildren().add(new Text(Manager.getMenuSections().get(finalI).print()));
            });
        }
    }
    public void chooseMenuItem( ) {
        for(int i=0;menuItemList.getItems().size()>i;i++){
            int finalI = i;
            menuItemList.getItems().get(finalI).setOnAction(event ->{
                printMenuItemData.getChildren().clear();
                printMenuItemData.getChildren().add(new Text(Manager.getMenuItems().get(finalI).print()));
            });
        }
    }
    public void chooseTable( ) {
        for(int i=0;tableList.getItems().size()>i;i++){
            int finalI = i;
            tableList.getItems().get(finalI).setOnAction(event ->{
                printTableData.getChildren().clear();
                printTableData.getChildren().add(new Text(Manager.getTables().get(finalI).print()));
            });
        }
    }
    public void addPress( ) {
        printEmployeeData.getChildren().clear();
        x=true;
        try {
            Manager manager=new Manager();
            manager.addEmployee(new Staff(nameFieldAdd.getText(),Integer.parseInt(ageFieldAdd.getText()),addressFieldAdd.getText(),phoneFieldAdd.getText(),Integer.parseInt(salaryFieldAdd.getText()),rankFieldAdd.getText()));
            addErrorMessage.setText("Added done");
            addErrorMessage.setVisible(true);
        }catch (NumberFormatException e){
                    addErrorMessage.setVisible(true);
        }
    }
    public void removePress( ) {
        printEmployeeData.getChildren().clear();
        x=true;
        try {
            for (int i=0;i<=Manager.getEmployees().size();i++){
              int z=  iDFieldRemove.getText().compareTo(Manager.getEmployees().get(i).getEmployeeID());
              if(z==0)break;
            }
         Manager manager=new Manager();
         manager.removeEmployee(iDFieldRemove.getText());
         addErrorMessage.setText("Removed done");
         addErrorMessage.setVisible(true);
        }catch (Exception e){
            addErrorMessage.setVisible(true);
        }
    }
    public void setNewSalaryPress( ) {
        printEmployeeData.getChildren().clear();
        x=true;
        int i;
        try {
            for (i=0;i<=Manager.getEmployees().size();i++){
                int z=  iDFieldSalary.getText().compareTo(Manager.getEmployees().get(i).getEmployeeID());
                if(z==0)break;
            }
            Manager.getEmployees().get(i).setSalary(Integer.parseInt(salaryFieldSalary.getText()));
            addErrorMessage.setText("Changed done");
            addErrorMessage.setVisible(true);
        }catch (Exception e){
            addErrorMessage.setVisible(true);
        }
    }
    public void setNewRankPress( ) {
        printEmployeeData.getChildren().clear();
        x=true;
        int i;
        try {
            for (i=0;i<=Manager.getEmployees().size();i++){
                int z=  IDFieldRank.getText().compareTo(Manager.getEmployees().get(i).getEmployeeID());
                if(z==0)break;
            }
            Manager.getEmployees().get(i).setRank(rankFieldRank.getText());
            addErrorMessage.setText("Changed done");
            addErrorMessage.setVisible(true);
        }catch (Exception e){
            addErrorMessage.setVisible(true);
        }
    }
    public void addMPress() {
        Manager.getMenus().add(new Restaurant.Menu(titleM.getText()));
    }
    public void  menuChoosed( ) {


    }
    public void addMSPress( ) {
        int x;
        for(int i=0;chooseMenu.getItems().size()>i;i++){
            int finalI = i;
            chooseMenu.getItems().get(i).setOnAction(event ->{
                addErrorMessage.setText(Manager.getMenus().get(finalI).getTitle());
            });
        }
        for( x=0;Manager.getMenus().size()>x;x++){System.out.println(addErrorMessage.getText());
            if(addErrorMessage.getText().compareTo(Manager.getMenus().get(x).getTitle())==0)break;
        }
        Manager.getMenuSections().add(new Restaurant.MenuSection(Manager.getMenus().get(x), titleMS.getText()));
    }
    public void menuSectionChoosed( ) {
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    boolean x=true;
    public void addList( ) {

                if(x) {
                    employeeList.getItems().clear();
                    for (int i = 1; i < Manager.getEmployees().size(); i++)
                        employeeList.getItems().add(new MenuItem(Manager.getEmployees().get(i).getName()));
                    x=false;
                }
    }
    boolean z=true;
    public void addListT( ) {
        if(z) {
            tableList.getItems().clear();
            for (int i = 0; i < Manager.getTables().size(); i++)
                tableList.getItems().add(new MenuItem(Integer.toString(Manager.getTables().get(i).getTableNum())));
            z=false;
        }
    }
    boolean a=true;
    public void addListMS( ) {
        if(a) {
            menuSectionList.getItems().clear();
            for (int i = 0; i < Manager.getMenuSections().size(); i++)
                menuSectionList.getItems().add(new MenuItem(Manager.getMenuSections().get(i).getTitle()));
            a=false;
        }
    }
    boolean b=true;
    public void addListMI( ) {
        if(b) {
            menuItemList.getItems().clear();
            for (int i = 0; i < Manager.getMenuItems().size(); i++)
                menuItemList.getItems().add(new MenuItem(Manager.getMenuItems().get(i).getTitle()));
            b=false;
        }
    }
    boolean c=true;
    public void addListM( ) {
        if(c) {
            menuList.getItems().clear();
            for (int i = 0; i < Manager.getMenus().size(); i++)
                menuList.getItems().add(new MenuItem(Manager.getMenus().get(i).getTitle()));
            c=false;
        }
    }
    boolean d=true;
    public void addListMSInMI( ) {
        if(d) {
            chooseMenuSection.getItems().clear();
            for (int i = 0; i < Manager.getMenuSections().size(); i++)
                chooseMenuSection.getItems().add(new MenuItem(Manager.getMenuSections().get(i).getTitle()));
            d=false;
        }
    }
    boolean e=true;
    public void addListMInMS( ) {
        if(e) {
            chooseMenu.getItems().clear();
            for (int i = 0; i < Manager.getMenus().size(); i++)
                chooseMenu.getItems().add(new MenuItem(Manager.getMenus().get(i).getTitle()));
            e=false;
        }
    }
}
