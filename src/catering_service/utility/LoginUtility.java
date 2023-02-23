package catering_service.utility;

import java.sql.SQLException;
import java.util.Scanner;

import catering_service.dao.LoginDAO;

public class LoginUtility {

	public static void main(String[] args) {
		checkLogin();
	}

	public static void checkLogin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***********LOGIN CREDENTIALS*************");
		System.out.println("-----------------------------------------");
		System.out.println();

		System.out.print("Enter User Name :");
		String userName = scanner.nextLine();
		System.out.print("Enter Password :");
		String password = scanner.nextLine();

		LoginDAO loginDao = new LoginDAO();
		boolean isLoginValid;
		try {
			isLoginValid = loginDao.findByUsernameAndPassword(userName, password);
			if (isLoginValid) {
				DisplayAllTables.displayAllTables();
			} else {
				System.out.println("Incorrect Login credentials. Try again");
				System.out.println();
				checkLogin();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
