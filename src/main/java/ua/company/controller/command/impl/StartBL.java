package ua.company.controller.command.impl;

import ua.company.bl.MainBL;
import ua.company.controller.command.GenericCommand.CommandOriginal;
import ua.company.model.dao.impl.FacultiesDAO;
import ua.company.model.entity.Faculty;
import ua.company.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
               httpRequest.getRequestDispatcher("WEB-INF/jsp/SuccessfulResultBL.jsp").forward(httpRequest,httpResponse);

    }


}
