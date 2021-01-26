package covid.app.additionalMethods;


import covid.app.data.model.Human;
import covid.app.data.model.Organisations;

import java.util.Scanner;
import java.util.ArrayList;

public class Classes {
    private static final Scanner scanner = new Scanner(System.in);
    private final String identifier;

    private final Organisations organisation;
    private final ArrayList<Human> members = new ArrayList<>();

    public Classes(Organisations org) {
        //Here we create a class for schools, unis and labors
        organisation = org;
        System.out.println("Please give the name of the department ");
        this.identifier = scanner.nextLine();
        int meter = 1;
        for (; ; ) {
            System.out.printf("Adding the %d member,0 for exit", meter);
            String answer = scanner.nextLine();
            if (answer.equals("0")) {
                break;
            }
        }
    }
    public String getIdentifier() {
        return identifier;
    }

    public void modify() {
        //asks for deleting or adding a Human
        for (;;) {
            System.out.println("Add or Delete a Person?");
            System.out.println("Give (a) for add, (d) for delete, or (0) for exit");
            String answer = scanner.nextLine();
            if (answer.equals("0")) {
                break;
            }
            if (answer.equals("d")) {
                System.out.println("Please give afm of the person");
                String checkAfm = scanner.nextLine();
                boolean flag = true;
                for (int i = 0; i < members.size(); i++) {
                    if (members.get(i).getAfm().equals(checkAfm)) {
                        members.get(i).removeFromOrg(organisation);
                        members.remove(i);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.printf("Could not find member with afm:%s", answer);
                } else {
                    organisation.reducePeople(1);
                }
                System.out.println("Continue the deletion process? 0 for exit");
                String ans1 = scanner.nextLine();
                if (ans1.equals("0")) {
                    break;
                }
            }
        }
    }

    public void affected() {
        int choice;
        while (true) {
            System.out.println("Give the number for each member");
            System.out.println("0: Exit");
            for (int i = 0; i < members.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, members.get(i).toString());
            }
            if (!scanner.hasNextInt()) {
                String ans = scanner.nextLine();
                System.out.printf(
                        " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", members.size());
            } else {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice > members.size()  || choice < 0) {
                    System.out.println("Wrong number!Place a number between 0 and "+ members.size());
                    continue;
                }
                break;
            }
        }
        if (choice != 0) {
            members.get(choice - 1).haveToBeTested();
        }
    }
    public void printStatus() {
        for (Human member : members) {
            System.out.printf("%s has status:%s", member.toString(), member.seeStatus());
        }
    }
    public Human isSame(String ssn) {
        for (Human member : members) {
            if (member.getAfm().equals(ssn)) {
                return member;
            }
        }
        return null;
    }
    public int size() {
        return members.size();
    }

}
