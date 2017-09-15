package ua.company.epam.dao.implementations;

import ua.company.epam.dao.connection.JDBCConnectionPool;
import ua.company.epam.dao.interfaces.FacultyDAO;
import ua.company.epam.model.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 11.09.2017.
 */
public class FacultiesDAOImpl implements FacultyDAO {
    private JDBCConnectionPool jdbcConnectionPool;
    private Connection connection;


    public FacultiesDAOImpl() {
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

    public void update() {

    }

    public void delete() {

    }

    public Faculty getByName(String name) throws SQLException {

        Statement statement = connection.createStatement();
        String selectFaculty ="Select description, maxCountOfStudents FROM faculties WHERE description like "+ "'"+name+"'";

        ResultSet rs = statement.executeQuery(selectFaculty);
        Faculty faculty = null;
        while (rs.next()) {
            String descr = rs.getString("description");
            int count = rs.getInt("maxCountOfStudents");
            faculty = new Faculty(descr,count);
        }
        return faculty;
    }

    public void insert(Object object) throws SQLException {
        Faculty faculty = (Faculty) object;
        PreparedStatement statement = connection.prepareStatement("INSERT INTO epamproject.faculties(description, maxCountOfStudents) VALUES(?,?)");
        statement.setString(1, faculty.getName());
        statement.setInt(2, faculty.getMaxCountOfStudents());
        statement.execute();
        statement.close();

    }

    public void select() {

    }

    public Faculty create() {
        return null;
    }

    public Faculty read(int id) {
        return null;
    }

    public void update(Faculty faculty) {

    }

    public void delete(Faculty faculty) {

    }

    public List<Faculty> getAll() throws SQLException {
        List<Faculty> list = new ArrayList<Faculty>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT  * FROM epamproject.faculties");
        while (rs.next()) {
            Faculty faculty = new Faculty(rs.getString("description"), rs.getInt("maxCountOfStudents"));
            list.add(faculty);
        }
        return list;
    }
}
