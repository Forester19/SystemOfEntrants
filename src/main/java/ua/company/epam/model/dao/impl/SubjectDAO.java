package ua.company.epam.model.dao.impl;

import ua.company.epam.model.dao.genericDAO.AbstractJDBCDao;
import ua.company.epam.model.entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 30.09.2017.
 */
public class SubjectDAO extends AbstractJDBCDao<Subject> {
    @Override
    public String getSelectQuery() {
        return "Select * from epamproject.subject";
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
    protected List<Subject> parseResultSet(ResultSet rs) {
        List<Subject> list = new ArrayList<>();
        try {
            while (rs.next()){
            Subject subject = new Subject();
            subject.setSubjectId(rs.getInt("subject_id"));
            subject.setSubjectTitle(rs.getString("subject_title"));
            list.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void prepareStatemantForInsert(PreparedStatement statement, Subject object) {

    }

    @Override
    protected void prepareStatemantForDelete(PreparedStatement statement, Subject object) {

    }

}
