

import java.util.Scanner;
import java.util.ArrayList;

public class Companies extends Labors implements caseManagmentAndHumanAddition {
	private final int id;
	private static int count = 0;
	static Scanner scanner = new Scanner(System.in);
	private boolean lockdown = false;
	private int limit_per_department = 2;
	private int limit_total_number_small = 5;
	private int limit_percentage = 0.1;
	private int total_limit_percentage = 60;
	public Companies(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		add(this);
		id = count++;

	}
	@Override
	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}
	protected void autoMonitoring() {
		int count = 0;
		int numbercases;
		int
		for (c : department) {
			count += c.size();
		}
		if (count > total_limit_percentage) {
			int total_positive = 0;
			for (var c : department) {
				int numberdepartment;
				total_positive += numberdepartment;
				if (numberdepartment > limit_per_department) {
					//lockdown department
				}
			}
			if (count * percentage < numbercases)
		} else {
			int total_positive = 0;
			for (var c: department) {
				int numberdepartment;
				numberdepartment = c.covidCases();
				total_positive += numberdepartment;
				if (numberdepartment > limit_per_department) {
					//lockdown department
				}
			}
			if (total_positive > limit_total_number_small) {
				//lockdown labor
			}
		}
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

	public void declareCase() {
		//look caseManagmentAndHumanAddition
	}

	public void printDetails() {
		System.out.println("Welcome.The" + getName() + "Companies of" + getArea()
				+ "will take drastic measures to stop spread of covid-19 in our school.Please stay safe and we will call you soon. "
				+"Always our first priority was the safety of our employees! Thanks for understanding in these difficult times.");
		//look caseManagmentAndHumanAddition
	}
	public void modifyDepartments() {

	}
	public void seeStatus() {

	}
}
