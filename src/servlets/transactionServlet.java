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

import model.Groups;
import model.GroupsDB;
import model.User;
import model.UserDB;

/**
 * Servlet implementation class transactionServlet
 */
@WebServlet("/transactionServlet")
public class transactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String g = request.getParameter("group");
		int groupID = Integer.parseInt(g);
		
		List<Integer> userIDs = UserDB.getUsersInGroup(groupID);
		
		List<User> users = new ArrayList<User>();
		System.out.println(userIDs);
		for (int i = 0; i < userIDs.size(); i++) {
			User u = new User();
			u.setFirstName(UserDB.getFullNameByID(userIDs.get(i)));
			u.setUserID(userIDs.get(i));
			users.add(u);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("groupID", groupID);
		request.setAttribute("users", users);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("transaction.jsp");
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
