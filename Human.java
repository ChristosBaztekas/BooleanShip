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
	private String name, surname, afm;
	private int id; // για την προσωπική μας καταμέτρηση και γρηγορότερη κλήση αντικειμένων
	private static int count = 0;
	static Scanner sc = new Scanner(System.in);

	public Human(String name, String surname, String afm) {
		count++;
		this.id = count;
		this.name = name;
		this.surname = surname;
		this.afm = afm;
	}

	public void instertHuman(Human anyHuman) {
		System.out.println(
				"Παρακαλώ προσθέστε το άτομο στην βάση δεδομένων για την συμβολή στην διαχείριση κρουσμάτων. ");
		allHuman.add(anyHuman);
		Collections.sort(allHuman, Collator.getInstance());//τοποθετεί τα αντικείμενα σε αλφαβητική σειρά κάθε φορά που προστίθετε ένα νέο

	}// ουσιαστικά θα καλείται η μέθοδος αυτόματα με την δημιουργία ενός νέου ατόμου
		// σε πιθανόν κάποια unlimited loop της main

	@Override
	public String toString() {
		return "Το άτομο [" + ", Όνομα = " + name + ", Επίθετο = " + surname + ", ΑΦΜ = " + afm + "]";
	}

	public ArrayList<Human> getAllHuman() {
		return allHuman;
	}

	public void setAllHuman(ArrayList<Human> allHuman) {
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

}
