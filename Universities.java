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
		modifyOthers();
		modifyDepartments();
		id = count++;
	}
	public void printDetails() {
		System.out.println("Welcome.The" + getName() +
				"University of" + .getArea() +
				"will take drastic measures to stop spread of covid-19 in our University.Please stay safe and we will call you soon." +
				"Always our first priority was the safety of our students!Thanks for understanding in these difficult times.");
		//this method is used in displayUMenu
		//prints all details of the specific Uni(FE name,region)
		//with the code that takes,the code is similar the the check method ahead
		//look caseManagmentAndHumanAddition
	}
	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}
	private void monitoring() {
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
					System.out.println("Contacts of the" + c.toString());
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
							for (int i = 0; i < secretariat.size(); i++) {
								System.out.printf("%d: %s\n", i + 1, secretariat.get(i).getIdifier());
							}
							if (!sc.hasNextInt()) {
								String ans = sc.nextLine();
								System.out.printf(
										" Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", secretariat.size());
								continue;
							} else {
								choice = sc.nextInt();
								sc.nextLine();
								if (choice > secretariat.size()  || choice < 0) {
									System.out.println("Wrong number!Place a number between 0 and "+ teachers.size());
									continue;
								}
								break;
							}
						}
						if (choice == 0) {
							continue;
						} else if (choice <= teachers.size()) {
							secretariat.get(choice -1 ).affected();
						}
					} else if (input.equals("3")) {
						while (true) {
							System.out.println("Give the number for each other employee");
							System.out.println("0: Exit");
							for (int i = 0; i < others.size(); i++) {
								System.out.printf("%d: %s\n", i + 1, others.get(i).toString());
							}
							if (!sc.hasNextInt()) {
								String ans = sc.nextLine();
								System.out.printf(
										" Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", others.size());
								continue;
							} else {
								choice = sc.nextInt();
								sc.nextLine();
								if (choice > others.size()  || choice < 0) {
									System.out.println("Wrong number!Place a number between 0 and "+ others.size());
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
		} else {
			System.out.println("Everything is done");
		}
	}
	public static void createOrg() {
		String name;
		String area;
		int teachers;
		int students;
		while(true) {
			System.out.println("What is the name of the university?\nWrite the name without spaces!");
			name = scanner.next();
			System.out.println("In which area is your organization located?\nWrite the are without spaces!");
			area = scanner.next();
			System.out.println("How many teachers does your organization have?");
			teachers = scanner.nextInt();
			System.out.println("How many students does your organization have?");
			students = scanner.nextInt();
			System.out.printf("Name University: %s, Area: %s, Total People(Teachers plus Students): %d." +
					"Is that correct? 1for yes",name,area,teachers+students);
			if (scanner.hasNext()) {
				scanner.nextLine();
			}
			if (scanner.nextLine().equals("1")) {
				break;
			}
		}
		Universities newOn = new Universities(name,area,teachers+students);
	}
		//look caseManagmentAndHumanAddition
	}
	public void declareCase(Human human) { //called by eody
	if (status) {
		changes.add(human);
	} else {
		changes.clear();
		status = true;
		changes.add(human);
	}
		//maybe where belongs
	}
	public void declareCase() {//from user
		if (status) {
			System.out.println("New cases in your university have been occured\nGoing to monitoring menu");
			monitoring();
		}
		System.out.println("Give the ssn of the person that is positive");
		String input = scanner.nextLine();
		/*Human human = Human.checkIfCovid(input, this);
		if (human == null) {
		System.out.println("We dont have a member with");
		}*/
		for (var c : department) {
				Human oneHuman = c.isSame(input);
				if (oneHuman != null) {
					System.out.printf("Want to report of student: %s, 0 for exit\n", oneHuman.toString());
					String input = scanner.nextLine();
					if (input.equals("0")) {
						return;
					} else {
						oneHuman.haveToBeTested();
						return;
					}
				}
			}
		for (var c : secretariat) {
				Human oneHuman = c.isSame(input);
				if (oneHuman != null) {
					System.out.printf("Want to report of a member of secretary: %s, 0 for exit\n", oneHuman.toString());
					String ans = scanner.nextLine();
					if (ans.equals("0")) {
						return;
					} else {
						oneHuman.haveToBeTested();
						return;
					}
				}
			}
		for (var c : others) {
				if (c.toString.equals(input)) {
					System.out.printf("Want to report of a member of secretary: %s, 0 for exit\n", oneHuman.toString());
					String ans = scanner.nextLine();
					if (ans.equals("0")) {
						return;
					} else {
						oneHuman.haveToBeTested();
						return;
					}
				}
			}
		for (var c : teachers) {
				if (c.toString.equals(input)) {
					System.out.printf("Want to report of a member of professors: %s, 0 for exit\n", oneHuman.toString());
					String ans = scanner.nextLine();
					if (ans.equals("0")) {
						return;
					} else {
						oneHuman.haveToBeTested();
						return;
					}
				}
			}
		System.out.println("Cant find a member with ssn:" + input);
	}


	private void modifyDepartments(){
		while (true){
				if (department.size() == 0) {
					//crete departments
					int count = 0;
					while (true) {
						System.out.printf("Creating the %d department,for exit 0", count + 1);
						if (scanner.nextLine().equals("0")) {
							if (department.size() == 0){
								System.out.println("Cant exit without creating one department");
							}else {
								break;
							}
						}
						Classes one = new Classes(this);
						department.add(one);
					}
					break;
				} else {
					while (true) {
						int ans = 0;

						try {
							System.out.println("Select which department to modify");
							int num = 1;
							for (Classes c : department) {
								System.out.printf("%d for : %s", num, c.getIdifier());
								num++;
							}
							System.out.println("Press a number");
							ans = scanner.nextInt();
							if (ans < 1 && ans > department.size()) {
								System.out.println("Invalid number, try again");
								continue;
							}
							break;
						} catch (InputMismatchException e) {
							System.err.println("That is not number, try again");
							scanner.nextLine();
						}
						//add or delete
						department.get(ans  - 1).modify();
						break;
					}
					break;
				}
		}
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
			System.out.println("New cases in your university have been occured\nGoing to monitoring menu");
			monitoring();
		}
		System.out.println("Status of professors");
		for (var c : teachers) {
			System.out.printf("%s has status:%s\n", c.toString(), c.seeStatus());
		}
		System.out.println("Status of secretariat");
		for (var c : secretariat) {
			System.out.printf("    Status secretariat:%s", c.getIdifier());
			c.printStatus();
		}
		System.out.println("Status of other employee");
		for (var c : others) {
			System.out.printf("%s has status:%s\n", c.toString(), c.seeStatus());
		}
		System.out.println("Status of each department");
		for (var c : department) {
			System.out.printf("    Status department:%s", c.getIdifier());
			c.printStatus();
		}

	}
	private void modifyOthers() {

	}

}
