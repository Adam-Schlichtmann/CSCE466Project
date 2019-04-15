package model;

import java.util.List;

public class DisplayTransactions {
	private String Name;
	private Double Amount;
	private List<String> chargedUsers;
	
	public DisplayTransactions() {
		super();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public List<String> getChargedUsers() {
		return chargedUsers;
	}

	public void setChargedUsers(List<String> chargedUsers) {
		this.chargedUsers = chargedUsers;
	}
	
	
}
