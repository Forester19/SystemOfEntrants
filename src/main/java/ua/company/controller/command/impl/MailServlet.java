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
        try{
            String SMTP_AUTH_USER = "vdvoreckij4@gmail.com";
            String SMTP_AUTH_PWD = "Forester19";

            List<String> userEmails = new ArrayList<>();
            for (User user : users){
                userEmails.add(user.getEmail());
            }

            Properties properties = new Properties();
            properties.put("mail.transport.protocol", "smtps");
            properties.put("mail.smtps.host", SMTP_AUTH_USER);
            properties.put("mail.smtps.auth", "true");

            Session session = Session.getDefaultInstance(properties);

            Transport transport = session.getTransport();
            transport.connect("smtp.gmail.com",465,SMTP_AUTH_USER,SMTP_AUTH_PWD);

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSubject("Congratulation");
            mimeMessage.setText("Congratulation");
            mimeMessage.setFrom(new InternetAddress("vdvoreckij4@gmail.com"));

            InternetAddress[] address = new InternetAddress[userEmails.size()];
            for (int i=0; i< userEmails.size(); i++){
                address[i] = new InternetAddress(userEmails.get(i));
            }

            mimeMessage.addRecipients(Message.RecipientType.TO, address);
            mimeMessage.setSentDate(new Date());

            transport.sendMessage(mimeMessage,mimeMessage.getRecipients(Message.RecipientType.TO));
        }catch (MessagingException e){
            System.out.println(e);
        }
    }
}
