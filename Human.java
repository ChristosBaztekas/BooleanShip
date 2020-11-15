package gr.projAboutCovid.leo.proj;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Human {
	// οι ανθρωποι ειναι σε αλφαβητικοι σειρα
	private ArrayList<Human> allHuman;
	private String name, surname, afm, belongsOrganisation;
	private int orgId;
	private final int id; // για την προσωπική μας καταμέτρηση και γρηγορότερη κλήση αντικειμένων
	private static enum Status= {Normal, Suspect, Presumptive, Confirmed}//σε τι κατασταση μπορεί να
																		// βρίσκεται η κατάσταση του αντικειμένου
	private Status status = Status.Normal;//αρχικοποιηση ολων των ανθρωπων σε φυσιολογικη κατασταση
	private static int count = 0;
	static Scanner sc = new Scanner(System.in);

	public Human(String name, String surname, String afm, String belongsOrganisation, int orgId) {
		count++;
		this.id = count;
		this.name = name;
		this.surname = surname;
		this.afm = afm;
		this.belongsOrganisation = belongsOrganisation;
		this.orgId = orgId;
	}

	public void instertHuman(Human anyHuman) {
		System.out.println(
				"Παρακαλώ προσθέστε το άτομο στην βάση δεδομένων για την συμβολή στην διαχείριση κρουσμάτων. ");
		allHuman.add(anyHuman);
		Collections.sort(allHuman, Collator.getInstance());//τοποθετεί τα αντικείμενα σε αλφαβητική σειρά
															// κάθε φορά που προστίθετε ένα νέο

	}// ουσιαστικά θα καλείται η μέθοδος αυτόματα με την δημιουργία ενός νέου ατόμου
		// σε πιθανόν κάποια unlimited loop της main

	@Override
	public String toString() {
		return "Το άτομο [" + ", Όνομα = " + name + ", Επίθετο = " + surname + ", ΑΦΜ = " + afm + "]";
	}

	public ArrayList<Human> getAllHuman() {
		return allHuman;
	}

	public void setAllHuman(ArrayList<Human> allHuman) {//μονο στην αρχη ισως ,αλλα καλυτερα να γινει διαγραφη
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

}
