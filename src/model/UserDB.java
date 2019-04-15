package model;

import java.util.List;

public class UserDB {
	public static void registerUser(User aUser) {
       	DBAccess db = new DBAccess();
       	db.connectMeIn();
       	db.addSingleUser(aUser);
       	db.closeConnection();
    }
    
    public static int validateUser(String aUserName, String password) {
       	DBAccess db = new DBAccess();
       	db.connectMeIn();
       	int userID = db.getCustomerID(aUserName, password);
       	db.closeConnection();
       	return userID;
    }
    
    public static User getUserByUserID(int userID) {   
	   	DBAccess db = new DBAccess();
	   	db.connectMeIn();
	   	User aUser = db.getUserByUserID(userID);
	   	db.closeConnection();
	   	return aUser;
    }
    
    public static String getFullNameByID(int userID) {   
	   	DBAccess db = new DBAccess();
	   	db.connectMeIn();
	   	String name = db.getNameByID(userID);
	   	db.closeConnection();
	   	return name;
    }
    
    public static List<Integer> getUsersInGroup(int groupID) {   
	   	DBAccess db = new DBAccess();
	   	db.connectMeIn();
	   	List<Integer> users = db.getAllUsersInGroup(groupID);
	   	db.closeConnection();
	   	return users;
    }
    
}
