package org.example.restaurant_management_system_ui.Staff;

import Human.Manager;

import Human.Staff;
import Restaurant.Menu;
import Restaurant.MenuItem;
import Restaurant.MenuSection;
import Restaurant.Table;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {
    public ImageView returnImage;
    public Text returnText;
    public Text returnText2;
    public TextField email;
    public TextField password;
    public RadioButton showPassword;
    public Button login;
    public TextField passwordShowed;
    public Text incorrect;

    public void press() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage mainStage=(Stage)returnImage.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void show1() {
        returnText.setText("Return");
    }

    public void hide1() {
        returnText.setText("");
    }

    public void show2( ) {
        returnText2.setText("Staff Area");
    }
    public void hide2( ) {
        returnText2.setText("");
    }

    public void showP() {
        if(showPassword.isSelected()){
            passwordShowed.setText(password.getText());
            password.setVisible(false);
            passwordShowed.setVisible(true);
        }else {
            password.setText(passwordShowed.getText());
            passwordShowed.setVisible(false);
            password.setVisible(true);
        }
    }

    public static int ii;
    public void pressLogin() throws IOException {
        int x=1;
        for (ii=0;ii<Manager.getEmployees().size();ii++){
            int y= email.getText().compareTo(Manager.getEmployees().get(ii).getEmail());
            int z=password.getText().compareTo(Manager.getEmployees().get(ii).getPassword());
            int w=passwordShowed.getText().compareTo(Manager.getEmployees().get(ii).getPassword());
            if(y==0&&(z==0||w==0)){
                x=0;
                break;}
        }
        if(x==0&&ii==0){
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("manager.fxml"));
            Scene managerScene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage mainStage=(Stage)returnImage.getScene().getWindow();
            mainStage.setScene(managerScene);
        } else if (x == 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("employee.fxml"));
            Scene employeeScene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage mainStage=(Stage)returnImage.getScene().getWindow();
            mainStage.setScene(employeeScene);
        }else {
            incorrect.setText("E-mail or password is incorrect\nTry again ");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Manager owner=new Manager("Moustafa Ahmed Hashem",20,"el-obour city","01097963663",10000,"high");
        owner.addEmployee(owner);
        Staff sasa=new Staff("kareem ",20,"el-obour city","01097963663",10000,"high");
        owner.addEmployee(sasa);
        Staff hoda=new Staff("hoda ",20,"el-obour city","01097963663",10000,"high");
        owner.addEmployee(hoda);
        owner.addMenu(new Menu("main menu"));
        owner.addMenuSection(new MenuSection(owner.getMenus().get(0),"Grilled"));
        owner.addMenuSection(new MenuSection(owner.getMenus().get(0),"Fried" ));
        owner.addMenuItem(new MenuItem(owner.getMenuSections().get(0),"chicken",100));
        owner.addMenuItem(new MenuItem(owner.getMenuSections().get(0),"meat",150));
        owner.addMenuItem(new MenuItem(owner.getMenuSections().get(0),"kebab",300));
        owner.addMenuItem(new MenuItem(owner.getMenuSections().get(1),"fried chicken",150));
        owner.addMenuItem(new MenuItem(owner.getMenuSections().get(1),"fish",75));
        owner.addMenuItem(new MenuItem(owner.getMenuSections().get(1),"meat",200));
        for (int i=0;i<5;i++) {
            owner.addTable(new Table());
        }
    }

    public void errorText1() {
        incorrect.setText("");
    }
}