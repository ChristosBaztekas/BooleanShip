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
}
