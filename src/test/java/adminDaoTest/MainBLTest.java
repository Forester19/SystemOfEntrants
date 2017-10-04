package adminDaoTest;

import org.junit.Assert;
import org.junit.Test;
import ua.company.epam.bl.MainBL;
import ua.company.epam.model.entity.Faculty;
import ua.company.epam.model.entity.additional.User_Mark;

import java.util.List;
import java.util.Map;

/**
 * Created by Владислав on 04.10.2017.
 */
public class MainBLTest {
    private MainBL mainBL = new MainBL();
    @Test
    public void separateUsersToSuccessfulEntryTest(){
     /*   Map<Faculty, List<User_Mark>> map = mainBL.separateUsersToSuccessfulEntry();
        Assert.assertTrue(map.size()>4);
    */}
}
