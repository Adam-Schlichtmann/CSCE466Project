package model;

import java.sql.Date;
import java.util.List;

public class Transactions {
	private int tranID;
	private int userID;
	private int groupID;
	private Date tranDate;
	private double amount;
	
	public Transactions() {
		super();
	}

	public int getTranID() {
		return tranID;
	}

	public void setTranID(int tranID) {
		this.tranID = tranID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
