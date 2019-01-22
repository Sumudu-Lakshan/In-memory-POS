package lk.ijse.dep.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.UserDetails;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerForSignUp {
    public TextField txtuser;
    public TextField txtpass;
    public TextField txtconfirmPassword;
    public Button btnsignUp;
    public Button btnback;

    public static ArrayList<UserDetails> userlist = new ArrayList<>();

    static {
        userlist.add(new UserDetails("suma","123"));
        userlist.add(new UserDetails("male","123"));


    }


    public void signUp(ActionEvent actionEvent) throws IOException {
        String username = txtuser.getText();
        String password = txtpass.getText();
        String confirmPass = txtconfirmPassword.getText();

        if (username.trim().isEmpty() || password.trim().isEmpty() || confirmPass.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Can't have blank fields", ButtonType.OK).show();
            txtuser.requestFocus();
            return;
        }

        if (!password.equals(confirmPass)){
            new Alert(Alert.AlertType.ERROR,"Mismatched Passwords", ButtonType.OK).show();
            txtpass.requestFocus();
            return;
        }

        userlist.add(new UserDetails(username,password));

        Parent login = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/Login.fxml"));
        Scene scene = new Scene(login);
        Stage stage = (Stage) btnsignUp.getScene().getWindow();
        stage.setScene(scene);

    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent login = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/Login.fxml"));
        Scene scene = new Scene(login);
        Stage stage = (Stage) btnsignUp.getScene().getWindow();
        stage.setScene(scene);
    }
}
