package covid.app.main.app.boolship;


import java.util.Scanner;
import java.util.ArrayList;

public class NursingHomes extends Organisations implements caseManagmentAndHumanAddition{
    private String status_descr;
    private final ArrayList<Human> employees = new ArrayList<>();
    private final ArrayList<Human> carenPeople = new ArrayList<>();
    static ArrayList<String> orgEmails = new ArrayList<>();
    private int count_employees = 0;
    private int count_carenPeople = 0;
    static Scanner sc = new Scanner(System.in);
    private boolean en_status; //true means enclosed and false free access
    private boolean status = false;//has covid if trues
    private final ArrayList<Human> changes = new ArrayList<>();
    private boolean update = false;
    private final int id;
    private static int count = 0;
    /*public static void createNH() {
        for (int i = 0; i < 10; i++) { //create 10
            String user_pass = "NH" + i;
            NursingHomes n = new NursingHomes(i, user_pass);
        }
    }
    public NursingHomes(int i, String a) {
        super("name", "area", 20, a, a);
        id = count ++;
        add(this);
    }*/

   public NursingHomes(String name, String area, int numberOfPeople, String emailAddress, boolean enclosed) {
        super(name, area, numberOfPeople);
        en_status = enclosed;
        status_descr = (enclosed ? "Enclosed" : "Free Access");
        id = count++;
        orgEmails.add(emailAddress);

        add(this);
        setNumbersOfPeople(employees.size() + carenPeople.size());//maybe doesnt need now

    }
    /*protected void modifyEmployees() {
        while (true){
            if(employees.size() != 0) {
                System.out.printf("There are %d Employee(s), would you like to add new?\n" +
                        "Press 1 for yes,otherwise we will go to remove panel", employees.size());
                String ans = sc.nextLine();
                if (ans.equals("1")) {
                    int i = 0;
                    while (true) {
                        System.out.printf("Adding the %d employ, for exit 0", i + 1);
                        if (sc.nextLine().equals("0")) {
                            break;
                        }
                        Human one = Human.createHuman(this);
                        if (one == null) {
                            break;
                        } else {
                            employees.add(one);
                            i++;
                        }
                    }
                    addPeople(i);
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
                            if (employees.get(i).getAfm().equals(afm)) {
                                employees.get(i).removeFromOrg(this);
                                employees.remove(i);
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.printf("Could not find employee with afm:% s", afm);
                        } else {
                            reducePeople(1);
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
                        if (employees.size() == 0) {
                            System.out.println("Cant continue without giving an employee");
                            continue;
                        } else {
                            break;
                        }
                    }
                    Human one = Human.createHuman(this);
                    if (one == null) {
                        if (carenPeople.size() == 0) {
                            System.out.println("Give at least one");
                            continue;
                        } else {
                            break;
                        }
                    }
                    employees.add(one);
                    i++;
                }
                break;
            }
        }
    }*/
    public void monitoring() {
        if (carenPeople.size() == 0 || employees.size() == 0) {
            return;
        }
        if (status) {
            status = false;
            System.out.println("Some changes have been ocured");
            System.out.println("Please for the safety of your institute" +
                    ", keep safety measures more carefully for the safety of your own people");
            en_status = true;
            status_descr = "Enclosed";
            System.out.println("Positive have been found: ");
            for (Human change : changes) {
                System.out.printf("    The person: %s", change.toString());
            }
        }
    }

    @Override
    public void autoMonitoring() {

    }

