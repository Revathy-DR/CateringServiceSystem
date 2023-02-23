package catering_service.utility;

import java.util.List;
import java.util.Scanner;

import catering_service.entity.Customer;
import catering_service.service.CustomerServiceImpl;

/***
 * 
 * @author Revathy
 *
 */
public class CustomerUtility {

	public static void main(String[] args) {
		menudisplay();
	}

	public static void displayById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer id to search");
		int id = scanner.nextInt();

		CustomerServiceImpl customerService = new CustomerServiceImpl();
		Customer customer = customerService.findById(id);
		if (customer != null) {
			System.out.println(
					"*******************************************CUSTOMER*******************************************");
			System.out.println("CUSTOMER_ID\tFIRST_NAME\tLAST_NAME\tCUSTOMER_EMAIL\t\tCUSTOMER_PHONE");
			System.out.println(
					"______________________________________________________________________________________________");
			System.out.println(customer.getCustomerId() + "\t\t" + customer.getCustomerFirstName() + "\t\t"
					+ customer.getCustomerLastName() + "\t\t" + customer.getCustomerEmail() + " \t"
					+ customer.getCustomerPhone());
		} else {
			System.out.println("No details found with the given ID...");
		}
	}

	public static void insertIntoCustomer() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Customer********");
		System.out.println("Enter the CustomerID:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter CustomerFirstName:");
		String customerfirstname = scanner.nextLine();
		System.out.println("Enter CustomerSecondName:");
		String customerlastname = scanner.nextLine();
		System.out.println("Enter CustomerEmail:");
		String customeremail = scanner.nextLine();
		System.out.println("Enter CustomerPhone:");
		String customerphone = scanner.nextLine();

		Customer customer = new Customer(customerId, customerfirstname, customerlastname, customeremail, customerphone);
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.save(customer);

	}

	public static void updateIntoCustomer() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********Update into Customer*********");
		System.out.println("Enter the CustomerID:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter CustomerFirstName:");
		String customerfirstname = scanner.nextLine();
		System.out.println("Enter CustomerSecondName:");
		String customerlastname = scanner.nextLine();
		System.out.println("Enter CustomerEmail:");
		String customeremail = scanner.nextLine();
		System.out.println("Enter CustomerPhone:");
		String customerphone = scanner.nextLine();

		Customer customer = new Customer(customerId, customerfirstname, customerlastname, customeremail, customerphone);
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.update(customer);

	}

	public static void deleteFromCustomer() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Delete from Customer********");
		System.out.println("Enter the CustomerID to delete:");
		int customerId = scanner.nextInt();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.delete(customer);

	}

	public static void getAllCustomer() {

		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		List<Customer> customerList = customerServiceImpl.findAll();
		display();
		for (Customer customer : customerList) {
			System.out.println(customer.getCustomerId() + "\t\t" + customer.getCustomerFirstName() + "\t\t"
					+ customer.getCustomerLastName() + "\t\t" + customer.getCustomerEmail() + " \t"
					+ customer.getCustomerPhone());
		}

	}

	public static void display() {
		System.out.println(
				"*******************************************CUSTOMER*******************************************");
		System.out.println("CUSTOMER_ID\tFIRST_NAME\tLAST_NAME\tCUSTOMER_EMAIL\t\tCUSTOMER_PHONE");
		System.out.println(
				"______________________________________________________________________________________________");
	}

	public static void menudisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("****************************CUSTOMER DETAILS****************************");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show customer details");
			System.out.println("2. Add new customer");
			System.out.println("3. Edit customer details");
			System.out.println("4. Remove from customer:");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllCustomer();
				System.out.println("\n");
				break;

			case 2:
				getAllCustomer();
				insertIntoCustomer();
				getAllCustomer();
				break;

			case 3:
				getAllCustomer();
				updateIntoCustomer();
				getAllCustomer();
				break;

			case 4:
				getAllCustomer();
				deleteFromCustomer();
				getAllCustomer();
				break;

			case 5:
				System.out.println("********************************************THANK YOU******************************************");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again.\n");
			}

		} while (condition);

	}

}
