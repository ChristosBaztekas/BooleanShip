package sample;

import java.util.Scanner;
import java.util.ArrayList;

public class Companies extends Labors implements caseManagmentAndHumanAddition {
	private final int id;
	private static int count = 0;
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Companies> allCompanies = new ArrayList<Companies>();

	public Companies(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		id = count++;
		allCompanies.add(this);

	}
	@Override
	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}
	@Override
	public static void createOrg() {
		//look caseManagmentAndHumanAddition
		while(true) {
			System.out.println("What is your name?");
			String name = scanner.nextLine();
			System.out.println("In which area is your company located?");
			String area = scanner.nextLine();
			System.out.println("How many employees does your company have?");
			int employees = scanner.nextInt();
			System.out.printf("Your Name: %s, Area: %s, Total Employees: %d.Is that correct? (1) for yes",name,area,employees);
			if (scanner.nextLine().equals("1")) {
				break;
			}
		}
		Companies newOne = new Companies(name, area, employees);
	}
	@Override
	public static void declareCase(int number) {
		//look caseManagmentAndHumanAddition
	}
	@Override
	public static void printDetails(int number) {
		//look caseManagmentAndHumanAddition
	}
}
