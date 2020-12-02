package gr.projAboutCovid.leo.proj;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.URI;
import java.net.URISyntaxException;

//import javax.swing.JFrame;

import java.awt.Desktop;
import java.io.IOException;

public class Main {
	static Organisations callMethods = new Organisations();
	static Main inOrderToCallMethods = new Main();
	static Scanner sc = new Scanner(System.in);
	private final String EodyPassword = "78892GG";// the password of National organization of Public Health fΞΏr the
													// platform
	static int chance = 0;

	public void displayGMenu() {
		Organisations callMethods = new Organisations();
		for (;;) {
			System.out.println("User Surveillance Menu." + "\n Press 1 to see all registered organizations."
					+ "\n Press 2 to see the latest statistics on the pandemic."
					+ "\n Press 3 to see all recorded case contacts." + "\n Press 4 to see cases by regions."
					+ "\n Press 5 to exit");

			while (!sc.hasNextInt()) {
				String input = sc.next();
				System.out.println(
						" Your import(" + input + ")it's not number.Please choose a number between 1 and 7.\n");
			}

			int choice = sc.nextInt();

			while (choice > 5 || choice < 1) {
				try {
					System.out.println("Wrong number!Place a number between 1 and 7");

					choice = sc.nextInt();
				} catch (InputMismatchException ime) {
					// System.out.println("Your import is not a number!Please choose a number
					// betwenn 1 and 6.\n");
					sc.next();
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
			case 4:// when we import the api we will add the option
				break;
			case 5:
				System.out.println("You chose exit.Stay safe.");
				System.exit(0);
			}

		}

	}

	public void gMenu() {
		System.out.println(
				"You have chosen the menu of the user responsible for surveillance.\n To proceed, enter a code. "
						+ "\n To exit or in case of incorrect selection press any other key.  ");
		try {
			String UsersPassword = sc.next();
			if (UsersPassword.equals(EodyPassword)) {
				System.out.println("Correct code.Below are the options of the user responsible for surveillance:");
				inOrderToCallMethods.displayGMenu();

			} else {
				try {
					if (chance == 0) {
						chance = 1;
						System.out.println(
								"You are denied access.In case of error insert t to try again otherwise any other key to exit .");

						String secondC = sc.next();
						if (secondC.equals("t")) {
							inOrderToCallMethods.gMenu();
						} else {
							System.out.println(
									"The program will be terminated if you do not have the appropriate documents.Thank you.");
							System.exit(0);
						}
					} else {
						System.out.println("You dont hava access priviledges for this menu.Stay safe.");
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

	public void sMenu() throws IOException, URISyntaxException {
		System.out.println("Welcome to the school user menu.");
		System.out.println("Type 1:if you are a new user." + "\n Type 2:if you are already registered. "
				+ "\n Type 3:if you want to exit.");
		int answer = sc.nextInt();
		while (answer > 3 || answer < 1) {
			try {
				System.out.println("Wrong number!Place a number between 1 and 7");

				answer = sc.nextInt();
			} catch (InputMismatchException ime) {
				// System.out.println("Your import is not a number!Please choose a number
				// betwenn 1 and 6.\n");
				sc.next();
				continue;

			} catch (Exception e) {
				System.err.println("Something unexpected has happened.The program will end.");
			}
		}
		switch (answer) {
		case 1:
			callMethods.insertAnewOrganisation();
			break;
		case 2:
			System.out.println("Please enter your username in order to find your account.");
			// εδώ πρέπει να δημιουργηθεί μια μέθοδος που θα ελέγχει εάν το όνομα που
			// εισάγει υπάρχει ήδη και θα τον βγάζει ως υπάρχων χρήστη σε περίπτωση που
			// θέλει να δηλώσει κρούσμα κλπ
			break;
		case 3:
			System.out.println(
					"You chose Exit!Here is a link for more info about covid.Stay safe and keep your people safe.");
			Desktop d = Desktop.getDesktop();
			d.browse(new URI(
					"https://eody.gov.gr/wp-content/uploads/2020/09/%CE%91%CE%9D%CE%A4%CE%99%CE%9C%CE%95%CE%A4%CE%A9%CE%A0%CE%99%CE%A3%CE%97-COVID-%CE%A3%CE%A4%CE%9F-%CE%A3%CE%A7%CE%9F%CE%9B%CE%95%CE%99%CE%9F-%CE%A0%CE%A1%CE%A9%CE%A4%CE%9F%CE%9A%CE%9F%CE%9B%CE%9B%CE%9F-%CE%91%CE%9D%CE%91%CE%A3%CE%A4%CE%9F%CE%9B%CE%97%CE%A3-%CE%9B%CE%95%CE%99%CE%A4%CE%9F%CE%A5%CE%A1%CE%93%CE%99%CE%91%CE%A3-%CE%A3%CE%A7%CE%9F%CE%9B%CE%95%CE%99%CE%A9%CE%9D_18-09-20.pdf"));
			System.exit(0);
		}
	}

	public void uMenu() throws IOException, URISyntaxException {
		System.out.println("Welcome to the university user menu.");
		System.out.println("Type 1:if you are a new user." + "\n Type 2:if you are already registered. "
				+ "\n Type 3:if you want to exit.");
		int answer = sc.nextInt();
		while (answer > 3 || answer < 1) {
			try {
				System.out.println("Wrong number!Place a number between 1 and 7");

				answer = sc.nextInt();
			} catch (InputMismatchException ime) {
				// System.out.println("Your import is not a number!Please choose a number
				// betwenn 1 and 6.\n");
				sc.next();
				continue;

			} catch (Exception e) {
				System.err.println("Something unexpected has happened.The program will end.");
			}
		}
		switch (answer) {
		case 1:
			callMethods.insertAnewOrganisation();
			break;
		case 2:
			System.out.println("Please enter your username in order to find your account.");
			// εδώ πρέπει να δημιουργηθεί μια μέθοδος που θα ελέγχει εάν το όνομα που
			// εισάγει υπάρχει ήδη και θα τον βγάζει ως υπάρχων χρήστη σε περίπτωση που
			// θέλει να δηλώσει κρούσμα κλπ
			break;
		case 3:
			System.out.println(
					"You chose Exit!Here is a link for more info about covid.Stay safe and keep your people safe.");
			Desktop d = Desktop.getDesktop();
			d.browse(new URI("https://eody.gov.gr/neos-koronaios-covid-19/"));
			System.exit(0);
		}

	}

	public void nMenu() {

	}

	public void eMenu() throws Exception, URISyntaxException {
		System.out.println("You chose exit.Thank you.Stay safe!");
		System.out.println("Below is the information website.");
		Desktop d = Desktop.getDesktop();
		d.browse(new URI("https://eody.gov.gr/neos-koronaios-covid-19/"));// here will lead the user to
																			// an informational website but
																			// the com[iler does not cooperate
																			// today
																			// so I can't confirm
																			// that there is no logical error
																			// that will prevent the user from
																			// getting here.
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Welcome to the app of case detection and contact detection!");
		System.out
				.println("The application is designed to make it easier for all organisations to manage the pandemic.");
		System.out.println(
				"Data access and analysis will only be for the provision of statistical data and for the purpose of limiting the spread of.");

		for (;;) {
			System.out.println("To get to the menu that's right for you, type in what kind of user you are:"
					+ "\n-Type 1 or G if you are the user responsible for surveillance. "
					+ "\n-Type 2 or L if you are corporate user (e.g. business or public organisation). "
					+ "\n-Type 3 or S if you belong to educational institution. "
					+ "\n-Type 4 or U if you belong to university. " + "\n-Type 5 or N if you belong to nursing home. "
					+ "\n-Type 6 or E if you wish exit. ");
			String usersInput = null;

			try {
				usersInput = sc.next();
				while (!usersInput.equals("1") && !usersInput.equals("2") && !usersInput.equals("3")
						&& !usersInput.equals("4") && !usersInput.equals("5") && !usersInput.equals("6")
						&& !usersInput.equals("G") && !usersInput.equals("L") && !usersInput.equals("S")
						&& !usersInput.equals("U") && !usersInput.equals("N") && !usersInput.equals("E")) {
					System.out.println("Your input (" + usersInput + ") is invalid.Please try again.");
					usersInput = sc.next();
				}

			} catch (Exception e) {
				System.out.println("Your import was invalid.Try again:");
				sc.next();
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
				inOrderToCallMethods.eMenu();

			}
		}

	}

}
