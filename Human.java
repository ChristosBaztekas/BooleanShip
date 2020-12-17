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
	enum Status {
		NORMAL, SUSPECT,PRESUMPITIVE,CONFIRMED
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

	@Override
	public String toString() {
		return "Το άτομο [" + ", Όνομα = " + name + ", Επίθετο = " + surname + ", ΑΦΜ = " + afm + "]";
	}


	public void setAllHuman(ArrayList<Human> allHuman) {// only in start for initilization
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
			String afmGiven = sc.nextLine();
			if (afmGiven.equals("-1")) {
				break;
			}
			int position = search(afmGiven);
			if (position == -1) {
				System.out.printf("Does not exist this %s afm", afmGiven);
				continue;
			}
			System.out.printf("Human registration %s with AFM: %s ;", allHuman.get(position).getName(), allHuman.get(position).getAfm());
			String confirmed = sc.nextLine();
			if (confirmed.equals("Yes") || confirmed.equals("yes") || confirmed.equals("y") || confirmed.equals("Y")) {
				for(;;) {
					System.out.println("Give 0 for negative, 1 for positive for the result of the test: ");
					int result = sc.nextInt();
					if (result == 0) {
						allHuman.get(position).status = Status.NORMAL;
						break;
					} else if (result == 1) {
						allHuman.get(position).status = Status.CONFIRMED;
						//συνεχιζεται η διαδικασια με ιχνηλατιση
						if (allHuman.get(position).belongsOrganisation == null) {//goes where a human belong
							//will change fields and similar operations will be performed
							// ισως την manageCase() της organisations και αλλες
						} else if (allHuman.get(position).belongsOrganisation.equals("NursingHomes")) {

						} else if (allHuman.get(position).belongsOrganisation.equals("Labors")) {

						} else if (allHuman.get(position).belongsOrganisation.equals("Schools")) {

						} else if (allHuman.get(position).belongsOrganisation.equals("Universities")) {

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
			if (ans_afm.equals("0")) {
				break;
			}
			if (!isValidAfm(ans_afm)) {
				System.out.printf("The %s is not right afm try again", ans_afm);
				continue;
			}
			int pos = search(ans_afm);
			if (pos == -1) {
				String name ,surname, gender;
				System.out.printf("No human with Afm number: %s at base, human creations", ans_afm);
				for(;;){
					System.out.println("Give the name: ");
					name = sc.nextLine();
					System.out.println("Give the surname: ");
					surname = sc.nextLine();
					System.out.println("Give the gender: ");
					gender = sc.nextLine();
					System.out.printf("Είναι αυτά τα σωστά στοιχεία %s %s %s;,0 για οχι\n", name, surname, gender);
					String ans = sc.nextLine();
					if(!ans.equals("0")) {
						System.out.println("The process of creating man is repeated");
					} else {
						break;
					}
				}
				Human one = null;
				try {
					one = new Human(name, surname, ans_afm, class_name, gender, orgId1);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				return one;


			} else {
				System.out.println("The person was found at the base");
				System.out.printf("We continue the process with man:% s;\n 0 to exit: ", allHuman.get(pos).toString());
				int ans = sc.nextInt();
				if (ans != 0) {
					return allHuman.get(pos);
				} else {
					System.out.println("The process for that person has stopped, it starts again for the next introduction");
				}

			}

		}
		return null;
	}
}
