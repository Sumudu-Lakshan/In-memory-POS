package lk.ijse.dep.fx.view.util;

import javafx.scene.control.Button;

public class adminUser {

    private String adminUser;
    private String adminPassword;
    private javafx.scene.control.Button delete;

    public adminUser(String adminUser, String adminPassword) {
        this.adminUser = adminUser;
        this.adminPassword = adminPassword;
    }

    public adminUser(String adminUser, String adminPassword,javafx.scene.control.Button delete) {
        this.adminUser = adminUser;
        this.adminPassword = adminPassword;
        this.delete = delete;
    }

    public javafx.scene.control.Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
