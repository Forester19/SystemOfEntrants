package ua.company.epam.controller.command.impl;

import ua.company.epam.controller.command.CommandOriginal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Владислав on 29.09.2017.
 */
public class AdminSignUpCommandOriginal implements CommandOriginal {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.getRequestDispatcher("WEB-INF/jsp/AdminPage.jsp").forward(req,resp);
    }
}
