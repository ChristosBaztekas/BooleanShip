package gr.projAboutCovid.leo.proj;

import java.util.ArrayList;
import java.util.Scanner;

public class Organisations {
	private String name, area;
	private final int id;
	private static int count = 0;
	static Scanner sc = new Scanner(System.in);
	ArrayList<String> contactsNames = null;

	public Organisations(String name, String area, int numbersOfPeople) {
		
		this.name = name;
		this.area = area;
		count++;
		this.id = count;
	}
	public Organisations() {
	  id = count;
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

	public void printAllHumans() {
		Human methodCall = new Human();
		for (int i = 0; i < methodCall.getAllHuman().size(); i++) {
			System.out.println(methodCall.toString());
		} // Ευελπιστώ να εκτυπώνει όλους τους ανθρώπους αν και θα φανεί στην πράξη
	}// χρήστος:Γτ να μην μπει στην Human εφόσον θέλουμε ολους?

	public void notifyContacts(Human anyH) {
		System.out.println(anyH + "was found with covid...Please write down his contacts!");
		for (;;) {
			System.out.println("Do you have available contacts of " + anyH);
			System.out.println("Answer Y for yes and N for no!");
			String answer = sc.next();
			switch (answer) {
			case "Y":
				for (;;) {
					int i = 0;// χρηστος:ισως η αρχικοποιηση να γινει εξω

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
					sc.nextLine(); // άδειασμα του buffer
				}

			case "N":
				System.out.println(anyH + " has to stay home and inform as for his contacts immediately.");
				return;
			default:
				System.out.println("The available options are Y and N!Please choose one of those.");
				continue;
			}

		}
		
	}// Η τυποποιημένη ειδοποίηση επαφών
	@Override
	public String toString() {
		return "Τα άτομα που ήρθαν σε επαφή με φορέα του covid είναι : [contactsNames=" + contactsNames + "]";
	}
  
}
