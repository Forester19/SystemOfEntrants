package ua.company.bl;

import ua.company.model.dao.impl.FacultiesDAO;
import ua.company.model.dao.impl.UserDAO;
import ua.company.model.entity.Faculty;
import ua.company.model.entity.User;
import ua.company.model.entity.additional.User_Mark;

import java.util.*;

/**
 * Created by Владислав on 03.10.2017.
 */
public class MainBL {
    private FacultiesDAO facultiesDAO = new FacultiesDAO();
    private UserDAO userDAO = new UserDAO();


    public List<User> getStudents(){
        return userDAO.getStudents();
    }
    /**
     * Method which control users and separate who entry to faculty successful.
     * @return Map faculty - List of users who entry to faculty successful.
     */
    public Map<Faculty, List<User>>  markUserAsStudent(){
        Map<Faculty, List<User_Mark>> map  =  separateUsersToSuccessfulEntry();

        Set<Faculty> facultySet = map.keySet();
        Map<Faculty, List<User>> newMap = new HashMap<>();
        for (Faculty faculty: facultySet){
            List<User_Mark> listUserMark = map.get(faculty);
            List<User> listUser = new ArrayList<>();
            for (User_Mark user_mark: listUserMark){
                listUser.add(userDAO.getUserByName(user_mark.getFirstName()));
            }
            for (User user : listUser){
                userDAO.markUserAsSuccessfulEntryToFaculty(user);
            }
            newMap.put(faculty,listUser);
        }
        return newMap;
    }


    public Map<Faculty, List<User_Mark>> getUsersWhichSuccessfulEntry(){
        return separateUsersToSuccessfulEntry();
    }

    private Map<Faculty, List<User_Mark>> separateUsersToSuccessfulEntry(){
        Map<Faculty,List<User_Mark>> abiturients = doMappingForBL();
        Set<Faculty> facultySet = abiturients.keySet();
        Map<Faculty, List<User_Mark>> students = new HashMap<>();
        for (Faculty faculty: facultySet){
            List<User_Mark> listOfAbiturients = abiturients.get(faculty);
            List<User_Mark> listOfStudents = new ArrayList<>();
            if (listOfAbiturients.size()<faculty.getMaxCountOfStudents()){
                for (int i=0; i<listOfAbiturients.size(); i++){
                    listOfStudents.add(listOfAbiturients.get(i));
                }
            }else {
                for (int i=0; i<faculty.getMaxCountOfStudents(); i++){
                    listOfStudents.add(listOfAbiturients.get(i));
                }
            }

            students.put(faculty, listOfStudents);
        }
        return students;
    }
    /**
     Method for mapping Faculty - List of Users
     * @return Map<Faculty, List <User>>
     */
    public   Map<Faculty,List<User_Mark>> doMappingForBL(){
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
