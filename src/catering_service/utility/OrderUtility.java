package catering_service.utility;

import java.util.List;
import java.util.Scanner;

import catering_service.entity.Customer;
import catering_service.entity.Menu;
import catering_service.entity.Order;
import catering_service.entity.Staff;
import catering_service.service.MenuServiceImpl;
import catering_service.service.OrderServiceImpl;

public class OrderUtility {

	public static void main(String[] args) {
		orderdisplay();

	}

	public static void displayById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the order id to search");
		int id = scanner.nextInt();

		OrderServiceImpl orderService = new OrderServiceImpl();
		Order order = orderService.findById(id);
		if (order != null) {
			System.out.println(
					"****************************************************************ORDER****************************************************************");
			System.out.println("ORDER_ID\tCUSTOMER_ID\tSTAFF_ID\tMENU_ID\t\tORDER_STATUS\t\tORDER_DATE\tNO_OFSERVINGS\tTOTAL_AMOUNT");
			System.out.println(
					"_____________________________________________________________________________________________________________________________________");
			System.out.println(order.getOrderId() + "\t\t" + order.getCustomer().getCustomerId() + "\t\t"
					+ order.getStaff().getStaffId() + "\t\t" + order.getMenu().getMenuId() + "\t\t"
					+ order.getOrderStatus() + "  \t\t" + order.getOrderDate() + "\t\t" + order.getNoOfServings());
		} else {
			System.out.println("No details found with the given ID...");
		}

	}

	public static void orderdisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("******************************ORDER DETAILS******************************");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show order details");
			System.out.println("2. Add new order");
			System.out.println("3. Edit order details");
			System.out.println("4. Remove from order");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllOrder();
				System.out.println("\n");
				break;

			case 2:
				getAllOrder();
				insertIntoOrder();
				getAllOrder();
				break;

			case 3:
				getAllOrder();
				updateIntoOrder();
				getAllOrder();
				break;

			case 4:
				getAllOrder();
				deleteFromOrder();
				getAllOrder();
				break;
				
			case 5:
				System.out.println("**********************************************************THANK YOU******************************************************");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again.\n");
			}
		} while (condition);
	}

	public static void getAllOrder() {

		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		List<Order> orderList = orderServiceImpl.findAll();
		display();
		for (Order order : orderList) {
			System.out.println(order.getOrderId() + "\t\t" + order.getCustomer().getCustomerId() + "\t\t"
					+ order.getStaff().getStaffId() + "\t\t" + order.getMenu().getMenuId() + "\t\t"
					+ order.getOrderStatus() + "  \t\t" + order.getOrderDate() + "\t\t" + order.getNoOfServings());
		}

	}

	public static void display() {
		System.out.println("****************************************************************ORDER****************************************************************");
		System.out.println("ORDER_ID\tCUSTOMER_ID\tSTAFF_ID\tMENU_ID\t\tORDER_STATUS\t\tORDER_DATE\tNO_OFSERVINGS");
		System.out.println("_____________________________________________________________________________________________________________________________________");
	}

	public static void insertIntoOrder() {

		CustomerUtility.getAllCustomer();
		StaffUtility.getAllStaff();
		MenuUtility.getAllMenu();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Order********");
		System.out.println("Enter the OrderID:");
		int orderId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CustomerID:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the MenuID:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Order Status:");
		String orderStatus = scanner.nextLine();
		System.out.println("Enter OrderDate:");
		String orderDate = scanner.nextLine();
		System.out.println("Enter No of Servings:");
		int noOfServings = scanner.nextInt();
		scanner.nextLine();

		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Staff staff = new Staff();
		staff.setStaffId(staffId);
		Menu menu = new Menu();
		menu.setMenuId(menuId);

		Order order = new Order(orderId, customer, staff, menu, orderStatus, orderDate, noOfServings);
		OrderServiceImpl orderService = new OrderServiceImpl();
		orderService.save(order);

	}

	public static void updateIntoOrder() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updating into Order********");
		System.out.println("Enter the OrderID:");
		int orderId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CustomerID:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the MenuID:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Order Status:");
		String orderStatus = scanner.nextLine();
		System.out.println("Enter OrderDate:");
		String orderDate = scanner.nextLine();
		System.out.println("Enter No of Servings:");
		int noOfServings = scanner.nextInt();
		scanner.nextLine();

		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Staff staff = new Staff();
		staff.setStaffId(staffId);
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		Order order = new Order(orderId, customer, staff, menu, orderStatus, orderDate, noOfServings);
		OrderServiceImpl orderService = new OrderServiceImpl();
		orderService.update(order);

	}

	public static void deleteFromOrder() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Delete from Order********");
		System.out.println("Enter the OrderID to delete:");
		int orderId = scanner.nextInt();
		Order order = new Order();
		order.setOrderId(orderId);
		OrderServiceImpl orderService = new OrderServiceImpl();
		orderService.delete(order);
	}

}
