<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Transactions</title>
    <link rel="stylesheet" href='design.css'>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<body>

    <ul>
        <li><a href="home.jsp">Home</a></li>
        <li><a class="active" href="transaction.jsp">New Transaction</a></li>
        <li><a href="viewTransactions.jsp">View Transactions</a></li>
        <li><a href="monthReview.jsp">Monthly Review</a></li>
        <li style="float:right"><a href="login.jsp">logout</a></li>
    </ul>

    <div>
        <h1>Add transaction here</h1>
        <form>
            From:
            <br>
            <select>
                <option value=""></option>
                <option value="Adam">Adam</option>
            </select>
            <br>
            To:
            <br>
            <select>
                <option value=""></option>
                <option value="Nick">Nick</option>
            </select>
            <br>
            <input type="text" placeholder="$10.00" name="amount">
            <br>
            <input type="submit" value="Submit">

        </form>

    </div>

</body>
</html>