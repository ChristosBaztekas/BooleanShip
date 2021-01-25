package covid.app.data.model;


import covid.app.additionalMethods.caseManagmentAndHumanAddition;

import java.util.Scanner;
import java.util.ArrayList;

public class NursingHomes extends Organisations implements caseManagmentAndHumanAddition {
    private ArrayList<Human> employees = new ArrayList<>();
    private final ArrayList<Human> carenPeople = new ArrayList<>();
    static ArrayList<String> orgEmails = new ArrayList<>();
    private int count_employees = 0;
    private int count_carenPeople = 0;
    static Scanner sc = new Scanner(System.in);
    private boolean en_status; //true means enclosed and false free access
    private boolean status = false;//has covid if trues
    private final ArrayList<Human> changes = new ArrayList<>();
    private boolean update = false;


   public NursingHomes(String name, String area, int numberOfPeople, String emailAddress, boolean enclosed) {
        super(name, area, numberOfPeople);
        en_status = enclosed;
        orgEmails.add(emailAddress);
        setNumbersOfPeople(employees.size() + carenPeople.size());

    }


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
            System.out.println("Positive have been found: ");
            for (Human change : changes) {
                System.out.printf("    The person: %s", change.toString());
            }
        }
    }

    @Override
    public void autoMonitoring() {

    }


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
                if (!ans.equals("0")) {
                    carenPerson.bePositive();
                    changeStatus(carenPerson);
                }
                return;
            }
        }
        for (Human employee : employees) {
            if (employee.getAfm().equals(input)) {
                System.out.printf("Want to report of a member of employee: %s" +
                        ", 0 for exit\n", employee.toString());
                String ans = sc.nextLine();
                if (!ans.equals("0")) {
                    employee.bePositive();
                    changeStatus(employee);
                }
                return;
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


    public void declareCase(Human human) {
        if (!update) {
            changes.clear();
            update = true;
        }
        changes.add(human);
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



}

