package covid.app.main.app.boolship;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Connect {
    static String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" +
            "databaseName=DB38;user=G538;password=48534trh045;";

    public static boolean existsUsername(String username) {
        Connection connection;
        PreparedStatement preparedStatement;
        String query1 = "SELECT O.id\n" +
                "FROM Organisations AS O\n" +
                "WHERE O.username = ?";
        try {
            connection = DriverManager.getConnection(url);
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return false;
    }

    public static int createOrg(String name,
                                String area,
                                String email,
                                String username,
                                String password) {
        Connection connection;
        int id = Integer.MIN_VALUE;
        PreparedStatement preparedStatement;
        String query1 = "INSERT into Organisations values(?,?,?,?,?)";
        try {
            connection = DriverManager.getConnection(url);
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, area);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement1 = connection.prepareStatement
                    ("select id from Organisations where username = ?");
            preparedStatement1.setString(1, username);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return id;
    }

    public static void createNH(int idOrg, String desc, int status) {
        Connection connection;
        String query = "INSERT INTO NursingHomes values(?,?,0,0,?,0)";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrg);
            preparedStatement.setString(2, desc);
            preparedStatement.setInt(3, status);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public static void createSchool(int idOrg) {
        Connection connection;
        String query = "INSERT INTO Schools VALUES(?,0,0,0,0,0)";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrg);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public static void createUni(int idOrg) {
        Connection connection;
        String query = "INSERT INTO Universities VALUES(?,0,0,0)";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrg);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    //option 0 means PublicServices otherwise Companies
    public static void createL(int idOrg, int option) {
        Connection connection;
        String query = "INSERT INTO Companies VALUES(?, 0)";
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrg);
            preparedStatement.executeUpdate();
            if (option == 0) {
                String query2 = "INSERT INTO Public_Services VALUES(?, 0)";
                preparedStatement = connection.prepareStatement(query2);
                preparedStatement.setInt(1, idOrg);
                preparedStatement.executeUpdate();
            } else {
                String query1 = "INSERT INTO Companies VALUES(?, 0)";
                preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, idOrg);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public static void register(int org, ArrayList<String> valuesString, ArrayList<Integer> valuesInteger) {
        System.out.println("Give name, area, email, username, password");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String area = scanner.nextLine();
        String email = scanner.nextLine();
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        int id;
        if (existsUsername(username)) {
            System.out.println("I am sorry");
        } else {
            id = createOrg(name, area, email, username, password);
            switch (org) {
                case 1:
                    createNH(id, valuesString.get(0),
                            valuesInteger.get(0));
                    break;
                case 2:
                    createSchool(id);
                    break;
                case 3:
                    createUni(id);
                    break;
                case 4:
                    createL(id, valuesInteger.get(0));
                    break;
            }
        }
    }

    //return min Integer if not right, otherwise id org
    public static int giveOrg(String username, String password) {
        Connection connection;
        String query = "SELECT O.id\n" +
                "FROM Organisations AS O\n" +
                "WHERE O.username = ? AND O.password = ?";
        PreparedStatement preparedStatement;
        int id = Integer.MIN_VALUE;
        try {
            connection = DriverManager.getConnection(url);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return id;
    }

    public static Organisations findOrg(String username, String password) {
        int idOrg = giveOrg(username, password);
        if (idOrg == Integer.MIN_VALUE) {
            System.out.println("Wrong username, password");
            return null;
        }
        String query1 = "SELECT 1 FROM NursingHomes AS NH WHERE NH.id = ?";
        String query2 = "SELECT 2 FROM Schools AS S WHERE S.id = ?";
        String query3 = "SELECT 3 FROM Universities AS U WHERE U.id = ?";
        String query4 = "SELECT 4 FROM Companies AS C WHERE C.id = ?";
        String query5 = "SELECT 5 FROM Public_Services AS P WHERE P.id = ?";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = DriverManager.getConnection(url);
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return giveNH(idOrg);
            }
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return giveSchool(idOrg);
            }
            preparedStatement = connection.prepareStatement(query3);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return null;
            }
            preparedStatement = connection.prepareStatement(query4);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return null;
            }
            preparedStatement = connection.prepareStatement(query5);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return null;
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    public static NursingHomes giveNH(int idOrg) {
        String name = null;
        String area = null;
        String email = null;
        String status_descr = null;
        int count_employees = Integer.MIN_VALUE;
        int count_carenPeople = Integer.MIN_VALUE;
        boolean en_status = false;
        boolean status = false;
        try {
            Connection connection = DriverManager.getConnection(url);
            String query = "SELECT name, area, email FROM Organisations as O WHERE O.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrg);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString(1);
                area = resultSet.getString(2);
                email = resultSet.getString(3);
            }
            String query2 = "SELECT status_descr, count_employees, count_carenPeople, en_status, status\n"
                    + "FROM NursingHomes as NH WHERE NH.id = ?";
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                status_descr = resultSet.getString(1);
                count_employees = resultSet.getInt(2);
                count_carenPeople = resultSet.getInt(3);
                en_status = (resultSet.getInt(4) == 0 ? false : true);
                status = (resultSet.getInt(5) == 0 ? false : true);
            }
            String query3 = "SELECT name, surname, Afm, email, gender FROM NursingHomes_employees AS E, Human as H\n" +
                    "WHERE E.id_NursingHomes = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query3);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> employees = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
            }
            String query4 = "SELECT name, surname, Afm, email, gender FROM NursingHomes_carenPeople AS E, Human as H\n" +
                    "WHERE E.id_NursingHomes = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query4);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> carenPeople = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
            }
            String query5 = "SELECT name, surname, Afm, email, gender FROM NursingHomes_changes AS E, Human as H\n" +
                    "WHERE E.id_NursingHomes = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query5);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> changes = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
            }
            NursingHomes nh = new NursingHomes(name, area, email, status_descr,
                    count_employees, count_carenPeople, en_status, status);
            nh.setEmployess(employees);
            nh.setCarenPeople(carenPeople);
            nh.setChanges(changes);
            return nh;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    public static Schools giveSchool(int idOrg) {
        String name = null;
        String area = null;
        String email = null;
        int number_of_students_positive = Integer.MIN_VALUE;
        int number_of_teachers_positive = Integer.MIN_VALUE;
        int number_of_others_positive = Integer.MIN_VALUE;
        boolean lockdown = false;
        boolean status = false;
        try {
            Connection connection = DriverManager.getConnection(url);
            String query = "SELECT name, area, email FROM Organisations as O WHERE O.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrg);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString(1);
                area = resultSet.getString(2);
                email = resultSet.getString(3);
            }
            String query2 = "SELECT number_of_students_positive, number_of_teachers_positive, " +
                    "number_of_others_positive, lockdown, status\n"
                    + "FROM Schools as S WHERE S.id = ?";
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                number_of_students_positive = resultSet.getInt(1);
                number_of_teachers_positive = resultSet.getInt(2);
                number_of_others_positive = resultSet.getInt(3);
                lockdown = (resultSet.getInt(4) == 0 ? false : true);
                status = (resultSet.getInt(5) == 0 ? false : true);
            }
            String query3 = "SELECT name, surname, Afm, email, gender FROM Schools_teachers AS E, Human as H\n" +
                    "WHERE E.id_Schools = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query3);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> employees = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                employees.add(h);
            }
            String query4 = "SELECT name, surname, Afm, email, gender FROM Schools_changes AS E, Human as H\n" +
                    "WHERE E.id_Schools = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query4);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> changes = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                changes.add(h);
            }
            String query5 = "SELECT name, surname, Afm, email, gender FROM Schools_others AS E, Human as H\n" +
                    "WHERE E.id_Schools = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query5);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> others = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                others.add(h);
            }
            String query6 = "SELECT C.id, C.idifier, H.name, H.surname, H.Afm, H.email, H.gender " +
                    "FROM Schools_departments AS D, Classes AS C, Classes_members AS M, Human as H" +
                    "WHERE C.id = M.id_Classes AND C.id_Organisations = ? AND H.ID = M. AND D.";
            preparedStatement = connection.prepareStatement(query6);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Classes> departents = new ArrayList<>();
            int change_class = Integer.MIN_VALUE;
            ArrayList<Human> humans = new ArrayList<>();
            while (resultSet.next()) {
                int classesId = resultSet.getInt(1);
                String idifier = resultSet.getString(2);
                if (classesId == change_class) {
                    Human h = new Human(resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
                    humans.add(h);
                } else {
                    change_class = classesId;
                    if (humans.size() == 0) {
                        continue;
                    }
                    Classes classes = new Classes(idifier, idOrg, humans);
                    departents.add(classes);
                    humans.clear();
                    Human h = new Human(resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
                    humans.add(h);
                }
            }

            Schools s = new Schools(name, area, email, number_of_students_positive,
                    number_of_teachers_positive, number_of_others_positive, lockdown,status);
            s.setTeachers(employees);
            s.setOthers(others);
            s.setChanges(changes);
            s.setDepartments(departents);
            return s;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }
    public static Universities giveUni(int idOrg) {
        String name = null;
        String area = null;
        String email = null;
        int number_of_teachers_positive = Integer.MIN_VALUE;
        int number_of_others_positive = Integer.MIN_VALUE;
        boolean lockdown = false;
        boolean status = false;
        try {
            Connection connection = DriverManager.getConnection(url);
            String query = "SELECT name, area, email FROM Organisations as O WHERE O.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrg);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString(1);
                area = resultSet.getString(2);
                email = resultSet.getString(3);
            }
            String query2 = "SELECT number_of_teachers_positive, " +
                    "number_of_others_positive, lockdown, status\n"
                    + "FROM Universities as S WHERE S.id = ?";
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                number_of_teachers_positive = resultSet.getInt(1);
                number_of_others_positive = resultSet.getInt(2);
                lockdown = (resultSet.getInt(3) == 0 ? false : true);
                status = (resultSet.getInt(4) == 0 ? false : true);
            }
            String query3 = "SELECT name, surname, Afm, email, gender FROM Universities_teachers AS E, Human as H\n" +
                    "WHERE E.id_Universities = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query3);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> teachers = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                teachers.add(h);
            }
            String query4 = "SELECT name, surname, Afm, email, gender FROM Universities_changes AS E, Human as H\n" +
                    "WHERE E.id_Universities = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query4);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> changes = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                changes.add(h);
            }
            String query5 = "SELECT name, surname, Afm, email, gender FROM Universities_others AS E, Human as H\n" +
                    "WHERE E.id_Universities = ? AND E.id_Human = Afm";
            preparedStatement = connection.prepareStatement(query5);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Human> others = new ArrayList<Human>();
            while (resultSet.next()) {
                Human h = new Human(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                others.add(h);
            }
            String query6 = "SELECT C.id, C.idifier, H.name, H.surname, H.Afm, H.email, H.gender " +
                    "FROM Universities_departments AS D, Classes AS C, Classes_members AS M, Human as H" +
                    "WHERE C.id = M.id_Classes AND C.id_Organisations = ? AND H.ID = M.id_Human";
            preparedStatement = connection.prepareStatement(query6);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Classes> departents = new ArrayList<>();
            int change_class = Integer.MIN_VALUE;
            ArrayList<Human> humans = new ArrayList<>();
            while (resultSet.next()) {
                int classesId = resultSet.getInt(1);
                String idifier = resultSet.getString(2);
                if (classesId == change_class) {
                    Human h = new Human(resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
                    humans.add(h);
                } else {
                    change_class = classesId;
                    if (humans.size() == 0) {
                        continue;
                    }
                    Classes classes = new Classes(idifier, idOrg, humans);
                    departents.add(classes);
                    humans.clear();
                    Human h = new Human(resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
                    humans.add(h);
                }
            }
            String query7 = "SELECT C.id, C.idifier, H.name, H.surname, H.Afm, H.email, H.gender " +
                    "FROM Schools_departments AS D, Classes AS C, Classes_members AS M, Human as H" +
                    "WHERE C.id = M.id_Classes AND C.id_Organisations = ? AND H.ID = M.id_Human";
            preparedStatement = connection.prepareStatement(query7);
            preparedStatement.setInt(1, idOrg);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Classes> departents = new ArrayList<>();
            int change_class = Integer.MIN_VALUE;
            ArrayList<Human> humans = new ArrayList<>();
            while (resultSet.next()) {
                int classesId = resultSet.getInt(1);
                String idifier = resultSet.getString(2);
                if (classesId == change_class) {
                    Human h = new Human(resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
                    humans.add(h);
                } else {
                    change_class = classesId;
                    if (humans.size() == 0) {
                        continue;
                    }
                    Classes classes = new Classes(idifier, idOrg, humans);
                    departents.add(classes);
                    humans.clear();
                    Human h = new Human(resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
                    humans.add(h);
                }
            }
            Schools s = new Schools(name, area, email, number_of_students_positive,
                    number_of_teachers_positive, number_of_others_positive, lockdown, status);
            s.setTeachers(employees);
            s.setOthers(others);
            s.setChanges(changes);
            s.setDepartments(departents);
            return s;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add("1st try");
        b.add(0);
        register(1, a, b);
    }
}
