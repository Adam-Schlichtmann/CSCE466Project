package model;

import java.util.List;

public class GroupsDB {
	public static List<Groups> getGroupsUserIn(int userID) {
       	DBAccess db = new DBAccess();
       	db.connectMeIn();
       	List<Groups> gNames = db.getAllGroupsByUserID(userID);
       	db.closeConnection();
       	return gNames;
    }
}
