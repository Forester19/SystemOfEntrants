package ua.company.epam.model.dao.impl;

import ua.company.epam.model.dao.mustHaveForDAO.AbstractJDBCDao;
import ua.company.epam.model.entity.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 25.09.2017.
 */
public class AdminDAO extends AbstractJDBCDao<Admin> {
    @Override
    public String getSelectQuery() {
        return "select * from epamproject.admins";
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getInsertQuery() {
        return "insert into epamproject.admins (login,password) values(?,?)";
    }

    @Override
    protected List<Admin> parseResultSet(ResultSet rs) {
        List<Admin> list = new ArrayList<>();

        try {
            while (rs.next()){
            Admin admin = new Admin();
            admin.setLogin(rs.getString("login"));
            admin.setPassword(rs.getString("password"));
            list.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    protected void prepareStatemantForInsert(PreparedStatement statement, Admin object) {
        try {
            statement.setString(1,object.getLogin());
            statement.setString(2,object.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareStatemantForDelete(PreparedStatement statement, Admin object) {
    }

}
