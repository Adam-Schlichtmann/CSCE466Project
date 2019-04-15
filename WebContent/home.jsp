<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href='design.css'>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<body>
    <ul>
        <li><a class="active" href="home.jsp">Home</a></li>
        <li><a href="groupSelectionServlet">New Transaction</a></li>
        <li><a href="viewTransactions.jsp">View Transactions</a></li>
        <li><a href="monthReview.jsp">Monthly Review</a></li>
        <li style="float:right"><a href="login.jsp">logout</a></li>
    </ul>

    <div>
        <h1>Home Page</h1>
        <form style="text-align:center" action=viewTransactionsServlet name="search">
			Select a Group :
			<select name="group">
				<c:forEach items ="${groups}" var="group">
					<option value="${group.getGroupID()}">${group.getGroupName()}</option>
				</c:forEach>
			</select>
			<input type=submit value="Search">
		</form>
    </div>

</body>
</html>