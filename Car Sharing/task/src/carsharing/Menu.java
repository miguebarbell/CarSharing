package carsharing;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Menu {
	Scanner in = new Scanner(System.in);
	DatabaseConnector database;

	public Menu(DatabaseConnector databaseConnector) throws SQLException {
		database = databaseConnector;
//		mainMenu();
	}

	public void mainMenu() throws SQLException {
		System.out.println("1. Log in as a manager\n0. Exit");
		int next = in.nextInt();
		switch (next) {
			case 1:
				managerMenu();
			case 0:
				database.disconnect();
		}
	}
	public void managerMenu() throws SQLException {
		System.out.println("1. Company list\n2. Create a company\n0. Back");
		int next = in.nextInt();
		switch (next) {
			case 1:
				companyList();
			case 2:
				createCompany();
			case 0:
				mainMenu();
		}
	}
	public void companyList() throws SQLException {
		// print all companies created
		List<Company> response = database.companydao.getAllCompanies();
		response.sort(Comparator.comparing(Company::getID));
		if (response.size() > 0) {
			for (Company company : response) {
				System.out.println(company.getID() + ". " + company.getCompanyName());
		}
		} else System.out.println("The company list is empty!");
//		String sql = "";
//		database.execute(sql);
		managerMenu();
	}
	public void createCompany() throws SQLException {
		System.out.println("Enter the company name: ");
		in.nextLine();
		String newCompanyName = in.nextLine();
		database.companydao.addCompany(newCompanyName);
		String sql = "INSERT INTO COMPANY (NAME) VALUES ('" + newCompanyName + "')";
		database.executeQuery(sql);
		System.out.println("The company was created!");
		managerMenu();
	}
}
