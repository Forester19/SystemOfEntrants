package ua.company.bl.tags;

import ua.company.model.dao.impl.UserDAO;
import ua.company.model.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Владислав on 09.10.2017.
 */
public class TagForShow extends TagSupport {
    private UserDAO userDAO = new UserDAO();
    @Override
    public int doStartTag() throws JspException {
        JspWriter jspWriter = pageContext.getOut();
        try {
            jspWriter.write("<table cellspacing=\"2\" border=\"1\" cellpadding=\"5\" width=\"600\">");
            for (User user : userDAO.getStudents()){

                jspWriter.write("<tr>");

                jspWriter.write("<td>" + user.getFirstName() + "</td>");
                jspWriter.write("<td>" + user.getLastName() + "</td>");
                jspWriter.write("<td>" + user.getEmail() + "</td>");
                jspWriter.write("<td>" + user.getFaculty_id() + "</td>");

                jspWriter.write("</tr>");
            }

            jspWriter.write("</table>");
            jspWriter.flush();
            jspWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
