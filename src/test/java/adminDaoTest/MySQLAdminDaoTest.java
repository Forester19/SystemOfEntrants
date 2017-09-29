package adminDaoTest;

import org.junit.Assert;
import org.junit.Test;
import ua.company.epam.model.dao.impl.AdminDAO;
import ua.company.epam.model.entity.Admin;

/**
 * Created by Владислав on 22.09.2017.
 */
public class MySQLAdminDaoTest {

    @Test
    public void testInsert(){
        Admin admin = new Admin("Fase","fara");
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.insert(admin);

        Assert.assertTrue(adminDAO.getAll().size()>4);
    }

}
