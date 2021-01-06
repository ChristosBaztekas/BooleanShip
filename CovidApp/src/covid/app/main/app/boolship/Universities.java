package covid.app.main.app.boolship;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Universities extends Organisations implements caseManagmentAndHumanAddition{
    private final ArrayList<Classes> department = new ArrayList<Classes>();
    private final ArrayList<Classes> secretariat = new ArrayList<Classes>();
    private final ArrayList<Human> teachers = new ArrayList<Human>();
    private final ArrayList<Human> others = new ArrayList<Human>();
    private boolean status = false;//eody have smth changed
    private ArrayList<Human> changes = new ArrayList<Human>();
    private static final Scanner scanner = new Scanner(System.in);
    private int number_others_positive = 0;
    private int number_teachers_positive = 0;
    private boolean lockdown = false;
    private ArrayList<Integer> number_department_positive = new ArrayList<Integer>();
    private ArrayList<Boolean> lockdown_department = new ArrayList<Boolean>();
    private ArrayList<Integer> number_secreterariat_positive = new ArrayList<Integer>();
    private ArrayList<Boolean> lockdown_secretariat = new ArrayList<Boolean>();
    private static final int limit_per_department = 2;
    private static final int limit_per_secretariat = 0;
    private static final int total_limit = 15;
    private static final int limit_others = 3;
    private static final int limit_per_teachers = 3;
    private static final int limit_decision = 1;
    private int id ;
    private static int count = 0;
    public Universities(String name, String area, int numbersOfPeople) {
        super(name, area, numbersOfPeople);
        add(this);
        modifyTeachers();
        modifySecretariat();
        modifyOthers();
        modifyDepartments();
        id = count++;
        setSize();
    }
    public static void createU() {
        for (int i = 0; i < 10; i++) { //create 10
            String user_pass = "U" + String.valueOf(i);
            Universities n = new Universities(i, user_pass);
        }
    }
    public Universities(int i, String a) {
        super("name", "area", 20, a, a);
        id = count ++;
        add(this);
    }
    protected void setSize() {
        int count = 0;
        for (int i = 0; i < department.size(); i++) {
            count += department.get(i).size();
        }
        for (int i = 0; i < secretariat.size(); i++) {
            count += secretariat.get(i).size();
        }
        count += teachers.size();
        count += others.size();
        setNumbersOfPeople(count);
    }
    public void printDetails() {
        System.out.println("Welcome.The" + getName() +
                "University of" + getArea() +
                "will take drastic measures to stop spread of covid-19 in our University.Please stay safe and we will call you soon." +
                "Always our first priority was the safety of our students!Thanks for understanding in these difficult times.");
        //this method is used in displayUMenu
        //prints all details of the specific Uni(FE name,region)
        //with the code that takes,the code is similar the the check method ahead
        //look caseManagmentAndHumanAddition
    }
    public void monitoring() {
        if (status) {
            System.out.println("Some changes have been ocured");
            status = false;
            System.out.println("Positive have been found: ");
            for (int i = 0; i < changes.size(); i++) {
                System.out.printf("    The person: %s", changes.get(i).toString());
            }
            System.out.println("Please say us who have to tested");
            for (int j = 0; j < changes.size(); j++) {
                int choice;
                while (true) {
                    System.out.println("Contacts of the" + changes.get(j).toString());
                    System.out.println("0 for exit, 1 for profesors, 2 for secretariat, 3 other people related, 4 departments");
                    String input = scanner.nextLine();
                    if (input.equals("0")) {
                        break;
                    } else if (input.equals("1")) {
                        while (true) {
                            System.out.println("Give the number for each profesor");
                            System.out.println("0: Exit");
                            for (int i = 0; i < teachers.size(); i++) {
                                System.out.printf("%d: %s\n", i + 1, teachers.get(i).toString());
                            }
                            if (!sc.hasNextInt()) {
                                String ans = sc.nextLine();
                                System.out.printf(
                                        " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", teachers.size());
                                continue;
                            } else {
                                choice = sc.nextInt();
                                sc.nextLine();
                                if (choice > teachers.size()  || choice < 0) {
                                    System.out.println("Wrong number!Place a number between 0 and "+ teachers.size());
                                    continue;
                                }
                                break;
                            }
                        }
                        if (choice == 0) {
                            continue;
                        } else if (choice <= teachers.size()) {
                            teachers.get(choice -1 ).haveToBeTested();
                            //send an email
                        } else {
                            continue;
                        }
                    } else if (input.equals("2")) {
                        while (true) {
                            System.out.println("Give the number for each secretariat");
                            System.out.println("0: Exit");
                            for (int i = 0; i < secretariat.size(); i++) {
                                System.out.printf("%d: %s\n", i + 1, secretariat.get(i).getIdifier());
                            }
                            if (!sc.hasNextInt()) {
                                String ans = sc.nextLine();
                                System.out.printf(
                                        " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", secretariat.size());
                                continue;
                            } else {
                                choice = sc.nextInt();
                                sc.nextLine();
                                if (choice > secretariat.size()  || choice < 0) {
                                    System.out.println("Wrong number!Place a number between 0 and "+ teachers.size());
                                    continue;
                                }
                                break;
                            }
                        }
                        if (choice == 0) {
                            continue;
                        } else if (choice <= teachers.size()) {
                            secretariat.get(choice -1 ).affected();
                        }
                    } else if (input.equals("3")) {
                        while (true) {
                            System.out.println("Give the number for each other employee");
                            System.out.println("0: Exit");
                            for (int i = 0; i < others.size(); i++) {
                                System.out.printf("%d: %s\n", i + 1, others.get(i).toString());
                            }
                            if (!sc.hasNextInt()) {
                                String ans = sc.nextLine();
                                System.out.printf(
                                        " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", others.size());
                                continue;
                            } else {
                                choice = sc.nextInt();
                                sc.nextLine();
                                if (choice > others.size()  || choice < 0) {
                                    System.out.println("Wrong number!Place a number between 0 and "+ others.size());
                                    continue;
                                }
                                break;
                            }
                        }
                        if (choice == 0) {
                            continue;
                        } else if (choice <= others.size()) {
                            others.get(choice - 1).haveToBeTested();
                        }
                    } else if (input.equals("4")) {
                        while (true) {
                            System.out.println("Select one by one in which departent should students be tested");
                            System.out.println("0: Exit");
                            for(int i = 0; i < department.size(); i++) {
                                System.out.printf("%d: %s", i + 1, department.get(i).getIdifier());
                            }
                            if (!sc.hasNextInt()) {
                                String ans = sc.nextLine();
                                System.out.printf(
                                        " Your import(" + ans + ")it's not number.Please choose a number between 0 and %d.\n", department.size());
                                continue;
                            } else {
                                choice = sc.nextInt();
                                sc.nextLine();
                                if (choice > department.size()  || choice < 0) {
                                    System.out.println("Wrong number!Place a number between 0 and "+ department.size());
                                    continue;
                                }
                                break;
                            }
                        }
                        if (choice == 0) {
                            continue;
                        } else if (choice <= department.size()) {
                            department.get(choice - 1).affected();
                        }
                    } else {
                        System.out.println("Not valid option: " + input);
                    }
                }
            }
        } else {
            System.out.println("Everything is done");
        }
    }
    public static void createOrg() {
        String name;
        String area;
        int teachers;
        int students;
        while(true) {
            System.out.println("What is the name of the university?\nWrite the name without spaces!");
            name = scanner.next();
            System.out.println("In which area is your organization located?\nWrite the are without spaces!");
            area = scanner.next();
            System.out.println("How many teachers does your organization have?");
            teachers = scanner.nextInt();
            System.out.println("How many students does your organization have?");
            students = scanner.nextInt();
            System.out.printf("Name University: %s, Area: %s, Total People(Teachers plus Students): %d." +
                    "Is that correct? 1for yes",name,area,teachers+students);
            if (scanner.hasNext()) {
                scanner.nextLine();
            }
            if (scanner.nextLine().equals("1")) {
                break;
            }
        }
        Universities newOn = new Universities(name,area,teachers+students);
    }
    public void autoMonitoring() {//to be changed
        int count = 0;
        if (number_teachers_positive > limit_per_teachers) {
            lockdown = true;
            return;
        }
        if (number_others_positive > limit_others) {
            lockdown = true;
            return;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < secretariat.size(); i++) {
            int a = number_secreterariat_positive.get(i);
            sum1 += a;
            if (a > limit_per_department) {
                lockdown_secretariat.set(i, true);
            }
        }
        for (int i = 0 ; i < department.size(); i++) {
            int secr = number_department_positive.get(i);
            sum2 += secr;
            if (secr > limit_per_secretariat) {
                lockdown_department.set(i, true);
            }
        }
        int sum = number_others_positive + number_teachers_positive + sum1 + sum2;
        if (sum > total_limit) {
            lockdown = true;
        }
    }
    public void findWhereBelongs(Human human) {
        String look_for = human.getAfm();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getAfm().equals(look_for)) {
                number_teachers_positive += 1;
                break;
            }
        }
        for (int i = 0; i < others.size(); i++) {
            if (others.get(i).getAfm().equals(look_for)) {
                number_others_positive += 1;
                break;
            }
        }
        for (int i = 0; i < department.size(); i++) {
            Human one;
            one = department.get(i).isSame(look_for);
            if (one != null) {
                number_department_positive.set(i,number_department_positive.get(i) + 1);
                break;
            }
        }
        for (int i = 0; i < secretariat.size(); i++) {
            Human one;
            one = department.get(i).isSame(look_for);
            if (one != null) {
                number_secreterariat_positive.set(i, number_secreterariat_positive.get(i) + 1);
                break;
            }
        }
        autoMonitoring();
    }
    public void declareCase(Human human) { //called by eody
        if (status) {
            changes.add(human);

        } else {
            changes.clear();
            status = true;
            changes.add(human);
        }
        findWhereBelongs(human);
    }
    public void declareCase() {//from user
        if (status) {
            System.out.println("New cases in your university have been occured\nGoing to monitoring menu");
            monitoring();
        }
        System.out.println("Give the ssn of the person that is positive");
        String input = scanner.nextLine();
		/*Human human = Human.checkIfCovid(input, this);
		if (human == null) {
		System.out.println("We dont have a member with");
		}*/
        for (int i = 0; i < department.size(); i++) {
            Human oneHuman = department.get(i).isSame(input);
            if (oneHuman != null) {
                System.out.printf("Want to report of student: %s, 0 for exit\n", oneHuman.toString());
                String input1 = scanner.nextLine();
                if (input1.equals("0")) {
                    return;
                } else {
                    oneHuman.bePositive();
                    findWhereBelongs(oneHuman);
                    return;
                }
            }
        }
        for (int i = 0; i < secretariat.size(); i++) {
            Human oneHuman = secretariat.get(i).isSame(input);
            if (oneHuman != null) {
                System.out.printf("Want to report of a member of secretary: %s, 0 for exit\n", oneHuman.toString());
                String ans = scanner.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    oneHuman.bePositive();
                    findWhereBelongs(oneHuman);
                    return;
                }
            }
        }
        for (int i = 0; i < others.size(); i++) {
            if (others.get(i).getAfm().equals(input)) {
                System.out.printf("Want to report of a member of secretary: %s, 0 for exit\n", others.get(i).toString());
                String ans = scanner.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    others.get(i).bePositive();
                    findWhereBelongs(others.get(i));
                    return;
                }
            }
        }
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getAfm().equals(input)) {
                System.out.printf("Want to report of a member of professors: %s, 0 for exit\n", teachers.get(i).toString());
                String ans = scanner.nextLine();
                if (ans.equals("0")) {
                    return;
                } else {
                    teachers.get(i).bePositive();
                    findWhereBelongs(teachers.get(i));
                    return;
                }
            }
        }
        System.out.println("Cant find a member with ssn:" + input);
    }


    protected void modifyDepartments(){
        while (true){
            if (department.size() == 0) {
                //crete departments
                int count = 0;
                while (true) {
                    System.out.printf("Creating the %d department,for exit 0", count + 1);
                    if (scanner.nextLine().equals("0")) {
                        if (department.size() == 0){
                            System.out.println("Cant exit without creating one department");
                        }else {
                            break;
                        }
                    }
                    Classes one = new Classes(this);
                    number_department_positive.add(0);
                    department.add(one);
                }
                break;
            } else {
                while (true) {
                    int ans = 0;
                    try {
                        System.out.println("Select which department to modify");
                        System.out.println("Press 0 to create a new one");
                        int num = 1;
                        for (Classes c : department) {
                            System.out.printf("%d for : %s", num, c.getIdifier());
                            num++;
                        }
                        System.out.println("Press a number");
                        ans = scanner.nextInt();
                        if (ans == 0) {
                            Classes one = new Classes(this);
                            number_department_positive.add(0);
                            department.add(one);
                        }
                        if (ans < 1 && ans > department.size()) {
                            System.out.println("Invalid number, try again");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("That is not number, try again");
                        scanner.nextLine();
                    }
                    //add or delete
                    department.get(ans  - 1).modify();
                    break;
                }
                break;
            }
        }
    }
    protected void modifyTeachers() {
        while (true){
            if(teachers.size() != 0) {
                System.out.printf("There are %d Professor(s), would you like to add new?\n" +
                        "Press 1 for yes,otherwise we will go to remove panel", teachers.size());
                String ans = scanner.nextLine();
                if (ans.equals("1")) {
                    int i = 0;
                    while (true) {
                        System.out.printf("Adding the %d professor, for exit 0", i+1);
                        if (scanner.nextLine().equals("0")) {
                            break;
                        }
                        Human one = Human.createHuman(this);
                        teachers.add(one);
                        i++;
                    }
                    addPeople(i);
                    break;
                }
                System.out.printf("There are %d Professor(s), would you like to remove one?\n" +
                        "Press 1 for yes", teachers.size());
                String ans0 = scanner.nextLine();
                if (ans0.equals("1")) {
                    while (true){
                        System.out.println("Give the afm of the professor that want to remove");
                        String afm = scanner.nextLine();
                        boolean flag = true;
                        for (int i=0; i < teachers.size(); i++) {
                            if (teachers.get(i).getAfm().equals(afm)) {
                                teachers.get(i).removeFromOrg(this);
                                teachers.remove(i);
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.printf("Could not find professor with afm:% s", afm);
                        } else {
                            reducePeople(1);
                        }
                        System.out.println("Continue the deletion process? 0 for exit");
                        String ans1 = scanner.nextLine();
                        if (ans1.equals("0")) {
                            break;
                        }
                    }
                    break;
                }
            } else {//from cunstractor
                System.out.println("There are no professors filled, Please start with giving them");
                int i = 0;
                while (true) {
                    System.out.printf("Creating the %d professor, 0 for exit", i+1);
                    if (scanner.nextLine().equals("0")) {
                        break;
                    }
                    Human one = Human.createHuman(this);
                    if (one == null) {
                        break;
                    }
                    teachers.add(one);
                    i++;
                }
                break;
            }
        }
    }

    protected void modifySecretariat() {
        while (true){
            if (secretariat.size() == 0) {
                //crete secretariat
                int count = 0;
                while (true) {
                    System.out.printf("Creating the %d secretariat,for exit 0", count + 1);
                    if (scanner.nextLine().equals("0")) {
                        if (secretariat.size() == 0){
                            System.out.println("Cant exit without creating one secretariat");
                        }else {
                            break;
                        }
                    }
                    Classes one = new Classes(this);
                    secretariat.add(one);
                    number_secreterariat_positive.add(0);
                }
                break;
            } else {
                while (true) {
                    int ans = 0;

                    try {
                        System.out.println("Select which secretariat to modify");
                        System.out.println("O to create a new one");
                        int num = 0;
                        for (Classes c : secretariat) {
                            System.out.printf("%d for : %s", num, c.getIdifier());
                            num++;
                        }
                        System.out.println("Press a number");
                        ans = scanner.nextInt();
                        if (ans == 0) {
                            Classes one = new Classes(this);
                            number_secreterariat_positive.add(0);
                            department.add(one);
                        }
                        if (ans < 1 && ans > secretariat.size()) {
                            System.out.println("Invalid number, try again");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("That is not number, try again");
                        scanner.nextLine();
                    }
                    //add or delete
                    secretariat.get(ans - 1).modify();
                    break;
                }
                break;
            }
        }
    }

    public void seeStatus() {
        if (status) {
            System.out.println("New cases in your university have been occured\nGoing to monitoring menu");
            monitoring();
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < number_secreterariat_positive.size(); i++) {
            sum1 += number_secreterariat_positive.get(i);
        }
        for (int i = 0; i < number_department_positive.size(); i++) {
            sum2 += number_department_positive.get(i);
        }
        int count = number_others_positive + number_teachers_positive + sum1 + sum2;
        System.out.printf("Total Positive in your Universitat: %d", count);
        System.out.printf("Total Positive Professors: %d", number_teachers_positive);
        System.out.printf("Total Positive Secretariat member: %d", sum1);
        System.out.printf("Total Positive of Other Employee: %d", number_others_positive);
        System.out.printf("Total Positive Students: %d", sum2);
        System.out.println("Status of professors");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.printf("%s has status:%s\n", teachers.get(i).toString(), teachers.get(i).seeStatus());
        }
        System.out.println("Status of secretariat");
        for (int i = 0; i < secretariat.size(); i++) {
            System.out.printf("    Status secretariat:%s", secretariat.get(i).getIdifier());
            secretariat.get(i).printStatus();
        }
        System.out.println("Status of other employee");
        for (int i = 0; i < others.size(); i++) {
            System.out.printf("%s has status:%s\n", others.get(i).toString(), others.get(i).seeStatus());
        }
        System.out.println("Status of each department");
        for (int i = 0; i < department.size(); i++) {
            System.out.printf("    Status department:%s", department.get(i).getIdifier());
            department.get(i).printStatus();
        }
        if (count > limit_decision) {
            System.out.println("Do you want to close your school?, 1 yes");//option if is serious
            String ans = scanner.nextLine();
            if (ans.equals("1")) {
                lockdown = true;
            }
        }
    }
    protected void modifyOthers() {
        while (true){
            if(others.size() != 0) {
                System.out.printf("There are %d People, would you like to add new?\n" +
                        "Press 1 for yes,otherwise we will go to remove panel", others.size());
                String ans = scanner.nextLine();
                int i = 0;
                if (ans.equals("1")) {
                    while (true) {
                        System.out.printf("Adding the %d person, for exit 0", i+1);
                        if (scanner.nextLine().equals("0")) {
                            break;
                        }
                        Human one = Human.createHuman(this);
                        if (one == null) {
                            break;
                        }
                        others.add(one);
                        i++;
                    }
                    addPeople(i);
                    break;
                }
                System.out.printf("There are %d People, would you like to remove one?\n" +
                        "Press 1 for yes", others.size());
                String ans0 = scanner.nextLine();
                if (ans0.equals("1")) {
                    while (true){
                        System.out.println("Give the afm of the person that want to remove");
                        String afm = scanner.nextLine();
                        boolean flag = true;
                        for (i = 0; i < others.size(); i++) {
                            if (others.get(i).getAfm().equals(afm)) {
                                others.remove(i);
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.printf("Could not find person with afm:% s", afm);
                        }
                        System.out.println("Continue the deletion process? 0 for exit");
                        String ans1 = scanner.nextLine();
                        if (ans1.equals("0")) {
                            break;
                        }
                    }
                    break;
                }
            } else {//from constractor
                System.out.println("There are no people filled, Please start with giving them");
                int i = 0;
                while (true) {
                    System.out.printf("Creating the %d person, 0 for exit", i+1);
                    if (scanner.nextLine().equals("0")) {
                        break;
                    }
                    Human one = Human.createHuman(this);
                    if (one == null) {
                        break;
                    }
                    others.add(one);
                    i++;
                }
                break;
            }
        }
    }

}

