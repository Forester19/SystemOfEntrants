package ua.company.epam.dao;

import ua.company.epam.model.User;

import java.sql.SQLException;

/**
 * Created by Владислав on 03.09.2017.
 */
public interface DaoInterface {
    void update();
    void delete();
    void insert(User user) throws SQLException;
    void select();
}
