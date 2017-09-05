<%--
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

<form action="/signUp" method="post">
    Login: <br/>
    <input type="text" name="login">
    <br/>
    Password:<br/>
    <input type="password" name="password">
    <br/>
    <input type="submit" value="Lest GO!">
</form>
</body>
</html>
