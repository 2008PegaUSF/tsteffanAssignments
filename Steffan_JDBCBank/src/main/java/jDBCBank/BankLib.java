package jDBCBank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.CustomerDAO;

public class BankLib {

	
	public static void usernameUniqueCheck(String userName) throws SQLException {
		ArrayList<Customer> masterCustList = CustomerDAO.getAllCustomers();
		Scanner userReader = new Scanner(System.in);
		int userNameErrChk = 0;
		while (userNameErrChk > 4) {
			for (Customer customer : masterCustList)
		    if(userName == customer.getUsername()) { //REPLACE WITH JDBC
		        System.out.println("Username is taken. Please pick another one.");
		        userName = userReader.next();
		        userNameErrChk++;
		    } else {
		    	return;
		    }
		}
		;
	}
	
	public static void usernameDBCheck(String username) {
		
	}
}
