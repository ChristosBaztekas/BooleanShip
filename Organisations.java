package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class Organisations {
	private String name, area;
	private final int id;
	private static int count = 0;
	private int numbersOfPeople;
	private static final String EodyPassword = "78892GG";
	private ArrayList<String> contactsNames;//extra info for people
															//that we dont have right now
	static Scanner sc = new Scanner(System.in);
    static ArrayList<Organisations> allOrgs = new ArrayList<Organisations>();
	public Organisations(String name, String area, int numbersOfPeople) {

		this.name = name;
		this.area = area;
		count++;
		this.id = count;
		allOrgs.add(this);
	}
	public Organisations() {
		insertAnewOrganisation();
		this.id = count;
		//do not count++, the ahead method calls the other constructor
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public int getNumbersOfPeople() {
			return numbersOfPeople;
	}

	public void setArea(String name) {
		this.name = area;
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

	}// typical information of the contacts
	@Override
	public String toString() {
		return "People that came to contact with a positive covid-19 person are: [contactsNames=" + contactsNames + "]";
	}
	public static void printAllOrganisations(String code) {
		if (code.equals(EodyPassword)) {
			//print all Organisations
			return;
		}
		System.out.println("You dont have acceess");
	}

}
