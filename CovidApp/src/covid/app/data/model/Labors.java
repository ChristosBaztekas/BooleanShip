package covid.app.data.model;


import covid.app.additionalMethods.Classes;
import covid.app.additionalMethods.caseManagementAndHumanAddition;

import java.util.ArrayList;


public class Labors extends Organisations implements caseManagementAndHumanAddition {
    protected ArrayList<Classes> department = new ArrayList<>();
    private final ArrayList<Human> changes = new ArrayList<>();
    private boolean status = false;
    private final String orgMail;

    public Labors(String name, String area, int numbersOfPeople, String orgMail) {
        super(name, area, numbersOfPeople);
        this.orgMail = orgMail;
    }

    public void autoMonitoring() {
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
            for (var ignored :changes) {
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

    public String getOrgMail() {
        return orgMail;
    }
}

