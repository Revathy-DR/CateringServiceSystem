package catering_service.utility;

import java.util.Scanner;

public class DisplayAllTables {

	public static void main(String[] args) {
		displayAllTables();
	}

	public static void displayAllTables() {
		Scanner scanner = new Scanner(System.in);
		boolean condition = true;
		do {
			System.out.println("***********CATERING SERVICE MANAGEMENT SYSTEM*****************");
			System.out.println("---------------------------------------------------------------");
			System.out.println("1. SELECT CUTOMER DETAILS \n");
			System.out.println("2. SELECT STAFF DETAILS \n");
			System.out.println("3. SELECT MENU TYPE DETAILS \n");
			System.out.println("4. SELECT MENU DETAILS \n");
			System.out.println("5. SELECT ORDER DETAILS \n");
			System.out.println("6. SELECT PAYMENT DETAILS \n");
			System.out.println("7. SELECT RATING DETAILS \n");
			System.out.println("8. EXIT");
			System.out.println();
			System.out.print("ENTER YOUR CHOICE: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				CustomerUtility.menudisplay();
				System.out.println("\n");
				break;

			case 2:
				StaffUtility.menudisplay();
				System.out.println("\n");
				break;

			case 3:
				MenuTypeUtility.menudisplay();
				System.out.println("\n");
				break;

			case 4:
				MenuUtility.menudisplay();
				System.out.println("\n");
				break;

			case 5:
				OrderUtility.orderdisplay();
				System.out.println("\n");
				break;

			case 6:
				PaymentUtility.paymentdisplay();
				System.out.println("\n");
				break;

			case 7:
				RatingUtility.menudisplay();
				System.out.println("\n");
				break;

			case 8:
				System.out.println("******************THANK YOU!***************");
				condition = false;
				break;

			default:
				System.out.println("Invalid Option!");

			}

		} while (condition);
	}
}
