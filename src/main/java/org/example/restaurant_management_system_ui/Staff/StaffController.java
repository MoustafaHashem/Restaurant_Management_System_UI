package org.example.restaurant_management_system_ui.Staff;

import Human.Manager;


import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.restaurant_management_system_ui.MainApplication;

import java.io.IOException;


public class StaffController {
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
        Stage mainStage = (Stage) returnImage.getScene().getWindow();
        mainStage.setScene(startScene);
    }

    public void show1() {
        returnText.setText("Return");
    }

    public void hide1() {
        returnText.setText("");
    }

    public void show2() {
        returnText2.setText("Staff Area");
    }

    public void hide2() {
        returnText2.setText("");
    }

    public void showP() {
        if (showPassword.isSelected()) {
            passwordShowed.setText(password.getText());
            password.setVisible(false);
            passwordShowed.setVisible(true);
        } else {
            password.setText(passwordShowed.getText());
            passwordShowed.setVisible(false);
            password.setVisible(true);
        }
    }

    public static int ii;

    public void pressLogin() throws IOException {
        int x = 1;
        for (ii = 0; ii < Manager.getEmployees().size(); ii++) {
            int y = email.getText().compareToIgnoreCase(Manager.getEmployees().get(ii).getEmail());
            int z = password.getText().compareTo(Manager.getEmployees().get(ii).getPassword());
            int w = passwordShowed.getText().compareTo(Manager.getEmployees().get(ii).getPassword());
            if (y == 0 && z == 0 || w==0) {
                x = 0;
                break;
            }else if(y == 0){
                x=2;
            }else if( z == 0 ){
                x=3;
            }
        }
        if (x == 0 && ii == 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("manager.fxml"));
            Scene managerScene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage mainStage = (Stage) returnImage.getScene().getWindow();
            mainStage.setScene(managerScene);
        } else if (x == 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("employee.fxml"));
            Scene employeeScene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage mainStage = (Stage) returnImage.getScene().getWindow();
            mainStage.setScene(employeeScene);
        } else {
            if(x==2){
                incorrect.setText("Password is incorrect\nTry again ");
            }else if (x==3){
                incorrect.setText("E-mail is incorrect\nTry again ");
            }
            else{
                incorrect.setText("E-mail and password are incorrect\nTry again ");
            }
        }
    }


    public void errorText1() {
        incorrect.setText("");
    }
}