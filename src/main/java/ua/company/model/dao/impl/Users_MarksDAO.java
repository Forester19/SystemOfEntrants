package ua.company.model.dao.impl;

import ua.company.model.dao.genericDAO.AbstractJDBCDao;
import ua.company.model.entity.Users_Marks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 02.10.2017.
 */
public class Users_MarksDAO extends AbstractJDBCDao<Users_Marks> {
    @Override
    public String getSelectQuery() {
        return "select * from epamproject.users_marks";
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
        return "insert into epamproject.users_marks(user_id,marks_id) values(?,?)";
    }

    @Override
    protected List<Users_Marks> parseResultSet(ResultSet rs) {
        return null;
    }

    @Override
    protected void prepareStatemantForInsert(PreparedStatement statement, Users_Marks object) {
        try {
            statement.setInt(1,object.getUser_id());
            statement.setInt(2,object.getMarks_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareStatemantForDelete(PreparedStatement statement, Users_Marks object) {

    }
}
