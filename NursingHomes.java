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
		System.out.println("Enter:name");
		String name = scanner.nextLine();
		System.out.println("Enter:area");
		String area = scanner.nextLine();
		System.out.println("Enter: numberOfPeople");
		System.out.println("Enter Yes, No");
		String input = scanner.nextLine();
        if(input.equals('Yes')){
			boolean enclosed = false;
		}else {
			boolean enclosed = true;
		}




        //look caseManagmentAndHumanAddition
    }
    public static void declareCase(int number) {
        //look caseManagmentAndHumanAddition
    }
    public static void printDetails(int number) {
        //look caseManagmentAndHumanAddition

}
