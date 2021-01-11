package covid.app.main.app.boolship;

import CovidApp.Gui.BooleanShip.GuiClass;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

public final class Human {
    private static ArrayList<Human> allHuman = new ArrayList<Human>();
    private String name, surname, afm, gender, email;
    private ArrayList<Organisations> belongs = new ArrayList<Organisations>();
    private final int id; // for our personal counting and faster dialing of items in what condition can
    //the state of the object is found
    private Status status = Status.NORMAL;// initialization of all people in a normal state
    private static int count = 0;
    private static ArrayList<Human> waitTest = new ArrayList<Human>();
    private static SortByAfm sortItem =new SortByAfm();//do not need to understand it
    static Scanner sc = new Scanner(System.in);

    public Human(String name, String surname, String afm, String email, String gender, Organisations org)
            throws IllegalAccessException {
        count++;
        this.id = count;
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.email = email;
        if (!isValidAfm(afm))
            throw new IllegalAccessException("Your input<" + afm + ">not valid afm");
        this.afm = afm;// when we will ask the afm from the user the code will be:
        /*
         * String ssn = getSsnFromUser(); while(!YourClass.isValidSSN(ssn)) {
         * showErrorMessage("Not a valid ssn: " + ssn); ssn = getSsnFromUser(); }
         */
        belongs.add(org);
        allHuman.add(this);
        sort();
    }
    enum Status {
        NORMAL, SUSPECT, PRESUMPTIVE, CONFIRMED, QUARANTINE
    }


    //helps for sort
    private static class SortByAfm implements Comparator<Human> {
        public int compare(Human a, Human b) {
            return a.afm.compareTo(b.afm);
        }
    }
    //it sorts with unicode form, that means the number not gonna be
    //in arithmetic series, but id doesnt mind,search gonna work the same
    private static void sort() {//it is called in constructor
        allHuman.sort(sortItem);
    }

