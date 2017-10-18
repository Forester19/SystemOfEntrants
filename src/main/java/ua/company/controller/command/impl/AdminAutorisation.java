package ua.company.controller.command.impl;

import com.sun.corba.se.impl.activation.CommandHandler;
import org.apache.log4j.Logger;
import ua.company.controller.command.GenericCommand.CommandOriginal;
import ua.company.model.dao.impl.AdminDAO;
import ua.company.model.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 16.10.2017.
 */
public class AdminAutorisation implements CommandOriginal {
    private AdminDAO adminDAO = new AdminDAO();
    private Logger log = Logger.getRootLogger();

    private static final String path = "/WEB-INF/jsp/AdminPage.jsp";
    private static final String pathError = "/WEB-INF/jsp/BadWayVerifAdmin.jsp";


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        Admin admin = new Admin(login, pass);
        boolean checkAdmin = false;

        List<Admin> list = adminDAO.getAll();
        List<Admin> listOfLoginsWichEqualsAdmin = new ArrayList<>();
        for (Admin adminFromDB : list) {
            if (adminFromDB.getLogin().equals(admin.getLogin())) {
                listOfLoginsWichEqualsAdmin.add(admin);
            }
        }
        for (Admin Admins : listOfLoginsWichEqualsAdmin) {
            if (Admins.getPassword().equals(admin.getPassword())) {
                checkAdmin = true;
            } else {
                checkAdmin = false;
            }
        }
        if (checkAdmin) {
            req.setAttribute("admin", admin.getLogin());
            req.getRequestDispatcher("/WEB-INF/jsp/AdminPage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/BadWayVerifAdmin.jsp").forward(req, resp);

        }


    }
}
