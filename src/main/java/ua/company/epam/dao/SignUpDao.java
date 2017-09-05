package ua.company.epam.dao;

import ua.company.epam.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Владислав on 03.09.2017.
 */
public class SignUpDao implements DaoInterface{
    private Connection connection = null;

    public SignUpDao(){
    }

    public SignUpDao(Connection connection) {
        this.connection = connection;
    }

    public void update() {

    }

    public void delete() {

    }

    public void insert(User user) throws SQLException {
         PreparedStatement statement = connection.prepareStatement("INSERT INTO epamproject.signup(login, password) VALUES(?,?)");
          statement.setString(1,user.getLogin());
          statement.setString(2,user.getPassword());
          statement.execute();
          statement.close();
    }

    public void select() {

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
