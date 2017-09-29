package ua.company.epam.model.dao.connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Владислав on 03.09.2017.
 */
class DBPropertiesManager {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.db.db");

    DBPropertiesManager() throws FileNotFoundException {
    }

    String getPropertiesDB(String key) throws IOException {
        return resourceBundle.getString(key);
    }

}
