package ua.company.controller.command.impl;

import ua.company.controller.command.GenericCommand.CommandOriginal;
import ua.company.model.dao.impl.FacultiesDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Владислав on 29.09.2017.
 */
public class RegistrationByUser implements CommandOriginal {
    private FacultiesDAO facultiesDAO = new FacultiesDAO();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("facultetsAndSubjets", facultiesDAO.showFacultetsAndSubjects());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("WEB-INF/jsp/QuestionnairePage.jsp").forward(req,resp);

    }

}
