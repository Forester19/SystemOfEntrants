package ua.company.model.entity;

/**
 * Created by Владислав on 03.09.2017.
 */
public class Admin implements Identified<String>{
    private String login;
    private String password;


    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Admin() {
    }

    @Override
    public String getPK() {
        return login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean equals(Admin admin) {
       if (login.equals(admin.getLogin()) && password.equals(admin.getPassword())){
           return true;
       }
       else return false;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
