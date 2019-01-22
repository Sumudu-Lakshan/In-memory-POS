package lk.ijse.dep.fx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.fx.view.util.customerTM;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerForManageCustomers {

    private static ArrayList<customerTM> items = new ArrayList<>();

    static {
        items.add(new customerTM("111","suma","hikka"));
        items.add(new customerTM("112","male","hikka"));
        items.add(new customerTM("113","putaya","colombo"));

    }

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnNewUser;
    @FXML
    private TextField txtCustomerId;
    @FXML
    private TextField txtCustomerName;
    @FXML
    private TextField txtCustomerAddress;
    @FXML
    private TableView<customerTM> tblCustomerDetails;
    private static ObservableList<customerTM> List;

    public void initialize() {

        /* table aka map karanna setCellValueFactory aka yoda gani,
        meken wenne customer class ake thiyena attributes tike table akata map wena aka.
        meka aka paraka dammama athi
         */


        tblCustomerDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomerDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomerDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        List = FXCollections.observableArrayList(items);
        tblCustomerDetails.setItems(List);

// if observer list is not static then use this ..,
//        ObservableList<customerTM> customerTMS = FXCollections.observableList(items);
//        tblCustomerDetails.setItems(customerTMS);

        txtCustomerId.setEditable(false);

    }

    @FXML
    private void newUser_OnAction(ActionEvent actionEvent) {
        System.out.println("button is working");
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtCustomerId.setEditable(true);
        txtCustomerId.requestFocus();

    }

    @FXML
    private void save_OnAction(ActionEvent actionEvent) {

        String custId = txtCustomerId.getText();
        String custName = txtCustomerName.getText();
        String custAddress = txtCustomerAddress.getText();

//        tblCustomerDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
//        tblCustomerDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
//        tblCustomerDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        if(custId.trim().isEmpty() || custName.trim().isEmpty() || custAddress.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Can't have blank fields",ButtonType.OK).show();

            txtCustomerId.setText("");
            txtCustomerName.setText("");
            txtCustomerAddress.setText("");
            txtCustomerId.requestFocus();

            return;
        }

        for (customerTM chekitem : items) {
            if(chekitem != null && chekitem.getId().equals(custId)){
                new Alert(Alert.AlertType.ERROR,"Can not have same id",ButtonType.OK).show();
                return;
            }
        }

//        for (customerTM observerListItem : List) {
//            if(observerListItem.getId().equals(custId));
//            new Alert(Alert.AlertType.ERROR,"Can not have same id",ButtonType.OK).show();
//                return;
//        }

            items.add(new customerTM(custId, custName, custAddress));
            List = FXCollections.observableList(items);
            tblCustomerDetails.setItems(List);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Customer has succesfully added");
            alert.show();

            txtCustomerId.setText("");
            txtCustomerName.setText("");
            txtCustomerAddress.setText("");
            txtCustomerId.requestFocus();



    }

    @FXML
    private void Back_OnAction(ActionEvent actionEvent) throws IOException {
        tblCustomerDetails.getItems().removeAll(tblCustomerDetails.getItems());
        Parent pointOfSale = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/pointOfSale.fxml"));
        Scene pointOfSalescene = new Scene(pointOfSale);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(pointOfSalescene);


    }

    @FXML
    private void selectItem_OnAction(MouseEvent mouseEvent) {
        txtCustomerId.setText(tblCustomerDetails.getSelectionModel().getSelectedItem().getId());
        txtCustomerName.setText(tblCustomerDetails.getSelectionModel().getSelectedItem().getName());
        txtCustomerAddress.setText(tblCustomerDetails.getSelectionModel().getSelectedItem().getAddress());

    }

    @FXML
    private void delete_OnAction(ActionEvent actionEvent) {
       customerTM selectedItem = tblCustomerDetails.getSelectionModel().getSelectedItem();
       List.remove(selectedItem);
//
//        customerTM selectedItem = tblCustomerDetails.getSelectionModel().getSelectedItem();
//        items.remove(selectedItem);


        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtCustomerId.requestFocus();

    }

    static ArrayList<customerTM> getItems(){
        return items;
    }

}