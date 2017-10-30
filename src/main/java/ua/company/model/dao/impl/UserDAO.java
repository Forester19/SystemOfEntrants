package ua.company.model.dao.impl;

import ua.company.model.dao.genericDAO.AbstractJDBCDao;
import ua.company.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Владислав on 28.10.2017.
 */
public class UserDAO extends AbstractJDBCDao<User> {
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
        return null;
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) {
        return null;
    }

    @Override
    protected void prepareStatemantForInsert(PreparedStatement statement, User object) {

    }

    @Override
    protected void prepareStatemantForDelete(PreparedStatement statement, User object) {

    }
}
