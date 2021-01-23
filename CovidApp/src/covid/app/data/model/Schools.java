package covid.app.data.model;


import covid.app.additionalMethods.Classes;
import covid.app.additionalMethods.caseManagmentAndHumanAddition;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Schools extends Organisations implements caseManagmentAndHumanAddition {
    private static Scanner scanner = new Scanner(System.in);
    private static int count = 0; //use for our personal separation of the objects
    private int id ;//personal id of each object
    private ArrayList<Human> teachers = new ArrayList<Human>();
    private ArrayList<Classes> departments = new ArrayList<Classes>();
    private ArrayList<Human> others = new ArrayList<Human>();
    private int number_of_students_positive;
    private int number_of_teachers_positive;
    private int number_of_others_positive;
    private ArrayList<Integer> number_department_positive = new ArrayList<Integer>();
    private ArrayList<Boolean> lockdown_department = new ArrayList<Boolean>();
    private boolean lockdown = false;
    private static final int limit = 5;//auto limit for concentrated positive covid
    private static final int limitteachers = 2;
    private static final int limitothers = 3;
    private static final int limitstudents = 4;
    private static final int limitdecision = 1;
    private static final int limitdepartment = 1;
    private boolean status = false;//eody have something changed
    private ArrayList<Human> changes = new ArrayList<Human>();
    public Schools(String name, String area, int numbersOfPeople) {
        //see if the arguments will be taken outside of the constructor or inside
        super(name, area, numbersOfPeople);
        add(this);
        modifyTeachers();
        modifyOthers();
        modifyDepartments();
        id = count++;
    }

    public Schools(String name, String area, String email,
                   int number_of_students_positive, int number_of_teachers_positive,
                   int number_of_others_positive, boolean lockdown, boolean status) {
        super(name, area, email);
        this.number_of_teachers_positive = number_of_teachers_positive;
        this.number_of_others_positive = number_of_others_positive;
        this.number_of_students_positive = number_of_students_positive;
        this.lockdown = lockdown;
        this.status = status;
    }
    public void setTeachers(ArrayList<Human> humans) {
        teachers = humans;
    }
    public void setOthers(ArrayList<Human> humans) {
        others = humans;
    }
    public void setChanges(ArrayList<Human> humans) {
        changes = humans;
    }
    public void setDepartments(ArrayList<Classes> classes) {
        departments = classes;
    }
    public static void createS() {
        for (int i = 0; i < 10; i++) { //create 10
            String user_pass = "S" + String.valueOf(i);
            Schools n = new Schools(i, user_pass);
        }
    }
    public Schools(int i, String a) {
        super("name", "area", 20, a, a);
        id = count ++;
        add(this);
    }
    public void autoMonitoring() {
        int n = number_of_others_positive + number_of_teachers_positive + number_of_students_positive;
        if (n > limit) {
            declareLockdown();
        }
        if (number_of_teachers_positive > limitteachers) {
            declareLockdown();
        }
        if (number_of_others_positive > limitothers) {
            declareLockdown();
        }
        if (number_of_students_positive > limitstudents) {
            declareLockdown();
        }
        for (int i = 0; i < number_department_positive.size(); i++) {
            if (number_department_positive.get(i) > limitdepartment) {
                lockdown_department.set(i, false) ;
            }
        }
    }
    private void declareLockdown() {
        lockdown = true;
    }
    private boolean isLockdown() {
        return lockdown;
    }
    public void seeStatus() {
        if (isLockdown()) {
            System.out.println("Your school is closed");
        }
        if (status) {
            System.out.println("New cases in your school have been occured\nGoing to monitoring menu");
            monitoring();
        }
        for (int i = 0; i < departments.size(); i++) {
            if (lockdown_department.get(i)) {
                System.out.printf("Department %s is closed",departments.get(i).getIdifier());
            }
        }
        System.out.printf("Students with Covid: %d", number_of_students_positive);
        System.out.printf("Teachers with Covid: %d", number_of_teachers_positive);
        System.out.printf("Others with Covid: %d", number_of_others_positive);
        System.out.println("Status of teachers");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.printf("%s has status:%s", teachers.get(i).toString(), teachers.get(i).seeStatus());
        }
        System.out.println("Status of the department");
        for (int i = 0; i < departments.size(); i++) {
            System.out.printf("    Status secretariat:%s", departments.get(i).getIdifier());
            departments.get(i).printStatus();
        }
        System.out.println("Status of other employee");
        for (int i = 0; i < others.size(); i++) {
            System.out.printf("%s has status:%s", others.get(i).toString(), others.get(i).seeStatus());
        }

        int total = number_of_others_positive + number_of_students_positive + number_of_teachers_positive;
        if (total > limitdecision) {
            System.out.println("Do you want to close your school?, 1 yes");//option if is serious
            String ans = scanner.nextLine();
            if (ans.equals("1")) {
                declareLockdown();
            }
        }
    }
    public static void createOrg() {
        String name;
        String area;
        int teachers;
        int students;
        while(true) {
            System.out.println("What is the name of the school?\nWrite the name without spaces!");
            name = scanner.next();
            System.out.println("In which area is your organization located?\nWrite the are without spaces!");
            area = scanner.next();
            System.out.println("How many teachers does your organization have?");
            teachers = scanner.nextInt();
            System.out.println("How many students does your organization have?");
            students = scanner.nextInt();
            System.out.printf("Name School: %s, Area: %s, Total People(Teachers plus Students): %d." +
                    "Is that correct? 1for yes",name,area,teachers+students);
            if (scanner.hasNext()) {
                scanner.nextLine();
            }
            if (scanner.nextLine().equals("1")) {
                break;
            }
        }
        Schools newOn = new Schools(name,area,teachers+students);
    }

    public void printDetails() {
        System.out.println("Welcome.The" + getName() +
                "School of" + getArea() +
                "will take drastic measures to stop spread of covid-19 in our school.Please stay safe and we will call you soon." +
                "Always our first priority was the safety of our children!Thanks for understanding in these difficult times.");
    }
    protected void modifyTeachers() {
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
//                        //Human one = Human.createHuman(this);
//                        if (one == null) {
//                            break;
//                        }
//                        teachers.add(one);
                        i++;
                    }
                    addPeople(i);
                    break;
                }
                System.out.printf("There are %d Teacher(s), would you like to remove one?\n" +
                        "Press 1 for yes", teachers.size());
                String ans0 = scanner.nextLine();
                if (ans0.equals("1")) {
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
                        } else {
                            reducePeople(1);
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
                    //Human one = Human.createHuman(this);
                    //teachers.add(one);
                    i++;
                }
                break;
            }
        }
    }
    //from user
    public void declareCase() {
        if (status) {
            System.out.println("New cases in the school, going to monitoring menu");
            monitoring();
        }
        System.out.println("Give the ssn of the person that is positive");
        String input = scanner.nextLine();
		/*Human human = Human.checkIfCovid(input, this);
		if (human == null) {
		System.out.println("We dont have a member with");
		}*/
        for (int i = 0; i < departments.size(); i++) {
            Human oneHuman = departments.get(i).isSame(input);
            if (oneHuman != null) {
                System.out.printf("Want to report of student: %s, 0 for exit\n", oneHuman.toString());
                String input1 = scanner.nextLine();
                if (input1.equals("0")) {
                    return;
                } else {
                    oneHuman.bePositive();
                    findPerson(oneHuman);
                    return;
                }
            }
        }
        for (int i = 0; i < teachers.size(); i ++) {
            if (teachers.get(i).toString().equals(input)) {
                System.out.printf("Want to report of a member of teachers: %s, 0 for exit\n", teachers.get(i).toString());
                String ans = scanner.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    teachers.get(i).bePositive();
                    findPerson(teachers.get(i));
                    return;
                }
            }
        }
        for (int i = 0; i < others.size(); i ++) {
            if (others.get(i).toString().equals(input)) {
                System.out.printf("Want to report of a member of other people: %s, 0 for exit\n", others.get(i).toString());
                String ans = scanner.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    others.get(i).bePositive();
                    findPerson(others.get(i));
                    return;
                }
            }
        }
        System.out.println("Cannot find school member with ssn: " + input);
    }
    protected void findPerson(Human human) {
        String look = human.getAfm();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getAfm().equals(look)) {
                number_of_teachers_positive += 1;
                break;
            }
        }
        for (int i = 0; i < others.size(); i++) {
            if (others.get(i).getAfm().equals(look)) {
                number_of_others_positive += 1;
                break;
            }
        }
        for (int i = 0; i < departments.size(); i++) {
            Human one = departments.get(i).isSame(look);
            if (one != null) {
                number_department_positive.set(i, number_department_positive.get(i) + 1) ;
                number_of_students_positive += 1;
                break;
            }
        }
        autoMonitoring();
    }
    public void declareCase(Human human) {
        if (!status) {
            status = true;
            changes.clear();
            changes.add(human);
        } else {
            changes.add(human);
        }
        findPerson(human);
    }
    public void modifyDepartments() {
        while (true){
            if (departments.size() == 0) {
                //crete departments
                int count = 0;
                while (true) {
                    System.out.printf("Creating the %d department,for exit 0", count + 1);
                    if (scanner.nextLine().equals("0")) {
                        if (departments.size() == 0){
                            System.out.println("Cant exit without creating one department");
                        }else {
                            break;
                        }
                    }
                    Classes one = new Classes(this);
                    number_department_positive.add(0);
                    lockdown_department.add(false);
                    departments.add(one);
                }
                break;
            } else {
                while (true) {
                    int ans = 0;
                    try {
                        System.out.println("Select which department to modify");
                        System.out.println("Press 0 to create a new one");
                        System.out.println("Press -1 to exit");
                        int num = 1;
                        for (int i = 0; i < departments.size(); i++) {
                            System.out.printf("%d for : %s", num, departments.get(i).getIdifier());
                            num++;
                        }
                        System.out.println("Press a number");
                        ans = scanner.nextInt();
                        if (ans == -1) {
                            break;
                        }
                        if (ans == 0) {
                            Classes one = new Classes(this);
                            number_department_positive.add(0);
                            lockdown_department.add(false);
                            departments.add(one);
                            return;
                        }
                        if (ans < 1 && ans > departments.size()) {
                            System.out.println("Invalid number, try again");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("That is not number, try again");
                        scanner.nextLine();
                    }
                    //add or delete
                    departments.get(ans  - 1).modify();
                    break;
                }
                break;
            }
        }
    }
    protected void modifyOthers() {
        while (true){
            if(others.size() != 0) {
                System.out.printf("There are %d People, would you like to add new?\n" +
                        "Press 1 for yes,otherwise we will go to remove panel", others.size());
                String ans = scanner.nextLine();
                if (ans.equals("1")) {
                    int i = 0;
                    while (true) {
                        System.out.printf("Adding the %d person, for exit 0", i+1);
                        if (scanner.nextLine().equals("0")) {
                            break;
                        }
                       // Human one = Human.createHuman(this);
//                        if (one == null) {
//                            break;
//                        }
//                        others.add(one);
                        i++;
                    }
                    addPeople(i);
                    break;
                }
                System.out.printf("There are %d People, would you like to remove one?\n" +
                        "Press 1 for yes", others.size());
                String ans0 = scanner.nextLine();
                if (ans0.equals("1")) {
                    while (true){
                        System.out.println("Give the afm of the person that want to remove");
                        String afm = scanner.nextLine();
                        boolean flag = true;
                        for (int i=0; i < others.size(); i++) {
                            if (others.get(i).getAfm().equals(afm)) {
                                others.remove(i);
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.printf("Could not find person with afm:% s", afm);
                        } else {
                            reducePeople(1);
                        }
                        System.out.println("Continue the deletion process? 0 for exit");
                        String ans1 = scanner.nextLine();
                        if (ans1.equals("0")) {
                            break;
                        }
                    }
                    break;
                }
            } else {//from constractor
                System.out.println("There are no people filled, Please start with giving them");
                int i = 0;
                while (true) {
                    System.out.printf("Creating the %d person, 0 for exit", i+1);
                    if (scanner.nextLine().equals("0")) {
                        break;
                    }
//                    Human one = Human.createHuman(this);
//                    if (one == null) {
//                        break;
//                    }
//                    others.add(one);
//                    i++;
//                }
                break;
            }
        }
    }}
    public void monitoring() {
        if (status) {
            System.out.println("Some changes have been ocured");
            status = false;
            System.out.println("Positive have been found: ");
            for (int i = 0; i < changes.size(); i++) {
                System.out.printf("    The person: %s", changes.get(i).toString());
            }
            System.out.println("Please say us who have to tested");
            for (int i = 0; i < changes.size(); i++) {
                int choice;
                while (true) {
                    System.out.println("Contacts of the" + changes.get(i).toString());
                    System.out.println("0 for exit, 1 for teachers, 2 for departments, 3 other people related");
                    String input = scanner.nextLine();
                    if (input.equals("0")) {
                        break;
                    } else if (input.equals("1")) {
                        while (true) {
                            System.out.println("Give the number for each profesor");
                            System.out.println("0: Exit");
                            for (int j = 0; i < teachers.size(); j++) {
                                System.out.printf("%d: %s\n", i + 1, teachers.get(j).toString());
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
                            teachers.get(choice - 1).haveToBeTested();
                        } else {
                            continue;
                        }
                    } else  if (input.equals("2")) {
                        while (true) {
                            System.out.println("Select one by one in which departent should students be tested");
                            System.out.println("0: Exit");
                            for(int j = 0; i < departments.size(); j++) {
                                System.out.printf("%d: %s", i + 1, departments.get(j).getIdifier());
                            }
                            if (!sc.hasNextInt()) {
                                String ans = sc.nextLine();
                                System.out.printf(
                                        " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", departments.size());
                                continue;
                            } else {
                                choice = sc.nextInt();
                                sc.nextLine();
                                if (choice > departments.size()  || choice < 0) {
                                    System.out.println("Wrong number!Place a number between 0 and "+ departments.size());
                                    continue;
                                }
                                break;
                            }
                        }
                        if (choice == 0) {
                            continue;
                        } else if (choice <= departments.size()) {
                            departments.get(choice - 1).affected();
                        }
                    } else if (input.equals("3")) {
                        while (true) {
                            System.out.println("Give the number for each other employee");
                            System.out.println("0: Exit");
                            for (int j = 0; i < others.size(); j++) {
                                System.out.printf("%d: %s\n", i + 1, others.get(j).toString());
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
                    } else {
                        System.out.println("Not valid option");
                    }
                }
            }

        } else {
            System.out.println("Everything is done");
        }
    }
}