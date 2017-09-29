package ua.company.epam.model.dao.mustHaveForDAO;

import java.util.List;

/**
 * Created by Владислав on 21.09.2017.
 */
public interface GenericDAO<T> {

    //create
    void insert(T object);

    //read
    T getById(int key);
    List<T> getAll();

    //update
    void update(T object);

    //delete
    void delete(T object);
}
