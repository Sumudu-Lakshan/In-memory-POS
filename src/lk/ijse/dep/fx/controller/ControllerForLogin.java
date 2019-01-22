package lk.ijse.dep.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.dep.fx.view.util.UserDetails;
import lk.ijse.dep.fx.view.util.adminUser;
import lk.ijse.dep.fx.view.util.normalUser;
import lk.ijse.dep.fx.view.util.systemUser;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerForLogin {
    public TextField txtuserName;
    public TextField txtpassword;
    public Button btnlogin;
    public Button btnsignup;
    static Object getuser;

    public static ArrayList<systemUser> system = ControllerForSystemLogin.systemUsers;
    public static ArrayList<adminUser>  admin = ControllerForAdminLogin.adminUsers;
//    public static ArrayList<normalUser> normaluser =

//    public static ArrayList<normalUser> normalUser = new ArrayList<>();


    public void login(ActionEvent actionEvent) throws IOException {

        String username =  txtuserName.getText();
        String password = txtpassword.getText();

        for (systemUser systemUser : system) {

            if(systemUser.getSystemUsername().equals(username) && systemUser.getSystemPassword().equals(password)){

                Parent pointOfSale = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/pointOfSale.fxml"));
                Scene scene = new Scene(pointOfSale);
                Stage stage = (Stage) btnlogin.getScene().getWindow();
                stage.setScene(scene);

                getuser = systemUser;
                System.out.println("getuser");

            }
        }

        for (adminUser adminUser : admin) {
            if(adminUser.getAdminUser().equals(username) && adminUser.getAdminPassword().equals(username)){
                Parent pointOfSale = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/pointOfSale.fxml"));
                Scene scene = new Scene(pointOfSale);
                Stage stage = (Stage) btnlogin.getScene().getWindow();
                stage.setScene(scene);

                getuser = adminUser;
                System.out.println("admin user");

            }
        }

        for (systemUser systemUser : system) {

        }


    }

//    public static ArrayList<UserDetails> getUserDetailList(){
//        return userlist;
//    }

    public void signUp(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/SignUp.fxml"));
        Scene scene = new Scene(root);
        Stage primarystage = (Stage) btnsignup.getScene().getWindow();
        primarystage.setScene(scene);

    }
}
