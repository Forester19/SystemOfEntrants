package ua.company.controller.command.impl;

import ua.company.bl.MainBL;
import ua.company.controller.command.GenericCommand.CommandOriginal;
import ua.company.model.entity.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Владислав on 04.10.2017.
 */
public class MailServlet implements CommandOriginal {
    private MainBL mainBL = new MainBL();
    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        try {

                sendMessages(mainBL.getStudents());
                httpRequest.setAttribute("stud" ,mainBL.getStudents());
                httpRequest.getRequestDispatcher("WEB-INF/jsp/Students.jsp").forward(httpRequest,httpResponse);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private void sendMessages(List<User> users) throws MessagingException, IOException {
    final Properties properties = new Properties() ;
    properties.put("mail.smtp.socketFactory.fallback", "true");
    properties.load(MailServlet.class.getClassLoader().getResourceAsStream("mail.properties"));

    List<String> userEmails = new ArrayList<>();
    for (User user: users){
        userEmails.add(user.getEmail());
    }

    Session session = Session.getDefaultInstance(properties);
    MimeMessage mimeMessage = new MimeMessage(session);
    mimeMessage.setFrom(new InternetAddress("vdvoreckij4@gmail.com"));
        InternetAddress[] address = new InternetAddress[userEmails.size()];
        for (int i=0; i< userEmails.size(); i++){
            address[i] = new InternetAddress(userEmails.get(i));
        }
        mimeMessage.setRecipients(Message.RecipientType.TO, address);
    mimeMessage.setSubject("Congratulations");
    mimeMessage.setText("You entered to faculty. My congratulations)");

    Transport tr = session.getTransport("smtps");
    tr.connect("smtp.gmail.com",465,"vdvoreckij4@gmail.com","Forester19");
    tr.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
    tr.close();
    }
}
