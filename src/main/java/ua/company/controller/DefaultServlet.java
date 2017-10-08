package ua.company.controller;

import org.apache.log4j.Logger;
import ua.company.controller.command.GenericCommand.CommandOriginal;
import ua.company.controller.command.GenericCommand.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Владислав on 25.09.2017.
 */
@WebServlet(name = "DefaultServlet", urlPatterns = {"/controller", "/adminSignUp","/usersRegistration","/usersForm","/adminAddQuestionnaireToSheet",
"/startBL","/MailFormк"})
public class DefaultServlet extends HttpServlet {

    private Logger logger = Logger.getRootLogger();
    private final static String COMMAND_STRING =  "command";

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
        String commandName = req.getParameter(COMMAND_STRING);
        if (commandName == null) {
            commandName = (String) req.getAttribute(COMMAND_STRING);
        }
        logger.info("handling query from client:  " + commandName);
        CommandOriginal commandOriginal = commandProvider.getCommand(commandName);
        commandOriginal.execute(req, resp);
    }

}
