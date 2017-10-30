package ua.company.controller.command.impl;

import ua.company.controller.command.GenericCommand.CommandOriginal;
import ua.company.model.dao.genericDAO.GenericDAO;
import ua.company.model.entity.UserAutentif;
import ua.company.validation.AbstractValidator;
import ua.company.validation.registration.ConfirmPassValidator;
import ua.company.validation.registration.LoginValidator;
import ua.company.validation.registration.PasswordValidator;
import ua.company.validation.registration.Priority;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Владислав on 25.10.2017.
 */
public class RegistrationFormExecution implements CommandOriginal {
    private GenericDAO<UserAutentif> genericDAO;

    public RegistrationFormExecution(GenericDAO<UserAutentif> genericDAO) {
        this.genericDAO = genericDAO;
    }

    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        executionOfregistrationByUser(httpRequest, httpResponse);

    }

    private void executionOfregistrationByUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {

        String login = httpRequest.getParameter("usernamesignup");
        String password = httpRequest.getParameter("passwordsignup");
        String passwordConfirm = httpRequest.getParameter("passwordsignup_confirm");
        if (password.equals(passwordConfirm)) {


            UserAutentif userAutentif;
            validationOfInputs(login, password, passwordConfirm);
            if (AbstractValidator.validated) {
                userAutentif = new UserAutentif(login, password);
                genericDAO.insert(userAutentif);
                httpRequest.setAttribute("name", login);
                httpRequest.getRequestDispatcher("WEB-INF/jsp/QuestionnairePage.jsp").forward(httpRequest, httpResponse);
            } else {
                httpRequest.getRequestDispatcher("WEB-INF/jsp/RegistrationError.jsp").forward(httpRequest, httpResponse);
            }
        } else {
            httpRequest.getRequestDispatcher("WEB-INF/jsp/RegistrationError.jsp").forward(httpRequest, httpResponse);
        }
    }

    private void validationOfInputs(String login, String password, String confirmPass) {
        AbstractValidator loginValidator = new LoginValidator(Priority.LOGIN);
        AbstractValidator passValidator = new PasswordValidator(Priority.PASSWORD);
        AbstractValidator confPassValidatior = new ConfirmPassValidator(Priority.ConfirmPASSWORD);

        loginValidator.setNextValidator(passValidator);
        passValidator.setNextValidator(confPassValidatior);

        loginValidator.validateManager(login, Priority.LOGIN);
        passValidator.validateManager(password, Priority.PASSWORD);
        confPassValidatior.validateManager(confirmPass, Priority.ConfirmPASSWORD);
    }
}
