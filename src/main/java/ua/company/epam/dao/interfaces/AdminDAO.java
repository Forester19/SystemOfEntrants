package ua.company.epam.dao.interfaces;

import ua.company.epam.model.Admin;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 11.09.2017.
 */
public interface AdminDAO {
    Admin create();
    Admin read(int id);
    void update(Admin admin);
    void delete(Admin admin);
    List<Admin> getAll() throws SQLException;

}
