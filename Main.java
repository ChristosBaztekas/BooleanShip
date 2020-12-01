package gr.projAboutCovid.leo.proj;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.URI;

//import javax.swing.JFrame;

import java.awt.Desktop;

public class Main {
	static Main inOrderToCallMethods = new Main();
	static Scanner s = new Scanner(System.in);
	private final String EodyPassword = "78892GG";// the password of National organization of Public Health fοr the platform
	static int chance = 0;

	public void displayGMenu() {
		Organisations callMethods = new Organisations();
		for (;;) {
			System.out.println("User Surveillance Menu."
					+ "/n Press 1 to see all registered organizations."
					+ "/n Press 2 to see the latest statistics on the pandemic."
					+ "/n Press 3 to see all recorded case contacts."
					+ "/n Press 4 to see cases by regions." + "/n Press 5 to exit");

			while (!s.hasNextInt()) {
				String input = s.next();
				System.out.println(" Your import(" + input
						+ ")it's not number.Please choose a number between 1 and 7.\n");
			}

			int choice = s.nextInt();

			while (choice > 5 || choice < 1) {
				try {
					System.out.println("Wrong number!Place a number between 1 and 7");

					choice = s.nextInt();
				} catch (InputMismatchException ime) {
					// System.out.println("Your import is not a number!Please choose a number
					// betwenn 1 and 6.\n");
					s.next();
					continue;

				} catch (Exception e) {
					System.err.println("Something unexpected has happened.The program will end.");
				}
			}
			switch (choice) {
			case 1:
				callMethods.printAllHumans();
				break;
			case 2:// an api will be added along the way so that the option can be provided
				break;
			case 3:
				for (int i = 0; i < callMethods.contactsNames.size(); i++) {
					System.out.println(callMethods.contactsNames.toString());
				}
			case 4://when we import the api we will add the option
				break;
			case 5:
				System.out.println("You chose exit.Stay safe.");
				System.exit(0);
			}

		}

	}

	public void gMenu() {
		System.out.println(
				"You have chosen the menu of the user responsible for surveillance./n To proceed, enter a code. "
						+ "/n To exit or in case of incorrect selection press any other key.  ");
		try {
			String UsersPassword = s.next();
			if (UsersPassword.equals(EodyPassword)) {
				System.out.println("Correct code.Below are the options of the user responsible for surveillance:");
				inOrderToCallMethods.displayGMenu();

			} else {
				try {
					if (chance == 0) {
						chance = 1;
						System.out.println(
								"You are denied access.In case of error insert t to try again otherwise any other key to exit .");

						String secondC = s.next();
						if (secondC.equals("t")) {
							inOrderToCallMethods.gMenu();
						} else {
							System.out.println(
									"The program will be terminated if you do not have the appropriate documents.Thank you.");
							System.exit(0);
						}
					} else {
						System.exit(0);
					}
				} catch (Exception e) {
					System.err.println("There's an unexpected mistake.End of program.");
				}

			}
		} catch (Exception e) {
			System.err.println("There's an unexpected mistake.End of program.");
		}

	}

	public void lMenu() {

	}

	public void sMenu() {

	}

	public void uMenu() {

	}

	public void nMenu() {

	}

	public void eMenu() {

	}

	public static void main(String[] args) throws Exception {

		System.out.println("Welcome to the app of case detection and contact detection!");
		System.out.println(
				"The application is designed to make it easier for all organisations to manage the pandemic.");
		System.out.println(
				"Data access and analysis will only be for the provision of statistical data and for the purpose of limiting the spread of.");

		for (;;) {
			System.out
					.println("To get to the menu that's right for you, type in what kind of user you are:/n"
							+ "type 1 or G if you are the user responsible for surveillance. "
							+ "/n-type 2 or L if you are corporate user (e.g. business or public organisation). "
							+ "/n type 3 or S if you belong to educational institution. "
							+ "/n type 4 or U if you belong to university. "
							+ "/n type 5 or N if you belong to nursing home. "
							+ "/n type 6 or E if you wish exit. ");
			String usersInput = null;

			try {
				usersInput = s.next();
				while (!usersInput.equals("1") && !usersInput.equals("2") && !usersInput.equals("3")
						&& !usersInput.equals("4") && !usersInput.equals("5") && !usersInput.equals("6")
						&& !usersInput.equals("G") && !usersInput.equals("L") && !usersInput.equals("S")
						&& !usersInput.equals("U") && !usersInput.equals("N") && !usersInput.equals("E")) {
					System.out
							.println("Your input (" + usersInput + ") is invalid.Please try again.");
					usersInput = s.next();
				}

			} catch (Exception e) {
				System.out.println("Your import was invalid.Try again:");
				s.next();
				continue;
			}

			switch (usersInput) {
			case "1":
			case "G":
				inOrderToCallMethods.gMenu();
				break;
			case "2":
			case "L":
				inOrderToCallMethods.lMenu();
				break;
			case "3":
			case "S":
				inOrderToCallMethods.sMenu();
				break;
			case "4":
			case "U":
				inOrderToCallMethods.uMenu();
				break;
			case "5":
			case "N":
				inOrderToCallMethods.nMenu();
				break;
			case "6":
			case "E":
			default:
				System.out.println("You chose exit.Thank you.Stay safe!");
				System.out.println("Below is the information website.");
				Desktop d = Desktop.getDesktop();
				d.browse(new URI("https://eody.gov.gr/neos-koronaios-covid-19/"));// here will lead the user to
																					// an informational website but
																					// the com[iler does not cooperate today
																					// so I can't confirm
																					// that there is no logical error
																					// that will prevent the user from
																					// getting here.
				System.exit(0);

			}
		}

	}

}
