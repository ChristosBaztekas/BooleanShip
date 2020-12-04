package gr.projAboutCovid.leo.proj;

import java.util.ArrayList;
import java.util.Scanner;

public class Organisations {
	private String name, area;
	private final int id;
	private static int count = 0;
	static Scanner sc = new Scanner(System.in);
	ArrayList<String> contactsNames = null;
    static ArrayList<Organisations> allOrgs;
	public Organisations(String name, String area, int numbersOfPeople) {
		
		this.name = name;
		this.area = area;
		count++;
		this.id = count;
	}
	public Organisations() {
	  id = count++;
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

	public void setArea(String name) {
		this.name = area;
	}
	public void insertAnewOrganisation() {//maybe is out
	System.out.println("What is the name of your Organisation?/n Write the name without spaces!");
	String name = sc.next();
	System.out.println("In which area is your organisation located?/n Write the name without spaces!");
	String area = sc.next();
	System.out.println("How many people does your organisation hava?");
	int people = sc.nextInt();
	allOrgs.add(new Organisations(name,area,people));
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
					System.out.println("If " + anyH + " has no contacts type E for Exit else type C. ");
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
  
}
