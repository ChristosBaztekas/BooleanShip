package gr.projAboutCovid.leo.proj;

public class Schools extends Organisations implements caseManagmentAndHumanAddition{

	public Schools(String name, String area, int numbersOfPeople) {
		//see if the arguments will be taken outside of the constructor or inside
		//more info call christos
		super(name, area, numbersOfPeople);
		
	}

	
	public void insertHumanToOrganisation(Human human) {
		
		
	}

	
	public void managementCases(Human anyH) {
		
		
	}

	
	public void declareCase() {
		
		
	}
	public static void createSchool() {
		//see if arguments will be taken from constructor
		Schools school = new Schools("", "", ""); //not good statement
												//trying to give an idea
	}
	public static int check() {
		//ask for the code , ask if wants to quit too
		//checks if the code exists and returns it, otherwise returns -1
		return 0;
	}
	public static void printDetails(int code) {
		//this method is used in displaySMenu
		//prints all details of the specific school(FE name,region)
		//with the code that takes,the code is similar the the check method ahead
	}
	public static void callDeclareCase(int code) {
		//for example allSchools.get(code).declareCase();
	}

}
