package gr.projAboutCovid.leo.proj;

import java.util.Scanner;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import java.util.ArrayList;

public class NursingHomes extends Organisations implements caseManagmentAndHumanAddition{
    private String status_descr;
    private ArrayList<Human> employees = new ArrayList<Human>();
    private ArrayList<Human> carenPeople = new ArrayList<Human>();
    static Scanner scanner = new Scanner(System.in);
    private boolean en_status; //true means enclosed and false free access
    private final int id;
    private static ArrayList<NursingHomes> allNursingHomes = new ArrayList<NursingHomes>();
    private static int count = 0;
    public NursingHomes(String name, String area, int numberOfPeople, boolean enclosed) {
        super(name, area, numberOfPeople);
        en_status = enclosed;
        status_descr = (enclosed ? "Enclosed" : "Free Access");
        id = count ++;
        modifyEmployees();
        fillingCarenPeople();//yet to do
    }
    private void modifyEmployees() {
        while (true){
            if(employees != null) {
                System.out.printf("There are %d Employee(s), would you like to add new?\nPress 1 for yes,otherwise we will go to remove panel", employees.size());
                int ans = scanner.nextInt();
                if (ans == 1) {
                    System.out.println("How many? ");
                    int num = scanner.nextInt();
                    for (int i=0 ; i < num ; i++) {
                        System.out.printf("Adding the %d employ", i+1);
                        Human one = createHuman(this.getClass().getName(), this.id);
                        if(one == null){
                            System.out.printlf("Δεν προσθέθηκε ο %d υπάλληλος", i+1);
                            i -=1;//να επαναληφθεί η διαδικασία
                            continue;
                        }
                        employees.add(one);
                    }
                    break;
                }
                System.out.printf("There are %d Employee(s), would you like to remove one?\nPress 1 for yes", employees.size());
                int ans = scanner.nextInt();
                if (ans == 1) {
                    while (true){
                        System.out.println("Give the afm of the employee that want to remove");
                        String afm = scanner.nextLine();
                        boolean flag;
                        for (int i=0; i<employees.size(); i++) {
                            //search
                            //an to vrei prepei na paei stin human na svisei to belongsOrganisation
                            flag = false;
                            break;
                        }
                        if (flag) {
                            System.out.printf("Δεν βρεθηκε υπαλληλος με αφμ:%s", afm);
                        }
                        System.out.println("Να συνεχιστεί η διαδικασία διαγγραφής; 0 για εξοδο");
                        int ans1 = scanner.nextInt();
                        if (ans1 == 0) {
                            break;
                        }
                    }
                    break;
                }
            } else {
                System.out.println("There are no employes filled, Please start with giving them");
                System.out.println("Ποσοι δουλεύουνε;");
                int num = scanner.nextInt();
                for (int i=0 ; i < num ; i++) {
                    System.out.printf("Creating the %d employ", i+1);
                    Human one = createHuman(this.getClass().getName(), this.id);
                    if(one == null){
                        System.out.printlf("Δεν προσθέθηκε ο %d υπάλληλος", i+1);
                        i -=1;//να επαναληφθεί η διαδικασία
                        continue;
                    }
                    employees.add(one);
                }
                break;
            }
        }
    }
    public void monitoring(int orgNum) {

    }
    public void declareCase(){
        System.out.println("Is the case Employee(s), caren person(s) or both");
        System.out.println("Enter       E,          C,                B");
        String input = scanner.nextLine();
        if(input.equals('E')){

        } else if (input.equals('C')){

        } else if (input.equals('B')){

        } else {

        }
    }
    private void fillingCarenPeople() {

    }

    public void managementCases() {
        //look caseManagmentAndHumanAddition
    }
    public static void createOrg() {
		System.out.println("What is the name of the NursingHome?/nWrite the name without spaces!");
		String name = sc.next();
		System.out.println("In which area is your organization located?/nWrite the are without spaces!");
		String area = sc.next();
		System.out.println("How many employees does your organization have?");
		scanner.nextLine();
		int numberOfEmployees = scanner.nextInt();
		System.out.println("How many carenPeople does your organization have?");
		int numberofCarenPeople = scanner.nextInt();
		System.out.println("Is your organization open? 1for yes");
		String input = sc.next();
        if(input.equals("1")){
			boolean enclosed = false;
		}else {
			boolean enclosed = true;
		}
		System.out.printf("Name NursingHome: %s, Area: %s, Total People(Employees plus CarenPeople): %d.Is that correct? 1for yes",name,area,employess+carenpeople);
		if (scanner.nextLine().equals("1")) {
			break;
		}
		NursingHomes newOne = new NursingHomes(String name, String area, int numberOfPeople, boolean enclosed);
	     //look caseManagmentAndHumanAddition
	 }

    public static void declareCase(int number) {
        //look caseManagmentAndHumanAddition
    }
    public static void printDetails(int number) {
		System.out.println("Welcome.The" + allNursingHomes.get(code).super.getName + "NursingHome of" + allNursingHomes.get(code).super.getArea + "will take drastic measures to stop spread of covid-19 in our NursingHome.Please stay safe and we will call you soon.Always our first priority was the safety of our beloved people!Thanks for understanding in these difficult times.");
      //look caseManagmentAndHumanAddition
}
