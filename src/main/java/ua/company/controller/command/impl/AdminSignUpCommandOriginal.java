package ua.company.controller.command.impl;

import org.apache.log4j.Logger;
import ua.company.controller.command.GenericCommand.CommandOriginal;
import ua.company.model.dao.impl.AdminDAO;
import ua.company.model.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Владислав on 29.09.2017.
 */
public class AdminSignUpCommandOriginal implements CommandOriginal {
    private static  final String path ="WEB-INF/jsp/AdminPage.jsp";
    private static  final String pathError ="WEB-INF/jsp/BadWayVerifAdmin.jsp";

    private Logger log = Logger.getRootLogger();

    private AdminDAO adminDAO = new AdminDAO();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      adminsVerificationHttpServletRequest(req,resp);

    }

    /**
     * Method for verification admin in system
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void adminsVerificationHttpServletRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
      String login = req.getParameter("login");
      String pass = req.getParameter("password");
      Admin admin = new Admin(login,pass);
      boolean checkAdmin = false;

      List<Admin> list = adminDAO.getAll();
        for (Admin admin1: list){
            if (admin1.equals(admin)){
                log.info("Verificated admin: "  + admin.getLogin());
                req.setAttribute("admin", admin.getLogin());
                req.getRequestDispatcher(path).forward(req,resp);
           checkAdmin = true;
            }
            if (!checkAdmin) req.getRequestDispatcher(pathError).forward(req,resp);


        }
    }
}
