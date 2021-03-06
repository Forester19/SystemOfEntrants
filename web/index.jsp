<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 23.10.2017
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainPage</title>
    <link rel="stylesheet" type="text/css" href="css/mainPage.css">
</head>
<body>
<div id="container_demo" >
    <!-- спрятанный якорь, чтобы избежать прыжков http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
    <a class="hiddenanchor" id="tosubscribe"></a>
    <a class="hiddenanchor" id="tologin"></a>
    <div id="wrapper">
        <div id="login" class="animate form">
            <form  action="authorization" method="get" autocomplete="on">
                <h1>Log in</h1>
                <input type="hidden" name ="command" value="REG_BY_USER">
                <p>
                    <label for="username" class="uname" data-icon="u" > Your email or username </label>
                    <input id="username" name="username" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                </p>
                <p>
                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" />
                </p>
                <p class="keeplogin">
                    <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                    <label for="loginkeeping">Keep me logged in</label>
                </p>
                <p class="login button">
                    <input type="submit" value="Login" />
                </p>
                <p class="change_link">
                    Not a member yet ?
                    <a href="#tosubscribe" class="to_subscribe">Join us</a>
                </p>
            </form>
        </div>

        <div id="subscribe" class="animate form">
            <form  action="registration" method="post" autocomplete="on">
                <h1> Sign up </h1>
                <input type="hidden" name ="command" value="REG_BY_USER">
                <p>
                    <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                    <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
                </p>

                <p>
                    <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                    <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                </p>
                <p>
                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                </p>
                <p class="signin button">
                    <input type="submit" value="Sign up"/>
                </p>
                <p class="change_link">
                    Already a member ?
                    <a href="#tologin" class="to_subscribe"> Go and log in </a>
                </p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
