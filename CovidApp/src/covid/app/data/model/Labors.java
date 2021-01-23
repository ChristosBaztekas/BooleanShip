package covid.app.data.model;


import covid.app.additionalMethods.Classes;
import covid.app.additionalMethods.caseManagmentAndHumanAddition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Labors extends Organisations implements caseManagmentAndHumanAddition {
    private final int id;
    private static int count = 0;
    protected ArrayList<Classes> department = new ArrayList<Classes>();
    private static ArrayList<Labors> allLabors = new ArrayList<Labors>();//see if we needs
    private ArrayList<Human> changes = new ArrayList<Human>();
    private boolean status = false;//eody changes something
    private boolean lockdown = false;
    private ArrayList<Boolean> lockdown_department = new ArrayList<Boolean>();
    private static Scanner scanner = new Scanner(System.in);
    public Labors(String name, String area, int numbersOfPeople, String orgMail) {
        super(name, area, numbersOfPeople);
        id = count++;
       // modifyDepartments();
        allLabors.add(this);
    }
    public Labors(String n, String a, int aa, String z, String e) {
        super(n, a, aa, z, e);
        id = count ++;
    }
    public void declareCase(Human human) {
        if (status) {
            changes.add(human);
        } else {
            changes.clear();
            status = true;
            changes.add(human);
        }
        autoMonitoring();
    }
    protected ArrayList<Classes> getDepartment() {
        return department;
    }
    protected boolean getLockdown() {
        return lockdown;
    }
    protected void setLockdown(boolean b) {
        lockdown = b;
    }
    protected void setDepartmentLockdown(int number) {
        if (number > lockdown_department.size() -1) {
            System.out.println("Wrong number" + number);
        } else {
            lockdown_department.set(number, true);
        }
    }
    public void autoMonitoring() {
    }//childs to do, and check if is called the child one
    public void declareCase() {
        if (status) {
            System.out.println("New cases in your Labor have been occured\nGoing to monitoring menu");
            monitoring();
        }
        System.out.println("Give the ssn of the person that is positive");
        String input = scanner.nextLine();
        for (var c : department) {
            Human one = c.isSame(input);
            if (one != null) {
                System.out.printf("Want to report positive of employee: %s, 0 exit", one.toString());
                String input1 = scanner.nextLine();
                if (input1.equals("0")) {
                    return;
                } else {
                    one.haveToBeTested();
                    autoMonitoring();
                    return;
                }
            }
        }
        System.out.println("Cant find a member with ssn:" + input);
    }
    public void monitoring() {
        if (status) {
            status = false;
            System.out.println("Some changes have been ocurred");
            System.out.println("Positive have been found: ");
            for (var c : changes) {
                System.out.printf("    The person: %s", c.toString());
            }
            System.out.println("Please tell who is likely to be positive too");
            for (var c :changes) {
                int choice;
                while (true) {
                    System.out.println("Give the number for each department of your Labor");
                    System.out.println("0: Exit");
                    for (int i = 0; i < department.size(); i++) {
                        System.out.printf("%d: %s\n", i + 1, department.get(i).getIdifier());
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
            }
        } else {
            System.out.println("Everything is ok");
        }

    }
    public void printDetails(){}
    public void seeStatus() {
        if (status) {
            System.out.println("New cases in your Labor have been occured\nGoing to monitoring menu");
            monitoring();
        }
        for (int i = 0; i < department.size(); i++) {
            if (lockdown_department.get(i)) {
                System.out.printf("Department: %s is closed", department.get(i).getIdifier());
            } else {
                System.out.printf("Department: %s is opened", department.get(i).getIdifier());
            }
        }
        for (var c : department) {
            System.out.println("Status of department: " + c.getIdifier());
            c.printStatus();
        }
        System.out.println("Would you like to lockdown your labor," +
                " 1 yes, 2 for lockdown of department");
        String ans = scanner.nextLine();
        if (ans.equals("1")) {
            lockdown = true;
        }
        if (ans.equals("2")) {
            for (int i = 0; i < department.size(); i++) {
                if (lockdown_department.get(i)) {
                    System.out.printf("%s is closed", department.get(i).getIdifier());
                } else {
                    System.out.printf("%s is functioning, option %d to be lockdowned", department.get(i).getIdifier(), i+1);
                }
            }
            scanner.nextLine();
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                if (option < 1 || option > department.size()) {
                    return;
                } else {
                    lockdown_department.set(option - 1, true);
                }
            }
        }
    }
    public void modifyDepartments() {
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
                        int num = 0;
                        for (Classes c : department) {
                            System.out.printf("%d for : %s", num, c.getIdifier());
                            num++;
                        }
                        System.out.println("Press a number");
                        ans = scanner.nextInt();
                        if (ans < 0 && ans > department.size()) {
                            System.out.println("Invalid number, try again");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("That is not number, try again");
                        scanner.nextLine();
                    }
                    //add or delete
                    department.get(ans).modify();
                    break;
                }
                break;
            }
        }
    }
}

