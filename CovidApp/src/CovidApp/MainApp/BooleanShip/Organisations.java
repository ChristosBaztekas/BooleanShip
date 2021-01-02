package CovidApp.MainApp.BooleanShip;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Organisations {
    private String name, area;
    private int id;
    private static int count = 0;
    private int numbersOfPeople;
    private static final String EodyPassword = "78892GG";
    private ArrayList<String> contactsNames;//extra info for people
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Organisations> allOrgs = new ArrayList<Organisations>();
    private String password;
    private String username;
    private Organisations subclass;//see if it doesnt need
    private static TreeMap<String, String> fields = new TreeMap<String, String>();
    private static TreeMap<String, Organisations> codes = new TreeMap<String, Organisations>();
    public Organisations(String name, String area, int numbersOfPeople) {
        this.name = name;
        this.area = area;
        this.numbersOfPeople = numbersOfPeople;
        count++;
        this.id = count++;
        register();
        allOrgs.add(this);
        codes.put(username,this);
    }
    private void register() {
        while (true) {
            System.out.println("Give a username: ");
            String input = sc.nextLine();
            if (fields.containsKey(input)) {
                System.out.println("Unfortunately this username is already used! Please try another one");
                continue;
            }
            while (true) {
                System.out.println("Give password: ");
                String pass1 = sc.nextLine();
                System.out.println("Give again password: ");
                String pass2 = sc.nextLine();
                if (pass1.equals(pass2)) {
                    fields.put(input, pass1);
                    username = input;
                    password = pass1;

                } else {
                    System.out.println("Does not match");
                    continue;
                }
            }
        }
    }
    protected void add(Organisations org) {
        subclass = org;
    }
    public static Organisations giveAccess() {
        while (true) {
            System.out.println("Give your username: ");
            String name = sc.nextLine();
            System.out.println("Give your password: ");
            String pass = sc.nextLine();
            if (fields.get(name) == pass) {
                System.out.print("The authication has procced");
                return codes.get(name).subclass;//see if doesnot need subclass
            } else {
                System.out.print("Wrong!!!Try again!");
                return null;
            }
        }
    }
    public Organisations() {
        insertAnewOrganisation();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getArea() {
        return area;
    }
    public void setNumbersOfPeople(int numbers) {
        numbersOfPeople = numbers;
    }
    public void reducePeople(int numbers) {//reduce
        numbersOfPeople -= numbers;
    }
    public void addPeople(int numbers) {//adding
        numbersOfPeople += numbers;
    }

    public int getNumbersOfPeople() {
        return numbersOfPeople;
    }

    public static void insertAnewOrganisation() {
        String name;
        String area;
        int numbersOfpeople;
        while (true) {
            System.out.println("What is the name of your Organisation?/n Write the name without spaces!");
            name = sc.next();
            System.out.println("In which area is your organisation located?/n Write the name without spaces!");
            area = sc.next();
            System.out.println("How many people does your organisation hava?");
            sc.nextLine();
            numbersOfpeople = sc.nextInt();
            System.out.printf("Name Organisation: %s, Area: %s, Total People: %d. Is that correct? 1 for yes", name, area, numbersOfpeople);
            if (sc.nextLine().equals("1")) {
                break;
            }
        }
        new Organisations(name, area, numbersOfpeople);
    }

    public void notifyContacts(Human anyH) {//maybe changes to be done
        System.out.println(anyH + "was found with covid...Please write down his contacts!");
        for (;;) {
            System.out.println("Do you have available contacts of " + anyH);
            System.out.println("Answer Y for yes and N for no!");
            String answer = sc.next();
            switch (answer) {
                case "Y":
                    int i = 0;
                    for (;;) {
                        System.out.printf("If %s has no other contacts type E for Exit else type C. ", anyH);
                        String startInsert = sc.next();
                        switch (startInsert) {
                            case "C":
                                System.out.println("Insert contact number " + (i++) + " name and surname : ");
                                String nameSur = sc.nextLine();
                                System.out.println("Is contacts name and surname : " + nameSur);
                                answer = sc.next();
                                if (answer == "Y") {
                                    contactsNames.add(nameSur);
                                } else if (answer == "N") {
                                    break;
                                } else {
                                    System.out.println("Not an available option try again!");
                                    break;
                                }
                                break;
                            case "E":
                                System.out.println("Try to inform the contacts , or tell " + anyH
                                        + " to do so.We will also do our best.Be safe!");
                                return;
                            default:
                                System.out.println("Not an available option!Try again!");
                                break;
                        }
                        sc.nextLine(); //empty buffer
                    }

                case "N":
                    System.out.println(anyH + " has to stay home and inform as for his contacts immediately.");
                    return;
                default:
                    System.out.println("The available options are Y and N!Please choose one of those.");
                    continue;
            }

        }

    }
    @Override
    public String toString() {
        return "Name of organisation is: " + name + "\n Organisation Area is: " + area + "\n Number of employees: " + numbersOfPeople;
    }
    public static void printAllOrganisations(String code) {
        if (codes.equals(EodyPassword)) {
            for (var c : allOrgs) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("You dont have access");
        }
    }

}

