package ua.company.epam.controller;

import ua.company.epam.dao.SignUpDao;
import ua.company.epam.dao.connection.JDBCConnectionPool;
import ua.company.epam.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Владислав on 03.09.2017.
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/signUp"})
public class SignUpServlet extends HttpServlet {
    private JDBCConnectionPool jdbcConnectionPool;
    private Connection connection;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        jdbcConnectionPool = JDBCConnectionPool.getInstanceConnectionPool();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        connection = jdbcConnectionPool.getConnection();
        if (connection == null) {
            System.out.println("Cant recieve connection");
        }
        jdbcConnectionPool.freeConnection(connection);
    }

    @Override
    public void destroy() {
        super.destroy();
        jdbcConnectionPool.released();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/SignUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);
        SignUpDao signUpDao = new SignUpDao(connection);

        try {
            signUpDao.insert(user);
        } catch (SQLException e) {
            System.out.println("Cant write to DB");
        }

        req.getRequestDispatcher("/WEB-INF/ResultOfRegistration.jsp").forward(req, resp);
    }
}
