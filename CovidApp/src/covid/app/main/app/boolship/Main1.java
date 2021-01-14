package covid.app.main.app.boolship;

import java.io.*;
import java.net.ConnectException;
import java.text.*;
import java.util.ArrayList;
import java.util.*;
import java.sql.*;

public class Main1 {
	static String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" +
			"databaseName=DB38;user=G538;password=48534trh045;";
	static Scanner scanner = new Scanner(System.in);
	/*public static void main(String[] args) {
		System.out.println("option 1:see all human");
		System.out.println("option 2:search by afm");
		//System.out.println("option 3:add human, please not same afm yet");
		String input = new Scanner(System.in).nextLine();
		System.out.println("give 0 to exit");
		int input2 = new Scanner(System.in).nextInt();
		do {
			if (input.equals("1")) {
				getHuman();
			} else if (input.equals("2")) {
				getHumanAfm();
			} else if (input.equals("3")) {
				getHumanexample();
			}
		} while (input2 == 0);
	}*/
	public static void main(String[] args) {
		System.out.println("1:show all email");
		String string = scanner.nextLine();
		if (string.equals("1")) {
			ArrayList<String> emails = getEmails();
		} else if (string.equals("2")) {
			register();
		}
	}
	public static void register() {
		System.out.println("Give user,name,area,email");
		String query = "DECLARE @flag int\n" +
				"SELECT @flag = id_org \n" +
				"FROM Registation_Org\n" +
				"WHERE username_org = ?\n" +
				"if @flag is null\n" +
				"\tinsert Organisations values(?,?,?)\n" +
				"\t--take id and make it foreign key\n" +
				"\t--in this way find id\n" +
				"\t--which org, make inserts too\n" +
				"\t/*fe NH*/insert NursingHomes values(/*id_org*/,?,?,?)\n" +
				"\tselect @everythink_ok = 0--does it return?\n" +
				"else\n" +
				"\tselect @everythink_ok = -1 --does it return?\"";
		String username = scanner.nextLine();
		String name = scanner.nextLine();
		String area = scanner.nextLine();
		String email = scanner.nextLine();
		Connection connection;
		ResultSet resultSet;
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, area);
			preparedStatement.setString(4, email);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int output = resultSet.getInt(1);
				if (output == 0) {
					System.out.println("Everythink ok");
				} else if (output == -1) {
					System.out.println("There is already this username ");
				}
			}
		} catch (SQLException sqlException) {
			System.out.println("Something occured" + sqlException.getMessage());
		}
	}
	public static ArrayList<String> getEmails() {
		String query = "SELECT O.email AS E \n" +
				"FROM Organisations AS O";
		ArrayList<String> arrayList = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		boolean flag = true;//to know if connection goes false
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				arrayList.add(resultSet.getString("E"));
			}
			flag = false;
			connection.close();
			statement.close();
			resultSet.close();
		} catch (SQLException sqlException) {
			System.out.println("Something has occured\nPlease try again!");
			System.out.println(sqlException.getMessage());
		}
		if (flag) {
			System.out.println("The process has not go well");//message for us and maybe to repeat
		}
		return arrayList;
	}

	public static String[] getDetails(int id) {
		String[] array = new String[2];
		String query = "SELECT O.name, O.area\n" +
				"FROM Organisations AS O\n" +
				"WHERE O.id = ?";
		Connection connection;
		ResultSet resultSet;
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			String name;
			String area;
			while (resultSet.next()) {
				name = resultSet.getString("name");
				area = resultSet.getString("area");
				array[0] = name;
				array[1] = area;
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException sqlException) {
			System.out.println("Something has occured\n" + sqlException.getMessage());
		}
		return array;
	}
	//Schools methods
	public static ArrayList<String> displayTeachers(int id) {
		String query = "SELECT H.name, H.surname, H.Afm \n" +
				"FROM Schools_teachers AS T, Human AS H\n" +
				"WHERE T.id_Human = H.id AND T.id_NursingHomes = ?";
		return display(id, query);
	}
	public static ArrayList<String> displayOthers(int id) {
		String query = "SELECT H.name, H.surname, H.Afm \n" +
				"FROM Schools_others AS O, Human AS H\n" +
				"WHERE O.id_Human = H.id AND O.id_NursingHomes = ?";
		return display(id, query);
	}
	public static boolean removeFromOrg(String afm, int id) {
		String query = "DELETE\n" +
				"FROM Human_belongs AS B" +
				"WHERE B.id_Human = ? AND id_Organisations = ?";
		Connection connection;
		PreparedStatement preparedStatement;
		int output = 0;
		try {
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, afm);
			preparedStatement.setInt(2, id);
			output = preparedStatement.executeUpdate();
		} catch (SQLException sqlException) {
			System.out.println("Something occured" + sqlException.getMessage());
		}
		if (output > 0) {
			return true;
		} else {
			return false;
		}
	}
	public static String getIdifier(int id) {
		String query = "SELECT idifier as i " +
				"FROM Classes as C" +
				"WHERE C.id_Organisations = ?";
		String idifier = null;
		Connection connection;
		ResultSet resultSet;
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				idifier = resultSet.getString("i");
			}
		} catch (SQLException sqlException) {
			System.out.println("Something occured" + sqlException.getMessage());
		}
		return idifier;
	}
	public static ArrayList<String> displayDepartments(int id) {
		/**
		 * display ALL the people of all Classes
		 * returns an arraylist of strings
		 * Every 4th element of this list is the idifier of the class that belongs
		 * and in that way can understand the different
		 */
		String query = "SELECT H.name, H.surname, H.Afm, C.idifier \n" +
				"FROM Classes_member as M, Classes as C, Human as H\n" +
				"WHERE M.id_Classes = C.id AND C.id_Organisations = ? AND H.Afm = M.id_Human\n" +
				"ORDER BY C.id";
		ArrayList<String> arrayList = new ArrayList<String>();
		Connection connection;
		ResultSet resultSet;
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString("name"));
				arrayList.add(resultSet.getString("surname"));
				arrayList.add(resultSet.getString("Afm"));
				arrayList.add(resultSet.getString("id"));
			}
		} catch (SQLException sqlException) {
			System.out.println("Something occured" + sqlException.getMessage());
		}
		return arrayList;
	}
	//NursingHomes methods
	public static int[] seeStatusfirst(int id) {
		int[] array = new int[3];
		String query = "SELECT NH.status, NH.count_employees, NH.count_carenPeople\n" +
				"FROM NursingHomes AS NH\n" +
				"WHERE NH.id = ?";
		Connection connection;
		ResultSet resultSet;
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				array[0] = resultSet.getInt("status");
				array[1] = resultSet.getInt("count_employees");
				array[2] = resultSet.getInt("count_carenPeople");

			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException sqlException) {
			System.out.println("Something has occured\n" + sqlException.getMessage());
		}
		return array;

	}

	public static ArrayList<String> displayEmployess(int id) {
		String query = "SELECT H.name, H.surname, H.Afm \n" +
				"FROM NursingHomes_employees AS E, Human AS H\n" +
				"WHERE E.id_Human = H.id AND E.id_NursingHomes = ?";
		return display(id, query);
	}
	public static ArrayList<String> displayCarenPeople(int id) {
		String query = "SELECT H.name, H.surname, H.Afm\n" +
				"FROM NursingHomes_carenPeople AS C, Human AS H\n" +
				"WHERE C.id_Human = H.id AND E.id_NursingHomes = ?";
		return display(id, query);
	}

	private static ArrayList<String> display(int id, String query) {
		/**
		 * display name, surname and afm of an org that have list of human
		 */
		ArrayList<String> arrayList = new ArrayList<>();
		Connection connection;
		ResultSet resultSet;
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement1 = connection.prepareStatement(query);
			preparedStatement1.setInt(1, id);
			resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString("name"));
				arrayList.add(resultSet.getString("surname"));
				arrayList.add(resultSet.getString("Afm"));
			}
		} catch (SQLException sqlException) {
			System.out.println("Something has occured\n" + sqlException.getMessage());
		}
		return arrayList;
	}
	//universities methods
	public static ArrayList<String> displayothers(int id) {
		String query = "SELECT H.name, H.surname, H.Afm \n" +
				"FROM Universities_others AS O, Human AS H\n" +
				"WHERE O.id_Human = H.id AND O.id_NursingHomes = ?";
		return display(id, query);
	}
	public static ArrayList<String> displayteachers(int id) {
		String query = "SELECT H.name, H.surname, H.Afm \n" +
				"FROM Universities_teachers AS T, Human AS H\n" +
				"WHERE T.id_Human = H.id AND T.id_NursingHomes = ?";
		return display(id, query);
	}
	public static void createHuman(String name, String surname, String email, String gender, String afm) {

		Connection dbco = null;
		try {
		dbco = DriverManager.getConnection(url);
		}
		catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
				
		String query = "insert into	Human(name, surname, email, gender, Afm)values(?,?,?,?,?)";
        
        try {
        	PreparedStatement pst = dbco.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setString(3, email);
            pst.setString(4, gender);
			pst.setString(5, afm);
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public static boolean findHuman(String afm) {
		String query = "SELECT H.id\n" +
				"FROM Human AS H\n" +
				"WHERE Afm = ?";
		Connection connection;
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		boolean flag = false;
		try {
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, afm);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String ans = resultSet.getString(1);
				if (ans != null) {
					flag = true;
				}
			}
		} catch (SQLException sqlException) {
			System.out.println("Something occures" + sqlException.getMessage());
		}
		return flag;
	}
}
