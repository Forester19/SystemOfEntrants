package ua.company.epam.dao.interfaces;

import ua.company.epam.model.Faculty;
import ua.company.epam.model.Questionnaire;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 13.09.2017.
 */
public interface QuestionnaireDAO {
    Questionnaire create();
    Questionnaire read(int id);
    void update(Questionnaire faculty);
    void delete(Questionnaire faculty);
    List<Questionnaire> getAll() throws SQLException;

}
