package org.example.restaurant_management_system_ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class StaffController {
    public ImageView returnImage;
    public Text returnText;
    public RadioButton showPasswoord;
    public TextField password;
    public TextField email;
    public Button login;
    public RadioButton showPassword;
    public Text returnText2;

    public void press(MouseEvent mouseEvent) {
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

    public void showP(ActionEvent actionEvent) {
    }

    public void pressLogin(ActionEvent actionEvent) {
    }
}
