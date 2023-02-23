package catering_service.utility;

import java.util.List;
import java.util.Scanner;

import catering_service.entity.Menu;
import catering_service.entity.MenuType;
import catering_service.service.MenuServiceImpl;

public class MenuUtility {

	public static void main(String[] args) {
		menudisplay();
	}

	public static void displayById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the menu id to search");
		int id = scanner.nextInt();

		MenuServiceImpl menuService = new MenuServiceImpl();
		Menu menu = menuService.findById(id);
		if (menu != null) {
			System.out.println("*************************************MENU*************************************");
			System.out.println("MENU_ID\t MENU_TYPE_ID\tMENU_NAME\tMENU_STATUS\t\tPRICE");
			System.out.println("______________________________________________________________________________");
			System.out.println(menu.getMenuId() + "\t\t" + menu.getMenuType().getMenuTypeId() + "\t"
					+ menu.getMenuName() + "\t\t" + menu.getMenuStatus() + "\t\t" + menu.getPrice());
		} else {
			System.out.println("No details found with the given ID...");
		}

	}

	public static void menudisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("******************************MENU DETAILS******************************");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show menu details");
			System.out.println("2. Add new menu");
			System.out.println("3. Edit menu details");
			System.out.println("4. Remove from menu");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllMenu();
				System.out.println("\n");
				break;

			case 2:
				getAllMenu();
				insertIntoMenu();
				getAllMenu();
				break;

			case 3:
				getAllMenu();
				updateIntoMenu();
				getAllMenu();
				break;

			case 4:
				getAllMenu();
				deleteFromMenu();
				getAllMenu();
				break;
				
			case 5:
				System.out.println("*********************************THANK YOU*******************************");
				condition = false;
				break;
				
			default:
				System.out.println("Invalid option, try again.\n");
			}
		} while (condition);
	}

	public static void getAllMenu() {

		MenuServiceImpl menuServiceImpl = new MenuServiceImpl();
		List<Menu> menuList = menuServiceImpl.findAll();
		display();
		for (Menu menu : menuList) {
			System.out.println(menu.getMenuId() + "\t\t" + menu.getMenuType().getMenuTypeId() + "\t\t"
					+ menu.getMenuName() + "\t\t" + menu.getMenuStatus() + "\t\t" + menu.getPrice());
		}

	}

	public static void display() {
		System.out.println("**************************************MENU**************************************");
		System.out.println("MENU_ID\t\tMENU_TYPE_ID\tMENU_NAME\tMENU_STATUS\t\tPRICE");
		System.out.println("________________________________________________________________________________");
	}

	public static void insertIntoMenu() {

		MenuTypeUtility.getAllMenuType();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Menu********");
		System.out.println("Enter the MenuID:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the MenuTypeID:");
		int menuTypeId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Menu Name:");
		String menuName = scanner.nextLine();
		System.out.println("Enter Menu Status:");
		String menuStatus = scanner.nextLine();
		System.out.println("Enter Price:");
		int price = scanner.nextInt();

		MenuType menuType = new MenuType();
		menuType.setMenuTypeId(menuTypeId);
		Menu menu = new Menu(menuId, menuType, menuName, menuStatus, price);
		MenuServiceImpl menuService = new MenuServiceImpl();
		menuService.save(menu);

	}

	public static void updateIntoMenu() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Update into Menu********");
		System.out.println("Enter the MenuID to update:");
		int menuId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the MenuTypeID to update:");
		int menuTypeId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter MenuName to update:");
		String menuName = scanner.nextLine();
		System.out.println("Enter MenuStatus to update:");
		String menuStatus = scanner.nextLine();
		System.out.println("Enter the Price to update:");
		int price = scanner.nextInt();

		MenuType menuType = new MenuType();
		menuType.setMenuTypeId(menuTypeId);
		Menu menu = new Menu(menuId, menuType, menuName, menuStatus, price);
		MenuServiceImpl menuService = new MenuServiceImpl();
		menuService.update(menu);
	}

	public static void deleteFromMenu() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Delete from Menu********");
		System.out.println("Enter the MenuID to delete:");
		int menuId = scanner.nextInt();
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		MenuServiceImpl menuService = new MenuServiceImpl();
		menuService.delete(menu);

	}

}
