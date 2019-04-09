package model;

import java.util.List;

public class Transactions {
	private List<Integer> toID;
	private int fromID;
	private double amount;
	
	public Transactions() {
		super();
	}

	public List<Integer> getToID() {
		return toID;
	}

	public void setToID(List<Integer> toID) {
		this.toID = toID;
	}

	public int getFromID() {
		return fromID;
	}

	public void setFromID(int fromID) {
		this.fromID = fromID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}	
	
}
