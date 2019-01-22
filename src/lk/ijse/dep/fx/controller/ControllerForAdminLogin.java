package lk.ijse.dep.fx.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.dep.fx.view.util.adminUser;

import java.util.ArrayList;

public class ControllerForAdminLogin {
    public TextField txtadminUsername;
    public TextField txtadminPassword;
    public TextField txtNormalUsername;
    public TextField txtNormalPassword;
    public Button btnNewUser;
    public Button btnAdminSave;
    public Button btnNormalSave;
    public Button btnNewAdmin;

    public static ArrayList<adminUser> adminUsers = new ArrayList<>();
    static {
        adminUsers.add(new adminUser("admin","admin"));

    }

}
