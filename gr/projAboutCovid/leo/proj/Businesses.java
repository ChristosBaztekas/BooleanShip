package gr.projAboutCovid.leo.proj;

import java.util.ArrayList;
import java.util.Scanner;

//better to make Companies Class for Businesses
public class Businesses extends Labors {
	private final int id;
	private static int count = 0;
	private ArrayList<Human> employees;
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Businesses> a = new ArrayList<Businesses>();

	public Businesses(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		id = count ++;
		
	}

}
