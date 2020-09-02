package jDBCBank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import DAO.CustomerDAO;


public class Menus {
	public static void initialPrompt() {
		System.out.println("Welcome to Sovereign Bank.\n"
				+ "If logging in, press 1. If registering a new account, "
				+ "press 2. To exit, press 3.");
		Scanner userReader = new Scanner(System.in);
		ArrayList<String> userLoginHolder = new ArrayList<String>(); //Holds First name, last name, Username, and password
		
		int errorCounter = 0;
		while (errorCounter == 0) {
			
		int numInput = userReader.nextInt();
		
			switch (numInput) {
			case 1: // Login Option
				System.out.println("Please input your username:");
				userLoginHolder.add(userReader.next());
				System.out.println("Please input your password:");
				userLoginHolder.add(userReader.next());
				
				if (userLoginHolder.get(0).equals("admin") && userLoginHolder.get(1).equals("12345")) {
					adminMenu(); //access to admin menu. No need for an admin object.
				} else {
					try {
						mainMenuPrompt(CustomerDAO.pickCurrentCustomer(userLoginHolder.get(0), userLoginHolder.get(1)));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
				errorCounter++;
				break;
			case 2: // Registration Option
				System.out.println("Please input your desired username:");
				String userName = userReader.next();
				userLoginHolder.add(userName);
				System.out.println("Please input your desired password:");
				String password = userReader.next();
				userLoginHolder.add(password);
				System.out.println("What is your first name?");
				String firstName = userReader.next();
				userLoginHolder.add(firstName);
				System.out.println("What is your last name?");
				String lastName = userReader.next();
				userLoginHolder.add(lastName);
				
				try {
					CustomerDAO.writeCustToDB(userLoginHolder.get(0), userLoginHolder.get(1), userLoginHolder.get(2), userLoginHolder.get(3));
					mainMenuPrompt(CustomerDAO.pickCurrentCustomer(userLoginHolder.get(0), userLoginHolder.get(1)));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				errorCounter++;
				break;
			case 3: //Admin Login
				//TODO: Admin login menu.
			case 4: //Exit
				System.out.println("Goodbye. Bank with us again soon.");
				System.exit(0);
			default: // Bad input catcher.
				System.out.println("Incorrect input. Please try again.");
				break;
			}
		}
	}
	
	public static void mainMenuPrompt(Customer customer) { 
		Scanner actionReader = new Scanner(System.in);
		Account currentAccount = null;
		ArrayList<Account> accList = new ArrayList<Account>();
		System.out.println("=================================================================");
		System.out.println("Thank you for banking with Sovereign Bank Services, " 
									+ customer.getFirstName() + " " + customer.getLastName());
		System.out.print("Your current open accounts are: ");
		
		try {
			accList = CustomerDAO.getAccounts(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			for (Account account : accList) {
				System.out.print(account.accountID + " ");
			}
			System.out.println();
		}
		System.out.println("=================================================================");
		
		int ErrCntr = 0;
		while (ErrCntr < 4) {
			System.out.println("Please enter your account ID below. "
					+ "\nEnter 000 if you have no accounts.");
			int accountNum = actionReader.nextInt();
			if (accountNum == 000) {
				try {
					CustomerDAO.createAccount(customer);
					System.out.println("New account created!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					mainMenuPrompt(customer);
				}
			}
			for (Account account : accList) {
				if (account.getAccountID() == accountNum) {
					currentAccount = account;
					System.out.println("Account number accepted.");
					accountMenu(customer, currentAccount);
					ErrCntr = 4;
					break;
					}
				}
			System.out.println("I'm sorry, that is an invalid account number. "
					+ "Please try again.");
			ErrCntr++;
			}
		}
		
	public static void accountMenu(Customer customer, Account currentAccount) {
		int menuInput = 0;
		System.out.println("=================================================================");
		System.out.println("What service would you like to perform today?");
		System.out.println("Enter the corresponding number to perform your desired service:");
		System.out.println("1. Deposit               || 2. Withdraw");
		System.out.println("3. Balance               || 4. Create New Account");
		System.out.println("5. Delete Empty Account  || 6. Logout");
		System.out.println("=================================================================");
		Scanner actionReader = new Scanner(System.in);
		menuInput = actionReader.nextInt();
		switch (menuInput) {
			case 1: //Deposit sequence.
				System.out.println("How much would you like to deposit?");
				double depositAmount = actionReader.nextDouble();
				if (depositAmount <= 0) {
					System.out.println("Invalid amount. Please try again.");
					accountMenu(customer, currentAccount);
				}
				currentAccount.setBalance(currentAccount.getBalance() + depositAmount);
				try {
					CustomerDAO.updateAccount(currentAccount.getBalance(), currentAccount.getAccountID());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Successfully deposited $" + depositAmount + " for a total balance of $"
						+ currentAccount.getBalance() + ".");
				accountMenu(customer, currentAccount);
			case 2: //Withdraw sequence.
				System.out.println("How much would you like to withdraw?");
				double withdrawAmount = actionReader.nextDouble();
				if (withdrawAmount <= 0) {
					System.out.println("Invalid amount. Please try again.");
					accountMenu(customer, currentAccount);
				}
				currentAccount.setBalance(currentAccount.getBalance() - withdrawAmount);
				try {
					CustomerDAO.updateAccount(currentAccount.getBalance(), currentAccount.getAccountID());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Successfully withdrawn $" + withdrawAmount + " for a total balance of $"
						+ currentAccount.getBalance() + ".");
				accountMenu(customer, currentAccount);
			case 3: //Display current balance.
				System.out.println("Current Balance: $" + currentAccount.getBalance());
				accountMenu(customer, currentAccount);
			case 4: //Create new account.
				try {
					CustomerDAO.createAccount(customer);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("New account created!");
				mainMenuPrompt(customer);
			case 5: //Deletes empty accounts.
				System.out.println("This option will delete the current account number (" 
						+ currentAccount.getAccountID() + "). Are you sure? (Y/N)");
				String deleteConfirm = actionReader.next();
				if (deleteConfirm.equals("Y")) {
					try {
						CustomerDAO.deleteAccount(currentAccount);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						mainMenuPrompt(customer);
					}
				} else {
					System.out.println("Delete cancelled. Returning you to the account menu.");
					mainMenuPrompt(customer);
				}
			case 6: //Logout.
				System.out.println("Thank you and have a nice day!");
				System.exit(0);
		}
	}
	
	public static void adminMenu() {
		ArrayList<Customer> custList = new ArrayList<Customer>();
		ArrayList<String> userLoginHolder = new ArrayList<String>();
		Scanner actionReader = new Scanner(System.in);
		System.out.println("=========================================");
		System.out.println("Hello, admin. Please enter the number "
				+ "\ncorresponding to your requested action.");
		System.out.println("1. View users   || 2. Create user ");
		System.out.println("3. Update user  || 4. Delete user ");
		System.out.println("5. Logout       ||");
		System.out.println("=========================================");
		int input = actionReader.nextInt();
		
		switch (input) {
			case 1:
				try {
					custList = CustomerDAO.getAllCustomers();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					for (Customer customer : custList) {
						System.out.println(customer.toString());
					}
					adminMenu();
				}
				break;
			case 2:
				System.out.println("Please input your desired username:");
				String userName = actionReader.next();
				userLoginHolder.add(userName);
				System.out.println("Please input your desired password:");
				String password = actionReader.next();
				userLoginHolder.add(password);
				System.out.println("What is your first name?");
				String firstName = actionReader.next();
				userLoginHolder.add(firstName);
				System.out.println("What is your last name?");
				String lastName = actionReader.next();
				userLoginHolder.add(lastName);
				
				try {
					CustomerDAO.writeCustToDB(userLoginHolder.get(0), userLoginHolder.get(1), userLoginHolder.get(2), userLoginHolder.get(3));
					System.out.println("User created.");
					adminMenu();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Please enter the customer ID to be edited.");
				int custPicker = actionReader.nextInt();
				System.out.println("Please input the category to be updated.");
				String newCategory = actionReader.next();
				System.out.println("Please input the new value.");
				String newValue = actionReader.next();
				
				try {
					CustomerDAO.updateCustomer(newCategory, newValue, custPicker);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					adminMenu();
				}
				
			case 4:
				System.out.println("Please enter the customer username whose profile you wish to delete.");
				String username = actionReader.next();
				try {
					CustomerDAO.deleteCustomer(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					System.out.println("Customer deleted.");
					adminMenu();
				}
				break;
			case 5:
				System.out.println("Logging out.");
				System.exit(0);;
		}
	}
}
