package gr.projAboutCovid.leo.proj;

public class Universities extends Organisations implements caseManagmentAndHumanAddition{

	public Universities(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		
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

}
