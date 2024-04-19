package org.example.restaurant_management_system_ui.Staff;



import Human.Manager;
import Human.Staff;
import Restaurant.Table;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;

public class ManagerController   {
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
        x=true;
        for(int i=0;employeeList.getItems().size()>i;i++){
            int finalI = i;
            employeeList.getItems().get(finalI).setOnAction(event ->{
                printEmployeeData.getChildren().clear();
            printEmployeeData.getChildren().add(new Text(Manager.getEmployees().get(finalI+1).print()));
        });
        }

    }
    public void chooseMenu( ) {
        c=true;
        for(int i=0;menuList.getItems().size()>i;i++){
            int finalI = i;
            menuList.getItems().get(finalI).setOnAction(event ->{
                printMenuData.getChildren().clear();
                printMenuData.getChildren().add(new Text(Manager.getMenus().get(finalI).print()));
            });
        }
    }
    public void  chooseMenuSection( ) {
        a=true;
        for(int i=0;menuSectionList.getItems().size()>i;i++){
            int finalI = i;
            menuSectionList.getItems().get(finalI).setOnAction(event ->{
                printMenuSectionData.getChildren().clear();
                printMenuSectionData.getChildren().add(new Text(Manager.getMenuSections().get(finalI).print()));
            });
        }
    }
    public void chooseMenuItem( ) {
        b=true;
        for(int i=0;menuItemList.getItems().size()>i;i++){
            int finalI = i;
            menuItemList.getItems().get(finalI).setOnAction(event ->{
                printMenuItemData.getChildren().clear();
                printMenuItemData.getChildren().add(new Text(Manager.getMenuItems().get(finalI).print()));
            });
        }
    }
    public void chooseTable( ) {
        z=true;
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
        printMenuData.getChildren().clear();
        Manager.getMenus().add(new Restaurant.Menu(titleM.getText()));
        addErrorMessage.setText("Added done");
        addErrorMessage.setVisible(true);
    }
    public void  menuChoosed( ) {
        addErrorMessage.setVisible(false);
        for(int i=0;chooseMenu.getItems().size()>i;i++){
            int finalI = i;
            chooseMenu.getItems().get(i).setOnAction(event -> addErrorMessage.setText(Manager.getMenus().get(finalI).getTitle()));
        }
    }
    public void addMSPress( ) {
        printMenuSectionData.getChildren().clear();
        int x;

        for( x=0;Manager.getMenus().size()>x;x++){
            if(addErrorMessage.getText().compareTo(Manager.getMenus().get(x).getTitle())==0)break;
        }
        if(x!=Manager.getMenus().size()){
        Manager.getMenuSections().add(new Restaurant.MenuSection(Manager.getMenus().get(x), titleMS.getText()));
        addErrorMessage.setText("Added done");
        addErrorMessage.setVisible(true);}else{addErrorMessage.setText("Invalid input. please try again.");
            addErrorMessage.setVisible(true);}
    }
    public void menuSectionChoosed( ) {
        addErrorMessage.setVisible(false);
        for(int i=0;chooseMenuSection.getItems().size()>i;i++){
            int finalI = i;
            chooseMenuSection.getItems().get(i).setOnAction(event -> addErrorMessage.setText(Manager.getMenuSections().get(finalI).getTitle()));
        }
    }
    public void addMIPress( ) {
        printMenuItemData.getChildren().clear();
        int x;
        for( x=0;Manager.getMenuSections().size()>x;x++){
            if(addErrorMessage.getText().compareTo(Manager.getMenuSections().get(x).getTitle())==0)break;
        }
        if(x!=Manager.getMenuSections().size()){
        try {

            Manager.getMenuItems().add(new Restaurant.MenuItem(Manager.getMenuSections().get(x),titleMi.getText(),Integer.parseInt(price.getText())));
            addErrorMessage.setText("Added done");
            addErrorMessage.setVisible(true);
        }catch (NumberFormatException e){
            addErrorMessage.setText("Invalid input. please try again.");
            addErrorMessage.setVisible(true);}}else{addErrorMessage.setText("Invalid input. please try again.");
            addErrorMessage.setVisible(true);}
    }
    public void updatePress( ) {
        printMenuItemData.getChildren().clear();
        try {
            int i;
            for ( i=0;i<=Manager.getMenuItems().size();i++){
                int z=  IDUpdatePrice.getText().compareTo(Integer.toString(Manager.getMenuItems().get(i).getID()));
                if(z==0)break;
            }
            Manager.getMenuItems().get(i).setPrice(Integer.parseInt(newPrice.getText()));
            addErrorMessage1.setText("Updated done");
            addErrorMessage1.setVisible(true);
        }catch (Exception e){
            addErrorMessage1.setVisible(true);
        }
    }
    public void removeTablePress( ) {
        addErrorMessage.setVisible(false);
        printTableData.getChildren().clear();
        Manager.getTables().remove(Manager.getTables().size()-1);
        addErrorMessage.setText("Removed done");
        addErrorMessage.setVisible(true);
    }
    public void addTableToArrayListPress( ) {
        addErrorMessage.setVisible(false);
        printTableData.getChildren().clear();
        Manager.getTables().add(Manager.getTables().size(),new Table());
        addErrorMessage.setText("Added done");
        addErrorMessage.setVisible(true);
    }
    public void changePress( ) {
        mangerProfileData.getChildren().clear();
        String oldPassword=Manager.getEmployees().get(0).getPassword();
        Manager.getEmployees().get(0).setPassword(newPassword.getText());
        String newPassword1=Manager.getEmployees().get(0).getPassword();
        if(oldPassword.compareTo(newPassword1)==0){addErrorMessage.setText("Invalid input. please try again.");
            addErrorMessage.setVisible(true);}
        else{
        Manager.getEmployees().get(0).setPassword(newPassword.getText());
        System.out.println(Manager.getEmployees().get(0).getPassword());
        addErrorMessage.setText("Changed done");
        addErrorMessage.setVisible(true);
        mangerProfileData.getChildren().add(new Text(Manager.getEmployees().get(0).print()));}
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
