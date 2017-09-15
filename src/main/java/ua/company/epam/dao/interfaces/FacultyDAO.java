package ua.company.epam.dao.interfaces;

import ua.company.epam.model.Faculty;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 11.09.2017.
 */
public interface FacultyDAO {
    Faculty create();
    Faculty read(int id);
    void update(Faculty faculty);
    void delete(Faculty faculty);
    List<Faculty> getAll() throws SQLException;
}
