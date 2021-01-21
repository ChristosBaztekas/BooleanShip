package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtils {


    private static String url = "jdbc:postgresql://localhost:5432/booleanship";
    private static String user = "postgres";
    private static String pass = "2109885125";
    private static  Connection dbcon;

    public static Connection initConnection(){
        try {
            dbcon = DriverManager.getConnection(url,user,pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dbcon;
    }

    public static void closeConnection(){
        try {

            System.out.println("Goodbye postgres");
            dbcon.close();
        } catch (SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
        }
    }


}
