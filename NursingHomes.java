package gr.projAboutCovid.leo.proj;
make
import java.util.Scanner;
import java.util.ArrayList;
//αν μπορούμε να γράφουμε σχόλια για είναι ο κώδικας ποιό ευανάγνωστος
//έχω διορθώσει κάποια συντακτικά λάθη κυρίως 
//προτίνω να ελένχουμε τον κώδικα με κάποιο IDE ή τουλάχιστον TextPad
public class NursingHomes extends Organisations {
    private String status_descr;
    private ArrayList<Human> employees;
    private Arraylist<Human> carenPeople;
    static Scanner scanner = new Scanner(System.out);
    boolean status; //true means enclosed and false free access
    public NursingHomes(String name, String area, int numberOfPeople, boolean enclosed) {
        super(name, area, numberOfPeople);
        status = enclosed;
        status_descr = (enclosed ? "Enclosed" : "Free Access");
        fillingEmployees();
        fillingCarenPeople();//yet to do
    }
    private void fillingEmployees() {
        String ans;
        int num;
        if(employees != null) {
            System.out.printf("There are %d Employee(s), would you like to add new?/nPress yes or no", employees.size());
            ans = scanner.nextLine();
            if (ans == "yes") {
                System.out.println("How many? ");
                num = scanner.nextInt();
                for (int i=0 ; i < num ; i++) {
                    employees.add();
                }
            }
        }
    }
    private void monitoring() {
        
    }
    private void declareCase(){
        System.out.println("Is the case Employee(s), caren person(s) or both");
        System.out.println("Enter       E,          C,                B")
        String input = scanner.nextLine();
        if(input = 'E'){

        } else if (input = 'C'){

        } else if (input = "B"){

        } else {

        }
    }
    @Override
    private void insertHumanToOrganisation(Human human) {
        //
    }
}
