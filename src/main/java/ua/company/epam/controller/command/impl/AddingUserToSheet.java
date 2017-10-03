package ua.company.epam.controller.command.impl;

import ua.company.epam.controller.command.GenericCommand.CommandOriginal;
import ua.company.epam.model.dao.impl.UserDAO;
import ua.company.epam.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 03.10.2017.
 */
public class AddingUserToSheet implements CommandOriginal {
    private UserDAO userDAO = new UserDAO();

    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
     List<User> list = executionOfInformation(httpRequest,httpResponse);
     userDAO.addingUsersToSheetByUser(list);
     httpRequest.getRequestDispatcher("WEB-INF/jsp/AdminPage.jsp").forward(httpRequest,httpResponse);


    }

    private List<User> executionOfInformation(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        List<User> listUser = new ArrayList<>();
        String[] nameOfUsers = httpRequest.getParameterValues("noting");

        for (String s:nameOfUsers) {
            listUser.add(userDAO.getUserByName(s));
        }
        return listUser;
    }

}
