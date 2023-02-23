package catering_service.utility;

import java.util.List;
import java.util.Scanner;

import catering_service.entity.Customer;
import catering_service.entity.MenuType;
import catering_service.service.CustomerServiceImpl;
import catering_service.service.MenuTypeServiceImpl;

public class MenuTypeUtility {

	public static void main(String[] args) {
		
		menudisplay();

	}

	public static void displayById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the menu type id to search");
		int id = scanner.nextInt();

		MenuTypeServiceImpl menuTypeService = new MenuTypeServiceImpl();
		MenuType menuType = menuTypeService.findById(id);
		if (menuType != null) {
			System.out.println("**********************************MENU TYPE**********************************");
			System.out.println("MENU_TYPE_ID\t MENU_TYPE_NAME\t\t\tDESCRIPTION");
			System.out.println("______________________________________________________________________________");
			System.out.println(menuType.getMenuTypeId() + "\t \t " + menuType.getTypeName() + "   \t\t "
					+ menuType.getDescription());
		} else {
			System.out.println("No details found with the given ID...");
		}

	}

	public static void updateIntoMenuType() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Update into MenuType********");
		System.out.println("Enter the MenuTypeID to update:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter TypeName to update:");
		String typeName = scanner.nextLine();
		System.out.println("Enter Description to update:");
		String description = scanner.nextLine();

		MenuType menuType = new MenuType(menuId, typeName, description);
		MenuTypeServiceImpl menuTypeService = new MenuTypeServiceImpl();
		menuTypeService.update(menuType);

	}

	public static void deleteFromMenuType() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Delete from MenuType********");
		System.out.println("Enter the MenuTypeID to delete:");
		int menuId = scanner.nextInt();
		MenuType menuType = new MenuType();
		menuType.setMenuTypeId(menuId);
		MenuTypeServiceImpl menuTypeService = new MenuTypeServiceImpl();
		menuTypeService.delete(menuType);

	}

	public static void insertIntoMenuType() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into MenuType********");
		System.out.println("Enter the MenuTypeID:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter TypeName:");
		String typeName = scanner.nextLine();
		System.out.println("Enter Description:");
		String description = scanner.nextLine();

		MenuType menuType = new MenuType(menuId, typeName, description);
		MenuTypeServiceImpl menuTypeService = new MenuTypeServiceImpl();
		menuTypeService.save(menuType);

	}

	public static void getAllMenuType() {

		MenuTypeServiceImpl menuTypeServiceImpl = new MenuTypeServiceImpl();
		List<MenuType> menuTypeList = menuTypeServiceImpl.findAll();
		display();
		for (MenuType menuType : menuTypeList) {
			System.out.println(menuType.getMenuTypeId() + "\t \t " + menuType.getTypeName() + "   \t\t "
					+ menuType.getDescription());
		}

	}

	public static void display() {
		System.out.println("**********************************MENU TYPE**********************************");
		System.out.println("MENU_TYPE_ID\t MENU_TYPE_NAME\t\t\tDESCRIPTION");
		System.out.println("______________________________________________________________________________");
	}

	public static void menudisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("******************************MENU TYPE DETAILS******************************");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show menu type details");
			System.out.println("2. Add new menu type");
			System.out.println("3. Edit menu type details");
			System.out.println("4. Remove from menu type");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllMenuType();
				System.out.println("\n");
				break;

			case 2:
				getAllMenuType();
				insertIntoMenuType();
				getAllMenuType();
				break;

			case 3:
				getAllMenuType();
				updateIntoMenuType();
				getAllMenuType();
				break;

			case 4:
				getAllMenuType();
				deleteFromMenuType();
				getAllMenuType();
				break;

			case 5:
				System.out.println("***********************************THANK YOU**********************************");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again.\n");
			}
			
		} while (condition);
		
	}
	
}
