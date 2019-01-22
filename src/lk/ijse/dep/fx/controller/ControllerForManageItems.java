package lk.ijse.dep.fx.controller;

import javafx.collections.FXCollections;
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
import javafx.stage.Window;
import lk.ijse.dep.fx.view.util.itemTM;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerForManageItems {
    @FXML
    private Button btnNewItem;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtItemId;
    @FXML
    private TextField txtItemName;
    @FXML
    private TextField txtUnitPrice;
    @FXML
    private TextField txtQty;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSave;
    @FXML
    private TableView<itemTM> tblItemList;

    private static ArrayList<itemTM> ItemArrayList = new ArrayList<>();


        static{
            ItemArrayList.add(new itemTM("11","coca cola","50","100"));
            ItemArrayList.add(new itemTM("12","sprite","100","200"));
            ItemArrayList.add(new itemTM("13","fanta","60","150"));

        }

    public static ArrayList<itemTM> getItems() {
        return ItemArrayList;
    }
    //  private static ObservableList<itemTM> observableList;

    public void initialize(){
        tblItemList.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemId"));
        tblItemList.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblItemList.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblItemList.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));

        ObservableList<itemTM> itemTMS = FXCollections.observableList(ItemArrayList);
        tblItemList.setItems(itemTMS);

    //    tblItemList.setItems(observableList);

    }


    @FXML
    private void Back_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/fx/view/pointOfSale.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);


    }

    @FXML
    private void itemSave_OnAction(ActionEvent actionEvent) {


        String id = txtItemId.getText();
        String name = txtItemName.getText();
        String unitprice = txtUnitPrice.getText();
        String qty = txtQty.getText();

        if(id.trim().isEmpty() || name.trim().isEmpty() || unitprice.trim().isEmpty() || qty.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Can't have blank fields", ButtonType.OK).show();

            txtItemId.setText("");
            txtItemName.setText("");
            txtUnitPrice.setText("");
            txtQty.setText("");
            txtItemId.requestFocus();

            return;
        }

        for (itemTM chekitem : ItemArrayList) {
            if(chekitem != null && chekitem.getItemId().equals(id)){
                new Alert(Alert.AlertType.ERROR,"Can not have same id",ButtonType.OK).show();
                return;
            }
        }
        ItemArrayList.add(new itemTM(id,name,unitprice,qty));
        ObservableList<itemTM> itemTMObservableList = FXCollections.observableList(ItemArrayList);
        tblItemList.setItems(itemTMObservableList);

//        observableList = FXCollections.observableList(ItemArrayList);
//        tblItemList.setItems(observableList);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Customer has succesfully added");
        alert.show();

        txtItemId.setText("");
        txtItemName.setText("");
        txtUnitPrice.setText("");
        txtQty.setText("");
        txtItemId.requestFocus();

    }

    @FXML
    private void selectItem_OnAction(MouseEvent mouseEvent) {
        txtItemId.setText(tblItemList.getSelectionModel().getSelectedItem().getItemId());
        txtItemName.setText(tblItemList.getSelectionModel().getSelectedItem().getItemName());
        txtUnitPrice.setText(tblItemList.getSelectionModel().getSelectedItem().getUnitPrice());
        txtQty.setText(tblItemList.getSelectionModel().getSelectedItem().getQty());

    }

    @FXML
    private void deleteItem(ActionEvent actionEvent) {
        itemTM selectedItem = tblItemList.getSelectionModel().getSelectedItem();
        ItemArrayList.remove(selectedItem);
        ObservableList<itemTM> itemTMObservableList = FXCollections.observableList(ItemArrayList);
        tblItemList.setItems(itemTMObservableList);
 //       observableList.remove(selectedItem);

        System.out.println("Button is working");
    }



}