    private static boolean isValidAfm(String afm) {
        int len = afm.length();
        if (len != 9) {
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (afm.charAt(i) >= '0' && afm.charAt(i) <= '9') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Name %s Surname %s afm %s", name, surname, afm);
    }

    public String seeStatus() {
        return status.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAfm() {
        return afm;
    }

    public void changeStatus(String st) {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void beCase() {
        status = Status.CONFIRMED;
    }
    public static void printAllRecordedCases() {

    }
    public static void printAllRecordedContacts() {

    }

    //true is org member a human
    //modifying
    static Human checkIfCovid(String a, Organisations org) {
        if (isValidAfm(a)) {
            int z = search(a);
            if (z > -1) {
                for (Organisations c : allHuman.get(z).belongs) {
                    if (org == c) {
                        return allHuman.get(z);
                    }
                }
            }
        }
        return null;
    }
    protected void haveToBeTested() {
        status = Status.PRESUMPTIVE;
        waitTest.add(this);
    }
    protected void bePositive() {
        status = Status.CONFIRMED;
    }
    protected void removeFromOrg(Organisations org) {
        for (int i = 0; i < belongs.size(); i++) {
            if (belongs.get(i) == org) {
                belongs.remove(i);
                break;
            }
        }
    }

    protected static void quarantineMode(@NotNull Human human) {
        System.out.println(human.toString() + "has been found with covid");
        human.status = Status.CONFIRMED;
        while (true) {
            System.out.println("Give us the SSN of the people that will stay with him too, exit 0");
            System.out.println("If these person have not already be registered, they will have to do it now");
            String ssntemp = sc.nextLine();
            if (ssntemp.equals("0")) {
                break;
            }
            if (!isValidAfm(ssntemp)) {
                System.out.printf("This ssn:%s can not exist. Try again\n", ssntemp);
                continue;
            }
            int search = search(ssntemp);
            if (search == -1) {
                System.out.printf("This ssn: does not exist, going to register, 0 for wrong input", ssntemp);
                String num = sc.nextLine();
                if (num.equals("0")) {
                    continue;

                } else {
                    Human a = Human.createHuman(ssntemp);
                    a.status = Status.QUARANTINE;
                }
            } else {
                Human a = allHuman.get(search);
                //status and perhaps test
                for (Organisations c : a.belongs) {
                    //inform organisations where belongs
                }
            }
        }
    }
    public static void testResults() {
        for(;;) {
            System.out.println("Give AFM of the person that get tested, (-1 for break): ");
            String afmGiven = sc.nextLine();
            if (afmGiven.equals("-1")) {
                break;
            }
            if (!isValidAfm(afmGiven)) {
                System.out.printf("Does not exist this kind: %s afm", afmGiven);
                continue;
            }
            int position = search(afmGiven);
            Human theHuman;
            if (position == -1) {
                theHuman = createHuman(afmGiven);
            } else {
                theHuman = allHuman.get(position);
            }
            System.out.printf("Human registration %s with AFM: %s ;", theHuman.getName(), theHuman.getAfm());
            String confirmed = sc.nextLine();
            if (confirmed.equals("Yes") || confirmed.equals("yes") || confirmed.equals("y") || confirmed.equals("Y")) {
                for(;;) {
                    System.out.println("Give 0 for negative, 1 for positive for the result of the test: ");
                    int result = sc.nextInt();
                    if (result == 0) {
                        theHuman.status = Status.NORMAL;
                        if (waitTest.remove(theHuman)) {
                            System.out.printf("The %s had to be tested and the Test is negative", theHuman.toString());
                        }
                        break;
                    } else if (result == 1) {
                        theHuman.status = Status.CONFIRMED;
                        if (waitTest.remove(theHuman)) {
                            System.out.printf("The %s had to be tested and the Test is positive", theHuman.toString());
                        }
                        quarantineMode(theHuman);
                        for (var org : theHuman.belongs){
                            if (org == null) {
                                continue;
                            } else if (org instanceof Schools) {

                            } else if (org instanceof Universities) {

                            } else if (org instanceof Companies) {

                            } else if (org instanceof PublicServices) {

                            } else if (org instanceof NursingHomes) {

                            } else {
                                System.out.println("Does not exist in a organisation of our app");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Not valid option");
                    }
                }
            }
        }
    }
    // finds if the human exists in allHuman
    // if yes, returns its position, otherwise -1
    private static int search(String idGiven) {
        int low = 0;
        int high = allHuman.size();
        int mid;
        if (high == 0) {
            return -1;
        }
        while (low < high) {
            mid = (low + high) / 2;
            if (idGiven.compareTo(allHuman.get(mid).afm) < 0)  {
                high = mid -1;
            } else if (idGiven.compareTo(allHuman.get(mid).afm) > 0) {
                low = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    //create human that returns, if does not exist
    //argument class name and id class
    //if person exists return the person
    public static Human createHuman(Organisations org) {
        //called as Human.creteHuman(this);
        //RETURNS A HUMAN OR NULL FOR EXIT
        Human one = null;

        String ans_afm = (String) JOptionPane.showInputDialog("Please write the Employee's afm");

        GuiClass.isValidAfm(ans_afm);

        int pos = search(ans_afm);
        if (pos == -1) {
            String name, surname, gender, email;
            JPanel panel = new JPanel(new GridLayout(4, 1));

            JLabel lname = new JLabel("Name");
            lname.setFont(new Font("Arial", Font.BOLD, 18));
            JLabel lsurname = new JLabel("Surname");
            lsurname.setFont(new Font("Arial", Font.BOLD, 18));
            JLabel lgender = new JLabel("Gender");
            lgender.setFont(new Font("Arial", Font.BOLD, 18));
            JLabel lemail = new JLabel("Email");
            lemail.setFont(new Font("Arial", Font.BOLD, 18));

            JTextField tname = new JTextField();
            JTextField tsurname = new JTextField();
            JTextField tgender = new JTextField();
            JTextField temail = new JTextField();

            panel.add(lname);
            panel.add(tname);
            panel.add(lsurname);
            panel.add(tsurname);
            panel.add(lgender);
            panel.add(tgender);
            panel.add(lemail);
            panel.add(temail);
            JOptionPane.showMessageDialog(null, panel, "Employee additional info", JOptionPane.INFORMATION_MESSAGE);
            name = tname.getText();
            surname = tsurname.getText();
            gender = tgender.getText();
            email = temail.getText();
            GuiClass.isValidEmail(email);
            if (name == "" || surname == "" || gender == "" || email == "") {
                JOptionPane.showMessageDialog(null, "All sections should Contain something process failed.Please Try again", "Content Missing", JOptionPane.ERROR_MESSAGE);
            }


            try {
                one = new Human(name, surname, ans_afm, email, gender, org);
            } catch (IllegalAccessException e) {
                JOptionPane.showMessageDialog(null, "Something unexpected happened.Please Try again", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
            }

            return one;


        } else {
            System.out.println("The person was found at the base");
            System.out.printf("We continue the process with man:%s;\n 0 to exit: ", allHuman.get(pos).toString());
            int ans = sc.nextInt();
            if (ans != 0) {
                allHuman.get(pos).belongs.add(org);
                return allHuman.get(pos);
            } else {
                System.out.println("The process for that person has stopped, it starts again for the next introduction");
            }
         return null;
        }
    }

        //return null;

    private static Human createHuman(String ssn) {
        Human one = null;
        String name ,surname, gender, email;
        for(;;){
            System.out.println("Give the name: ");
            name = sc.nextLine();
            System.out.println("Give the surname: ");
            surname = sc.nextLine();
            System.out.println("Give the gender: ");
            gender = sc.nextLine();
            System.out.println("Give the email: ");
            email = sc.nextLine();
            System.out.printf("Are these the correct datas %s %s %s %s;,0 for no \n", name, surname, gender, email);
            String ans = sc.nextLine();
            if(!ans.equals("0")) {
                System.out.println("The process of creating man is repeated");
            } else {
                break;
            }
        }
        try {
            one = new Human(name, surname, ssn, email, gender, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("Something gone wrong, repeat this Progress please!");
        }
        return one;
    }
    public static void exampleCreateHuman() {
        int afm_int = 100000000;
        for (int i = 0; i < 50; i++) {
            try {
                Human one = new Human("name", "surname", String.valueOf(afm_int++), "email@.com", "gender", null);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
}

