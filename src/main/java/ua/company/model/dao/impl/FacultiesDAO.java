package ua.company.model.dao.impl;

import ua.company.model.dao.genericDAO.AbstractJDBCDao;
import ua.company.model.entity.Faculty;
import ua.company.model.entity.additional.FacultyAndSubjects;
import ua.company.model.entity.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 29.09.2017.
 */
public class FacultiesDAO extends AbstractJDBCDao<Faculty> {
    @Override
    public String getSelectQuery() {
        return "SELECT * FROM epamproject.faculties ";
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
    protected List<Faculty> parseResultSet(ResultSet rs) {
        List<Faculty> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Faculty faculty = new Faculty(rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("max_size"),
                        rs.getInt("subject_id_1"),
                        rs.getInt("subject_id_2"),
                        rs.getInt("subject_id_3"));


                list.add(faculty);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void prepareStatemantForInsert(PreparedStatement statement, Faculty object) {

    }

    @Override
    protected void prepareStatemantForDelete(PreparedStatement statement, Faculty object) {

    }

    public List<FacultyAndSubjects> showFacultetsAndSubjects() throws SQLException {
        FacultyAndSubjects facultyAndSubjects;
        List<FacultyAndSubjects> facultyAndSubjectss = new ArrayList<>();
        for (Faculty faculty : getAll()) {
            facultyAndSubjects = new FacultyAndSubjects();
            facultyAndSubjects.setFaculty(faculty);
            for (int i = 0; i < getAllSubjectsForOneFaculty(faculty).size(); i++) {
                facultyAndSubjects.setSubject1(getAllSubjectsForOneFaculty(faculty).get(0));
                facultyAndSubjects.setSubject2(getAllSubjectsForOneFaculty(faculty).get(1));
                facultyAndSubjects.setSubject3(getAllSubjectsForOneFaculty(faculty).get(2));
            }
            facultyAndSubjectss.add(facultyAndSubjects);
        }

        return facultyAndSubjectss;
    }

    /**
     Method returns all subject for one faculty
     * @param faculty for what returns list of subjects
     * @return
     * @throws SQLException
     */
    private List<Subject> getAllSubjectsForOneFaculty(Faculty faculty) throws SQLException {
        List<Subject> list = new ArrayList<>();
        String query = "select * FROM epamproject.subject WHERE id = " + faculty.getSubject1();
        query += " UNION ";
        query += " select * FROM epamproject.subject WHERE id = " + faculty.getSubject2();
        query += " UNION ";
        query += " select * FROM epamproject.subject WHERE id = " + faculty.getSubject3();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = getConnectionFromPool();
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            Subject subject;
            while (rs.next()) {
                subject = new Subject();
                subject.setSubjectId(rs.getInt("id"));
                subject.setSubjectTitle(rs.getString("title"));
                list.add(subject);
            }
        } finally {
         closeResources(rs,preparedStatement,connection);
        }
        return list;

    }
}
