package covid.app.data.model;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Organisations {
    private String name, area;
    private String email;
    private int numbersOfPeople;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Organisations> allOrgs = new ArrayList<>();
    public Organisations(String name, String area, String email) {
        this.name = name;
        this.area = area;
        this.email = email;
    }
    public Organisations(String name, String area, int numbersOfPeople) {
        this.name = name;
        this.area = area;
        this.numbersOfPeople = numbersOfPeople;
        allOrgs.add(this);//to be removed
    }
    public Organisations() {
        insertAnewOrganisation();
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

    @Override
    public String toString() {
        return "Name of organisation is: " + name + "\n Organisation Area is: " + area + "\n Number of employees: " + numbersOfPeople;
    }


}
