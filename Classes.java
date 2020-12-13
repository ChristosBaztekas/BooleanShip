package gr.projAboutCovid.leo.proj;
import java.util.Scanner;
import java.util.ArrayList;

public class Classes {
    private static Scanner scanner = new Scanner(System.in);
    private String idifier;
    private String clas;
    private ArrayList<Human> students = new ArrayList<Human>();
    private static int count = 0;

    	public Classes(String clas, int id) {
			//Here we create a class for schools
			count++;
			this.id = count;
			this.clas = clas;
			System.out.println("Parakalo, eisagetai tmhma(gramma kai arithmos xwris keno). ");
			this.idifier = scanner.nextLine();

			for (;;) {
				System.out.println("Na ginei eisagwgh mathitwn? (n), gia Nai/(o), gia Oxi" );
				String answr = scanner.nextLine();
				if (answr.equals("n")) {
					human = Human.createHuman(clas, id);
					students.add(human);
				} else if (answr.equals("o")) {
					break;
				} else {
					continue;
				}
			}
    }

    public String getIdifier() {
		return idifier;
	}
}
