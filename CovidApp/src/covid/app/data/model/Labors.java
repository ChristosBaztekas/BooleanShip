package covid.app.data.model;


import covid.app.additionalMethods.Classes;
import covid.app.additionalMethods.caseManagmentAndHumanAddition;

import java.util.ArrayList;
import java.util.Scanner;

public class Labors extends Organisations implements caseManagmentAndHumanAddition {
    protected ArrayList<Classes> department = new ArrayList<>();
    private ArrayList<Human> changes = new ArrayList<>();
    private boolean status = false;//eody changes something
    private static final Scanner scanner = new Scanner(System.in);
    public Labors(String name, String area, int numbersOfPeople, String orgMail) {
        super(name, area, numbersOfPeople);
    }
    public void declareCase(Human human) {
        if (!status) {
            changes.clear();
            status = true;
        }
        changes.add(human);
        autoMonitoring();
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
                if (!input1.equals("0")) {
                    one.haveToBeTested();
                    autoMonitoring();
                }
                return;
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
                        System.out.printf("%d: %s\n", i + 1, department.get(i).getIdentifier());
                    }
                    if (!sc.hasNextInt()) {
                        String ans = sc.nextLine();
                        System.out.printf(
                                " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", department.size());
                    } else {
                        choice = sc.nextInt();
                        sc.nextLine();
                        if (choice > department.size()  || choice < 0) {
                            System.out.println("Wrong number!Place a number between 0 and "+ department.size());
                        }
                        break;
                    }
                }
                if (choice <= department.size()) {
                    department.get(choice - 1).affected();
                }
            }
        } else {
            System.out.println("Everything is ok");
        }

    }
    public void printDetails(){}

}

