package model;

import java.util.List;

public class TransactionsDB {
	public static List<Transactions> getTransactionsByUserANDGroup(int userID, int groupID){
		DBAccess db = new DBAccess();
       	db.connectMeIn();
       	List<Transactions> trans = db.getAllTransactionsByUserANDGroup(userID, groupID);
       	db.closeConnection();
       	return trans;
	}
	
	public static List<Transactions> getTransactionsByGroup(int groupID){
		DBAccess db = new DBAccess();
       	db.connectMeIn();
       	List<Transactions> trans = db.getAllTransactionsByGroup(groupID);
       	db.closeConnection();
       	return trans;
	}
	
	public static int addTransaction(Transactions t){
		DBAccess db = new DBAccess();
       	db.connectMeIn();
       	int tranID = db.newTransaction(t);
       	db.closeConnection();
       	return tranID;
	}
}
