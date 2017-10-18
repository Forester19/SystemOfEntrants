package adminDaoTest;

import org.junit.Assert;
import org.junit.Test;
import ua.company.model.dao.impl.AdminDAO;

/**
 * Created by Владислав on 17.10.2017.
 */
public class AdminDAOTest {
    private AdminDAO adminDAO = new AdminDAO();

    @Test
    public void testAllAdmins(){
        Assert.assertEquals(adminDAO.getAll().size(),3);

    }
}
