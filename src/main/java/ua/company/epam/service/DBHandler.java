package ua.company.epam.service;

import org.apache.log4j.Logger;
import ua.company.epam.dao.implementations.AdminDAOImpl;
import ua.company.epam.dao.implementations.FacultiesDAOImpl;
import ua.company.epam.dao.implementations.QuestionnaireDAOImpl;
import ua.company.epam.model.Admin;
import ua.company.epam.model.Faculty;
import ua.company.epam.model.Questionnaire;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Владислав on 13.09.2017.
 */
public class DBHandler {
    private Logger log = Logger.getRootLogger();

    /**
     * Method is handler of registration entrance
     *
     * @param req  Standard request
     * @param resp
     * @throws ServletException method will calls in servlet
     * @throws IOException      Using PrintWriter here
     */
    public void executeQuestionnaireForAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        FacultiesDAOImpl facultiesDAO = new FacultiesDAOImpl();
        QuestionnaireDAOImpl questionnaireDAO = new QuestionnaireDAOImpl();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        String faculty = req.getParameter("facultet");
        Faculty faculty1 = null;
        String mathScope = req.getParameter("mathScope");
        String langScope = req.getParameter("langScope");

        try {
            faculty1 = facultiesDAO.getByName(faculty);
            Questionnaire questionnaire = new Questionnaire(firstName, lastName, email, faculty1, Integer.valueOf(mathScope), Integer.valueOf(langScope));

            if (questionnaireDAO.checkEmail(questionnaire)) {
                req.getRequestDispatcher("/WEB-INF/ExistUserPage.jsp").forward(req, resp);
            } else {
                questionnaireDAO.insert(questionnaire);

                PrintWriter out = resp.getWriter();
                out.write("<H1>Registration success!! Wait massage on your email;)</H1>");
                 log.info("Wrote to DB new questionnaire:  " + questionnaire.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
             log.error("Sql exception in questionnaire handling  " + e.getMessage());
        }

    }

    private static Admin adminWhoOnPage;                                    //Info about admin for log4j from other servlet

    public static Admin getAdminWhoOnPage() {                               //Info about admin for log4j from other servlet
        return adminWhoOnPage;
    }


    public void executeAdminLogUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Admin admin = new Admin(login, password);
        AdminDAOImpl adminDAOImpl = new AdminDAOImpl();
        log.info("Admin for equals...");
        boolean isAdmin = false;
        try {
            for (Admin admin1 : adminDAOImpl.getAll()) {
                if (admin.equals(admin1)) {
                    adminWhoOnPage = admin1;
                    req.setAttribute("questionnaire", new QuestionnaireDAOImpl().getAll());
                    req.setAttribute("admin", admin.getLogin());
                    req.getRequestDispatcher("/WEB-INF/AdminPage.jsp").forward(req, resp);
                    log.info(admin.toString() + " indenteficated...");
                   isAdmin= true;
                }
                else isAdmin = false;
            }
            if (!isAdmin){
                PrintWriter out = resp.getWriter();
                out.write("<h2>Hey you is't admin!</h2>");

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addingToSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String questionnaire = req.getParameter("questionnaire");
     PrintWriter pw = resp.getWriter();
     pw.print("hell");
     pw.print(questionnaire);
    }


}
