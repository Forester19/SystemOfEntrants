package ua.company.model.dao.impl;

import ua.company.model.dao.genericDAO.AbstractJDBCDao;
import ua.company.model.entity.UserAutentif;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 25.10.2017.
 */
public class UserAutentifDAO extends AbstractJDBCDao<UserAutentif> {
    @Override
    public String getSelectQuery() {
        return null;
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
        return "insert into epamproject.userautentif values(?,?,?,?)";
    }

    @Override
    protected List<UserAutentif> parseResultSet(ResultSet rs) {
        return null;
    }

    @Override
    protected void prepareStatemantForInsert(PreparedStatement statement, UserAutentif object) {
        try {
            statement.setString(1,null);
            statement.setString(2,object.getLogin());
            statement.setString(3,object.getPassword());
            statement.setString(4,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareStatemantForDelete(PreparedStatement statement, UserAutentif object) {

    }
    protected void search(){

    }
}
