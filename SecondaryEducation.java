package gr.projAboutCovid.leo.proj;

import java.util.Scanner;


public class SecondaryEducation extends Schools {
	private final int id;
	private static int count = 0;
	private ArrayList<Human> students;
	private ArrayList<Human> teachers;
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<SecondaryEducation> a = new ArrayList<SecondaryEducation>();
	
	public SecondaryEducation(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		id = count ++;
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
