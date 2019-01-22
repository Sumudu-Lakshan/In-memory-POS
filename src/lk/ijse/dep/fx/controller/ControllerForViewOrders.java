package lk.ijse.dep.fx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.orderTM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerForViewOrders {

    @FXML
    private Button btnBack;
    @FXML
    private TableView<orderTM> tblViewOrders;
    @FXML
    private TextField txtOrderId;

    public static ArrayList<orderTM> orderDetails = ControllerForPlaceOrder.getOrdrerList();

    public void initialize(){

        tblViewOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblViewOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblViewOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblViewOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("customerName"));

        ObservableList<orderTM> list = FXCollections.observableArrayList(orderDetails);
        tblViewOrders.setItems(list);



    }


    @FXML
    private void Back(ActionEvent actionEvent) throws IOException {
        Parent pointOfSale = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/pointOfSale.fxml"));
        Scene scene = new Scene(pointOfSale);
        Stage primarystage = (Stage) btnBack.getScene().getWindow();
        primarystage.setScene(scene);

    }

    public void searchData(ActionEvent actionEvent) {



    }


}
