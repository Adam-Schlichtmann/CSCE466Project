package model;

import java.util.List;

public class tranToDB {
	public static List<Integer> getUsersTo(int tranID){
		DBAccess db = new DBAccess();
       	db.connectMeIn();
       	List<Integer> trans = db.getTranToByTranID(tranID);
       	db.closeConnection();
       	return trans;
	}
	
	public static String newTranTo(List<tranTo> t){
		DBAccess db = new DBAccess();
       	db.connectMeIn();
       	String result = db.newTranTo(t);
       	db.closeConnection();
       	return result;
	}
}
