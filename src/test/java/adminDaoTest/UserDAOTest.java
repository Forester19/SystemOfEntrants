package adminDaoTest;

import org.junit.Assert;
import org.junit.Test;
import ua.company.epam.model.dao.impl.UserDAO;

/**
 * Created by Владислав on 02.10.2017.
 */
public class UserDAOTest {

    @Test
    public void testGetIdBYName(){
        UserDAO userDAO = new UserDAO();
        int id = userDAO.getPKByName("Vdvor");
        Assert.assertEquals(id,20);
    }
}
