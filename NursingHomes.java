package gr.projAboutCovid.leo.proj;

import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.util.ArrayList;
//αν μπορούμε να γράφουμε σχόλια για είναι ο κώδικας ποιό ευανάγνωστος
//έχω διορθώσει κάποια συντακτικά λάθη κυρίως 
//προτίνω να ελένχουμε τον κώδικα με κάποιο IDE ή τουλάχιστον TextPad
public class NursingHomes extends Organisations {//απλά έκανα implement τις abstract γιατί αλλιώς δίνει error
    private String status_descr;
    private ArrayList<Human> employees;
    private ArrayList<Human> carenPeople;//υπήρχε συνταχτικό λάθος
   static Scanner scanner = new Scanner(System.in);//System.out??
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
            if (ans.equals("yes")) {//στην java για να χειρίζεσαι Strings δεν λειτουργεί το == αλλά το equals 
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
        System.out.println("Enter       E,          C,                B");//έλλειπε απλά το ερωτηματικό
        String input = scanner.nextLine();
        if(input.equals('E')){

        } else if (input.equals('C')){

        } else if (input.equals('B')){

        } else {

        }
    }
    @Override
    private void insertHumanToOrganisation(Human human) {
        //
    }
	@Override
	public void insertHumanToOrganisation(Human human) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void managementCases(Human anyH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void declareCase() {
		// TODO Auto-generated method stub
		
	}
}
