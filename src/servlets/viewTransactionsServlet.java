package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DisplayTransactions;
import model.Transactions;
import model.TransactionsDB;
import model.UserDB;
import model.tranToDB;

/**
 * Servlet implementation class viewTransactionsServlet
 */
@WebServlet("/viewTransactionsServlet")
public class viewTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewTransactionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String g = request.getParameter("group");
		int groupID = Integer.parseInt(g);
		
		
		List<DisplayTransactions> displayTrans = new ArrayList<DisplayTransactions>();
		
		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("userID");
		List<Transactions> trans = TransactionsDB.getTransactionsByUserANDGroup(userID, groupID);
		
		for (int i = 0; i < trans.size(); i ++) {
			DisplayTransactions temp = new DisplayTransactions();
			List<String> chargedUsers = new ArrayList<String>();
			for (int j = 0; j < tranToDB.getUsersTo(trans.get(i).getTranID()).size(); j++) {
				chargedUsers.add(UserDB.getFullNameByID(tranToDB.getUsersTo(trans.get(i).getTranID()).get(j)));
			}
			temp.setName(UserDB.getFullNameByID(trans.get(i).getUserID()));
			temp.setAmount(trans.get(i).getAmount());
			temp.setChargedUsers(chargedUsers);

			displayTrans.add(temp);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewTransactions.jsp");
		request.setAttribute("trans", displayTrans);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
