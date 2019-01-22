package lk.ijse.dep.fx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.dep.fx.view.util.customerTM;
import lk.ijse.dep.fx.view.util.itemTM;
import lk.ijse.dep.fx.view.util.orderTM;
import lk.ijse.dep.fx.controller.ControllerForManageItems;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;


public class ControllerForPlaceOrder {

    @FXML
    private Button btnDelete;
    @FXML
    private Label lblSubTotal;
    @FXML
    private Button btnSave;
    @FXML
    private Button txtPlaceOrder;
    @FXML
    private TableView<orderTM> tblOrderList;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtOrderId;
    @FXML
    private TextField txtCustomerId;
    @FXML
    private TextField txtItemCode;
    @FXML
    private TextField txtItemOnHand;
    @FXML
    private TextField txtcustomerName;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtQty;
    @FXML
    private TextField txtUnitPrice;
    @FXML
    private Label lblDate;
    private int newquantity =0;
    private static int orderCount=1;
   // private static int subTotal = 0;

    private static ArrayList<orderTM> ordrerList = new ArrayList<>();

    public static ArrayList<orderTM> getOrdrerList() {
        return ordrerList;
    }

    public void initialize(){
        LocalDate date = LocalDate.now();
        lblDate.setText(String.valueOf(date));

        System.out.println(ordrerList);

        txtOrderId.setText(String.valueOf("00"+orderCount));
        txtOrderId.setEditable(false);

        tblOrderList.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblOrderList.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblOrderList.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblOrderList.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrderList.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        ObservableList<orderTM> orderTMS = FXCollections.observableArrayList(ordrerList);
        tblOrderList.setItems(orderTMS);

    }

    /* if you need to access arraylist from the customer controller class then make a method to return the arraylist from that class
    and make new array list in this class.
     */
    @FXML
    private void fillCustomerDetails(ActionEvent actionEvent) {
            String id = txtCustomerId.getText();
            ArrayList<customerTM> newList = ControllerForManageCustomers.getItems();
        for (customerTM customer : newList) {
            if(customer.getId().equals(id)){
                txtcustomerName.setText(customer.getName());
                txtItemCode.requestFocus();
                return;
            }
        }

    }


    @FXML
    private void back(ActionEvent actionEvent) throws IOException {
        Parent goToMain = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/pointOfSale.fxml"));
        Scene scene = new Scene(goToMain);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);

    }

    @FXML
    private void getItemDetails(ActionEvent actionEvent) {
        String itemcode = txtItemCode.getText();
        ArrayList<itemTM> arrayList = ControllerForManageItems.getItems();
        for (itemTM itemdetails : arrayList) {
            if(itemdetails.getItemId().equals(itemcode)){
                txtItemOnHand.setText(itemdetails.getQty());
                txtUnitPrice.setText(itemdetails.getUnitPrice());
                txtDescription.setText(itemdetails.getItemName());
//                txtQty.requestFocus();
                return;
            }
        }

    }

    @FXML
    private void checkQuantity(KeyEvent keyEvent) {

            int qtyOnHand = Integer.parseInt(txtItemOnHand.getText());
            int qty = Integer.parseInt(txtQty.getText());

            if(qtyOnHand < qty){
                txtQty.setStyle("-fx-text-inner-color: red;");

            }else{
                txtQty.setStyle("-fx-text-inner-color: green;");
            }

    }
    @FXML
    private void Add_OnAction(ActionEvent actionEvent) {

        String code = txtItemCode.getText();
        String description = txtDescription.getText();
        String UnitPrice = txtUnitPrice.getText();
        String quantity = txtQty.getText();
        String orderId = txtOrderId.getText();
        String onHand = txtItemOnHand.getText();

        int unitPrice = Integer.parseInt(UnitPrice.toString());
        int quanty = Integer.parseInt(quantity.toString());

        String total = String.valueOf(unitPrice * quanty);

        newquantity = Integer.parseInt(onHand) - Integer.parseInt(quantity);
        txtItemOnHand.setText(String.valueOf(newquantity));

        //ordrerList.add(new orderTM(code, description, UnitPrice, quantity, total,orderId));
        ObservableList<orderTM> orderTMS = tblOrderList.getItems();
        orderTMS.add(new orderTM(code,description,UnitPrice,quantity,total));
        //tblOrderList.setItems(orderTMS);

//        for (int i = 0; i <ordrerList.size() ; i++) {
//            if(ordrerList.get(i).getOrderId().equals(orderId)){
//                int newvalue = onhand - quanty;
//                txtItemOnHand.setText(String.valueOf(newvalue));
//                return;
//
//            }
//        }

    int subTotal = 0;
        for (orderTM orders : orderTMS) {
            String tot = orders.getTotal();
            int toatl = Integer.parseInt(tot);
            subTotal += toatl;

        }
        lblSubTotal.setText(String.valueOf(subTotal));

//       txtItemCode.setText("");
//       txtDescription.setText("");
//       txtItemOnHand.setText("");
//       txtUnitPrice.setText("");
//       txtQty.getText()
//       txtItemCode.requestFocus();


    }
    @FXML
    private void placeOrder(ActionEvent actionEvent) {

        orderCount++;

        String code = txtItemCode.getText();
        String description = txtDescription.getText();
        String UnitPrice = txtUnitPrice.getText();
        String quantity = txtQty.getText();
        String orderId = txtOrderId.getText();
        String onHand = txtItemOnHand.getText();

        int unitPrice = Integer.parseInt(UnitPrice.toString());
        int quanty = Integer.parseInt(quantity.toString());

        String total = String.valueOf(unitPrice * quanty);
        String date = lblDate.getText();
        String custId = txtCustomerId.getText();
        String cutomername = txtcustomerName.getText();

        System.out.println(date);
        System.out.println("=======================================================");
        System.out.println(ordrerList);
        ordrerList.add(new orderTM(code,description,UnitPrice,quantity,total,orderId,date,custId,cutomername));

        new Alert(Alert.AlertType.INFORMATION,"Order has been saved successfully",ButtonType.OK).show();

        txtOrderId.setText("00"+String.valueOf(orderCount));
        txtcustomerName.setText("");
        txtCustomerId.setText("");
        txtItemCode.setText("");
        txtDescription.setText("");
        txtItemOnHand.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        txtCustomerId.requestFocus();

        tblOrderList.getItems().removeAll(tblOrderList.getItems());

    }



    @FXML
    private void delete_OnAction(ActionEvent actionEvent) {
        String onHand = txtItemOnHand.getText();
        orderTM selectedItem = tblOrderList.getSelectionModel().getSelectedItem();
        int newvalue = Integer.parseInt(onHand) + Integer.parseInt(selectedItem.getQty());
        txtItemOnHand.setText(String.valueOf(newvalue));
        ordrerList.remove(selectedItem);
        ObservableList<orderTM> orderTMS = FXCollections.observableList(ordrerList);
        tblOrderList.setItems(orderTMS);


        int itemtotal = Integer.parseInt(selectedItem.getTotal());
        int subTotal = Integer.parseInt(lblSubTotal.getText()) - itemtotal;
        lblSubTotal.setText(String.valueOf(subTotal));


    }
    @FXML
    private void tableItemSelect(MouseEvent mouseEvent) {
        orderTM selectedItem = tblOrderList.getSelectionModel().getSelectedItem();
        txtItemCode.setText(selectedItem.getItemCode());
        txtUnitPrice.setText(selectedItem.getUnitPrice());
        txtQty.setText(selectedItem.getQty());
        txtDescription.setText(selectedItem.getDescription());


    }


}
