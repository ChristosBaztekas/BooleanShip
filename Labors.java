import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Labors extends Organisations implements caseManagmentAndHumanAddition{
	private final int id;
	private static int count = 0;
	private ArrayList<Classes> department = new ArrayList<Classes>();
	private static ArrayList<Labors> allLabors = new ArrayList<Labors>();//see if we needs
	private static Scanner scanner = new Scanner(System.in);
	public Labors(String name, String area, int numbersOfPeople) {
		super(name, area, numbersOfPeople);
		id = count++;
		modifyDepartments(id);
		allLabors.add(this);
	}

	public void managementCases() {
		//look caseManagmentAndHumanAddition
	}
	public static void createOrg() {
		//look caseManagmentAndHumanAddition
	}
	public static void declareCase(int number) {
		//look caseManagmentAndHumanAddition
	}
	public static void printDetails(int number) {
		//look caseManagmentAndHumanAddition
	}
	private void modifyDepartments(int code) {
		while (true){
			if (department.size() == 0) {
				//crete departments
				int count = 0;
				while (true) {
					System.out.printf("Creating the %d department,for exit 0", count + 1);
					if (scanner.nextLine().equals("0")) {
						if (department.size() == 0){
							System.out.println("Cant exit without creating one department");
						}else {
							break;
						}
					}
					Classes one = new Classes(this);
					department.add(one);
				}
				break;
			} else {
				while (true) {
					int ans = 0;

					try {
						System.out.println("Select which department to modify");
						int num = 0;
						for (Classes c : department) {
							System.out.printf("%d for : %s", num, c.getIdifier());
							num++;
						}
						System.out.println("Press a number");
						ans = scanner.nextInt();
						if (ans < 0 && ans > department.size()) {
							System.out.println("Invalid number, try again");
							continue;
						}
						break;
					} catch (InputMismatchException e) {
						System.err.println("That is not number, try again");
						scanner.nextLine();
					}
					//add or delete
					department.get(ans).modify();
					break;
				}
				break;
			}
		}
	}
}
