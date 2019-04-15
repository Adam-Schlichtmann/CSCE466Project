package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Transactions;
import model.TransactionsDB;
import model.tranTo;
import model.tranToDB;

/**
 * Servlet implementation class newTransactionServlet
 */
@WebServlet("/newTransactionServlet")
public class newTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("userID");
		String a = request.getParameter("amount");
		Double amount = Double.parseDouble(a);
		String u = request.getParameter("user");
		int toUser = Integer.parseInt(u);
		int groupID = (int) session.getAttribute("groupID");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		java.sql.Date tranDate = convertUtilToSql(date);
		
		
		Transactions t = new Transactions();
		t.setUserID(userID);
		t.setAmount(amount);
		t.setGroupID(groupID);
		t.setTranDate(tranDate);
		int tranID = TransactionsDB.addTransaction(t);
		List<tranTo> tranTo = new ArrayList<tranTo>();
		tranTo tran = new tranTo();
		tran.setTranID(tranID);
		tran.setUserID(toUser);
		tranTo.add(tran);
		
		String result = tranToDB.newTranTo(tranTo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
