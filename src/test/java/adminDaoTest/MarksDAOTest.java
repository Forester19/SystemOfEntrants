package adminDaoTest;

import org.junit.Assert;
import org.junit.Test;
import ua.company.model.dao.impl.MarksDAO;
import ua.company.model.dao.impl.UserDAO;
import ua.company.model.entity.Marks;
import ua.company.model.entity.User;

import java.sql.SQLException;

/**
 * Created by Владислав on 03.10.2017.
 */
public class MarksDAOTest {
    @Test
    public void getMarksByUserTest(){
        MarksDAO marksDAO = new MarksDAO();
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getById(25);

        System.out.println(user.getFirstName());
        Marks marks = null;
       try {
            marks = marksDAO.getMarksByUser(user);
            Assert.assertEquals(124, marks.getMark_1());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
