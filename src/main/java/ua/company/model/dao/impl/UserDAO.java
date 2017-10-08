package ua.company.model.dao.impl;

import ua.company.model.dao.genericDAO.AbstractJDBCDao;
import ua.company.model.entity.User;
import ua.company.model.entity.additional.User_Mark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 01.10.2017.
 */
public class UserDAO extends AbstractJDBCDao<User> {
    @Override
    public String getSelectQuery() {
        return "select * from epamproject.users";
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE  epamproject.users SET ";

    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getInsertQuery() {
        return "insert into epamproject.users (first_name,second_name,email, facultet_id, noted_by_admin,successful_entry) values(?,?,?,?,?,?)";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) {
        List<User> userList = new ArrayList<>();
        if (rs == null)return null;
        else {
            try {
                while (rs.next()){
                 User newUser = new User(
                         rs.getString("first_name"),
                         rs.getString("second_name"),
                         rs.getString("email"),
                         rs.getInt("facultet_id"),
                         rs.getBoolean("noted_by_admin"),
                         rs.getBoolean("successful_entry")
                 );
                 userList.add(newUser);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    protected void prepareStatemantForInsert(PreparedStatement statement, User object) {
        try {
            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getEmail());
            statement.setInt(4, object.getFaculty_id());
            statement.setBoolean(5, object.isNoted_by_admin());
            statement.setBoolean(6, object.isSuccessful_entry());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareStatemantForDelete(PreparedStatement statement, User object) {

    }

    public Integer getPKByName(String name) {
        String query = "select epamproject.users.id FROM epamproject.users WHERE first_name = ?";
        Connection connection = getConnectionFromPool();
        int id = 0;
        try {

         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1,name);
         ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public User getUserByName(String name){
        int pk = getPKByName(name);
        User user = getById(pk);
        return user;
    }
   public void addingUsersToSheetByUser(List<User> list){
        String query = getUpdateQuery();
        query += " noted_by_admin = 1 where id = ?";
       PreparedStatement preparedStatement = null;
       try(Connection connection = getConnectionFromPool()) {
       for (User user: list) {
           preparedStatement = connection.prepareStatement(query);
           preparedStatement.setInt(1, getPKByName(user.getFirstName()));
           preparedStatement.executeUpdate();
       }}
                catch (SQLException e) {
                    e.printStackTrace();
                }finally {
           try {
               preparedStatement.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
   public List<User_Mark> joinTablesUsersMarks(){
       String query = "Select * from users JOIN users_marks ON users.id = users_marks.user_id JOIN marks ON users_marks.marks_id = marks.id ORDER BY (mark_1+ mark_2 + mark_3)/3 DESC ";
       PreparedStatement preparedStatement = null;
       List<User_Mark> list = new ArrayList<>();
       ResultSet resultSet = null;
       User_Mark user_mark = null;
       try(Connection connection = getConnectionFromPool()) {
       preparedStatement = connection.prepareStatement(query);
       resultSet =preparedStatement.executeQuery();
       while (resultSet.next()){
           user_mark = new User_Mark(resultSet.getString("first_name"),
                   resultSet.getString("second_name"),
                   resultSet.getString("email"),
                   resultSet.getInt("facultet_id"),
                   resultSet.getBoolean("noted_by_admin"),
                   resultSet.getBoolean("successful_entry"),
                   resultSet.getInt("mark_1"),
                   resultSet.getInt("mark_2"),
                   resultSet.getInt("mark_3") );
           list.add(user_mark);
       }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return list;
   }

   public void markUserAsSuccessfulEntryToFaculty(User student){
       String query = "UPDATE  epamproject.users SET users.successful_entry = 1 ";
       PreparedStatement preparedStatement = null;
       try(Connection connection = getConnectionFromPool()) {
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   public List<User> getStudents(){
       String query = getSelectQuery();
       query += " where users.successful_entry = 1";
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<User> users = new ArrayList<>();
       try(Connection connection = getConnectionFromPool()) {
         preparedStatement = connection.prepareStatement(query);
         resultSet = preparedStatement.executeQuery();
       users = parseResultSet(resultSet);
       }
       catch (SQLException e) {
           e.printStackTrace();
       }finally {
           try {
               resultSet.close();
               preparedStatement.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return users;
   }

}
