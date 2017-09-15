<%@ page import="java.util.List" %>
<%@ page import="ua.company.epam.model.Faculty" %><%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 03.09.2017
  Time: 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUpPage</title>
</head>
<body>
<h1>Congratulations you can sign up here))</h1>
<br/>
<hr/>

 Registration page for intrant

<br/>
<hr/>

<form action="questionareAction" method="post">
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

    <%List list = (List) request.getAttribute("faculties");%>
     <select name="facultet">
         <% int count = list.size(); %>>
         <%for(int i=0;i<count;i++){%>
         <option value="<%=list.get(i)%>" + i><%=list.get(i)%></option>
         <%}%>
    </select>
    <br/>
    <p>
        <label for="mathScope">Math Scope:</label>
        <input type="number" max="200" min="100" name="mathScope" id="mathScope" value="100">
    </p>

    <p>
        <label for="langScope">Math Scope:</label>
        <input type="number" max="200" min="100" name="langScope" id="langScope" value="100">
    </p>

    <p>
        <input type="submit" name="submit" value="Submit">
    </p>

</form>
</body>
</html>
