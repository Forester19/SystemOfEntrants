package ua.company.epam.controller.command.impl;

import ua.company.epam.controller.command.GenericCommand.CommandOriginal;
import ua.company.epam.model.dao.impl.UserDAO;
import ua.company.epam.model.dao.impl.MarksDAO;
import ua.company.epam.model.dao.impl.Users_MarksDAO;
import ua.company.epam.model.entity.Marks;
import ua.company.epam.model.entity.User;
import ua.company.epam.model.entity.Users_Marks;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Владислав on 01.10.2017.
 */
public class ExecutionFormByUser implements CommandOriginal {
    private UserDAO userDAO = new UserDAO();
    private MarksDAO _marksDAO = new MarksDAO();
    private Users_MarksDAO users_marksDAO = new Users_MarksDAO();

    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        executionFormFromUser(httpRequest, httpResponse);
    }

    private void executionFormFromUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        int facultetId = Integer.parseInt(req.getParameter("mySelect"));


        int mark1 = Integer.parseInt(req.getParameter("mark1"));
        int mark2 = Integer.parseInt(req.getParameter("mark2"));
        int mark3 = Integer.parseInt(req.getParameter("mark3"));

        User user = new User(firstName, lastName, email, facultetId, false, false);
        Marks marks = new Marks(mark1,mark2,mark3);

        boolean canInsert = true;
        for (User userFromDB:  userDAO.getAll()){
            if (user.equals(userFromDB) || user.getEmail().isEmpty())canInsert = false;
        }

        if (userDAO.getAll() != null){
           if(canInsert){
               redirection(user,marks,req,resp);
               insertInUsers_MarksDB(user,marks);
           }else{
               req.getRequestDispatcher("WEB-INF/jsp/ErrorExistUserPage.jsp").forward(req,resp);

           }

        }else{
          redirection(user,marks, req,resp);
          insertInUsers_MarksDB(user,marks);
        }


    }

    private void redirection(User user, Marks marks, HttpServletRequest req, HttpServletResponse resp) {
        _marksDAO.insert(marks);
        userDAO.insert(user);
        try {
            req.getRequestDispatcher("WEB-INF/jsp/SuccessfulRegistration.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void insertInUsers_MarksDB(User user, Marks marks){
        Users_Marks users_marks = new Users_Marks(userDAO.getPKByName(user.getFirstName()), _marksDAO.getPKByFirstMark(marks.getMark_1()));
        users_marksDAO.insert(users_marks);
    }


}
