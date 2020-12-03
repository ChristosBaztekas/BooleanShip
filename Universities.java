package gr.projAboutCovid.leo.proj;

public class Universities extends Organisations implements caseManagmentAndHumanAddition{

	public Universities(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		
	}

	
	public void insertHumanToOrganisation(Human human) {
		
		
	}

	
	public void managementCases(Human anyH) {
		
		
	}

	
	public void declareCase() {
		
		
	}
	public static void createUni() {
		//creates a new university
		//Universities u = new Universities()
	}
	public static int check() {
		//ask for the code , ask if wants to quit too
		//checks if the code exists and returns it, otherwise returns -1
		return 0;
	}
	public static void printDetails(int code) {
		//this method is used in displayUMenu
		//prints all details of the specific Uni(FE name,region)
		//with the code that takes,the code is similar the the check method ahead
	}
	public static void callDeclareCase(int code) {
		//for example allUni.get(code).declareCase();
	}
}
