package gr.projAboutCovid.leo.proj;

public interface caseManagmentAndHumanAddition {
	public void managementCases() {};//is called by inside the class with cooperation of declareCase for the protocol
	public static void createOrg() {};//creates a new whole object of your class
	public static void declareCase(int number) {};// implements the protocol of each class !in a object!
	public static void printDetails(int number) {};//prints the details of the object (int number)
													// in your class that you want
}