package gr.projAboutCovid.leo.proj;

import java.util.Scanner;


public class PublicServices extends Labors {
	private final int id;
	private static int count = 0;
	private ArrayList<Human> employees;
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<PublicServices> a = new ArrayList<PublicServices>();

	public PublicServices(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		count ++;
		
	}
	@Override
	public void insertHumanToOrganisation(Human human) {
		
		
	}

	@Override
	public void managementCases(Human anyH) {
		
		
	}

	@Override
	public void declareCase() {
		
		
	}
}
