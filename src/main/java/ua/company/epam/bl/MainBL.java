package ua.company.epam.bl;

import ua.company.epam.model.dao.impl.FacultiesDAO;
import ua.company.epam.model.dao.impl.UserDAO;
import ua.company.epam.model.entity.Faculty;
import ua.company.epam.model.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Владислав on 03.10.2017.
 */
public class MainBL {
    private FacultiesDAO facultiesDAO = new FacultiesDAO();
    private UserDAO userDAO = new UserDAO();

   public void sortUserInFaculties(){

       Map<Faculty,List<User>> map = doMainBL();
   }



    public Map<Faculty,List<User>> doMainBL(){
        List<User> markedUsers = getUsersMarkedByAdmin(userDAO.getAll());
        List<Faculty> faculties = facultiesDAO.getAll();
        Map<Faculty, List<User>> facultetUserMap = new HashMap<>();

        List<User> userBySomeFaculty= null;
        for(Faculty faculty: faculties){
            userBySomeFaculty = new ArrayList<>();
            for (User user: markedUsers){
                if (user.getFaculty_id() == faculty.getPK()){
                    userBySomeFaculty.add(user);
                }
                facultetUserMap.put(faculty,userBySomeFaculty);
            }
        }
        return facultetUserMap;
    }

    /**
     * Method witch separate all users to marked users by admin;
     * @param allUsers
     * @return
     */
    private List<User> getUsersMarkedByAdmin(List<User> allUsers){
        List<User> markedUsers = new ArrayList<>();
        for (User user: allUsers){
            if (user.isNoted_by_admin()){
                markedUsers.add(user);
            }
        }
        return markedUsers;
    }
}
