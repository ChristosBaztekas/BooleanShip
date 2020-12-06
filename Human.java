package gr.projAboutCovid.leo.proj;

import java.text.Collator;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human {
	private static ArrayList<Human> allHuman = new ArrayList<Human>();
	private String name, surname, afm, belongsOrganisation, gender;
	private int orgId;
	private final int id; // for our personal counting and faster dialing of items in what condition can
						//the state of the object is found
	private Status status = Status.NORMAL;// initialization of all people in a normal state
	private static int count = 0;
	private static SortByAfm sortItem =new SortByAfm();//do not need to understand it
	static Scanner sc = new Scanner(System.in);

	public Human(String name, String surname, String afm, String belongsOrganisation, String gender, int orgId)
			throws IllegalAccessException {
		count++;
		this.id = count;
		this.gender = gender;
		this.name = name;
		this.surname = surname;
		if (!isValidAfm(afm))
			throw new IllegalAccessException("Your input<" + afm + ">not valid afm");
		this.afm = afm;// when we will ask the afm from the user the code will be:
		/*
		 * String ssn = getSsnFromUser(); while(!YourClass.isValidSSN(ssn)) {
		 * showErrorMessage("Not a valid ssn: " + ssn); ssn = getSsnFromUser(); }
		 */
		this.belongsOrganisation = belongsOrganisation;
		this.orgId = orgId;
		allHuman.add(this);
		sort();
	}
	//helps for sort
	private static class SortByAfm implements Comparator<Human> {
		public int compare(Human a, Human b) {
			return a.afm.compareTo(b.afm);
		}
	}
	//it sorts with unicode form, that means the number not gonna be
	//in arithmetic series, but id doesnt mind,search gonna work the same
	private static void sort() {//it is called in constructor
		allHuman.sort(sortItem);
	}

	public static boolean isValidAfm(String afm) {
		int len = afm.length();
		if (len != 9) {
			return false;
		} else {

			for (int i = 0; i < 9; i++) {
				if (afm.charAt(i) >= '0' && afm.charAt(i) <= '9') {
				    continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	public void instertHuman(Human anyHuman) {
		System.out.println(
				"Παρακαλώ προσθέστε το άτομο στην βάση δεδομένων για την συμβολή στην διαχείριση κρουσμάτων. ");
		Human anyHuman = this;//wrong!! is all ready a human

	}// ουσιαστικά θα καλείται η μέθοδος αυτόματα με την δημιουργία ενός νέου ατόμου
		// σε πιθανόν κάποια unlimited loop της  main

	@Override
	public String toString() {
		return "Το άτομο [" + ", Όνομα = " + name + ", Επίθετο = " + surname + ", ΑΦΜ = " + afm + "]";
	}

	public ArrayList<Human> getAllHuman() {
		return allHuman;
	}

	public void setAllHuman(ArrayList<Human> allHuman) {// μονο στην αρχη ισως ,αλλα καλυτερα να γινει διαγραφη
		this.allHuman = allHuman;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAfm() {
		return afm;
	}

	public void changeStatus(String st) {

	}

	public String getBelongsOrganisation() {
		return belongsOrganisation;
	}

	public void setBelongsOrganisation(String belongsOrganisation) {
		this.belongsOrganisation = belongsOrganisation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void beCase() {
		status = Status.CONFIRMED;
	}
	public static void testResult() {
		for(;;) {
			System.out.println("Give AFM of the person that get tested, (-1 for break): ");
			String afmGiven = sc.nextInt();
			if (afmGiven.equal("-1") {
				break;
			}
			int position = search(afmGiven);
			if (position == -1) {
				System.out.printf("Does not exist this %s afm", afmGiven);
				continue;
			}
			System.out.printf("Καταχώριση του ανθρώπου %s με ΑΦΜ: %s ;", allHuman[position].getName(), allHuman[position].getAFM());
			String confirmed = sc.nextLine();
			if (confirmed.equals("Yes") || confirmed.equals("yes") || confirmed.equals("y") || confirmed.equals("Y")) {
				for(;;) {
					System.out.println("Give 0 for negative, 1 for positive for the result of the test: ");
					int result = sc.nextInt();
					if (result == 0) {
						allHuman[position].status = Status.NORMAL;
						break;
					} else if (result == 1) {
						allHuman[position].status = Status.CONFIRMED;
						//συνεχιζεται η διαδικασια με ιχνηλατιση
						if (allHuman[position].belongsOrganisation = null) {//θα στελνονται στις αλλες κλασεις και απο κει
							//θα αλλαζει πεδια και θα γινονται αναλογες πραξεις
							// ισως την manageCase() της organisations και αλλες
						} else if (allHuman[position].belongsOrganisation.equals(NursingHomes)) {

						} else if (allHuman[position].belongsOrganisation.equals(Labors)) {

						} else if (allHuman[position].belongsOrganisation.equals(Schools)) {

						} else if (allHuman[position].belongsOrganisation.equals(Universities)) {

						}
						break;
					} else {
						System.out.println("Not valid option");
					}
				}
			}
		}
	}
	// finds if the human exists in allHuman
	// if yes, returns its position, otherwise -1
	//be sure of giving a number
	private static int search(String idGiven) {
		int low = 0;
		int high = allHuman.size();
		int mid;
		while (low <=high) {
			mid = (low + high) / 2;
			if (idGiven.compareTo(allHuman.get(mid).afm) < 0)  {
				high = mid -1;
			} else if (idGiven.compareTo(allHuman.get(mid).afm) > 0) {
				low = mid +1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	//create human that returns, if does not exist
	//argument class name and id class
	//if person exists return the person
	public static Human createHuman(String class_name, int orgId1) {
		//class name=object.getClass().getName() or write your class F.E. Schools
		//orgId1 is a indifier of the object that belongs F.E. 31 for thirty first school
		for(;;) {
			System.out.println("Give the AFM of the Person, 0 for exit");
			String ans_afm = sc.nextLine();
			if (ans_afm.equals("0") {
				break;
			}
			if (!isValidAfm(ans_afm)) {
				System.out.printf("The %s is not right afm try again", ans_afm);
				continue;
			}
			int pos = search(afm);
			if (pos == -1) {
				String name ,surname, gender;
				System.out.printf("Δεν υπάρχει άνθρωπος με ΑΦΜ:%s στην βάση, δημιουργεία ανθρώπου");
				for(;;){
					System.out.println("Give the name: ");
					name = sc.nextLine();
					System.out.println("Give the surname: ");
					surname = sc.nextLine();
					System.out.println("Give the gender: ");
					gender = sc.nextLine();
					System.out.printf("Είναι αυτά τα σωστά στοιχεία %s %s %s;,0 για οχι\n", name, surname, gender);
					int ans = sc.nextInt()
					if(ans == 0) {
						System.out.println("Επαναλαμβάνεται η διαδικασία για την δημιουργεία ανθρώπου");
					} else {
						break;
					}
				}
				Human one = new Human(name, surname, ans_afm, class_name, gender, orgId1);
				return one;


			} else {
				System.out.println("Το άτομο βρέθηκε στην βάση");
				System.out.printf("Συνεχίζουμε την διαδικασία με τον άνθρωπο:%s;/n 0 για έξοδο: ", allHuman[pos].toString());
				int ans = sc.nextInt();
				if (ans != 0) {
					return allHuman[pos];
				} else {
					System.out.println("Η διαδικασία για το συγκεκριμένο άτομο σταμάτησε, ξαναρχίζει για την επόμενη εισαγωγή");
				}

			}

		}
	}
}
