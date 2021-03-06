package servlets;

import java.io.IOException;
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
import model.TransactionsDB;
import model.UserDB;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		int cID = UserDB.validateUser(username, password);
		
		if(cID != -1) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10*60);
			session.setAttribute("userID", cID);
			List<Groups> groups = GroupsDB.getGroupsUserIn(cID);
			request.setAttribute("groups", groups);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			request.setAttribute("username", username);
			System.out.println(cID);
			System.out.println(username);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("response", "Invalid Username or Password");
			dispatcher.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
