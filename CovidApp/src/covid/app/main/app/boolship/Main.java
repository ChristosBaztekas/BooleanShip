package covid.app.main.app.boolship;


import CovidApp.Gui.BooleanShip.GuiClass;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
/*public class Main {
    public static void main(String[] args) throws MessagingException {
        GuiClass wsFrame = new GuiClass();
        wsFrame.setBounds(400, 100, 900, 700);
        wsFrame.setVisible(true);
        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}*/
//import javax.swing.*;


public class Main {
    static Scanner sc = new Scanner(System.in);
    private static final String EodyPassword = "78892GG";// the password of National organization of Public Health
    static int chance = 0;
	public static String[] a;// we need this for the piechart
    public static void main(String[] args) throws Exception {
    	a = args;// we need this for the piechart
    		// database connection
        String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" +
                "databaseName=DB38;user=G538;password=48534trh045;";
    		Connection connection;
    		try {
    			connection = DriverManager.getConnection(url);
    		}
    		catch(SQLException e) {
    			System.out.println(e.getMessage());
    		}

        /*AutomaticMail test = new AutomaticMail();
        test.sendMail("christosBaztekas@gmail.com");//will send automatic mail to any gmail or hotmail.com
         */
        NursingHomes.createNH();
        Universities.createU();
        Schools.createS();

        PublicServices.createP();
        Organisations.print();
        Human.exampleCreateHuman();
        //Organisations.example();
        GuiClass wsFrame = new GuiClass();
        wsFrame.setBounds(400, 100, 900, 700);
        wsFrame.setVisible(true);
        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("Welcome to the app of case detection and contact detection!"
                + "\nThe application is designed to make it easier for all organisations to manage the pandemic."
                + "\nData access and analysis will only be for the provision of statistical "
                + "data and for the purpose of limiting the spread of.");
        for (; ; ) {
            System.out.println("To get to the menu that's right for you, type in what kind of user you are:"
                    + "\n-Type 1 or G if you are the user responsible for surveillance. "// think about not even tell
                    // them the option
                    + "\n-Type 2 or L if you are corporate user (e.g. business or public organisation) and want to create org. "
                    + "\n-Type 3 or S if you belong to educational institution and want to create org. "
                    + "\n-Type 4 or U if you belong to university and want to create org. " + "\n-Type 5 or N if you belong to nursing home and want to create org. "
                    + "\n-Type 6 or SU if you wish to sign up." + "\n-Type 7 or E if you wish exit.");
            String usersInput = null;
            try {
                usersInput = sc.next();
                while (!usersInput.equals("1") && !usersInput.equals("2") && !usersInput.equals("3")
                        && !usersInput.equals("4") && !usersInput.equals("5") && !usersInput.equals("7")
                        && !usersInput.equals("G") && !usersInput.equals("L") && !usersInput.equals("S")
                        && !usersInput.equals("U") && !usersInput.equals("N") && !usersInput.equals("E")
                        && !usersInput.equals("6") && !usersInput.equals("SU")) {
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
                        System.out.println("1 for Public services creation, otherwise company creation");
                        String out = sc.nextLine();
                        if (out.equals("1")) {
                            PublicServices.createOrg();
                        } else {
                            Companies.createOrg();
                        }
                        break;
                    case "3":
                    case "S":
                        Schools.createOrg();
                        break;
                    case "4":
                    case "U":
                        Universities.createOrg();
                        break;
                    case "5":
                    case "N":
                        NursingHomes.createOrg();
                        break;
                    case "6":
                    case "SU":
                        signUp();
                        break;
                    case "7":
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
                    Organisations.printAllOrganisations();
                    break;
                case 2:
                    break;
                case 3:
                    Human.printAllRecordedCases();
                    break;
                // i dont know if its posible now,we have to keep every case to a static member
                // for (int i = 0; i < callMethods.contactsNames.size(); i++) {
                // System.out.println(callMethods.contactsNames.toString());
                // }
                case 4:// when we import the api we will add the option
                    Human.printAllRecordedContacts();
                    break;
                case 5:
                    Human.testResults();//we believe only Eody gives results
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
    public static void nMenu() throws URISyntaxException, IOException { //to be deleted
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
                    signUp();
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
                    signUp();
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
            //option to be deleted
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
                    signUp();
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
    private static void displaylMenu(Labors labor) {
        while (true) {
            int input;
            while (true) {
                labor.printDetails();
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
                    labor.modifyDepartments();
                    break;
                case 2:
                    labor.declareCase();
                    break;
                case 3:
                    labor.seeStatus();
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
                signUp();
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
                signUp();
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
        d.browse(new URI("https://eody.gov.gr/neos-koronaios-covid-19/"));
        System.exit(0);
    }
    private static void displayUMenu(Universities u) {
        while (true) {
            int input;
            while (true) {
                u.printDetails();// shows details for this uni
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
                    u.modifyDepartments();
                    break;
                case 2:
                    u.modifyTeachers();
                    break;
                case 3:
                    u.declareCase();
                    break;
                case 4:
                    u.seeStatus();
                    break;
                case 5:
                    u.modifyOthers();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
    private static void displaySMenu(Schools school) {
        while (true) {
            int input;
            while (true) {
                school.printDetails();// shows details for this school
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
                    school.modifyDepartments();
                    break;
                case 2:
                    school.modifyTeachers();
                    break;
                case 3:
                    school.declareCase();
                    break;
                case 4:
                    school.seeStatus();
                    break;
                case 5:
                    school.modifyOthers();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
    private static void displayNMenu(NursingHomes nh) {
        while (true) {
            int input;
            while (true) {
                nh.printDetails();
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
                    nh.modifyEmployees();
                    break;
                case 2:
                    nh.modifyCarenPeople();
                    break;
                case 3:
                    nh.declareCase();
                    break;
                case 4:
                    nh.seeStatus();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
    private static void signUp() {
        Organisations org = Organisations.giveAccess();
        if (org instanceof Schools) {
            Schools school = (Schools) org;
            displaySMenu(school);
        } else if (org instanceof Universities) {
            Universities u = (Universities) org;
            displayUMenu(u);
        } else if (org instanceof NursingHomes) {
            NursingHomes nh = (NursingHomes) org;
            displayNMenu(nh);
        } else if (org instanceof Companies) {
            Labors l = (Labors) org;
            displaylMenu(l);
        } else if (org instanceof PublicServices) {
            Labors l = (Labors) org;
            displaylMenu(l);
        } else {
            System.out.println("Not Organisation of our app");
        }
    }
}
