<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href='design.css'>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<body>	
	<div>

        <h1>Login</h1>

        <form action="loginServlet" method="post">
            <input type="text" name="uname" placeholder="User name"><br><br>
            <input type="password" name="pword" placeholder="Password"><br><br>
            <input type="submit" value="Login">
        </form>

        <h3 value="${response}"></h3>

    </div>

</body>
</html>