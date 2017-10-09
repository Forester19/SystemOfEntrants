package ua.company.bl.view;

import ua.company.model.dao.impl.UserDAO;
import ua.company.model.entity.User;
import ua.company.model.entity.additional.ModelOfUserForShow;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by Владислав on 09.10.2017.
 */
public class TagForShowEnrolles extends TagSupport{

    private User user;
    private ModelOfUserForShow modelOfUserForShow;

    public void setModelOfUserForShow(ModelOfUserForShow modelOfUserForShow) {
        this.modelOfUserForShow = modelOfUserForShow;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter jspWriter = pageContext.getOut();
        StringBuffer stringBuffer = new StringBuffer();

          stringBuffer.append("<tr>");
          stringBuffer.append("<td> <input type=\"checkbox\" name=\"noting\" value=" +modelOfUserForShow.getFn() + "></td>");
          stringBuffer.append("<td><"+ modelOfUserForShow.getFn()+"></td>");
          stringBuffer.append("<td><"+ modelOfUserForShow.getLn()+"></td>");
          stringBuffer.append("<td><"+ modelOfUserForShow.getEmail()+"></td>");
          stringBuffer.append("<td><"+ modelOfUserForShow.getFac()+"></td>");
          stringBuffer.append("<td><"+ modelOfUserForShow.getMarkVal1()+"></td>");
          stringBuffer.append("<td><"+ modelOfUserForShow.getMarkVal2()+"></td>");
          stringBuffer.append("<td><"+ modelOfUserForShow.getMarkVal3()+"></td>");
          stringBuffer.append("</tr>");

        try {
            jspWriter.write(stringBuffer.toString());
            jspWriter.flush();
            jspWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }
}
