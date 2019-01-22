package lk.ijse.dep.fx.controller;

import com.sun.deploy.util.FXLoader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.dep.fx.view.util.UserDetails;
import lk.ijse.dep.fx.view.util.adminUser;
import lk.ijse.dep.fx.view.util.systemUser;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerForPointOfSale {

    public Button btnBack;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnViewOrder;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Button btnAddItem;
    @FXML
    private AnchorPane ancPointOfSale;
    @FXML
    private Button btnAddCustomer;

    @FXML
    private void newCustomer_OnAction(ActionEvent actionEvent) throws IOException {



        Parent manageCustomers = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/manageCustomers.fxml"));
        Scene scene = new Scene(manageCustomers);
        Stage primarystage = (Stage) ancPointOfSale.getScene().getWindow();
        primarystage.setScene(scene);


    }

    @FXML
    private void addItem_OnAction(ActionEvent actionEvent) throws IOException {
        Parent manageItems = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/manageItems.fxml"));
        Scene scene = new Scene(manageItems);
        Stage primarystage = (Stage) ancPointOfSale.getScene().getWindow();
        primarystage.setScene(scene);

    }

    @FXML
    private void placeOrder(ActionEvent actionEvent) throws IOException {
        Parent manageItems = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/mangeOrders.fxml"));
        Scene scene = new Scene(manageItems);
        Stage primarystage = (Stage)ancPointOfSale.getScene().getWindow();
        primarystage.setScene(scene);
    }

    @FXML
    private void ViewOrder(ActionEvent actionEvent) throws IOException {
        Parent viewOrders = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/viewOrders.fxml"));
        Scene scene = new Scene(viewOrders);
        Stage primarystage = (Stage)ancPointOfSale.getScene().getWindow();
        primarystage.setScene(scene);
    }

    @FXML
    private void goTOsettings(ActionEvent actionEvent) throws IOException {

        if(ControllerForLogin.getuser instanceof systemUser){
            Parent systemLogin = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/systemLogin.fxml"));
            Scene scene = new Scene(systemLogin);
            Stage primarystage = (Stage)ancPointOfSale.getScene().getWindow();
            primarystage.setScene(scene);

        }

        if(ControllerForLogin.getuser instanceof adminUser){
            Parent adminLogin = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/adminLogin.fxml"));
            Scene scene = new Scene(adminLogin);
            Stage primarystage = (Stage)ancPointOfSale.getScene().getWindow();
            primarystage.setScene(scene);

        }

    }

    public void Back(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/Login.fxml"));
        Scene scene = new Scene(parent);
        Stage primarystage = (Stage) btnBack.getScene().getWindow();
        primarystage.setScene(scene);
    }
}
