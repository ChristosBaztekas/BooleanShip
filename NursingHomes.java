import java.util.Scanner;
import java.util.ArrayList;

public class NursingHomes extends Organisations implements caseManagmentAndHumanAddition{
    private String status_descr;
    private ArrayList<Human> employees = new ArrayList<Human>();
    private ArrayList<Human> carenPeople = new ArrayList<Human>();
    static Scanner sc = new Scanner(System.in);
    private boolean en_status; //true means enclosed and false free access
    private boolean status = false;//has covid if trues
    private ArrayList<Human> changes = new ArrayList<Human>();
    private boolean update = false;
    private final int id;
    private static int count = 0;

    public NursingHomes(String name, String area, int numberOfPeople, boolean enclosed) {
        super(name, area, numberOfPeople);
        en_status = enclosed;
        status_descr = (enclosed ? "Enclosed" : "Free Access");
        id = count ++;
        add(this);
        modifyEmployees();
        modifyCarenPeople();
    }
    protected void modifyEmployees() {
        while (true){
            if(employees.size() != 0) {
                System.out.printf("There are %d Employee(s), would you like to add new?\n" +
                        "Press 1 for yes,otherwise we will go to remove panel", employees.size());
                String ans = sc.nextLine();
                if (ans.equals("1")) {
                    int i = 0;
                    while (true) {
                        System.out.printf("Adding the %d employ, for exit 0", i+1);
                        if (sc.nextLine().equals("0")) {
                            break;
                        }
                 //not fuctional code       //Human one = Human.createHuman(this.getClass().getName(), this.id);
                        //employees.add(one);
                    }
                    break;
                }
                System.out.printf("There are %d Employee(s), would you like to remove one?\n" +
                        "Press 1 for yes", employees.size());
                String ans0 = sc.nextLine();
                if (ans0.equals("1")) {
                    while (true){
                        System.out.println("Give the afm of the employee that want to remove");
                        String afm = sc.nextLine();
                        boolean flag = true;
                        for (int i=0; i < employees.size(); i++) {
                            /*if (employees.get(i).getAfm().equals(afm)) {
                                employees.remove(i);
                                flag = false;
                                break;
                            }*/
                        }
                        if (flag) {
                            System.out.printf("Could not find employee with afm:% s", afm);
                        }
                        System.out.println("Continue the deletion process? 0 for exit");
                        String ans1 = sc.nextLine();
                        if (ans1.equals("0")) {
                            break;
                        }
                    }
                    break;
                }
            } else {//from constractor
                System.out.println("There are no employes filled, Please start with giving them");
                int i = 0;
                while (true) {
                    System.out.printf("Creating the %d employ, 0 for exit", i+1);
                    if (sc.nextLine().equals("0")) {
                        break;
                    }
                    //Human one = Human.createHuman(this.getClass().getName(), this.id);
                    //employees.add(one);
                    i++;
                }
                break;
            }
        }
    }
    public void monitoring(int orgNum) {

    }
    public void declareCase() {

        System.out.println("Is the case Employee(s), caren person(s) or both");
        System.out.println("Enter       E,          C,                B");
        String input = sc.nextLine();
        if(input.equals('E')){

        } else if (input.equals('C')){

        } else if (input.equals('B')){

        } else {

        }
    }

    public void managementCases() {
        //look caseManagmentAndHumanAddition
    }
    public static void createOrg() {
        while (true) {
            System.out.println("What is the name of the NursingHome?/nWrite the name without spaces!");
            String name = sc.next();
            System.out.println("In which area is your organization located?/nWrite the are without spaces!");
            String area = sc.next();
            System.out.println("How many employees does your organization have?");
            sc.nextLine();
            int numberOfEmployees = sc.nextInt();
            System.out.println("How many carenPeople does your organization have?");
            int numberofCarenPeople = sc.nextInt();
            System.out.println("Is your organization open? 1for yes");
            String input = sc.next();
            boolean enclosed;
            if(input.equals("1")){
                enclosed = false;
            }else {
                enclosed = true;
            }
            System.out.printf("Name NursingHome: %s, Area: %s, Total People(Employees plus CarenPeople): %d." +
                    "Is that correct? 0 for no", name, area, numberofCarenPeople + numberOfEmployees);
            if (sc.hasNext()) {
                sc.nextLine();
            }
            if (sc.nextLine().equals("0")) {
                continue;
            }
            NursingHomes newOne = new NursingHomes(name, area, numberofCarenPeople + numberOfEmployees, enclosed);
            //look caseManagmentAndHumanAddition
        }

	 }

