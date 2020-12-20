import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Universities extends Organisations implements caseManagmentAndHumanAddition{
	private ArrayList<Classes> department = new ArrayList<Classes>();
	private ArrayList<Classes> secretariat = new ArrayList<Classes>();
	private ArrayList<Human> teachers = new ArrayList<Human>();
	private ArrayList<Human> others = new ArrayList<Human>();
	private boolean status = false;//eody have smth changed
	private ArrayList<Human> changes = new ArrayList<Human>();
	private static Scanner scanner = new Scanner(System.in);
	private int id ;
	private static int count = 0;
	public Universities(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		add(this);
		modifyTeachers();
		modifySecretariat();
		id = count++;
	}
	public void printDetails() {
		//this method is used in displayUMenu
		//prints all details of the specific Uni(FE name,region)
		//with the code that takes,the code is similar the the check method ahead
		//look caseManagmentAndHumanAddition
	}
	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}
	public static void createOrg() {
		//look caseManagmentAndHumanAddition
	}
	public void declareCase(Human human) {
		Human one;
		changes.add(human);
		//where belongs in uni
	}
	public void declareCase() {//from user
		if (status) {
			System.out.println("First go to see your Status of your University. New cases have been entered by EODY");
		} else {

		}
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
	public void seeStatus() {
		if (status) {
			System.out.println("Some changes have been ocured");
			status = false;
			System.out.println("Positive have been found: ");
			for (var c : changes) {
				System.out.printf("    The person: %s", c.toString);
			}
			System.out.println("Please say us who have to tested");
			for (var c : changes) {
				int choice;
				while (true) {
					System.out.println("0 for exit, 1 for profesors, 2 for secretariat, 3 other people related, 4 departments");
					String input = scanner.nextLine();
					if (input.equals("0")) {
						break;
					} else if (input.equals("1")) {
						while (true) {
							System.out.println("Give the number for each profesor");
							System.out.println("0: Exit");
							for (int i = 0; i < teachers.size(); i++) {
								System.out.printf("%d: %s\n", i + 1, teachers.get(i).toString());
							}
							if (!sc.hasNextInt()) {
								String ans = sc.nextLine();
								System.out.printf(
										" Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", teachers.size());
								continue;
							} else {
								choice = sc.nextInt();
								sc.nextLine();
								if (choice > teachers.size()  || choice < 0) {
									System.out.println("Wrong number!Place a number between 0 and "+ teachers.size());
									continue;
								}
								break;
							}
						}
						if (choice == 0) {
							continue;
						} else if (choice <= teachers.size()) {
							teachers.get(choice -1 ).haveToBeTested();
							//send an email
						} else {
							continue;
						}
					} else if (input.equals("2")) {
						while (true) {
							System.out.println("Give the number for each secretariat");
							System.out.println("0: Exit");
							for (int i = 0; i < teachers.size(); i++) {
								System.out.printf("%d: %s\n", i + 1, teachers.get(i).toString());
							}
							if (!sc.hasNextInt()) {
								String ans = sc.nextLine();
								System.out.printf(
										" Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", teachers.size());
								continue;
							} else {
								choice = sc.nextInt();
								sc.nextLine();
								if (choice > teachers.size()  || choice < 0) {
									System.out.println("Wrong number!Place a number between 0 and "+ teachers.size());
									continue;
								}
								break;
							}
						}
						if (choice == 0) {
							continue;
						} else if (choice <= teachers.size()) {
							secretariat.get(choice -1 ).haveToBeTested();
						}
					} else if (input.equals("3")) {
						while (true) {
							System.out.println("Give the number for each other employee");
							System.out.println("0: Exit");
							for (int i = 0; i < teachers.size(); i++) {
								System.out.printf("%d: %s\n", i + 1, others.get(i).toString());
							}
							if (!sc.hasNextInt()) {
								String ans = sc.nextLine();
								System.out.printf(
										" Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", teachers.size());
								continue;
							} else {
								choice = sc.nextInt();
								sc.nextLine();
								if (choice > teachers.size()  || choice < 0) {
									System.out.println("Wrong number!Place a number between 0 and "+ teachers.size());
									continue;
								}
								break;
							}
						}
						if (choice == 0) {
							continue;
						} else if (choice <= others.size()) {
							others.get(choice - 1).haveToBeTested();
						}
					} else if (input.equals("4")) {
						while (true) {
							System.out.println("Select one by one in which departent should students be tested");
							System.out.println("0: Exit");
							for(int i = 0; i < department.size(); i++) {
								System.out.printf("%d: %s", i + 1, department.get(i).getIdifier());
							}
							if (!sc.hasNextInt()) {
								String ans = sc.nextLine();
								System.out.printf(
										" Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", department.size());
								continue;
							} else {
								choice = sc.nextInt();
								sc.nextLine();
								if (choice > department.size()  || choice < 0) {
									System.out.println("Wrong number!Place a number between 0 and "+ department.size());
									continue;
								}
								break;
							}
						}
						if (choice == 0) {
							continue;
						} else if (choice <= department.size()) {
							department.get(choice - 1).affected();
						}
					} else {
						System.out.println("Not valid option: " + input);
					}
				}
			}
		}
		System.out.println("Status of professors");
		for (var c : teachers) {
			System.out.println("%s has status:%s", c.toString(), c.seeStatus());
		}
		System.out.println("Status of secretariat");
		for (var c : secretariat) {
			System.out.println("    Status secretariat:%s", c.getIdifier());
			c.printStatus();
		}
		System.out.println("Status of other employee");
		for (var c : others) {
			System.out.println("%s has status:%s", c.toString(), c.seeStatus());
		}
		System.out.println("Status of each department");
		for (var c : department) {
			System.out.println("    Status secretariat:%s", c.getIdifier());
			c.printStatus();
		}

	}
	private void modifyOthers() {

	}

}
