package ua.company.epam.controller;

import org.apache.log4j.Logger;
import ua.company.epam.dao.implementations.FacultiesDAOImpl;
import ua.company.epam.dao.implementations.QuestionnaireDAOImpl;
import ua.company.epam.model.Faculty;
import ua.company.epam.model.Questionnaire;
import ua.company.epam.service.DBHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Владислав on 13.09.2017.
 */
@WebServlet(name = "QuestionnairePageServlet", urlPatterns = {"/questionareAction"})

public class QuestionnairePageServlet extends HttpServlet {

    private Logger log = Logger.getRootLogger();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBHandler dbHandler = new DBHandler();
        dbHandler.executeQuestionnaireForAdmin(req,resp);
        //Questionnaire questionnaire = new Questionnaire();
    }

}
