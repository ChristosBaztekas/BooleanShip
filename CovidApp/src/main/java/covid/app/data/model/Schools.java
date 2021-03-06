package covid.app.data.model;


import covid.app.additionalMethods.Classes;
import covid.app.additionalMethods.caseManagementAndHumanAddition;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Schools extends Organisations implements caseManagementAndHumanAddition {
    private static final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Human> teachers = new ArrayList<>();
    private final ArrayList<Classes> departments = new ArrayList<>();
    private final ArrayList<Human> others = new ArrayList<>();
    private int number_of_students_positive;
    private int number_of_teachers_positive;
    private int number_of_others_positive;
    private final ArrayList<Integer> number_department_positive = new ArrayList<>();
    private final ArrayList<Boolean> lockdown_department = new ArrayList<>();
    private boolean lockdown = false;
    private static final int limit = 5;
    private static final int limitteachers = 2;
    private static final int limitothers = 3;
    private static final int limitstudents = 4;
    private static final int limitdecision = 1;
    private static final int limitdepartment = 1;
    private boolean status = false;
    private final ArrayList<Human> changes = new ArrayList<>();
    public Schools(String name, String area, int numbersOfPeople) {
        super(name, area, numbersOfPeople);
        modifyTeachers();
        modifyOthers();
        modifyDepartments();
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
                System.out.printf("Department %s is closed",departments.get(i).getIdentifier());
            }
        }
        System.out.printf("Students with Covid: %d", number_of_students_positive);
        System.out.printf("Teachers with Covid: %d", number_of_teachers_positive);
        System.out.printf("Others with Covid: %d", number_of_others_positive);
        System.out.println("Status of teachers");
        for (Human teacher : teachers) {
            System.out.printf("%s has status:%s", teacher.toString(), teacher.seeStatus());
        }
        System.out.println("Status of the department");
        for (Classes department : departments) {
            System.out.printf("    Status secretariat:%s", department.getIdentifier());
            department.printStatus();
        }
        System.out.println("Status of other employee");
        for (Human other : others) {
            System.out.printf("%s has status:%s", other.toString(), other.seeStatus());
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
                            System.out.printf("Could not find teacher with afm:%s", afm);
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
                    i++;
                }
                break;
            }
        }
    }

    protected void findPerson(Human human) {
        String look = human.getAfm();
        for (Human teacher : teachers) {
            if (teacher.getAfm().equals(look)) {
                number_of_teachers_positive += 1;
                break;
            }
        }
        for (Human other : others) {
            if (other.getAfm().equals(look)) {
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

    public void modifyDepartments() {
        while (true){
            if (departments.size() == 0) {
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
            } else {
                while (true) {
                    int ans = 0;
                    try {
                        System.out.println("Select which department to modify");
                        System.out.println("Press 0 to create a new one");
                        System.out.println("Press -1 to exit");
                        int num = 1;
                        for (Classes department : departments) {
                            System.out.printf("%d for : %s", num, department.getIdentifier());
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
                        if (ans < 1 || ans > departments.size()) {
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
            }
            break;
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
                            System.out.printf("Could not find person with afm:%s", afm);
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
                break;
            }
        }
    }}
    public void monitoring() {
        if (status) {
            System.out.println("Some changes have been ocured");
            status = false;
            System.out.println("Positive have been found: ");
            for (Human change : changes) {
                System.out.printf("    The person: %s", change.toString());
            }
            System.out.println("Please say us who have to tested");
            for (int i = 0; i < changes.size(); i++) {
                int choice;
                label:
                while (true) {
                    System.out.println("Contacts of the" + changes.get(i).toString());
                    System.out.println("0 for exit, 1 for teachers, 2 for departments, 3 other people related");
                    String input = scanner.nextLine();
                    switch (input) {
                        case "0":
                            break label;
                        case "1":
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
                                } else {
                                    choice = sc.nextInt();
                                    sc.nextLine();
                                    if (choice > teachers.size() || choice < 0) {
                                        System.out.println("Wrong number!Place a number between 0 and " + teachers.size());
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
                            break;
                        case "2":
                            while (true) {
                                System.out.println("Select one by one in which departent should students be tested");
                                System.out.println("0: Exit");
                                for (int j = 0; i < departments.size(); j++) {
                                    System.out.printf("%d: %s", i + 1, departments.get(j).getIdentifier());
                                }
                                if (!sc.hasNextInt()) {
                                    String ans = sc.nextLine();
                                    System.out.printf(
                                            " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", departments.size());
                                } else {
                                    choice = sc.nextInt();
                                    sc.nextLine();
                                    if (choice > departments.size() || choice < 0) {
                                        System.out.println("Wrong number!Place a number between 0 and " + departments.size());
                                    }
                                    break;
                                }
                            }
                            if (choice == 0) {
                                continue;
                            } else if (choice <= departments.size()) {
                                departments.get(choice - 1).affected();
                            }
                            break;
                        case "3":
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
                                } else {
                                    choice = sc.nextInt();
                                    sc.nextLine();
                                    if (choice > others.size() || choice < 0) {
                                        System.out.println("Wrong number!Place a number between 0 and " + others.size());
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
                            break;
                        default:
                            System.out.println("Not valid option");
                            break;
                    }
                }
            }

        } else {
            System.out.println("Everything is done");
        }
    }
}
