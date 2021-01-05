package covid.app.main.app.boolship;



import java.util.Scanner;
import java.util.ArrayList;

public class Companies extends Labors implements caseManagmentAndHumanAddition {
    private final int id;
    private static int count = 0;
    static Scanner scanner = new Scanner(System.in);
    private boolean lockdown = false;
    private int limit_per_department = 2;
    private int limit_total_number_small = 5;
    private double limit_percentage = 0.85;
    private int total_limit_percentage = 60;
    public Companies(String name, String area, int numbersOfPeople) {
        super(name, area, numbersOfPeople);
        add(this);
        id = count++;

    }
    public static void createP() {
        for (int i = 0; i < 10; i++) { //create 10
            String user_pass = "C" + String.valueOf(i);
            Companies n = new Companies(i, user_pass);
        }
    }
    public Companies(int i, String a) {
        super("name", "area", 20, a, a);
        id = count ++;
        add(this);
    }
    public void autoMonitoring() {
        ArrayList<Classes> department = getDepartment();
        int count = 0;
        for (var c : department) {
            count += c.size();
        }
        if (count > total_limit_percentage) {
            int total_positive = 0;
            for (int i = 0; i < department.size(); i++) {
                int numberdepartment = department.get(i).covidCases();
                total_positive += numberdepartment;
                if (numberdepartment > limit_per_department) {
                    setDepartmentLockdown(i);
                }
            }
            if (total_positive > limit_percentage * count){
                setLockdown(true);
            }
        } else {
            int total_positive = 0;
            for (int i = 0; i < department.size(); i++) {
                int numberdepartment = department.get(i).covidCases();
                total_positive += numberdepartment;
                if (numberdepartment > limit_per_department) {
                    setDepartmentLockdown(i);
                }
            }
            if (total_positive > limit_total_number_small) {
                setLockdown(true);
            }
        }
    }

    public static void createOrg() {

        String name;
        String area;
        int employees;
        while (true) {
            System.out.println("What is your name?");
            name = scanner.nextLine();
            System.out.println("In which area is your company located?");
            area = scanner.nextLine();
            System.out.println("How many employees does your company have?");
            employees = scanner.nextInt();
            System.out.printf("Your Name: %s, Area: %s, Total Employees: %d.Is that correct? (1) for yes", name, area, employees);
            if (scanner.hasNext()) {
                scanner.nextLine();
            }
            String input = scanner.nextLine();
            if (input.equals("1")) {
                break;
            }
        }
        Companies newOne = new Companies(name, area, employees);
    }
    public void printDetails() {
        System.out.println("Welcome.The" + getName() + "Companies of" + getArea()
                + "will take drastic measures to stop spread of covid-19 in your companie.Please stay safe and we will call you soon. "
                +"Always our first priority was the safety of your employees! Thanks for understanding in these difficult times.");
    }
}

