import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.prism.Image;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Label;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static final String EodyPassword = "78892GG";// the password of National organization of Public Health
    static int chance = 0;

    private static void displayGMenu() {
        int choice;
        for (; ; ) {
            System.out.println("User Surveillance Menu." + "\n Press 1 to see all registered organizations."
                    + "\n Press 2 to see the latest statistics on the pandemic."
                    + "\n Press 3 to see all recorded case." + "\n Press 4 to see all Contacts of Cases"
                    + "\n Press 5 to give testResults" + "\n Press 6 to see cases by regions."
                    + "\n Press 7 to send an email to all registered Organisations" + "\n Press 8 to exit");

            while (true) {
                if (!sc.hasNextInt()) {
                    String input = sc.nextLine();
                    System.out.println(
                            " Your import(" + input + ")it's not number.Please choose a number between 1 and 8.\n");
                    continue;
                } else {
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice > 8 || choice < 1) {
                        System.out.println("Wrong number!Place a number between 1 and 8");
                        continue;
                    }
                    break;
                }
            }
            switch (choice) {
                case 1:
                    Organisations.printAllOrganisations(EodyPassword);
                    break;
                case 2:
                    break;
                case 3:
                    Human.printAllRecordedCases(EodyPassword);
                    // i dont know if its posible now,we have to keep every case to a static member
                    // for (int i = 0; i < callMethods.contactsNames.size(); i++) {
                    // System.out.println(callMethods.contactsNames.toString());
                    // }
                case 4:// when we import the api we will add the option
                    Human.printAllRecordedContacts(EodyPassword);
                    break;
                case 5:
                    Human.testResults(EodyPassword);//we believe only Eody gives results
                    break;
                case 6:
                    break;
                case 7:
                    //send an email
                case 8:
                    System.out.println("You chose exit.Stay safe.");
                    System.exit(0);
            }

        }

    }

    public static void gMenu() {
        System.out.println(
                "You have chosen the menu of the user responsible for surveillance.\n To proceed, enter a code. "
                        + "\n To exit or in case of incorrect selection press any other key.  ");
        try {
            String UsersPassword = sc.next();
            sc.nextLine();
            if (UsersPassword.equals(EodyPassword)) {
                System.out.println("Correct code.Below are the options of the user responsible for surveillance:");
                displayGMenu();

            } else {
                try {
                    if (chance == 0) {
                        chance = 1;
                        System.out.println(
                                "You are denied access. In case of error insert try again otherwise any other key to exit.");
                        String secondC = sc.next();
                        if (secondC.equals(EodyPassword)) {
                            sc.nextLine();
                            displayGMenu();
                        } else {
                            System.out.println(
                                    "The program will be terminated if you do not have the appropriate documents.Thank you.");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("You dont hava access priviledges for this menu.Stay safe.");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.err.println("There's an unexpected mistake.End of program.");
                }

            }
        } catch (Exception e) {
            System.err.println("There's an unexpected mistake.End of program.");
        }

    }

    public static void nMenu() throws URISyntaxException, IOException {
        int answer;
        while (true) {
            System.out.println("Welcome to the Nursing Homes user menu.");
            System.out.println(" Type 1:if you are a new user." + "\n Type 2:if you are already registered. "
                    + "\n Type 3:if you want to exit.");
            while (true) {
                if (!sc.hasNextInt()) {
                    String input = sc.nextLine();
                    System.out.println(
                            " Your import(" + input + ")it's not number.Please choose a number between 1 and 3.\n");
                    continue;
                } else {
                    answer = sc.nextInt();
                    sc.nextLine();
                    if (answer > 3 || answer < 1) {
                        System.out.println("Wrong number!Place a number between 1 and 5");
                        continue;
                    }
                    break;
                }
            }
            switch (answer) {
                case 1:
                    NursingHomes.createOrg();
                    System.out.println("The Nursing Home has been created, now enter as registered");
                    System.out.println("Would you like to connect?, enter 1 for yes");
                    String ans = sc.nextLine();
                    if (ans.equals("1")) {
                        System.out.println("Going to registered menu...");
                    } else {
                        break;
                    }
                case 2:
                    System.out.println("Please enter your username in order to find your account.");
                    //register proccess out =...
                    int out = 0;
                    if (out == -1) {
                        System.exit(0);
                    } else {
                        displayNMenu(out);
                    }
                    //must be created a method checking if the inputed name already exists
                    //and give access as a specific user and can in case to give a positice test
                    break;
                case 3:
                    System.out.println(
                            "You chose Exit!Here is a link for more info about covid.Stay safe and keep your people safe.");
                    Desktop d = Desktop.getDesktop();
                    d.browse(new URI(
                            "https://eody.gov.gr/wp-content/uploads/2020/09/%CE%91%CE%9D%CE%A4%CE%99%CE%9C%CE%95%CE%A4%CE%A9%CE%A0%CE%99%CE%A3%CE%97-COVID-%CE%A3%CE%A4%CE%9F-%CE%A3%CE%A7%CE%9F%CE%9B%CE%95%CE%99%CE%9F-%CE%A0%CE%A1%CE%A9%CE%A4%CE%9F%CE%9A%CE%9F%CE%9B%CE%9B%CE%9F-%CE%91%CE%9D%CE%91%CE%A3%CE%A4%CE%9F%CE%9B%CE%97%CE%A3-%CE%9B%CE%95%CE%99%CE%A4%CE%9F%CE%A5%CE%A1%CE%93%CE%99%CE%91%CE%A3-%CE%A3%CE%A7%CE%9F%CE%9B%CE%95%CE%99%CE%A9%CE%9D_18-09-20.pdf"));
                    System.exit(0);
            }
        }
    }

    public static void sMenu() throws URISyntaxException, IOException {
        int answer;
        while (true) {
            System.out.println("Welcome to the school user menu.");
            System.out.println("Type 1:if you are a new user." + "\n Type 2:if you are already registered. "
                    + "\n Type 3:if you want to exit.");
            while (true) {
                if (!sc.hasNextInt()) {
                    String input = sc.nextLine();
                    System.out.println(
                            " Your import(" + input + ")it's not number.Please choose a number between 1 and 3.\n");
                    continue;
                } else {
                    answer = sc.nextInt();
                    sc.nextLine();
                    if (answer > 3 || answer < 1) {
                        System.out.println("Wrong number!Place a number between 1 and 3");
                        continue;
                    }
                    break;
                }
            }
            switch (answer) {
                case 1:
                    Schools.createOrg();
                    System.out.println("The school have been created, now enter as refistered");
                    System.out.println("Would you like to connect?, enter 1 for yes");
                    String ans = sc.nextLine();
                    if (ans.equals("1")) {
                        System.out.println("Going to registered menu...");
                    } else {
                        break;
                    }
                case 2:
                    System.out.println("Please enter your username in order to find your account.");
                    //register progress out=...
                    int out = -1;
                    if (out == -1) {
                        System.exit(0);
                    } else {
                        displaySMenu(out);
                    }
                    break;
                case 3:
                    System.out.println(
                            "You chose Exit!Here is a link for more info about covid.Stay safe and keep your people safe.");
                    Desktop d = Desktop.getDesktop();
                    d.browse(new URI(
                            "https://eody.gov.gr/wp-content/uploads/2020/09/%CE%91%CE%9D%CE%A4%CE%99%CE%9C%CE%95%CE%A4%CE%A9%CE%A0%CE%99%CE%A3%CE%97-COVID-%CE%A3%CE%A4%CE%9F-%CE%A3%CE%A7%CE%9F%CE%9B%CE%95%CE%99%CE%9F-%CE%A0%CE%A1%CE%A9%CE%A4%CE%9F%CE%9A%CE%9F%CE%9B%CE%9B%CE%9F-%CE%91%CE%9D%CE%91%CE%A3%CE%A4%CE%9F%CE%9B%CE%97%CE%A3-%CE%9B%CE%95%CE%99%CE%A4%CE%9F%CE%A5%CE%A1%CE%93%CE%99%CE%91%CE%A3-%CE%A3%CE%A7%CE%9F%CE%9B%CE%95%CE%99%CE%A9%CE%9D_18-09-20.pdf"));
                    System.exit(0);
            }
        }
    }

    public static void uMenu() throws URISyntaxException, IOException {
        int answer;
        while (true) {
            System.out.println("Welcome to the university user menu.");
            System.out.println("Type 1:if you are a new user." + "\n Type 2:if you are already registered. "
                    + "\n Type 3:if you want to exit.");
            while (true) {
                if (!sc.hasNextInt()) {
                    String input = sc.nextLine();
                    System.out.printf("Your input %s is not a number 1-3, please try again", input);
                    continue;
                } else {
                    answer = sc.nextInt();
                    sc.nextLine();
                    if (answer > 3 || answer < 1) {
                        System.out.println("Wrong number!Place a number between 1 and 3");
                        continue;
                    }
                    break;
                }
            }
            switch (answer) {
                case 1:
                    Universities.createOrg();// should be implement the createOrg in order to create the uni
                    System.out.println("The university have been created, now enter as refistered");
                    System.out.println("Would you like to connect?, enter 1 for yes");
                    String ans = sc.nextLine();
                    if (ans.equals("1")) {
                        System.out.println("Going to registered menu...");
                    } else {
                        break;
                    }
                case 2:
                    System.out.println("Please enter your username in order to find your account.");
                    //must be created a method checking if the inputed name already exists
                    //and give access as a specific user and can in case to give a positice test
                    //register progress, out=...
                    int output = 0;
                    if (output == -1) {
                        System.exit(0);
                    } else {
                        displayUMenu(output);
                    }
                    break;
                case 3:
                    System.out.println(
                            "You chose Exit!Here is a link for more info about covid.Stay safe and keep your people safe.");
                    Desktop d = Desktop.getDesktop();
                    d.browse(new URI("https://eody.gov.gr/neos-koronaios-covid-19/"));
                    System.exit(0);
            }
        }

    }

    private static void displaylMenu(int code, int idefier) {
        while (true) {
            int input;
            while (true) {
                if (idefier == 1) {
                    PublicServices.printDetails(code);
                } else {
                    Companies.printDetails(code);
                }
                System.out.println("\n Press 1: To modify Departments" +
                        "\n Press 2: To Declare a Case of Covid-19" + "\n Press 3: To see the Status of your Labor" +
                        "\n Press 4: To exit");
                if (!sc.hasNextInt()) {
                    String input1 = sc.nextLine();
                    System.out.println(
                            " Your import(" + input1 + ")it's not number.Please choose a number between 1 and 4.\n");
                    continue;
                } else {
                    input = sc.nextInt();
                    sc.nextLine();
                    if (input > 4 || input < 1) {
                        System.out.println("Wrong number!Place a number between 1 and 4");
                        continue;
                    }
                    break;
                }
            }
            switch (input) {
                case 1:
                    if (idefier == 1) {
                        PublicServices.modifyDepartments(code);
                    } else {
                        Companies.modifyDepartments(code);
                    }
                    break;
                case 2:
                    if (idefier == 1) {
                        PublicServices.declareCase(code);
                    } else {
                        Companies.declareCase(code);
                    }
                    break;
                case 3:
                    if (idefier == 1) {
                        PublicServices.seeStatus(code);
                    } else {
                        Companies.seeStatus(code);
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    public static void lMenu() {
        System.out.println("Welcome to the Labor user menu.");
        System.out.println("Type 1:if you want the public services menu.");
        System.out.println("Type 2:if you want the companies menu.");
        System.out.println("Type anything else:if you want to exit.");
        String answer = sc.next();
        if (Integer.valueOf(answer) == 1) {
            System.out.println("Welcome to the Public services menu.");
            System.out.println("Type 1:if you already have an account.");
            System.out.println("Type 2:if you want to register.");
            System.out.println("Type anything else:if you want to exit.");
            String option = sc.next();
            if (option.equals("1")) {
                //sign up int code = ...
                int code = 0;
                displaylMenu(code, 0);

            } else if (option.equals("2")) {
                System.out.println(
                        "After creating your org you will be redirected to the initial menu.Then you can insert pressing 1.");
                PublicServices.createOrg();// must implement the interface in order to create the new user
                lMenu();
            } else {
                System.out.printf("You chose exit(input= %s ).Stay safe!", answer);
                System.exit(0);
            }
        } else if (Integer.valueOf(answer) == 2) {
            System.out.println("Welcome to the companies services menu.");
            System.out.println("Type 1:if you already have an account.");
            System.out.println("Type 2:if you want to register.");
            System.out.println("Type anything else:if you want to exit.");
            String option = sc.next();
            if (option.equals("1")) {
                //sign up int code =
                int code = 0;
                displaylMenu(code, 1);

            } else if (option.equals("2")) {
                System.out.println(
                        "After creating your org you will be redirected to the initial menu.Then you can insert pressing 1.");
                Companies.createOrg();// obviously the same as above
                lMenu();
            } else {
                System.out.println("You chose exit.Stay safe!");
                System.exit(0);
            }

        } else {
            System.out.println("You chose exit.Stay safe!");
            System.exit(0);
        }
        System.exit(0);


    }

    public static void eMenu() throws URISyntaxException, Exception {
        System.out.println("You chose exit.Thank you.Stay safe!");
        System.out.println("Below is the information website.");
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://eody.gov.gr/neos-koronaios-covid-19/"));// here will lead the user to
        // an informational website but
        // the com[iler does not cooperate
        // today
        // so I can't confirm
        // that there is no logical error
        // that will prevent the user from
        // getting here.
        System.exit(0);
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        GuiClass wsFrame = new GuiClass();
        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wsFrame.setBounds(500, 200, 700, 700);
        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
        
        System.out.println("Welcome to the app of case detection and contact detection!"
                + "\nThe application is designed to make it easier for all organisations to manage the pandemic."
                + "\nData access and analysis will only be for the provision of statistical "
                + "data and for the purpose of limiting the spread of.");

        for (; ; ) {
            System.out.println("To get to the menu that's right for you, type in what kind of user you are:"
                    + "\n-Type 1 or G if you are the user responsible for surveillance. "// think about not even tell
                    // them the option
                    + "\n-Type 2 or L if you are corporate user (e.g. business or public organisation). "
                    + "\n-Type 3 or S if you belong to educational institution. "
                    + "\n-Type 4 or U if you belong to university. " + "\n-Type 5 or N if you belong to nursing home. "
                    + "\n-Type 6 or E if you wish exit. ");

            String usersInput = null;

            try {
                usersInput = sc.next();
                while (!usersInput.equals("1") && !usersInput.equals("2") && !usersInput.equals("3")
                        && !usersInput.equals("4") && !usersInput.equals("5") && !usersInput.equals("6")
                        && !usersInput.equals("G") && !usersInput.equals("L") && !usersInput.equals("S")
                        && !usersInput.equals("U") && !usersInput.equals("N") && !usersInput.equals("E")) {

                    System.out.println("Your input (" + usersInput + ") is invalid.Please try again.");
                    sc.nextLine();
                    usersInput = sc.next();
                }

            } catch (Exception e) {
                System.out.println("Your import was invalid.Try again:");
                break;
            } finally {
                sc.nextLine();
            }
            try {
                switch (usersInput) {
                    case "1":
                    case "G":
                        gMenu();
                        break;
                    case "2":
                    case "L":
                        lMenu();
                        break;
                    case "3":
                    case "S":
                        sMenu();
                        break;
                    case "4":
                    case "U":
                        uMenu();
                        break;
                    case "5":
                    case "N":
                        nMenu();
                        break;
                    case "6":
                    case "E":
                    default:
                        eMenu();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void displayUMenu(int code) {
        while (true) {
            int input;
            while (true) {
                Universities.printDetails(code);// shows details for this uni
                // choices of a chancellor
                System.out.println("\n Press 1: To modify departments" + "\n Press 2: To modify teachers" +
                        "\n Press 3: To Declare a Case of Covid-19" + "\n Press 4: To see the status of your University"
                        + "\n Press 5: To modify the other ralated working people" + "\n Press 6: To exit");
                if (!sc.hasNextInt()) {
                    String input1 = sc.nextLine();
                    System.out.println(
                            " Your import(" + input1 + ")it's not number.Please choose a number between 1 and 6.\n");
                    continue;
                } else {
                    input = sc.nextInt();
                    sc.nextLine();
                    if (input > 6 || input < 1) {
                        System.out.println("Wrong number!Place a number between 1 and 6");
                        continue;
                    }
                    break;
                }
            }
            switch (input) {
                case 1:
                    Universities.modifyDepartments(code);
                    break;
                case 2:
                    Universities.modifyTeachers(code);
                    break;
                case 3:
                    Universities.declareCase(code);
                    break;
                case 4:
                    Universities.seeStatus(code);
                    break;
                case 5:
                    Universities.modifyOthers(code);
                case 6:
                    System.exit(0);
            }
        }
    }

    private static void displaySMenu(int code) {
        while (true) {
            int input;
            while (true) {
                Schools.printDetails(code);// shows details for this school
                // choices of a school minister
                System.out.println("\n Press 1: To modify students and classes" + "\n Press 2: To modify teachers" +
                        "\n Press 3: To Declare a Case of Covid-19" + "\n Press 4: To see the status of your School"
                        + "\n Press 5: To modify the other ralated working people" + "\n Press 5: To exit");
                if (!sc.hasNextInt()) {
                    String input1 = sc.nextLine();
                    System.out.println(
                            " Your import(" + input1 + ")it's not number.Please choose a number between 1 and 6.\n");
                    continue;
                } else {
                    input = sc.nextInt();
                    sc.nextLine();
                    if (input > 6 || input < 1) {
                        System.out.println("Wrong number!Place a number between 1 and 6");
                        continue;
                    }
                    break;
                }
            }
            switch (input) {
                case 1:
                    Schools.modifyDepartments(code);
                    break;
                case 2:
                    Schools.modifyTeachers(code);
                    break;
                case 3:
                    Schools.declareCase(code);
                    break;
                case 4:
                    Schools.seeStatus(code);
                    break;
                case 5:
                    Schools.modifyOthers(code);
                case 6:
                    System.exit(0);
            }

        }
    }

    private static void displayNMenu(int code) {
        while (true) {
            int input;
            while (true) {
                NursingHomes.printDetails(code);
                System.out.println("\n Press 1: To modify employees" + "\n Press 2: To modify guesters people" +
                        "\n Press 3: To Declare a Case of Covid-19" + "\n Press 4: To see the status of your Nursing Home"
                        + "\n Press 5: To exit");
                if (!sc.hasNextInt()) {
                    String input1 = sc.nextLine();
                    System.out.println(
                            " Your import(" + input1 + ")it's not number.Please choose a number between 1 and 4.\n");
                    continue;
                } else {
                    input = sc.nextInt();
                    sc.nextLine();
                    if (input > 4 || input < 1) {
                        System.out.println("Wrong number!Place a number between 1 and 4");
                        continue;
                    }
                    break;
                }
            }
            switch (input) {
                case 1:
                    NursingHomes.modifyEmployees(code);
                    break;
                case 2:
                    NursingHomes.modifyCarenPeople(code);
                    break;
                case 3:
                    NursingHomes.declareCase(code);
                    break;
                case 4:
                    NursingHomes.seeStatus(code);
                case 5:
                    System.exit(0);
            }
        }
    }
}
