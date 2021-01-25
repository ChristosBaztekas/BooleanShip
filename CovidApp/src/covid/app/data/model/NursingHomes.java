package covid.app.data.model;


import covid.app.additionalMethods.caseManagementAndHumanAddition;

import java.util.ArrayList;

public class NursingHomes extends Organisations implements caseManagementAndHumanAddition {
    private final ArrayList<Human> employees = new ArrayList<>();
    private final ArrayList<Human> carenPeople = new ArrayList<>();
    static ArrayList<String> orgEmails = new ArrayList<>();
    static int count_employees = 0;
    static int count_carenPeople = 0;
    private boolean en_status;
    private boolean status = false;
    private final ArrayList<Human> changes = new ArrayList<>();


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


}

