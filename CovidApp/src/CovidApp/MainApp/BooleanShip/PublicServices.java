package CovidApp.MainApp.BooleanShip;

import java.util.Scanner;
import java.util.ArrayList;

public class PublicServices extends Labors {
    private final int id;
    private static int count = 0;
    static Scanner scanner = new Scanner(System.in);
    private boolean lockdown = false;
    private int limit_per_department = 1;
    private int limit_total_number_small = 3;
    private double limit_percentage = 0.1;
    private int total_limit_percentage = 30;
    public PublicServices(String name, String area, int numbersOfPeople) {
        super(name, area, numbersOfPeople);
        add(this);
        id = count ++;

    }
    public void autoMonitoring() {
        ArrayList<Classes> department = getDepartment();
        int total_number = 0;
        for (var c : department) {
            total_number += c.size();
        }
        if (total_number > total_limit_percentage) {
            int total_number_positive = 0;
            for (int i = 0; i<department.size(); i++) {
                int number_per_department = department.get(i).covidCases();
                total_number_positive += number_per_department;
                if (number_per_department > limit_per_department) {
                    setDepartmentLockdown(i);
                }
            }
            if (total_number_positive > limit_percentage *total_number ) {
                setLockdown(true);
            }
        } else {
            int total_number_positive = 0;
            for (int i = 0; i < department.size(); i++) {
                int number_per_department = department.get(i).covidCases();
                total_number_positive += number_per_department;
                if (number_per_department > limit_per_department) {
                    setDepartmentLockdown(i);
                }
            }
            if (total_number_positive > limit_total_number_small ) {
                setLockdown(true);
            }
        }
    }

    public static void createOrg() {
        String name;
        String area;
        int employees;
        while(true) {
            System.out.println("What is your name?");
            name = scanner.nextLine();
            System.out.println("In which area is your Public Service located?");
            area = scanner.nextLine();
            System.out.println("How many employees does your Service have?");
            employees = scanner.nextInt();
            System.out.printf("Your Name: %s, Area: %s, Total Employees: %d. Is that correct? (1) for yes",name,area,employees);
            if (scanner.hasNext()) {
                scanner.nextLine();
            }
            String a = scanner.nextLine();
            if (a.equals("1")) {
                break;
            }
        }
        PublicServices newOne = new PublicServices(name, area, employees);
    }
    public void printDetails() {
        System.out.println("Welcome.The" + getName() + "Companies of" + getArea() +
                "will take drastic measures to stop spread of covid-19 in this public sector. Please stay safe and we will call you soon. " +
                "Always our first priority was the safety of our employees! Thanks for understanding in these difficult times.");
    }
}


