package gr.projAboutCovid.leo.proj;

import java.util.Scanner;
import java.util.ArrayList;

public class PublicServices extends Labors {
	private final int id;
	private static int count = 0;
	private ArrayList<Human> employees;
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<PublicServices> allPublicServices = new ArrayList<PublicServices>();

	public PublicServices(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		id = count ++;
		
	}
	@Override
	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}
	@Override
	public static void createOrg() {
		//look caseManagmentAndHumanAddition
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
