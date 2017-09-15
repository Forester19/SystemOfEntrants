<%@ page import="java.util.List" %>
<%@ page import="ua.company.epam.model.Questionnaire" %>
<%@ page import="java.sql.SQLException" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
   Hello admin  ${admin} its your page.
   <br/>
   <hr/>

   <br/>
   <hr/>

   <h3>If you want add new faculty:</h3>
   <form name="f1" method="post" action="adminPageAddFaculty">
       Description: <br />
       <input name="description" type="text" size="25" maxlength="30" value="DescriptionOfFaculty" /> <br />
       Max count of Students: <br />
       <input name="maxCount" type="text" size="25" maxlength="30" value="Max Count" /> <br />
       <input type="submit" name="submit" value="Submit" />
   </form>
<br/>
<hr/>

        Questionnaires (check entrants to sheet):<br/>
   <jsp:useBean id ="questionnairesBean" class="ua.company.epam.dao.implementations.QuestionnaireDAOImpl"/>

   <jsp:setProperty name="questionnairesBean" property="*"/>

   <form method="get" action="adminAddQuestionnaireToSheet">
   <% List<Questionnaire> list = null;
       try {
       list = questionnairesBean.getAll();
   } catch (SQLException e) {
       e.printStackTrace();
   }%>
       <table>
    <tr><th>Check</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Faculty</th>
    <th>Math scope</th>
    <th>Ukrainian lang scope</th>

    </tr>
       <%for (int i=0; i<list.size();i++){%>

       <tr>
           <td><input type="checkbox" name="questionnaire" value="<%list.get(i).getFirstName();%>"> </td>
           <td>      <%= list.get(i).getFirstName()%></td>
           <td><%= list.get(i).getLastName()%></td>
           <td><%= list.get(i).getEmail()%></td>
           <td><%= list.get(i).getFaculty()%></td>
           <td><%= list.get(i).getMathScope()%></td>
           <td><%= list.get(i).getUkrainianLangScope()%></td>
       </tr>
       <%}%>

       </table>

       <br/>
             <input type="submit" value="Submit">
   </form>


</body>
</html>
