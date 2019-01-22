package lk.ijse.dep.fx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.UserDetails;
import lk.ijse.dep.fx.view.util.adminUser;
import lk.ijse.dep.fx.view.util.normalUser;
import lk.ijse.dep.fx.view.util.systemUser;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerForSystemLogin {

   
    public TextField txtsystemConfirmPassword;
    public TextField txtadminUsername;
    public TextField txtadminPassword;
    public TextField txtNormalUsername;
    public TextField txtNormalPassword;
    public TextField txtsystemNewPassword;
    public Button btnsystemChange;
    public Button btnNewAdmin;
    public Button btnNewUser;
    public Button btnAdminSave;
    public Button btnNormalSave;


    public static ArrayList<systemUser> systemUsers = new ArrayList<>();
    static {
        systemUsers.add(new systemUser("system","system"));

    }
    public static ArrayList<adminUser> adminUserslist = ControllerForAdminLogin.adminUsers;
    public static ArrayList<normalUser> normalUserList = new ArrayList<>();

    public Button btnBack;
    public TextField txtsystemPassword;
    public TableView<adminUser> tblAdmin;
    public TableView<normalUser> tblUser;

    public void initialize(){

        tblAdmin.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("adminUser"));
        tblAdmin.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("delete"));
        ObservableList<adminUser> adminUserObservableList = FXCollections.observableArrayList(adminUserslist);
        tblAdmin.setItems(adminUserObservableList);

        tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("normalUsername"));
        tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("delete"));
        ObservableList<normalUser> User = FXCollections.observableArrayList(normalUserList);
        tblUser.setItems(User);

        txtadminUsername.setEditable(false);
        txtadminPassword.setEditable(false);
        txtNormalUsername.setEditable(false);
        txtNormalPassword.setEditable(false);
    }

    public void changePassword(ActionEvent actionEvent) {
        String password = txtsystemPassword.getText();
        String newpassword = txtsystemNewPassword.getText();
        String confirmpassword = txtsystemConfirmPassword.getText();

        if(password.trim().isEmpty() || newpassword.trim().isEmpty() || confirmpassword.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Textfields shoul not empty", ButtonType.OK).show();

        }
        if(!newpassword.equals(confirmpassword)){
            new Alert(Alert.AlertType.ERROR,"Mismatatch passwords", ButtonType.OK).show();

        }

        systemUsers.get(0).setSystemPassword(newpassword);
        new Alert(Alert.AlertType.INFORMATION,"password has been changed succesfully", ButtonType.OK).show();


    }

    public void back(ActionEvent actionEvent) throws IOException {
       Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/pointOfSale.fxml"));
        Scene scene = new Scene(parent);
        Stage primarystage = (Stage) btnBack.getScene().getWindow();
        primarystage.setScene(scene);
    }

    public void newAdmin(ActionEvent actionEvent) {
        txtadminUsername.setEditable(true);
        txtadminPassword.setEditable(true);
    }

    public void saveAdmin(ActionEvent actionEvent) {
        String adminusername = txtadminUsername.getText();
        String password = txtadminPassword.getText();
         Button delete = new Button("delete");

        adminUserslist.add(new adminUser(adminusername,password,delete));
        ObservableList<adminUser> adminUserList = FXCollections.observableArrayList(adminUserslist);
        tblAdmin.setItems(adminUserList);

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                adminUser selectedItem = tblAdmin.getSelectionModel().getSelectedItem();
                adminUserslist.remove(selectedItem);
                adminUserList.remove(selectedItem);

                System.out.println("button is working");


            }
        });

    }


    public void newUser(ActionEvent actionEvent) {

        txtNormalUsername.setEditable(true);
        txtNormalPassword.setEditable(true);
        txtNormalUsername.requestFocus();

    }

    public void saveUser(ActionEvent actionEvent) {

        String UserName = txtNormalUsername.getText();
        String UserPassword = txtNormalPassword.getText();
        Button delete = new Button("delete");

        normalUserList.add(new normalUser(UserName,UserPassword,delete));
        ObservableList<normalUser> userlist = FXCollections.observableArrayList(normalUserList);
        tblUser.setItems(userlist);

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                normalUser selectedItem = tblUser.getSelectionModel().getSelectedItem();
                normalUserList.remove(selectedItem);
                userlist.remove(selectedItem);
            }
        });



    }
}
