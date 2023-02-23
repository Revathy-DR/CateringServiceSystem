package catering_service.utility;

import java.util.List;
import java.util.Scanner;

import catering_service.entity.Customer;
import catering_service.entity.Menu;
import catering_service.entity.Payment;
import catering_service.entity.Rating;
import catering_service.service.CustomerServiceImpl;
import catering_service.service.RatingServiceImpl;

public class RatingUtility {

	public static void main(String[] args) {
		menudisplay();

	}

	public static void displayById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the menu id to search");
		int id = scanner.nextInt();

		RatingServiceImpl ratingService = new RatingServiceImpl();
		Rating rating = ratingService.findById(id);
		
		if (rating != null) {
			System.out.println("******************************************RATING******************************************");
			System.out.println("RATING_ID\tCUSTOMER_ID\tMENU_ID\t\tPAYMENT_ID\tSCORE\t\tREVIEW");
			System.out.println("__________________________________________________________________________________________");
			System.out.println(rating.getRatingId() + "\t\t" + rating.getCustomer().getCustomerId() + "\t\t"
					+ rating.getMenu().getMenuId() + "\t\t" + rating.getPayment().getPaymentId() + "\t\t"
					+ rating.getScore() + "\t\t" + rating.getReview());
		} else {
			System.out.println("No details found with the given ID...");
		}

	}
	public static void displayMaxScore() {
		
		RatingServiceImpl ratingService = new RatingServiceImpl();
		List<Rating> ratingList = ratingService.findMaxScore();
				
		for (Rating rating : ratingList) {
		
				System.out.println("______________________________________");
				System.out.println("Customer id  : "+ rating.getCustomer().getCustomerId());
				System.out.println("Menu id      : "+ rating.getMenu().getMenuId());
				System.out.println("Highest Score: "+ rating.getScore());
				System.out.println("Review       : "+ rating.getReview());
				System.out.println("______________________________________");
				
		}

	}

	public static void menudisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("******************************RATING DETAILS******************************");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show rating details");
			System.out.println("2. Add new rating");
			System.out.println("3. Edit rating details");
			System.out.println("4. Remove from rating details");
			System.out.println("5. Show max score and review");
			System.out.println("6. Exit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			/*case 1:
				displayById();
				System.out.println("\n");
				break;*/

			case 1:
				getAllRating();
				System.out.println("\n");
				break;

			case 2:
				getAllRating();
				insertIntoRating();
				getAllRating();
				break;

			case 3:
				getAllRating();
				updateIntoRating();
				getAllRating();
				break;

			case 4:
				getAllRating();
				deleteFromRating();
				getAllRating();
				break;
				
			case 5:
				//getAllRating();
				displayMaxScore();
				//getAllRating();
				break;
				
			case 6:
				System.out.println("*****************************THANK YOU***************************");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again.\n");
			}
		} while (condition);
	}

	public static void getAllRating() {

		RatingServiceImpl ratingServiceImpl = new RatingServiceImpl();
		List<Rating> ratingList = ratingServiceImpl.findAll();
		display();
		for (Rating rating : ratingList) {
			System.out.println(rating.getRatingId() + "\t\t" + rating.getCustomer().getCustomerId() + "\t\t"
					+ rating.getMenu().getMenuId() + "\t\t" + rating.getPayment().getPaymentId() + "\t\t"
					+ rating.getScore() + "\t\t" + rating.getReview());
		}

	}

	public static void display() {
		System.out.println("******************************************RATING******************************************");
		System.out.println("RATING_ID\tCUSTOMER_ID\tMENU_ID\t\tPAYMENT_ID\tSCORE\t\tREVIEW");
		System.out.println("__________________________________________________________________________________________");
	}

	public static void insertIntoRating() {

		CustomerUtility.getAllCustomer();
		MenuUtility.getAllMenu();
		PaymentUtility.getAllPayment();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Rating********");
		System.out.println("Enter the RatingID:");
		int ratingId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CustomerID:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter MenuID:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Payment ID:");
		int paymentId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Score:");
		int score = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Review:");
		String review = scanner.nextLine();

		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		Payment payment = new Payment();
		payment.setPaymentId(paymentId);

		Rating rating = new Rating(ratingId, customer, menu, payment, score, review);
		RatingServiceImpl ratingService = new RatingServiceImpl();
		ratingService.save(rating);

	}

	public static void updateIntoRating() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updating into Rating********");
		System.out.println("Enter the RatingID to update:");
		int ratingId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CustomerID to update:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter MenuID to update:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Payment ID to update:");
		int paymentId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Score to update:");
		int score = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Review:");
		String review = scanner.nextLine();

		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		Payment payment = new Payment();
		payment.setPaymentId(paymentId);

		Rating rating = new Rating(ratingId, customer, menu, payment, score, review);
		RatingServiceImpl ratingService = new RatingServiceImpl();
		ratingService.update(rating);
	}

	public static void deleteFromRating() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Delete from Rating********");
		System.out.println("Enter the RatingID to delete:");
		int ratingId = scanner.nextInt();
		Rating rating = new Rating();
		rating.setRatingId(ratingId);
		RatingServiceImpl ratingService = new RatingServiceImpl();
		ratingService.delete(rating);

	}

}
