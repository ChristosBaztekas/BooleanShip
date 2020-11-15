package gr.projAboutCovid.leo.proj;

import java.util.Scanner;
import java.util.ArrayList;

public class NursingHomes extends Organisations {
    private String status_descr;
    private ArrayList<Human> employs;
    private Arraylist<Human> carenPeople;
    static Scanner scanner = new Scanner(System.out);
    boolean status; //true means enclosed and false free access
    public NursingHomes(String name, String area, int numberOfPeople, boolean enclosed) {
        super(name, area, numberOfPeople);
        status = enclosed;
        status_descr = (enclosed ? "Enclosed" : "Free Access");
        fillingEmploys();
        fillingCarenPeople();//yet to do
    }
    private void fillingEmploys() {
        String ans;
        int num;
        if(employs != null) {
            System.out.printf("There are %d Employ(s), would you like to add new?/nPress yes or no", employs.size());
            ans = scanner.nextLine();
            if (ans == "yes") {
                System.out,println("How many? ");
                num = scanner.nextInt();
                for (int i=0 ; i < num ; i++) {
                    employs.add()
                }
            }
        }
    }
    private void monitoring() {
        
    }
    private void declareCase(){
        System.out.println("Is the case Employ(s), caren person(s) or both");
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
