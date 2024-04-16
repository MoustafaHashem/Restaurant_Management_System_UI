package org.example.restaurant_management_system_ui;

import Human.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    public TextField passwordshowed;

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

    public void show2(MouseEvent mouseEvent) {
        returnText2.setText("Staff Area");
    }
    public void hide2(MouseEvent mouseEvent) {
        returnText2.setText("");
    }

    public void showP() {
        if(showPassword.isSelected()){
            passwordshowed.setText(password.getText());
            password.setVisible(false);
            passwordshowed.setVisible(true);
        }else {
            password.setText(passwordshowed.getText());
            passwordshowed.setVisible(false);
            password.setVisible(true);
        }
    }

    public void pressLogin(ActionEvent actionEvent) throws IOException {
        int i;
        int x=1;
        for (i=0;i<Manager.getEmployees().size();i++){
           int y= email.getText().compareTo(Manager.getEmployees().get(i).getEmail());
           int z=password.getText().compareTo(Manager.getEmployees().get(i).getPassword());
        if(y==0&&z==0){
            x=0;
            break;}
        }
        if(x==0&&i==0){
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("manager.fxml"));
            Scene managerScene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage mainStage=(Stage)returnImage.getScene().getWindow();
            mainStage.setScene(managerScene);
        } else if (x==0&&i!=0) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("employee.fxml"));
            Scene employeeScene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage mainStage=(Stage)returnImage.getScene().getWindow();
            mainStage.setScene(employeeScene);
        }else {
                    //except handling
            System.out.println("error");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Manager owner=new Manager("Moustafa Ahmed Hashem",20,"el-obor city","01097963663","123456789",10000,"high");
        owner.addEmployee(owner);
    }
}
