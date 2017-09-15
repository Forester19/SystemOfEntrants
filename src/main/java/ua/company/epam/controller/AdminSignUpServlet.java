package ua.company.epam.controller;

import org.apache.log4j.Logger;
import ua.company.epam.dao.implementations.AdminDAOImpl;
import ua.company.epam.dao.implementations.FacultiesDAOImpl;
import ua.company.epam.model.Admin;
import ua.company.epam.model.Faculty;
import ua.company.epam.service.DBHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Владислав on 03.09.2017.
 */
@WebServlet(name = "WelcomeServlet", urlPatterns = {"/adminSignUp"})
public class AdminSignUpServlet extends HttpServlet {
    private Logger log = Logger.getRootLogger();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void destroy() {
        super.destroy();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();
        FacultiesDAOImpl facultiesDAOImpl = new FacultiesDAOImpl();

        try {
            req.setAttribute("faculties", facultiesDAOImpl.getAll());
        } catch (SQLException e) {
            log.error(e.toString());
        }
        req.getRequestDispatcher("/WEB-INF/QuestionnairePage.jsp").forward(req, resp);
        log.info("Get method of servlet..");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBHandler dbHandler = new DBHandler();
        dbHandler.executeAdminLogUp(req,resp);
    }
}
