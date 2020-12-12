package gr.projAboutCovid.leo.proj;

import java.util.Scanner;
import java.util.ArrayList;
public class Schools extends Organisations implements caseManagmentAndHumanAddition{
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Schools> allSchools = new ArrayList<Schools>() ;
	private static int count = 0; //use for our personal separation of the objects
	private int id ;//personal id of each object
	private ArrayList<Human> teachers = new ArrayList<Human>();
	private ArrayList<Human> w
	public Schools(String name, String area, int numbersOfPeople,) {
		//see if the arguments will be taken outside of the constructor or inside
		//more info call christos
		super(name, area, numbersOfPeople);
		createDetails();
		id = count++;
		allSchools.add(this);
	}
	public void createDetails() {

	}

	public static void callDeclareCase(int code) {
		//for example allSchools.get(code).declareCase();
	}
	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}

	public static void declareCase(int number) {
		//look caseManagmentAndHumanAddition
	}
	public static void createOrg() {
		while(true) {
			System.out.println("What is the name of the school?/nWrite the name without spaces!");
			String name = scanner.next();
			System.out.println("In which area is your organization located?/nWrite the are without spaces!");
			String area = scanner.next();
			System.out.println("How many teachers does your organization have?");
			scanner.nextLine();
			int teachers = scanner.nextInt();
			System.out.println("How many students does your organization have?");
			int students = scanner.nextInt();
			System.out.printf("Name School: %s, Area: %s, Total People(Teachers plus Students): %d.Is that correct? 1for yes",name,area,teachers+students);
			if (scanner.nextLine().equals("1")) {
				break;
			}
		}
		Schools newOn = new Schools(name,area,teachers+students);
	}

	public static void printDetails(int code) {
		System.out.println("Welcome.The" + allSchools.get(code).super.getName + "School of" + allSchools.get(code).super.getArea + "will take drastic measures to stop spread of covid-19 in our school.Please stay safe and we will call you soon.Always our first priority was the safety of our children!Thanks for understanding in these difficult times.");
	}
}
