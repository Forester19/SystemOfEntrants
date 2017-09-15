package ua.company.epam.dao.implementations;

import ua.company.epam.dao.connection.JDBCConnectionPool;
import ua.company.epam.model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 03.09.2017.
 */
public class AdminDAOImpl implements ua.company.epam.dao.interfaces.AdminDAO {

    private JDBCConnectionPool jdbcConnectionPool;
    private Connection connection;

    public AdminDAOImpl() {
        jdbcConnectionPool = JDBCConnectionPool.getInstanceConnectionPool();
        connection = jdbcConnectionPool.getConnection();
        if (connection == null) {
            System.out.println("Cant recieve connection");
        }
        jdbcConnectionPool.freeConnection(connection);


    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        jdbcConnectionPool.released();
    }
    public void insert(Object admin) throws SQLException {
        Admin admin1 = (Admin) admin;
         PreparedStatement statement = connection.prepareStatement("INSERT INTO epamproject.admins(login, password) VALUES(?,?)");
          statement.setString(1, admin1.getLogin());
          statement.setString(2, admin1.getPassword());
          statement.execute();
          statement.close();
    }
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Admin create() {
        return null;
    }

    public Admin read(int id) {
        return null;
    }

    public void update(Admin admin) {

    }

    public void delete(Admin admin) {

    }

    public List<Admin> getAll() throws SQLException {
        List<Admin> list = new ArrayList<Admin>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT  * FROM epamproject.admins");
        while (rs.next()){
            Admin admin = new Admin(rs.getString("login"),rs.getString("password"));
            list.add(admin);
        }
        return list;
    }
}
