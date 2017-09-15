<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 03.09.2017
  Time: 7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello Welcome!!!</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <link rel="stylesheet" href="WEB-INF/css/style.css">
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">

    <script>
      function readInputs(){
          if(document.forms[0].elements[0].value ==""){
              alert("Null fields (login or password)")
              return false;
          }
          else{
              alert("Identificated))")
              return true;
          }

      }
    </script>

  </head>
  <body bgcolor="#a9a9a9">

  <marquee behavior="alternate" direction="right"><h1>Welcome in the best system of entrants!!! </h1></marquee>

  <hr/>
  <br/>
  <p align="center" style="color:#3f41ff; font-size:30px">If you first time here...</p>
  <form action="adminSignUp" method="get">
  <input type="submit" value="Registration for enrollee..."/>
  </form>

  <hr/>
  <br/>
  <p align="center" style="color:#3f41ff; font-size:30px">If you admin...</p>


  <form onsubmit="readInputs()" action="adminSignUp" method="post" class="login">

    <p>
      <label for="login">Логин:</label>
      <input type="text" name="login" id="login" value="name@example.com">
    </p>

    <p>
      <label for="password">Пароль:</label>
      <input type="password" name="password" id="password" value="4815162342">
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Войти</button>
    </p>

    <p align="center" class="forgot-password"><a href="registrationPage.html">Забыл пароль?</a></p>


  </form>


  </body>
</html>
