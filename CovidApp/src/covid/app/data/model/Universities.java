package covid.app.data.model;


import covid.app.additionalMethods.Classes;
import covid.app.additionalMethods.caseManagementAndHumanAddition;

import java.util.ArrayList;
import java.util.Scanner;

public class Universities extends Organisations implements caseManagementAndHumanAddition {
    private final ArrayList<Classes> department = new ArrayList<>();
    private final ArrayList<Classes> secretariat = new ArrayList<>();
    private final ArrayList<Human> teachers = new ArrayList<>();
    private final ArrayList<Human> others = new ArrayList<>();
    private boolean status = false;
    private final ArrayList<Human> changes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private int number_others_positive = 0;
    private int number_teachers_positive = 0;
    private final ArrayList<Integer> number_department_positive = new ArrayList<>();
    private final ArrayList<Boolean> lockdown_department = new ArrayList<>();
    private final ArrayList<Integer> number_secreterariat_positive = new ArrayList<>();
    private final ArrayList<Boolean> lockdown_secretariat = new ArrayList<>();
    private static final int limit_per_department = 2;
    private static final int limit_per_secretariat = 0;
    private static final int limit_others = 3;
    private static final int limit_per_teachers = 3;
    public Universities(String name, String area, int numbersOfPeople,String email) {
        super(name, area, numbersOfPeople);
        setSize();
    }

    protected void setSize() {
        int count = 0;
        for (var c : department) {
            count += c.size();
        }
        for (var c : secretariat) {
            count += c.size();
        }
        count += teachers.size();
        count += others.size();
        setNumbersOfPeople(count);
    }

    public void monitoring() {
        if (status) {
            System.out.println("Some changes have been ocured");
            status = false;
            System.out.println("Positive have been found: ");
            for (var c : changes) {
                System.out.printf("    The person: %s", c.toString());
            }
            System.out.println("Please say us who have to tested");
            for (var c : changes) {
                int choice;
                label:
                while (true) {
                    System.out.println("Contacts of the" + c.toString());
                    System.out.println("0 for exit, 1 for profesors, 2 for secretariat, 3 other people related, 4 departments");
                    String input = scanner.nextLine();
                    switch (input) {
                        case "0":
                            break label;
                        case "1":
                            while (true) {
                                System.out.println("Give the number for each profesor");
                                System.out.println("0: Exit");
                                for (int i = 0; i < teachers.size(); i++) {
                                    System.out.printf("%d: %s\n", i + 1, teachers.get(i).toString());
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
                                        continue;
                                    }
                                    break;
                                }
                            }
                            if (choice <= teachers.size()) {
                                teachers.get(choice - 1).haveToBeTested();
                            }
                            break;
                        case "2":
                            while (true) {
                                System.out.println("Give the number for each secretariat");
                                System.out.println("0: Exit");
                                for (int i = 0; i < secretariat.size(); i++) {
                                    System.out.printf("%d: %s\n", i + 1, secretariat.get(i).getIdentifier());
                                }
                                if (!sc.hasNextInt()) {
                                    String ans = sc.nextLine();
                                    System.out.printf(
                                            " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", secretariat.size());
                                } else {
                                    choice = sc.nextInt();
                                    sc.nextLine();
                                    if (choice > secretariat.size() || choice < 0) {
                                        System.out.println("Wrong number!Place a number between 0 and " + teachers.size());
                                        continue;
                                    }
                                    break;
                                }
                            }
                            if (choice <= teachers.size()) {
                                secretariat.get(choice - 1).affected();
                            }
                            break;
                        case "3":
                            while (true) {
                                System.out.println("Give the number for each other employee");
                                System.out.println("0: Exit");
                                for (int i = 0; i < others.size(); i++) {
                                    System.out.printf("%d: %s\n", i + 1, others.get(i).toString());
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
                            if (choice <= others.size()) {
                                others.get(choice - 1).haveToBeTested();
                            }
                            break;
                        case "4":
                            while (true) {
                                System.out.println("Select one by one in which departent should students be tested");
                                System.out.println("0: Exit");
                                for (int i = 0; i < department.size(); i++) {
                                    System.out.printf("%d: %s", i + 1, department.get(i).getIdentifier());
                                }
                                if (!sc.hasNextInt()) {
                                    String ans = sc.nextLine();
                                    System.out.printf(
                                            " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", department.size());
                                } else {
                                    choice = sc.nextInt();
                                    sc.nextLine();
                                    if (choice > department.size() || choice < 0) {
                                        System.out.println("Wrong number!Place a number between 0 and " + department.size());
                                        continue;
                                    }
                                    break;
                                }
                            }
                            if (choice <= department.size()) {
                                department.get(choice - 1).affected();
                            }
                            break;
                        default:
                            System.out.println("Not valid option: " + input);
                            break;
                    }
                }
            }
        } else {
            System.out.println("Everything is done");
        }
    }

    public void autoMonitoring() {
        if (number_teachers_positive > limit_per_teachers) {
            return;
        }
        if (number_others_positive > limit_others) {
            return;
        }
        for (int i = 0; i < secretariat.size(); i++) {
            int a = number_secreterariat_positive.get(i);
            if (a > limit_per_department) {
                lockdown_secretariat.set(i, true);
            }
        }
        for (int i = 0 ; i < department.size(); i++) {
            int secr = number_department_positive.get(i);
            if (secr > limit_per_secretariat) {
                lockdown_department.set(i, true);
            }
        }

    }
    public void findWhereBelongs(Human human) {
        String look_for = human.getAfm();
        for (var c : teachers) {
            if (c.getAfm().equals(look_for)) {
                number_teachers_positive += 1;
                break;
            }
        }
        for (var c : others) {
            if (c.getAfm().equals(look_for)) {
                number_others_positive += 1;
                break;
            }
        }
        for (int i = 0; i < department.size(); i++) {
            Human one;
            one = department.get(i).isSame(look_for);
            if (one != null) {
                number_department_positive.set(i,number_department_positive.get(i) + 1);
                break;
            }
        }
        for (int i = 0; i < secretariat.size(); i++) {
            Human one;
            one = department.get(i).isSame(look_for);
            if (one != null) {
                number_secreterariat_positive.set(i, number_secreterariat_positive.get(i) + 1);
                break;
            }
        }
        autoMonitoring();
    }


}
