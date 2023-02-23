package catering_service.utility;

import java.util.List;
import java.util.Scanner;
import catering_service.entity.Staff;
import catering_service.service.StaffServiceImpl;

/***
 * 
 * @author Revathy
 *
 */
public class StaffUtility {

	public static void main(String[] args) {
		// getAllStaff();
		// insertIntoStaff();
		menudisplay();

	}

	public static void displayById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the staff id to search");
		int id = scanner.nextInt();

		StaffServiceImpl staffService = new StaffServiceImpl();
		Staff staff = staffService.findById(id);
		if (staff != null) {
			System.out.println("***********************************STAFF***********************************");
			System.out.println("STAFF_ID\tSTAFF_NAME\tSTAFF_PHONE\tSTAFF_ADDRESS");
			System.out.println("___________________________________________________________________________");
			System.out.println(staff.getStaffId() + "\t\t" + staff.getStaffName() + "\t\t" + staff.getStaffPhone()
					+ "\t" + staff.getStaffAddress());
		} else {
			System.out.println("No details found with the given ID...");
		}
	}

	public static void insertIntoStaff() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Staff********");
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter StaffName:");
		String staffname = scanner.nextLine();
		System.out.println("Enter StaffPhone:");
		String staffphone = scanner.nextLine();
		System.out.println("Enter StaffAddress:");
		String staffaddress = scanner.nextLine();

		Staff staff = new Staff(staffId, staffname, staffphone, staffaddress);
		StaffServiceImpl staffService = new StaffServiceImpl();
		staffService.save(staff);

	}

	public static void updateIntoStaff() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updating into Staff********");
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter StaffName:");
		String staffname = scanner.nextLine();
		System.out.println("Enter StaffPhone:");
		String staffphone = scanner.nextLine();
		System.out.println("Enter StaffAddress:");
		String staffaddress = scanner.nextLine();

		Staff staff = new Staff(staffId, staffname, staffphone, staffaddress);
		StaffServiceImpl staffService = new StaffServiceImpl();
		staffService.update(staff);

	}

	public static void deleteFromStaff() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Delete from Staff********");
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		Staff staff = new Staff();
		staff.setStaffId(staffId);
		StaffServiceImpl staffService = new StaffServiceImpl();
		staffService.delete(staff);

	}

	/***
	 * To get all customers from the staff table
	 */

	public static void getAllStaff() {

		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		List<Staff> staffList = staffServiceImpl.findAll();
		display();
		for (Staff staff : staffList) {
			System.out.println(staff.getStaffId() + "\t\t" + staff.getStaffName() + "\t\t" + staff.getStaffPhone()
					+ "\t" + staff.getStaffAddress());
		}

	}

	public static void display() {
		System.out.println("***********************************STAFF***********************************");
		System.out.println("STAFF_ID\tSTAFF_NAME\tSTAFF_PHONE\tSTAFF_ADDRESS");
		System.out.println("___________________________________________________________________________");
	}

	public static void menudisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("****************************STAFF DETAILS****************************");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show staff details");
			System.out.println("2. Add new staff");
			System.out.println("3. Edit staff details");
			System.out.println("4. Remove from staff");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllStaff();
				System.out.println("\n");
				break;

			case 2:
				getAllStaff();
				insertIntoStaff();
				getAllStaff();
				break;

			case 3:
				getAllStaff();
				updateIntoStaff();
				getAllStaff();
				break;

			case 4:
				getAllStaff();
				deleteFromStaff();
				getAllStaff();
				break;
				
			case 5:
				System.out.println("**********************************THANK YOU*********************************");
				condition = false;
				break;
				
			default:
				System.out.println("Invalid option, try again.\n");
			}

		} while (condition);

	}

}
