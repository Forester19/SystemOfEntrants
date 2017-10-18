package ua.company.controller.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Владислав on 16.10.2017.
 */
@WebFilter(urlPatterns = {"/usersRegistration", "/adminSignUp"})
public class RegistrationPageFilter implements Filter {
    private Logger logger = Logger.getRootLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Init registration filter ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String servletPath = req.getServletPath();
        String[] url = req.getRequestURI().split("/");

        if (url[1].equals("/usersRegistration")) {
            logger.info("#INFO " + new Date() + " - ServletPath :" + servletPath //
                    + ", URL =" + req.getRequestURL());

            filterChain.doFilter(servletRequest, servletResponse);
        }
        if (url[1].equals("/adminSignUp")) {

            logger.info("Admin verified");

            filterChain.doFilter(servletRequest, servletResponse);

        }


    }

    @Override
    public void destroy() {
        logger.info("Destroy registration filter");

    }
}
