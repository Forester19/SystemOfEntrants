package ua.company.model.dao.impl;

import ua.company.model.dao.genericDAO.AbstractJDBCDao;
import ua.company.model.entity.Marks;
import ua.company.model.entity.User;

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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = 0;
        try {
            connection = getConnectionFromPool();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,mark);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeResources(resultSet,preparedStatement,connection);
        }
        return id;
    }
    public Marks getMarksByUser(User user) throws SQLException {
       UserDAO userDAO = new UserDAO();
       MarksDAO marksDAO = new MarksDAO();
        String query = "SELECT epamproject.users_marks.marks_id FROM users_marks WHERE user_id = ?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
         Marks marks = null;

        try{
            connection = getConnectionFromPool();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userDAO.getPKByName(user.getFirstName()));
            rs = preparedStatement.executeQuery();
           while (rs.next()) {
               int marks_id = rs.getInt("marks_id");
               marks = marksDAO.getById(marks_id);
           }
        }
        finally {
         closeResources(rs,preparedStatement,connection);
         }
        return marks;
    }

    /**
     * Method which doing mapping in DB
     * @param marks object which persist in DB
     * @return id of object
     */
    public int persist(Marks marks){
          int id = 0;
          String sqlQuery = "select epamproject.marks.id FROM marks where mark_1 = ? AND mark_2 = ? AND marks.mark_3 = ?";
        Connection connection = null;
          PreparedStatement preparedStatement = null;
          ResultSet resultSet = null;
          try{
              connection = getConnectionFromPool();
              preparedStatement = connection.prepareStatement(sqlQuery);
              preparedStatement.setInt(1, marks.getMark_1());
              preparedStatement.setInt(2, marks.getMark_2());
              preparedStatement.setInt(3, marks.getMark_3());
              resultSet = preparedStatement.executeQuery();

              while (resultSet.next()){
                  id = resultSet.getInt("id");
              }
          } catch (SQLException e) {
        e.printStackTrace();
          }
          return id;
    }
}
