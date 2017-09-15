package ua.company.epam.controller;

import org.apache.log4j.Logger;
import ua.company.epam.dao.implementations.FacultiesDAOImpl;
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
import java.sql.SQLException;

/**
 * Created by Владислав on 11.09.2017.
 */

@WebServlet(name = "AdminPageServlet", urlPatterns = {"/adminPageAddFaculty","/adminAddQuestionnaireToSheet"})

public class AdminPageServlet extends HttpServlet {
    private Logger log = Logger.getRootLogger();
    private FacultiesDAOImpl facultiesDAOImpl;
    private DBHandler dbHandler;
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
        dbHandler = new DBHandler();
        dbHandler.addingToSheet(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        int max = Integer.parseInt(req.getParameter("maxCount"));
        Faculty faculty = new Faculty(description,max);
        facultiesDAOImpl = new FacultiesDAOImpl();
        try {
            facultiesDAOImpl.insert(faculty);
            log.info("Insert into faculties.db " +faculty.getName() + "  by admin: " + DBHandler.getAdminWhoOnPage()  );
        } catch (SQLException e) {
            log.error("Cant insert into db.faculties new faculty" + faculty.getName());
        }
    }
}
