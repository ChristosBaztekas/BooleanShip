package gr.projAboutCovid.leo.proj;

import java.util.Scanner;
import java.net.URI;

//import javax.swing.JFrame;

import java.awt.Desktop;

public class Main {
	static Main inOrderToCallMethods = new Main();
	static Scanner s = new Scanner(System.in);
	private final String EodyPassword = "78892GG";// το password του εοδυ για την πλατφόρμα
	static int chance = 0;

	public void gMenu() {
		System.out.println(
				"Διαλέξατε το μενού του αρμόδιου για την επιτήρηση χρήστη./n Για να προχωρήσετε εισάγεται κωδικό. "
						+ "/n Για έξοδο ή σε περίπτωση λανθασμένης επιλογής πατήστε οποιοδήποτε άλλο πλήκτρο και το πρόγραμμα θα τερματίσει.  ");
		try {
			String UsersPassword = s.next();
			if (UsersPassword.equals(EodyPassword)) {
				System.out.println("Ορθός κωδικός.Παρακάτω είναι οι επιλογές του αρμόδιου για την επιτήρηση χρήστη:");

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
					System.err.println("Συναίβει κάποιο απρόοπτο λάθος.Τερματισμός προγράμματος.");
				}

			}
		} catch (Exception e) {
			System.err.println("Συναίβει κάποιο απρόοπτο λάθος.Τερματισμός προγράμματος.");
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

		System.out.println("Καλωσήρθατε στην εφαρμογή ανίχνευσης κρουσμάτων και εντοπισμού επαφών!");
		System.out.println(
				"H εφαρμογή είναι σχεδιασμένη για να διευκολύνει όλους τους οργανισμούς αναφορικά με την διαχείριση της πανδημίας.");
		System.out.println("Η πρόσβαση και η ανάλυση δεδομένων θα γίνει μόνο για παροχή στατιστικών δεδομένων.");

		for (;;) {
			System.out
					.println("Για να οδηγηθείτε στο κατάλληλο για εσάς μενου πληκτρολογείστε τι είδους χρήστης είστε:/n"
							+ "Πληκτρολογείστε 1 ή G εάν είστε ο αρμόδιος για την επιτήρηση χρήστης. "
							+ "/n-Πληκτρολογείστε 2 ή L εάν είστε εταιρικός χρήστης(π.χ. επιχείρηση ή δημόσιος οργανισμός. "
							+ "/n Πληκτρολογείστε 3 ή S εάν είστε εκπαιδευτικό ίδρυμα. "
							+ "/n Πληκτρολογείστε 4 ή U εάν είστε πανεπιστημιακό ίδρυμα. "
							+ "/n Πληκτρολογείστε 5 ή N εάν είστε γηροκομείο. "
							+ "/n Πληκτρολογείστε 6 ή E εάν επιθυμείτε έξοδο. ");
			String usersInput = null;

			try {
				usersInput = s.next();
				while (!usersInput.equals("1") && !usersInput.equals("2") && !usersInput.equals("3")
						&& !usersInput.equals("4") && !usersInput.equals("5") && !usersInput.equals("6")
						&& !usersInput.equals("G") && !usersInput.equals("L") && !usersInput.equals("S")
						&& !usersInput.equals("U") && !usersInput.equals("N") && !usersInput.equals("E")) {
					System.out
							.println("Η εισαγωγή σας (" + usersInput + ") είναι λανθασμένη.Παρακαλώ προσπαθήστε ξανά.");
					usersInput = s.next();
				}

			} catch (Exception e) {
				System.out.println("Η εισαγωγή σας δεν ήταν έγκυρη.Ξαναπροσπαθήστε:");
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
