package covid.app.main.app.boolship;


import covid.app.data.dao.UserDaoImpl;
import covid.app.data.model.User;
import covid.app.gui.bool.ship.GuiClass;
import covid.app.gui.bool.ship.piechart;
import covid.app.manager.DBConnectionManager;
import javafx.application.Application;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Human> all;

	public static String[] a;// we need this for the piechart
    public static void main(String[] args) {
        //this is how the create user will work
//        User leonidas =  new User("","123467","leonidasdiam2001@gmail.com","Leonidas Diamantopoulos");
//        DBConnectionManager manager = new DBConnectionManager();
//        UserDaoImpl impl = new UserDaoImpl(manager);
//        impl.insertUser(leonidas);


        GuiClass wsFrame = new GuiClass();
        wsFrame.setBounds(400, 100, 900, 700);
        wsFrame.setVisible(true);
        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a = args;// we need this for the piechart



    }
}