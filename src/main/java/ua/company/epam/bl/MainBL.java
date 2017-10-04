package ua.company.epam.bl;

import ua.company.epam.model.dao.impl.FacultiesDAO;
import ua.company.epam.model.dao.impl.UserDAO;
import ua.company.epam.model.entity.Faculty;
import ua.company.epam.model.entity.User;
import ua.company.epam.model.entity.additional.User_Mark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
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

    public void separateUsersToSuccessfulEntry(){
        Map<Faculty,List<User_Mark>> abiturients = doMappingForBL();
        Map<Faculty, List<User_Mark>> students = new HashMap<>();
        for (Faculty faculty: facultiesDAO.getAll()){
            List<User_Mark> listOfAbiturients = abiturients.get(faculty);
            List<User_Mark> listOfStudents = new ArrayList<>();
        }
    }





    /**
     Method for mapping Faculty - List of Users
     * @return Map<Faculty, List <User>>
     */
    private  Map<Faculty,List<User_Mark>> doMappingForBL(){
        List<User_Mark> markedUsers = getUsersMarkedByAdmin(userDAO.joinTablesUsersMarks());
        List<Faculty> faculties = facultiesDAO.getAll();
        Map<Faculty, List<User_Mark>> facultetUserMap = new HashMap<>();

        List<User_Mark> userBySomeFaculty= null;
        for(Faculty faculty: faculties){
            userBySomeFaculty = new ArrayList<>();
            for (User_Mark user: markedUsers){
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
    private List<User_Mark> getUsersMarkedByAdmin(List<User_Mark> allUsers){
        List<User_Mark> markedUsers = new ArrayList<>();
        for (User_Mark user: allUsers){
            if (user.isNoted_by_admin()){
                markedUsers.add(user);
            }
        }
        return markedUsers;
    }
}
