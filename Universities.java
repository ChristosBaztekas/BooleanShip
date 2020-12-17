import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Universities extends Organisations implements caseManagmentAndHumanAddition{
	private ArrayList<Classes> department = new ArrayList<Classes>();
	private ArrayList<Classes> secretariat = new ArrayList<Classes>();
	private ArrayList<Human> teachers = new ArrayList<Human>();
	private static Scanner scanner = new Scanner(System.in);
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
		while (true){
			if(teachers.size() != 0) {
				System.out.printf("There are %d Professor(s), would you like to add new?\n" +
						"Press 1 for yes,otherwise we will go to remove panel", teachers.size());
				String ans = scanner.nextLine();
				if (ans.equals("1")) {
					int i = 0;
					while (true) {
						System.out.printf("Adding the %d professor, for exit 0", i+1);
						if (scanner.nextLine().equals("0")) {
							break;
						}
						Human one = Human.createHuman(this.getClass().getName(), this.id);
						teachers.add(one);
					}
					break;
				}
				System.out.printf("There are %d Professor(s), would you like to remove one?\n" +
						"Press 1 for yes", teachers.size());
				String ans0 = scanner.nextLine();
				if (ans0.equals("1")) {
					while (true){
						System.out.println("Give the afm of the professor that want to remove");
						String afm = scanner.nextLine();
						boolean flag = true;
						for (int i=0; i < teachers.size(); i++) {
							if (teachers.get(i).getAfm().equals(afm)) {
								teachers.remove(i);
								flag = false;
								break;
							}
						}
						if (flag) {
							System.out.printf("Could not find professor with afm:% s", afm);
						}
						System.out.println("Continue the deletion process? 0 for exit");
						String ans1 = scanner.nextLine();
						if (ans1.equals("0")) {
							break;
						}
					}
					break;
				}
			} else {//from cunstractor
				System.out.println("There are no professors filled, Please start with giving them");
				int i = 0;
				while (true) {
					System.out.printf("Creating the %d professor, 0 for exit", i+1);
					if (scanner.nextLine().equals("0")) {
						break;
					}
					Human one = Human.createHuman(this.getClass().getName(), this.id);
					teachers.add(one);
					i++;
				}
				break;
			}
		}
	}

	private void modifySecretariat() {

	}

}
