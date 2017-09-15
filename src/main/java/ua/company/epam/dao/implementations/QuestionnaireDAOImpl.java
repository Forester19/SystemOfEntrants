package ua.company.epam.dao.implementations;

import ua.company.epam.dao.connection.JDBCConnectionPool;
import ua.company.epam.dao.interfaces.QuestionnaireDAO;
import ua.company.epam.model.Faculty;
import ua.company.epam.model.Questionnaire;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 13.09.2017.
 */
public class QuestionnaireDAOImpl implements QuestionnaireDAO {

    private JDBCConnectionPool jdbcConnectionPool;
    private Connection connection;


    public QuestionnaireDAOImpl() {
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

    public Questionnaire create() {
        return null;
    }

    public Questionnaire read(int id) {
        return null;
    }

    public boolean checkEmail(Questionnaire questionnaire) throws SQLException {
        boolean equalsEmails = false;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select email FROM epamproject.questionnaireforadmin");
        while (rs.next()) {
            equalsEmails = questionnaire.getEmail().equals(rs.getString("email"));
        }
        return equalsEmails;
    }

    public void insert(Questionnaire questionnaire) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("INSERT INTO epamproject.questionnaireforadmin(firstName, lastName," +
                "email,faculty,mathScope,ukrainianLangScope) VALUES(?,?,?,?,?,?)");
        statement.setString(1, questionnaire.getFirstName());
        statement.setString(2, questionnaire.getLastName());
        statement.setString(3, questionnaire.getEmail());
        statement.setString(4, questionnaire.getFaculty().getName());
        statement.setInt(5, questionnaire.getMathScope());
        statement.setInt(6, questionnaire.getUkrainianLangScope());
        statement.execute();
        statement.close();


    }

    public void update(Questionnaire faculty) {

    }

    public void delete(Questionnaire faculty) {

    }

    public List<Questionnaire> getAll() throws SQLException {
        FacultiesDAOImpl facultiesDAO = new FacultiesDAOImpl();
        List<Questionnaire> list = new ArrayList<Questionnaire>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT  * FROM epamproject.questionnaireforadmin");
        while (rs.next()) {
            Faculty faculty = facultiesDAO.getByName(rs.getString("faculty"));
            Questionnaire questionnaire = new Questionnaire(rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    faculty,
                    rs.getInt("mathScope"),
                    rs.getInt("ukrainianLangScope"));
            list.add(questionnaire);
        }
        return list;
    }
}
