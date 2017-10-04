package ua.company.epam.controller.command.impl;

import ua.company.epam.controller.command.GenericCommand.CommandOriginal;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Владислав on 04.10.2017.
 */
public class MailServlet implements CommandOriginal {
    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        Properties properties = new Properties();
        ServletContext servletContext = httpRequest.getServletContext();
        String fileName =  servletContext.getInitParameter("mail");
        properties.load(servletContext.getResourceAsStream(fileName));

    }
}
