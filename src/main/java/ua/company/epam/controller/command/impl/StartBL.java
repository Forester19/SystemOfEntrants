package ua.company.epam.controller.command.impl;

import ua.company.epam.bl.MainBL;
import ua.company.epam.controller.command.GenericCommand.CommandOriginal;
import ua.company.epam.model.dao.impl.FacultiesDAO;
import ua.company.epam.model.entity.Faculty;
import ua.company.epam.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by Владислав on 03.10.2017.
 */
public class StartBL implements CommandOriginal {

    private MainBL mainBL = new MainBL();
    private FacultiesDAO facultiesDAO = new FacultiesDAO();
    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {

        Map<Faculty, List<User>> map =  mainBL.markUserAsStudent();
               httpRequest.setAttribute("students",map);
               httpRequest.getRequestDispatcher("WEB-INF/jsp/Students.jsp").forward(httpRequest,httpResponse);

    }


}
