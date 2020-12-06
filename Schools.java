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

	public static void printDetails(int code) {
		//this method is used in displaySMenu
		//prints all details of the specific school(FE name,region)
		//with the code that takes,the code is similar the the check method ahead
		//look caseManagmentAndHumanAddition
	}
	public static void callDeclareCase(int code) {
		//for example allSchools.get(code).declareCase();
	}
	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}
	public static void createOrg() {
		//look caseManagmentAndHumanAddition
	}
	public static void declareCase(int number) {
		//look caseManagmentAndHumanAddition
	}
}
