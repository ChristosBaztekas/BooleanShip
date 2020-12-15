package gr.projAboutCovid.leo.proj;

import java.util.Scanner;
import java.util.ArrayList;

public class PublicServices extends Labors {
	private final int id;
	private static int count = 0;
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<PublicServices> allPublicServices = new ArrayList<PublicServices>();

	public PublicServices(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		id = count ++;
		allPublicServices.add(this);

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
			System.out.println("In which area is your Public Service located?");
			String area = scanner.nextLine();
			System.out.println("How many employees does your Service have?");
			int employees = scanner.nextInt();
			System.out.printf("Your Name: %s, Area: %s, Total Employees: %d.Is that correct? (1) for yes",name,area,employees);
			if (scanner.nextLine().equals("1")) {
				break;
			}
		}
		PublicServices newOne = new PublicServices(name, area, employees);
	}
	@Override
	public static void declareCase(int code) {
		//look caseManagmentAndHumanAddition
	}
	@Override
	public static void printDetails(int code) {
		System.out.println("Welcome.The" + allPublicServices.get(code).super.getName + "Companies of" + allPublicServices.get(code).super.getArea + "will take drastic measures to stop spread of covid-19 in this public sector. Please stay safe and we will call you soon. Always our first priority was the safety of our employees! Thanks for understanding in these difficult times.");
	}

}

