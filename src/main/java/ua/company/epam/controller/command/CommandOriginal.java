package ua.company.epam.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Владислав on 29.09.2017.
 Interface which need for using command pattern.
 */
public interface CommandOriginal {
    void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException;
}
