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
        <li><a href="groupSelectionServlet">New Transaction</a></li>
        <li><a href="viewTransactions.jsp">View Transactions</a></li>
        <li><a href="monthReview.jsp">Monthly Review</a></li>
        <li style="float:right"><a href="login.jsp">logout</a></li>
    </ul>

    <div>
        <h1>Enter a new Transaction</h1>
        <form style="text-align:center" action=newTransactionServlet name="newTran">
			Select a Group :
			<select name="user">
				<c:forEach items ="${users}" var="user">
					<option value="${user.getUserID()}">${user.getFirstName()}</option>
				</c:forEach>
			</select>
			$ <input type="text" id="amount" name="amount" placeholder="10.00">
			<input type=submit value="Search">
		</form>
    </div>

</body>
</html>