package jDBCBank;

public class Customer {
	
	int customerID;
	String username;
	String password;
	String firstName;
	String lastName;
	
	public Customer() {
		super();
	}
	
	public Customer(int customerID, String username, String password, String firstName, String lastName) {
		this.customerID = customerID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


}
