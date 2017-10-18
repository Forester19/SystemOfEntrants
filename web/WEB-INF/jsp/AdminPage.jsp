<%@ page import="java.util.List" %>
<%@ page import="ua.company.model.entity.User" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="ua.company.model.entity.Faculty" %>
<%@ page import="ua.company.model.entity.additional.ModelOfUserForShow" %>
<%@ page import="ua.company.bl.tags.ShowUsersInfo" %>
<%@ page import="ua.company.model.dao.impl.UserDAO" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="information" class="ua.company.bl.tags.ShowUsersInfo"/>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
   Hello admin  ${admin} its your page.
   <br/>
   <hr/>



<form action="startBL" method="get">
    <input type="hidden" name="command" value="START_BL">
    <input type="submit" name="startBL" value="Start BL">
</form>
   <br/>
   <hr/>

   <form action="MailForm" method="POST">
       <input type="hidden" name="command" value="SEND_MASSAGES">

       <input type="submit" value="Send messages for students!"/>
   </form>


       <br/>
       <hr/>
        Questionnaires (check entrants to sheet):<br/>

   <form method="get" action="adminAddQuestionnaireToSheet">

       <input type="hidden" name="command" value="ADD_USER_TO_SHEET">

       <table cellspacing="2" border="1" cellpadding="5" width="600">
    <tr>
        <th>Check</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Faculty</th>
    <th>Scope_1</th>
    <th>Scope_2</th>
    <th>Scope_3</th>
    </tr>
           <%UserDAO userDAO = new UserDAO();
            ShowUsersInfo showUsersInfo = new ShowUsersInfo();
            List<ModelOfUserForShow> modelOfUserForShow = showUsersInfo.showInfo(); %>
        <% for (ModelOfUserForShow modelOfUserForShow1 : modelOfUserForShow){
        User user = userDAO.getById(userDAO.getPKByName(modelOfUserForShow1.getFn()));
            if(!user.isNoted_by_admin()){%>
           <tr>
               <td> <input type="checkbox" name="noting" value="<%=modelOfUserForShow1.getFn()%>"></td>
            <td> <%=modelOfUserForShow1.getFn()%></td>
            <td> <%=modelOfUserForShow1.getLn()%></td>
            <td> <%=modelOfUserForShow1.getEmail()%></td>
            <td> <%=modelOfUserForShow1.getFac() %></td>
            <td> <%=modelOfUserForShow1.getMarkVal1()%></td>
            <td> <%=modelOfUserForShow1.getMarkVal2()%></td>
            <td> <%=modelOfUserForShow1.getMarkVal3()%></td>
        </tr>
           <%}
           }%>
       </table>
       <br/>
       <p>
           <input type="submit" name="Submit" value="Submit">
       </p>
   </form>


</body>
</html>
