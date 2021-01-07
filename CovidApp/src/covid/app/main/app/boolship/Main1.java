package covid.app.main.app.boolship;

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;

public class Main1 {
	public static void main(String[] args) {
		System.out.println("option 1:see all human");
		System.out.println("option 2:search by afm");
		//System.out.println("option 3:add human, please not same afm yet");
		String input = new Scanner(System.in).nextLine();
		if (input.equals("1")) {
			getHuman();
		} else if (input.equals("2")) {
			getHumanAfm();
		} /*else if (input.equals("3")) {
			getHumanexample();
		}*/


	}
	public static void getHumanAfm() {
		String name;
		String surname;
		String email;
		String gender;
		String afm;
		boolean flag = true;
		String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" +
		                   "databaseName=DB38;user=G538;password=48534trh045;";
		Connection dbcon;
		Statement stmt;
		ResultSet rs;
		System.out.println("Give afm");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
			rs = stmt.executeQuery("EXECUTE giveHumans");
			while(rs.next()) {
				name = rs.getString("name");
				surname = rs.getString("surname");
				email = rs.getString("email");
				gender = rs.getString("gender");
				afm = rs.getString("Afm");
				if(afm.equals(input)) {
					System.out.print("The person has been found: ");
					System.out.printf("Name:%s, Surname:%s, email:%s, gender:%s", name, surname, email, gender);
					flag = false;
					break;
				}

			}
			if (flag) {
				System.out.printf("Cant find person with afm:%s", input);
			}
			rs.close();
			stmt.close();
			dbcon.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
	}
	public static void getHuman() {
			String name;
			String surname;
			String email;
			String gender;
			String afm;
			String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" +
			                   "databaseName=DB38;user=G538;password=48534trh045;";
			Connection dbcon;
			Statement stmt;
			ResultSet rs;
			try {
				dbcon = DriverManager.getConnection(url);
				stmt = dbcon.createStatement();
				rs = stmt.executeQuery("EXECUTE giveHumans");
				while(rs.next()) {
					name = rs.getString("name");
					surname = rs.getString("surname");
					email = rs.getString("email");
					gender = rs.getString("gender");
					afm = rs.getString("Afm");
					System.out.printf("Name:%s, Surname:%s, email:%s, gender:%s\n", name, surname, email, gender);
				}
				rs.close();
				stmt.close();
				dbcon.close();
			} catch (SQLException e) {
				System.out.print("SQLException: ");
				System.out.println(e.getMessage());
			}
	}
}
