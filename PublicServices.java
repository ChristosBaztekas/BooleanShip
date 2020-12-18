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

	public static void createOrg() {
		//look caseManagmentAndHumanAddition
		String name;
		String area;
		int employees;
		while(true) {
			System.out.println("What is your name?");
			name = scanner.nextLine();
			System.out.println("In which area is your Public Service located?");
			area = scanner.nextLine();
			System.out.println("How many employees does your Service have?");
			employees = scanner.nextInt();
			System.out.printf("Your Name: %s, Area: %s, Total Employees: %d. Is that correct? (1) for yes",name,area,employees);
			if (scanner.hasNext()) {
				scanner.nextLine();
			}
			String a = scanner.nextLine();
			if (a.equals("1")) {
				break;
			}
		}
		PublicServices newOne = new PublicServices(name, area, employees);
	}
	public static void declareCase(int code) {
		//look caseManagmentAndHumanAddition
	}
	public static void printDetails(int code) {
		System.out.println("Welcome.The" + allPublicServices.get(code).getName() + "Companies of" + allPublicServices.get(code).getArea() +
				"will take drastic measures to stop spread of covid-19 in this public sector. Please stay safe and we will call you soon. " +
				"Always our first priority was the safety of our employees! Thanks for understanding in these difficult times.");
	}
	public static void modifyDepartments(int code) {

	}
	public static void seeStatus(int code) {

	}


}

