package ua.company.epam.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Владислав on 03.09.2017.
 */
class DBPropertiesManager {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.DBconfig");

    DBPropertiesManager() throws FileNotFoundException {
    }

    String getPropertiesDB(String key) throws IOException {
        return resourceBundle.getString(key);
    }

}
