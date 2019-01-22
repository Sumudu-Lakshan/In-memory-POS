package lk.ijse.dep.fx.view.util;

public class UserDetails {

    private String usename;
    private String password;

    public UserDetails(String usename, String password) {
        this.setUsename(usename);
        this.setPassword(password);
    }


    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