    public void declareCase(Human human) {
        if (!update) {
            changes.clear();
            update = true;
        } else {
            changes.add(human);
        }
        status = true;
        for (var empl : employees) {
            if (empl != human) {
                empl.haveToBeTested();
            }
        }
        if (a == null) {
            for (var p : carenPeople) {
                if (p != human) {
                    p.haveToBeTested();
                }
            }
        }
    }
    public void printDetails() {
        System.out.println("Welcome.The" + getName() +
                "NursingHome of" + getArea() +
                "will take drastic measures to stop spread of covid-19 in our NursingHome." +
                "Please stay safe and we will call you soon.Always our first priority was the safety of our beloved people!" +
                "Thanks for understanding in these difficult times.");
        //look caseManagmentAndHumanAddition
    }
    public void modifyCarenPeople() {
		while (true){
			if(carenPeople.size() != 0) {
				System.out.printf("There are %d carenPeople, would you like to add new?\n" +
										"Press 1 for yes,otherwise we will go to remove panel", carenPeople.size());
				String ans = scanner.nextLine();
				if (ans.equals("1")) {
					int i=0;
					while(true) {
						System.out.printf("Adding the %d carenPeople, for exit 0", i+1);
						if (scanner.nextLine().equals("0")) {
							break;
						}
						Human one = Human.createHuman(this);
						carenPeople.add(one);
					}
					break;
				}
				System.out.printf("There are %d carenPeople, would you like to remove one?\n" +
				        "Press 1 for yes", carenPeople.size());
				String ans0 = scanner.nextLine();
				if (ans0.equals("1")) {
					while (true){
						System.out.println("Give the afm of the carenPeople that want to remove");
						String afm = scanner.nextLine();
						boolean flag = true;
						for (int i=0; i < carenPeople.size(); i++) {
							if (carenPeople.get(i).getAfm().equals(afm)) {
								carenPeople.remove(i);
								flag = false;
								break;
							}
						}
						if (flag) {
							System.out.printf("Could not find carenPeople with afm:% s", afm);
						}
						System.out.println("Continue the deletion process? 0 for exit");
						String ans1 = scanner.nextLine();
						if (ans1.equals("0")) {
							break;
						}
					}
					break;
				}
			} else {
				System.out.println("There are no carenPeople filled, Please start with giving them");
				int i = 0;
				while (true) {
					System.out.printf("Creating the %d carenPeople, 0 for exit", i+1);
					if (scanner.nextLine().equals("0")) {
						break;
					}
					Human one = Human.createHuman(this);
					carenPeople.add(one);
					i++;
				}
				break;
			}
		}
	}

	public void seeStatus() {
        if (update) {
            update = false;
            System.out.println("There have been changes");
            System.out.println("Positive have been found: ");
            for (var c : changes) {
                System.out.printf("   The person: %s\n", c.toString());
            }
        }
        System.out.println("Status of your employees");
        for (var c  : employees) {
            System.out.println("%s has status:%s", c.toString(), c.seeStatus());
        }
        System.out.println("Status of your guesters");
        for (var c : carenPeople) {
            System.out.println("%s has status:%s", c.toString(), c.seeStatus());
        }
        if (status) {
            System.out.println("Your Nursing Home can not be visited");
        } else {
            System.out.println("You are able to have visitors, but all " +
                    "have to respect the measures for covid");
        }
    }
}
