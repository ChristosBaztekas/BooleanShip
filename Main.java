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
			System.out.println("Μενού αρμόδιου για την επιτήρηση χρήστη."
					+ "/n Πατήστε 1 για να δείτε όλους του καταγεγραμμένους οργανισμούς."
					+ "/n Πατήστε 2 για να δείτε επίκαιρα στατιστικά στοιχεία σχετικά με την πανδημία."
					+ "/n Πατήστε 3 για να δείτε όλες τις καταγεγραμμένες επαφές των κρουσμάτων."
					+ "/n Πατήστε 4 για να δείτε τα κρούσματα ανά περιοχές." + "/n Πατήστε 5 για έξοδο");

			while (!s.hasNextInt()) {
				String input = s.next();
				System.out.println(" Η εισαγωγή σας(" + input
						+ ")δεν είναι αριθμός.Παρακαλώ επιλέξτε έναν αριθμό μεταξύ 1 και 7.\n");
			}

			int choice = s.nextInt();

			while (choice > 5 || choice < 1) {
				try {
					System.out.println("Λανθασμένος αριθμός!Τοποθετήστε έναν αριθμό από το 1 μέχρι το 7");

					choice = s.nextInt();
				} catch (InputMismatchException ime) {
					// System.out.println("H εισαγωγή σας δεν είναι αριθμός!Παρακαλώ επιλέξτε έναν
					// αριθμό μεταξύ 1 και 6.\n");
					s.next();
					continue;

				} catch (Exception e) {
					System.err.println("Κάτι αναπάντεχο συναίβει.Το πρόγραμμα θα τερματίσει.");
				}
			}
			switch (choice) {
			case 1:
				callMethods.printAllHumans();
				break;
			case 2:// στην πορεία θα προστεθεί μια api ώστε να μπορεί να παρέχεται η επιλογή
				break;
			case 3:
				for (int i = 0; i < callMethods.contactsNames.size(); i++) {
					System.out.println(callMethods.contactsNames.toString());
				}
			case 4://όταν εισάγουμε την api θα προσθέσουμε την επιλογή
				break;
			case 5:
				System.out.println("Επιλέξατε έξοδο.Μείνετε ασφαλείς.");
				System.exit(0);
			}

		}

	}

	public void gMenu() {
		System.out.println(
				"Διαλέξατε το μενού του αρμόδιου για την επιτήρηση χρήστη./n Για να προχωρήσετε εισάγεται κωδικό. "
						+ "/n Για έξοδο ή σε περίπτωση λανθασμένης επιλογής πατήστε οποιοδήποτε άλλο πλήκτρο.  ");
		try {
			String UsersPassword = s.next();
			if (UsersPassword.equals(EodyPassword)) {
				System.out.println("Ορθός κωδικός.Παρακάτω είναι οι επιλογές του αρμόδιου για την επιτήρηση χρήστη:");
				inOrderToCallMethods.displayGMenu();

			} else {
				try {
					if (chance == 0) {
						chance = 1;
						System.out.println(
								"Δεν σας επιτρέπετε η πρόσβαση.Σε περίπτωση λάθους εισάγεται t για να ξαναπροσπαθήσετε αλλιώς οποιοδήποτε άλλο πλήκτρο για έξοδο .");

						String secondC = s.next();
						if (secondC.equals("t")) {
							inOrderToCallMethods.gMenu();
						} else {
							System.out.println(
									"Το πρόγραμμα θα τερματιστεί αφού δεν έχετε τα κατάλληλα τεκμήρια.Καλή συνέχεια.");
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
				System.out.println("Επιλέξατε έξοδο.Καλή συνέχεια.Μείνετε ασφαλείς!");
				System.out.println("Παρακάτω η ενημερωτική ιστοσελίδα.");
				Desktop d = Desktop.getDesktop();
				d.browse(new URI("https://eody.gov.gr/neos-koronaios-covid-19/"));// εδώ θα οδηγεί τον χρήστη σε
																					// ενημερωτική ιστοσελίδα απλά δεν
																					// δουλέυει ο compiler μου σήμερα
																					// οπότε δεν μπορώ να επιβεβαιώσω
																					// πως δεν υπάρχει λογικό σφάλμα που
																					// θα αποτρέψει τον χρήστη από το να
																					// οδηγηθεί εδώ.
				System.exit(0);

			}
		}

	}

}
