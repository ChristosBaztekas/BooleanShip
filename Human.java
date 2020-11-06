package gr.projAboutCovid.leo.proj;
import java.util.Scanner;
public class Human {
	//οι ανθρωποι ειναι σε αλφαβητικοι σειρα
	private ArrayList<Human> allHuman;
	private String id;
	public Human() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Give id: ");
		String id = sc.nextLine();
		if(findIndex(id) == -1) {
			apothikeysi(
		}
	}
	public static ArrayList<Human> inputHuman() {
		//input peopple of an organazation
		human = /*list of human*/
		for(;;) {
			System.out.println("Another input?yes or no")
			Scanner sc = new Scanner(System.in);
			ans = sc.nextLine();
			if (ans == 'Yes' || ans =='yes') {
				human[1] = new Human();
			}
		}
	}
	// returns -1 if already exists
	private static int findIndex(String id){
		//diadiki anazitisi stin static list allHuman
			int left = 1;
			int right = allHuman.size();
			int middle;
			boolean flag= false;
		while(flag && left <= right) {
			middle = (left + right)/2;
			if (allHuman.get(middle).getId() == id) {
				return middle;
			} else if (allHuman.get(middle).getId() < id) {
				left = middle + 1;
			} else {
				right = middle -1;
			}
		}
		return -1;
	}
	// maybe change public access
	public int getId() {
			return id;
		}
	private static void apothikeysi
}
