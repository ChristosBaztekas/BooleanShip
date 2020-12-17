package sample;

import java.util.Scanner;
import java.util.ArrayList;

public class Schools extends Organisations implements caseManagmentAndHumanAddition {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Schools> allSchools = new ArrayList<Schools>() ;
	private static int count = 0; //use for our personal separation of the objects
	private int id ;//personal id of each object
	private ArrayList<Human> teachers = new ArrayList<Human>();
	private ArrayList<Classes> departments = new ArrayList<Classes>();
	public Schools(String name, String area, int numbersOfPeople) {
		//see if the arguments will be taken outside of the constructor or inside
		super(name, area, numbersOfPeople);
		modifyTeachers();
		id = count++;
		allSchools.add(this);
	}

	public static void callDeclareCase(int code) {
		//for example allSchools.get(code).declareCase();
	}
	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}

	public static void declareCase(int number) {
		//look caseManagmentAndHumanAddition
	}
	public static void createOrg() {
		while(true) {
			System.out.println("What is the name of the school?\nWrite the name without spaces!");
			String name = scanner.next();
			System.out.println("In which area is your organization located?\nWrite the are without spaces!");
			String area = scanner.next();
			System.out.println("How many teachers does your organization have?");
			int teachers = scanner.nextInt();
			System.out.println("How many students does your organization have?");
			int students = scanner.nextInt();
			System.out.printf("Name School: %s, Area: %s, Total People(Teachers plus Students): %d." +
					"Is that correct? 1for yes",name,area,teachers+students);
			if (scanner.nextLine().equals("1")) {
				break;
			}
			Schools newOn = new Schools(name,area,teachers+students);
		}

	}

	public static void printDetails(int code) {
		System.out.println("Welcome.The" + allSchools.get(code).getName() +
				"School of" + allSchools.get(code).getArea() +
				"will take drastic measures to stop spread of covid-19 in our school.Please stay safe and we will call you soon." +
				"Always our first priority was the safety of our children!Thanks for understanding in these difficult times.");
	}
	private void modifyTeachers() {
        	while (true){
            		if(teachers.size() != 0) {
                		System.out.printf("There are %d Teacher(s), would you like to add new?\n" +
                        		"Press 1 for yes,otherwise we will go to remove panel", teachers.size());
                		String ans = scanner.nextLine();
                		if (ans.equals("1")) {
                    			int i = 0;
                    			while (true) {
                        			System.out.printf("Adding the %d teacher, for exit 0", i+1);
                        			if (scanner.nextLine().equals("0")) {
                            				break;
			                        }
			                        Human one = createHuman(this.getClass().getName(), this.id);
			                        teachers.add(one);
		                        }
			                break;
		                }
		                System.out.printf("There are %d Teacher(s), would you like to remove one?\n" +
		                        "Press 1 for yes", teachers.size());
                		String ans = scanner.nextLine();
                		if (ans.equals("1")) {
                    			while (true){
                        			System.out.println("Give the afm of the teacher that want to remove");
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
                            				System.out.printf("Could not find teacher with afm:% s", afm);
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
                		System.out.println("There are no teachers filled, Please start with giving them");
                		int i = 0;
                		while (true) {
                    			System.out.printf("Creating the %d teacher, 0 for exit", i+1);
                    			if (scanner.nextLine().equals("0")) {
                        			break;
                    			}
                    			Human one = createHuman(this.getClass().getName(), this.id);
                    			teachers.add(one);
                    			i++;
                		}
                		break;
            		}
        	}
    	}
}
