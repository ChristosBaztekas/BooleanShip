package gr.projAboutCovid.leo.proj;

import java.util.Scanner;
import java.util.ArrayList;

public class NursingHomes extends Organisations {
    String status_descr;
    ArrayList<Human> employs;
    Arraylist<Human> carenPeople;
    boolean status; //true means enclosed and false free access
    public NursingHomes(String name, String area, int numberOfPeople, boolean enclosed) {
        super(name, area, numberOfPeople);
        status = enclosed;
        status_descr = (enclosed ? "Enclosed" : "Free Access");
        fillingEmploys();
        fillingCarenPeople();//yet to do
    }
    private void fillingEmploys() {
        Scanner scanner = new Scanner(System.in);
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
    @Override
    private void insertHumanToOrganisation(Human human) {
        //
    }
}
