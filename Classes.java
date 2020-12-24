import java.util.Scanner;
import java.util.ArrayList;

public class Classes {
    private static Scanner scanner = new Scanner(System.in);
    private String idifier;
    private Organisations organisation;
    private ArrayList<Human> members = new ArrayList<Human>();
    private static int count = 0;

    public Classes(Organisations org) {
    	//Here we create a class for schools, unis and labors
		organisation = org;
		System.out.println("Please give the name of the department ");
		this.idifier = scanner.nextLine();
		int metr = 1;
		for (;;) {
			System.out.printf("Adding the %d member,0 for exit", metr);
			String answr = scanner.nextLine();
			if (answr.equals("0")) {
				break;
			}
			while (true) {
				Human human = Human.createHuman(organisation);
				if (human != null) {
					members.add(human);
					metr++;
				} else {
					return;
				}
			}
		}
    }

    public String getIdifier() {
		return idifier;
	}
	protected void modify() {
		//asks for deleting or adding a Human
	}
	protected void affected() {
    	int choice;
		while (true) {
			System.out.println("Give the number for each member");
			System.out.println("0: Exit");
			for (int i = 0; i < members.size(); i++) {
				System.out.printf("%d: %s\n", i + 1, members.get(i).toString());
			}
			if (!sc.hasNextInt()) {
				String ans = sc.nextLine();
				System.out.printf(
						" Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", members.size());
				continue;
			} else {
				choice = sc.nextInt();
				sc.nextLine();
				if (choice > members.size()  || choice < 0) {
					System.out.println("Wrong number!Place a number between 0 and "+ members.size());
					continue;
				}
				break;
			}
		}
		if (choice == 0) {
			return;
		} else if (choice <= members.size()) {
			members.get(choice - 1).haveToBeTested();
		}
	}
	public void printStatus() {
    	for (var c : members) {
			System.out.println("%s has status:%s", c.toString(), c.seeStatus());
		}
	}
	public Human isSame(String ssn) {
    	for (var c : members) {
    		if (c.getAfm().equals(ssn)) {
    			return c;
			}
		}
    	return null;
	}
	protected int size() {
    	return members.size();
	}
	protected int covidCases() {
    	int count = 0;
    	for (var c : members) {
    		if (c.seeStatus().equals("CONFIRMED")) {//check if it works
    			count += 1;
			}
		}
    	return count;
	}
}