    /*protected void toBeTested(Human human) {
        if (carenPeople.size() == 0 || employees.size() == 0) {
            return;
        }
        System.out.println("Give the people that have to be tested, 0 exit");
        String input = sc.nextLine();
        if (input.equals("0")) {
            return;
        }
        for (int i = 0; i < carenPeople.size(); i++) {
            if (carenPeople.get(i).getAfm().equals(input)) {
                System.out.printf("Elder people: %s must be tested?" +
                        ", 0 for exit\n", carenPeople.get(i).toString());
                String ans = sc.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    carenPeople.get(i).haveToBeTested();
                    return;
                }
            }
        }
        for (int i = 0; i < carenPeople.size(); i++) {
            if (carenPeople.get(i).getAfm().equals(input)) {
                System.out.printf("Member of employee: %s must be tested?, 0 for exit\n", carenPeople.get(i).toString());
                String ans = sc.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    carenPeople.get(i).haveToBeTested();
                    return;
                }
            }
        }
        System.out.println("Cant find a member with ssn:" + input);
    }*/
    public void declareCase() {
        if (carenPeople.size() == 0 || employees.size() == 0) {
            return;
        }
        System.out.println("Give the afm of the person that have been found positive, 0 for exit");
        String input = sc.nextLine();
        if (input.equals("0")) {
            return;
        }
        for (Human carenPerson : carenPeople) {
            if (carenPerson.getAfm().equals(input)) {
                System.out.printf("Want to report of a member of elder people: %s" +
                        ", 0 for exit\n", carenPerson.toString());
                String ans = sc.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    carenPerson.bePositive();
                    changeStatus(carenPerson);
                    return;
                }
            }
        }
        for (Human employee : employees) {
            if (employee.getAfm().equals(input)) {
                System.out.printf("Want to report of a member of employee: %s" +
                        ", 0 for exit\n", employee.toString());
                String ans = sc.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    employee.bePositive();
                    changeStatus(employee);
                    return;
                }
            }
        }
        System.out.println("Cant find a member with ssn:" + input);
    }
    protected void changeStatus(Human human) {
        if (carenPeople.size() == 0 || employees.size() == 0) {
            return;
        }
        for (Human employee : employees) {
            if (employee != human) {
                employee.haveToBeTested();
            } else {
                count_employees += 1;
            }
        }
        for (Human carenPerson : carenPeople) {
            if (carenPerson != human) {
                carenPerson.haveToBeTested();
            } else {
                count_carenPeople += 1;
            }
        }
    }

    /*public static void createOrg() {
        while (true) {
            System.out.println("What is the name of the NursingHome?/nWrite the name without spaces!");
            String name = sc.next();
            System.out.println("In which area is your organization located?/nWrite the are without spaces!");
            String area = sc.next();
            System.out.println("How many employees does your organization have?");
            sc.nextLine();
            System.out.println("Give email");
            String email = sc.next();
            int numberOfEmployees = sc.nextInt();
            System.out.println("How many carenPeople does your organization have?");
            int numberofCarenPeople = sc.nextInt();
            System.out.println("Is your organization open? 1for yes");
            String input = sc.next();
            boolean enclosed;
            enclosed = !input.equals("1");
            System.out.printf("Name NursingHome: %s, Area: %s, Total People(Employees plus CarenPeople): %d." +
                    "Is that correct? 0 for no", name, area, numberofCarenPeople + numberOfEmployees);
            if (sc.hasNext()) {
                sc.nextLine();
            }
            if (sc.nextLine().equals("0")) {
                continue;
            }
            NursingHomes newOne = new NursingHomes(name, area, numberofCarenPeople + numberOfEmployees, email, enclosed);
            break;
        }

    }*/

    public void declareCase(Human human) {
        if (!update) {
            changes.clear();
            update = true;
            changes.add(human);
        } else {
            changes.add(human);
        }
        status = true;
        changeStatus(human);
    }
    public void printDetails() {
        System.out.println("Welcome.The" + getName() +
                "NursingHome of" + getArea() +
                "will take drastic measures to stop spread of covid-19 in our NursingHome." +
                "Please stay safe and we will call you soon.Always our first priority was the safety of our beloved people!" +
                "Thanks for understanding in these difficult times.");
    }
    /*public void modifyCarenPeople() {
        while (true){
            if(carenPeople.size() != 0) {
                System.out.printf("There are %d carenPeople, would you like to add new?\n" +
                        "Press 1 for yes,otherwise we will go to remove panel", carenPeople.size());
                String ans = sc.nextLine();
                if (ans.equals("1")) {
                    int i=0;
                    while(true) {
                        System.out.printf("Adding the %d carenPeople, for exit 0", i+1);
                        if (sc.nextLine().equals("0")) {
                            break;
                        }
                        Human one = Human.createHuman(this);
                        carenPeople.add(one);
                    }
                    addPeople(i);
                    break;
                }
                System.out.printf("There are %d carenPeople, would you like to remove one?\n" +
                        "Press 1 for yes", carenPeople.size());
                String ans0 = sc.nextLine();
                if (ans0.equals("1")) {
                    while (true){
                        System.out.println("Give the afm of the carenPeople that want to remove");
                        String afm = sc.nextLine();
                        boolean flag = true;
                        for (int i=0; i < carenPeople.size(); i++) {
                            if (carenPeople.get(i).getAfm().equals(afm)) {
                                carenPeople.get(i).removeFromOrg(this);
                                carenPeople.remove(i);
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.printf("Could not find carenPeople with afm:% s", afm);
                        } else {
                            reducePeople(1);
                        }
                        System.out.println("Continue the deletion process? 0 for exit");
                        String ans1 = sc.nextLine();
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
                    if (sc.nextLine().equals("0")) {
                        if (employees.size() == 0) {
                            System.out.println("There no employees, you can not exit without giving at least one employee");
                            System.out.println("Please try again");
                        } else {
                            break;
                        }
                    }
                    Human one = Human.createHuman(this);
                    if (one == null) {
                        if (carenPeople.size() == 0) {
                            System.out.println("Give at least one");
                            continue;
                        } else {
                            break;
                        }
                    }
                    employees.add(one);
                    i++;
                }
                break;
            }
        }
    }

    public void seeStatus() {
        if (carenPeople.size() == 0 || employees.size() == 0) {
            return;
        }
        if (update) {
            update = false;
            System.out.println("There have been changes");
            System.out.println("Positive have been found: ");
            for (int i = 0; i < changes.size(); i++) {
                System.out.printf("   The person: %s\n", changes.get(i).toString());
            }
        }
        if (status) {
            System.out.println("Your Nursing Home is closed because of covid");
            System.out.printf("Employees positive:%d - Elder positive:%d", count_employees, count_carenPeople);
        }
        System.out.println("Status of your employees");
        for (int i = 0; i <employees.size(); i++) {
            System.out.printf("%s has status:%s", employees.get(i).toString(), employees.get(i).seeStatus());
        }
        System.out.println("Status of your guesters");
        for (int i =0; i < carenPeople.size(); i++) {
            System.out.printf("%s has status:%s", carenPeople.get(i).toString(), carenPeople.get(i).seeStatus());
        }
        if (status) {
            System.out.println("Your Nursing Home can not be visited");
        } else {
            System.out.println("You are able to have visitors, but all " +
                    "have to respect the measures for covid");
        }
    }*/

    public String getStatus_descr() {
        return status_descr;
    }

    public void setStatus_descr(String status_descr) {
        this.status_descr = status_descr;
    }

    public boolean isEn_status() {
        return en_status;
    }

    public void setEn_status(boolean en_status) {
        this.en_status = en_status;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getCount_employees() {
        return count_employees;
    }

    public void setCount_employees(int count_employees) {
        this.count_employees = count_employees;
    }

    public int getCount_carenPeople() {
        return count_carenPeople;
    }

    public void setCount_carenPeople(int count_carenPeople) {
        this.count_carenPeople = count_carenPeople;
    }
}

