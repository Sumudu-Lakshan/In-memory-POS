package lk.ijse.dep.fx.view.util;

public class systemUser {

  private String systemUsername;
  private String systemPassword;

    public systemUser(String systemUsername, String systemPassword) {
        this.setSystemUsername(systemUsername);
        this.setSystemPassword(systemPassword);
    }


    public String getSystemUsername() {
        return systemUsername;
    }

    public void setSystemUsername(String systemUsername) {
        this.systemUsername = systemUsername;
    }

    public String getSystemPassword() {
        return systemPassword;
    }

    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }
}
