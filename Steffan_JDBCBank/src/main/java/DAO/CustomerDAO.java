package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jDBCBank.Account;
import jDBCBank.Customer;

public class CustomerDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public static ArrayList<Customer> getAllCustomers() throws SQLException {
			ArrayList<Customer> custList = new ArrayList<Customer>();
			Connection conn = cf.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			Customer customer = null;
			while (rs.next()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				custList.add(customer);
			}
			return custList;
	}
	
	public static void writeCustToDB(String userName, String password, String firstName, String lastName) throws SQLException {
		Connection conn = cf.getConnection();
		String stmt = "insert into customer (username, password, firstname, lastname) values (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(stmt);
		ps.setString(1, userName);
		ps.setString(2, password);
		ps.setString(3, firstName);
		ps.setString(4, lastName);
		ps.executeUpdate();
	}
	
	public static Customer pickCurrentCustomer(String userName, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String stmt = "select * from customer where username = ?";
		PreparedStatement ps = conn.prepareStatement(stmt);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		Customer customer = null;
		while (rs.next()) {
			customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		return customer;
	}
	
	public static void updateCustomer(String category, String newValue, int customerID) throws SQLException {
		Connection conn = cf.getConnection();
		String stmt = "update customer set ? = ? where customerid = ?";
		PreparedStatement ps = conn.prepareStatement(stmt);
		ps.setString(1, category);
		ps.setString(2, newValue);
		ps.setInt(3,  customerID);
		ps.executeUpdate();
	}
	
	public static void deleteCustomer(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String stmt = "select delete_from_users(?)";
		PreparedStatement ps = conn.prepareStatement(stmt);
		ps.setString(1, username);
		ps.execute();
	}
	
	public static void createAccount(Customer customer) throws SQLException {
		Connection conn = cf.getConnection();
		String stmt = "insert into accounts (customerid) values (?)";
		PreparedStatement ps = conn.prepareStatement(stmt);
		ps.setInt(1, customer.getCustomerID());
		ps.executeUpdate();
	}
	
	public static ArrayList<Account> getAccounts(Customer customer) throws SQLException {
		ArrayList<Account> accList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		String stmt = "select * from accounts where customerid = ?";
		PreparedStatement ps = conn.prepareStatement(stmt);
		ps.setInt(1, customer.getCustomerID());
		ResultSet rs = ps.executeQuery();
		Account currentAccount = null;
		while(rs.next()) {
			currentAccount = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			accList.add(currentAccount);
		}
		return accList;
	}
	
	public static void updateAccount(double newBalance, int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String stmt = "update accounts set balance = ? where accountid = ?";
		PreparedStatement ps = conn.prepareStatement(stmt);
		ps.setDouble(1, newBalance);
		ps.setInt(2,  accountID);
		ps.executeUpdate();
	}
	
	public static void deleteAccount(Account currentAccount) throws SQLException {
		if (currentAccount.getBalance() == 0) {
			Connection conn = cf.getConnection();
			String stmt = "select delete_from_accounts(?)";
			PreparedStatement ps = conn.prepareStatement(stmt);
			ps.setInt(1, currentAccount.getAccountID());
			ps.execute();
			System.out.println("Account deleted.");
			return;
		} else {
			System.out.println("This account cannot be deleted, there is an outstanding balance.");
			System.out.println("Returning you to the account selection menu.");
			return;
		}
	}
}
