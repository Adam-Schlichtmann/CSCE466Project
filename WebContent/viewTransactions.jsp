<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Transactions</title>
    <link rel="stylesheet" href='design.css'>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<body>

    <ul>
        <li><a href="home.jsp">Home</a></li>
        <li><a href="transaction.jsp">New Transaction</a></li>
        <li><a class="active" href="viewTransactions.jsp">View Transactions</a></li>
        <li><a href="monthReview.jsp">Monthly Review</a></li>
        <li style="float:right"><a href="login.jsp">logout</a></li>
    </ul>

    <div>
        <h1>View Transactions Here</h1>
        <table width="50%">
        	 <tr>
		  	<th>From</th>
		    <th>Amount</th>
		    <th>To</th> 
		  	</tr>
	        <c:forEach items="${trans}" var="tran">
		        <tr>
		        	<td><c:out value="${tran.getName()}"></c:out></td>
		            <td><c:out value="${tran.getAmount()}"></c:out></td>
		            <td><c:out value="${tran.getChargedUsers()}"></c:out></td>
		        </tr>
	    	</c:forEach>
        </table>
       
    </div>

</body>
</html> 