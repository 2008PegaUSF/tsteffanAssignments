package jDBCBank;

public class Account {
	int accountID;
	double balance;
	int customerID;
	
	public Account() {
		super();
	}
	
	public Account(int accountID, double balance, int customerID) {
		this.accountID = accountID;
		this.balance = balance;
		this.customerID = customerID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", customerID=" + customerID + "]";
	}
}
