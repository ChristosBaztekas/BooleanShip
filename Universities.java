package sample;

import java.util.Scanner;
import java.util.ArrayList;

public class Universities extends Organisations implements caseManagmentAndHumanAddition{
	private ArrayList<Classes> department = new ArrayList<Classes>();
	private ArrayList<Classes> secretariat = new ArrayList<Classes>();
	private ArrayList<Human> teachers = new ArrayList<Classes>();
	private static ArrayList<Universities> allUnis = new ArrayList<Universities>();
	private int id ;
	private static int count = 0;
	public Universities(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		modifyTeachers();
		modifySecretariat();
		id = count++;
		allUnis.add(this);
		
	}
	public static void printDetails(int code) {
		//this method is used in displayUMenu
		//prints all details of the specific Uni(FE name,region)
		//with the code that takes,the code is similar the the check method ahead
		//look caseManagmentAndHumanAddition
	}
	public static void callDeclareCase(int code) {
		//for example allUni.get(code).declareCase();
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
	private void modifyDepartments(){

	}
	private void modifyTeachers() {

	}

	private void modifySecretariat() {

	}

}
