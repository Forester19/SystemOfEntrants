<%@ page import="java.util.List" %>
<%@ page import="ua.company.model.entity.Faculty" %>
<%@ page import="ua.company.model.entity.Subject" %>
<%@ page import="ua.company.model.entity.additional.FacultyAndSubjects" %>

<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 03.09.2017
  Time: 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="faculties" class="ua.company.model.dao.impl.FacultiesDAO" scope="session"/>
<jsp:useBean id="subjects" class="ua.company.model.dao.impl.SubjectDAO" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SignUpPage</title>
</head>
<body>
<h1>Congratulations you can sign up here))</h1>
<br/>
<hr/>

 Registration page for enrollees

<br/>
<hr/>

<form action="usersRegistration" method="post">
    <input type="hidden" name="command" value="FORM_BY_USER">
    <p>
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" id="firstName" value="">
    </p>
    <p>
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" id="lastName" value="">
    </p>
    <p>
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" value="">
    </p>
   <br/>
    <p>
        Faculty:
        <select name="mySelect">
            <c:forEach var ="fac" items ="${faculties.all}">
               <option value="${fac.PK}"> <c:out value="${fac.name}" /> </option>
            </c:forEach>
        </select>

<p>
    Mark 1: <input type="number" name="mark1" id="mark1" min="100" max="200" />
    Mark 2: <input type="number" name="mark2" id="mark2" min="100" max="200"/>
    Mark 3: <input type="number" name="mark3" id="mark3" min="100" max="200"/>
</p>
<input type="submit" value="Submit">

</form>

<p align="center"> <H2>Faculties - subjects mapping</H2></p>

<table cellspacing="2" border="1" cellpadding="5" width="600">
    <tr>
        <td>Faculty</td>
        <td>Subject 1</td>
        <td>Subject 2</td>
        <td>Subject 3</td>
    </tr>
    <%    for (FacultyAndSubjects facultyAndSubjects: faculties.showFacultetsAndSubjects()){       %>
        <tr>
            <td> <%= facultyAndSubjects.getFaculty().getName()%></td>
            <td> <%= facultyAndSubjects.getSubject1().getSubjectTitle()%></td>
            <td> <%= facultyAndSubjects.getSubject2().getSubjectTitle()%></td>
            <td> <%= facultyAndSubjects.getSubject3().getSubjectTitle()%></td>
        </tr>
    <%}%>

</table>


</body>
</html>
