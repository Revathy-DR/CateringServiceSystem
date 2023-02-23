package catering_service.utility;

import java.util.List;
import java.util.Scanner;

import catering_service.entity.Customer;
import catering_service.entity.Menu;
import catering_service.entity.Order;
import catering_service.entity.Payment;
import catering_service.entity.Staff;
import catering_service.service.OrderServiceImpl;
import catering_service.service.PaymentServiceImpl;
import catering_service.service.RatingServiceImpl;

public class PaymentUtility {

	public static void main(String[] args) {
		paymentdisplay();
		//BillPdfGenerator.generateBillById();

	}

	public static void displayById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the payment id to search");
		int id = scanner.nextInt();

		PaymentServiceImpl paymentService = new PaymentServiceImpl();
		Payment payment = paymentService.findById(id);
		if (payment != null) {
			System.out.println("***********************************************************PAYMENT************************************************************");
			System.out.println("PAYMENT_ID\tSTAFF_ID\tORDER_ID\tCUSTOMER_ID\tMENU_ID\t\tAMOUNT\t\tPAID_BY\t\tPAYMENT_DATE");
			System.out.println("______________________________________________________________________________________________________________________________");
			System.out.println(payment.getPaymentId() + "\t\t" + payment.getStaff().getStaffId() + "\t\t"
					+ payment.getOrder().getOrderId() + "\t\t" + payment.getCustomer().getCustomerId() + "\t\t"
					+ payment.getMenu().getMenuId() + "\t\t" + payment.getAmount() + "\t\t" + payment.getPaidBy() + "\t\t" + payment.getPaymentDate());

		} else {
			System.out.println("No details found with the given ID...");
		}

	}

	public static void paymentdisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("******************************PAYMENT DETAILS******************************");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show payment details");
			System.out.println("2. Add new payment");
			System.out.println("3. Edit payment details");
			System.out.println("4. Remove from payment");
			System.out.println("5. Bill generator");
			System.out.println("6. Exit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllPayment();
				System.out.println("\n");
				break;

			case 2:
				getAllPayment();
				insertIntoPayment();
				getAllPayment();
				break;

			case 3:
				getAllPayment();
				updateIntoPayment();
				getAllPayment();
				break;

			case 4:
				getAllPayment();
				deleteFromPayment();
				getAllPayment();
				break;
				
			case 5: 
				BillPdfGenerator.generateBillById();
				System.out.println("\n");
				break;
				
			case 6:
				System.out.println("****************************************THANK YOU**************************************");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again.\n");
			}
		} while (condition);
	}

	public static void getAllPayment() {

		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		List<Payment> paymentList = paymentServiceImpl.findAll();
		display();
		for (Payment payment : paymentList) {
			System.out.println(payment.getPaymentId() + "\t\t" + payment.getStaff().getStaffId() + "\t\t"
					+ payment.getOrder().getOrderId() + "\t\t" + payment.getCustomer().getCustomerId() + "\t\t"
					+ payment.getMenu().getMenuId() + "\t\t" + payment.getAmount() + "\t\t" + payment.getPaidBy() + "\t\t" + payment.getPaymentDate());
		}

	}

	public static void display() {
		System.out.println("**********************************************************PAYMENT************************************************************");
		System.out.println("PAYMENT_ID\tSTAFF_ID\tORDER_ID\tCUSTOMER_ID\tMENU_ID\t\tAMOUNT\t\tPAID_BY\t\tPAYMENT_DATE");
		System.out.println("_____________________________________________________________________________________________________________________________");
	}

	public static void insertIntoPayment() {

		StaffUtility.getAllStaff();
		OrderUtility.getAllOrder();
		CustomerUtility.getAllCustomer();
		MenuUtility.getAllMenu();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Payment********");
		System.out.println("Enter the PaymentID:");
		int paymentId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the OrderID:");
		int orderId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CustomerID:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the MenuID:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Amount:");
		int amount = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Paid by:");
		String paidBy = scanner.nextLine();
		System.out.println("Enter Payment Date:");
		String paymentDate = scanner.nextLine();

		// Payment payment = new Payment();
		Staff staff = new Staff();
		staff.setStaffId(staffId);
		Order order = new Order();
		order.setOrderId(orderId);
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Menu menu = new Menu();
		menu.setMenuId(menuId);

		/*
		 * payment.setStaff(staff); payment.setOrder(order); payment.setAmount(amount);
		 * payment.setPaidBy(paidBy); payment.setPaymentDate(paymentDate);
		 */
		Payment payment = new Payment(paymentId, staff, order, customer, menu, amount, paidBy, paymentDate);
		PaymentServiceImpl paymentService = new PaymentServiceImpl();
		paymentService.save(payment);

	}

	public static void updateIntoPayment() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updating into Payment********");
		System.out.println("Enter the PaymentID:");
		int paymentId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the OrderID:");
		int orderId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CustomerID:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the MenuID:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Amount:");
		int amount = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Paid by:");
		String paidBy = scanner.nextLine();
		System.out.println("Enter Payment Date:");
		String paymentDate = scanner.nextLine();

		Staff staff = new Staff();
		staff.setStaffId(staffId);
		Order order = new Order();
		order.setOrderId(orderId);
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Menu menu = new Menu();
		menu.setMenuId(menuId);

		Payment payment = new Payment(paymentId, staff, order, customer, menu, amount, paidBy, paymentDate);
		PaymentServiceImpl paymentService = new PaymentServiceImpl();
		paymentService.update(payment);

	}

	public static void deleteFromPayment() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Delete from Payment********");
		System.out.println("Enter the PaymentID to delete:");
		int paymentId = scanner.nextInt();
		Payment payment = new Payment();
		payment.setPaymentId(paymentId);
		PaymentServiceImpl paymentService = new PaymentServiceImpl();
		paymentService.delete(payment);

	}

}
