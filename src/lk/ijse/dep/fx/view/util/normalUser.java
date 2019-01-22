package lk.ijse.dep.fx.view.util;

import javafx.scene.control.Button;

public class normalUser {

    private String normalUsername;
    private String normalUserPassword;
    Button delete;

    public normalUser(String normalUsername, String normalUserPassword, Button delete) {
        this.normalUsername = normalUsername;
        this.normalUserPassword = normalUserPassword;
        this.delete = delete;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public String getNormalUsername() {
        return normalUsername;
    }

    public void setNormalUsername(String normalUsername) {
        this.normalUsername = normalUsername;
    }

    public String getNormalUserPassword() {
        return normalUserPassword;
    }

    public void setNormalUserPassword(String normalUserPassword) {
        this.normalUserPassword = normalUserPassword;
    }
}
