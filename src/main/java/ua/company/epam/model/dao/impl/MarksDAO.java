package ua.company.epam.model.dao.impl;

import ua.company.epam.model.dao.genericDAO.AbstractJDBCDao;
import ua.company.epam.model.entity.Marks;
import ua.company.epam.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 01.10.2017.
 */
public class MarksDAO extends AbstractJDBCDao<Marks> {
    @Override
    public String getSelectQuery() {
        return "select * from epamproject.marks";
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
        return "insert into epamproject.marks (mark_1,mark_2,mark_3) values(?,?,?)";
    }

    @Override
    protected List<Marks> parseResultSet(ResultSet rs) {
        List<Marks> marksList = new ArrayList<>();
            try {
                while (rs.next()){
                    Marks marks = new Marks();
                    marks.setMark_1(rs.getInt("mark_1"));
                    marks.setMark_2(rs.getInt("mark_2"));
                    marks.setMark_3(rs.getInt("mark_3"));
                  marksList.add(marks);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return marksList;
    }

    @Override
    protected void prepareStatemantForInsert(PreparedStatement statement, Marks object) {
        try {
            statement.setInt(1, object.getMark_1());
            statement.setInt(2, object.getMark_2());
            statement.setInt(3, object.getMark_3());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void prepareStatemantForDelete(PreparedStatement statement, Marks object) {

    }
    public Integer getPKByFirstMark(int mark) {
        String query = "select epamproject.marks.id FROM epamproject.marks WHERE epamproject.marks.mark_1 = ?";
        Connection connection = getConnectionFromPool();
        int id = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,mark);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public Marks getMarksByUser(User user) throws SQLException {
       UserDAO userDAO = new UserDAO();
       MarksDAO marksDAO = new MarksDAO();
        String query = "SELECT epamproject.users_marks.marks_id FROM users_marks WHERE user_id = ?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

         Marks marks = null;

        try(   Connection connection = getConnectionFromPool()) {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userDAO.getPKByName(user.getFirstName()));
            rs = preparedStatement.executeQuery();
           while (rs.next()) {
               int marks_id = rs.getInt("marks_id");
               marks = marksDAO.getById(marks_id);
           }
        }
        finally {
            rs.close();
            preparedStatement.close();
        }
        return marks;
    }
}
