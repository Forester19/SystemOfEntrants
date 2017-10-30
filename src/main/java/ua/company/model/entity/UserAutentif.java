package ua.company.model.entity;

/**
 * Created by Владислав on 25.10.2017.
 */
public class UserAutentif {
    private int id;
    private String login;
    private String password;
    private int user_id;

    public UserAutentif(String login, String password, int user_id) {
        this.login = login;
        this.password = password;
        this.user_id = user_id;
    }

    public UserAutentif() {
    }

    public UserAutentif(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserAutentif(int id, String login, String password, int user_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserAutentif{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
