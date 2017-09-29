package ua.company.epam.controller;

import ua.company.epam.controller.command.CommandOriginal;
import ua.company.epam.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Владислав on 25.09.2017.
 */
@WebServlet(name = "DefaultServlet", urlPatterns = {"/controller", "/adminSignUp"})
public class DefaultServlet extends HttpServlet {
    private CommandProvider commandProvider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     process(req,resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        if (commandName == null) {
            commandName = (String) req.getAttribute("command");
        }
        CommandOriginal commandOriginal = commandProvider.getCommand(commandName);
        commandOriginal.execute(req, resp);
    }

}
