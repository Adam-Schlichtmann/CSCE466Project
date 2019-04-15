package model;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;




public class DBAccess {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/aschlichtm"; 
	//final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/CSE_LOGIN";
	
	

	//  Database credentials
	static final String USER = "aschlichtm"; // Replace with your CSE_LOGIN
	static final String PASS = "LM6-dy";   // Replace with your CSE MySQL_PASSWORD
	
	// <---------------Users------------------>
	
	public User getUserByUserID(int userID) {
		String SQL = "SELECT * from users WHERE userID='"+userID+"'";
	    Statement stat;
	   
	    User aUser = new User();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(userID == rs.getInt("userID")) {
					aUser.setFirstName(rs.getString("firstName"));
					aUser.setLastName(rs.getString("lastName"));
					aUser.setUsername(rs.getString("userName"));
					aUser.setUserID(rs.getInt("userID"));
					aUser.setPassword(rs.getString("password"));
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aUser;
	}
	
	public String getNameByID(int userID) {
		String SQL = "SELECT * from users WHERE userID='"+userID+"'";
	    Statement stat;
	    String name = "";
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			rs.next();
			name = rs.getString("firstName") + " "+ rs.getString("lastName");
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	
	
	// =============== REGISTRATION =====================
	
	public void addSingleUser(User aUser) {
		  
		try {
		  stmt = conn.createStatement();
		  String sql;
		  
		  String firstName = aUser.getFirstName();
		  String lastName = aUser.getLastName();
		  String userName = aUser.getUsername();
		  String password = aUser.getPassword();
		  sql = "INSERT INTO users (FirstName, LastName, Username, Password)" +
		          "VALUES (?, ?, ?, ?)";
		  ps = conn.prepareStatement(sql);
		  ps.setString(1, firstName);
		  ps.setString(2, lastName);
		  ps.setString(3, userName);
		  ps.setString(4, password);
		  ps.executeUpdate();	  
		  
		  } catch (SQLException e) {
			  e.printStackTrace();
		}
		
	}
	
	// =============== FOR LOGIN PURPOSES ===============
	public int getCustomerID(String username, String password) {
		String SQL = "SELECT * from users WHERE username='"+username+"' AND password='"+password+"'";
	    Statement stat;
	    int cId = -1;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
				if(username.equals( rs.getString("username") )) {
					cId = rs.getInt("userID");
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cId;
	}
	
	// <---------------Groups------------------>
	
	public List<Groups> getAllGroupsByUserID(int userID) {
		String SQL = "SELECT * from groups WHERE userID='"+userID+"'";
	    Statement stat;
	    
	    List<Groups> groups = new ArrayList<Groups>();
	    
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()) {
				Groups temp = new Groups();
				temp.setgID(rs.getInt("gID"));
				temp.setGroupID(rs.getInt("groupID"));
				temp.setGroupName(rs.getString("groupName"));
				temp.setUserID(rs.getInt("userID"));
				groups.add(temp);
			}
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}
	
	public List<Integer> getAllUsersInGroup(int groupID) {
		String SQL = "SELECT * from groups WHERE groupID='"+groupID+"'";
	    Statement stat;
	    List<Integer> users = new ArrayList<Integer>();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while(rs.next()) {
				users.add(rs.getInt("userID"));
			}
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	// <---------------Transactions------------------>

	public List<Transactions> getAllTransactionsByUserANDGroup(int userID, int groupID) {
		String SQL = "SELECT * from transactions WHERE userID='"+userID+"' AND groupID='"+groupID+"'";
	    Statement stat;
	    
	    List<Transactions> trans = new ArrayList<Transactions>();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()) {
				Transactions temp = new Transactions();
				temp.setTranID(rs.getInt("tranID"));
				temp.setUserID(rs.getInt("userID"));
				temp.setGroupID(rs.getInt("groupID"));
				temp.setTranDate(rs.getDate("tranDate"));
				temp.setAmount(rs.getDouble("amount"));
				trans.add(temp);
			}
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trans;
	}
	
	public int newTransaction(Transactions t) {
		int tranID = -1;
		int userID = t.getUserID();
  		int groupID = t.getGroupID();
  		Date tranDate = t.getTranDate();
		  Double amount = t.getAmount();
		try {
			  stmt = conn.createStatement();
			  String sql;
			  
			 
			  sql = "INSERT INTO transactions (userID, groupID, tranDate, amount)" +
			          "VALUES (?, ?, ?, ?)";
			  ps = conn.prepareStatement(sql);
			  ps.setInt(1, userID);
			  ps.setInt(2, groupID);
			  ps.setDate(3, tranDate);
			  ps.setDouble(4, amount);
			  ps.executeUpdate();	  
			  } catch (SQLException e) {
				  e.printStackTrace();
			}
		String SQL = "SELECT * from transactions WHERE tranDate='"+tranDate+"' AND amount='"+amount+"'";
	    Statement stat;
	    
	   
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			rs.next();
			tranID = rs.getInt("tranID");
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tranID;
	}
	
	// FOR CALCULATIONS
	public List<Transactions> getAllTransactionsByGroup(int groupID) {
		String SQL = "SELECT * from transactions WHERE groupID='"+groupID+"'";
	    Statement stat;
	    
	    List<Transactions> trans = new ArrayList<Transactions>();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()) {
				Transactions temp = new Transactions();
				temp.setTranID(rs.getInt("tranID"));
				temp.setUserID(rs.getInt("userID"));
				temp.setGroupID(rs.getInt("groupID"));
				temp.setTranDate(rs.getDate("tranDate"));
				temp.setAmount(rs.getDouble("amount"));
				trans.add(temp);
			}
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trans;
	}
	
	
	
	// <---------------tranTo------------------>
	
	public List<Integer> getTranToByTranID(int tranID) {
		String SQL = "SELECT * from tranTo WHERE tranID='"+tranID+"'";
	    Statement stat;
	    
	    List<Integer> trans = new ArrayList<Integer>();
		int temp;
	    try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while(rs.next()) {
				temp = rs.getInt("userID");
				trans.add(temp);
			}
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trans;
	}
	
	public String newTranTo(List<tranTo> t) {
		String result = "Failed to Add";
		try {
			  stmt = conn.createStatement();
			  String sql;
			  for( int i = 0; i<t.size();i++) {
				  int tranID = t.get(i).getTranID();
				  int userID = t.get(i).getUserID();
				  sql = "INSERT INTO tranTo (tranID, userID)" +
				          "VALUES (?, ?)";
				  ps = conn.prepareStatement(sql);
				  ps.setInt(1, tranID);
				  ps.setInt(2, userID);

				  ps.executeUpdate();	  

			  }
			  result = "Transation Added";
			  } catch (SQLException e) {
				  e.printStackTrace();
			}
		return result;
	}
	
	
	// <---------------Connection------------------>
	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
