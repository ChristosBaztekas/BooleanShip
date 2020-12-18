

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

	public static void createOrg() {
		//look caseManagmentAndHumanAddition
		String name;
		String area;
		int employees;
		while(true) {
			System.out.println("What is your name?");
			name = scanner.nextLine();
			System.out.println("In which area is your company located?");
			area = scanner.nextLine();
			System.out.println("How many employees does your company have?");
			employees = scanner.nextInt();
			System.out.printf("Your Name: %s, Area: %s, Total Employees: %d.Is that correct? (1) for yes",name,area,employees);
			if (scanner.hasNext()) {
				scanner.nextLine();
			}
			if (scanner.nextLine().equals("1")) {
				break;
			}
		}
		Companies newOne = new Companies(name, area, employees);
	}

	public static void declareCase(int number) {
		//look caseManagmentAndHumanAddition
	}

	public static void printDetails(int code) {
		System.out.println("Welcome.The" + allCompanies.get(code).getName() + "Companies of" + allCompanies.get(code).getArea()
				+ "will take drastic measures to stop spread of covid-19 in our school.Please stay safe and we will call you soon. "
				+"Always our first priority was the safety of our employees! Thanks for understanding in these difficult times.");
		//look caseManagmentAndHumanAddition
	}
	public static void modifyDepartments(int code) {

	}
	public static void seeStatus(int code) {

	}
}
