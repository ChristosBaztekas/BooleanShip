package covid.app.gui.bool.ship.mainMenu;


import covid.app.data.dao.DaoImpl;
import covid.app.data.model.Human;
import covid.app.gui.bool.ship.registrationForms.RegistrationFormNh;
import covid.app.manager.DBConnectionManager;

import javax.mail.MessagingException;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Human> all;

    public static String[] a;// we need this for the piechart

    public static void main(String[] args) throws IllegalAccessException {
        //this is how the create user will work
//        User leonidas =  new User("","123467","leonidasdiam2001@gmail.com","Leonidas Diamantopoulos");

//        try {
//            Human leonidas = new Human("Leonidas","Diamantopoulos","154267985","leodiam@gmail.com","male","University","Student");
//            DBConnectionManager manager = new DBConnectionManager();
//        DaoImpl impl = new DaoImpl(manager);
//        impl.insertHuman(leonidas,"AUEB");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        //launch(args);


     GuiClass wsFrame = new GuiClass();
        wsFrame.setBounds(400, 100, 900, 700);
        wsFrame.setVisible(true);
        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a = args;// we need this for the piechart


    }
      /*@Override public void start(Stage stage) {
            Scene scene = new Scene(new Group());
            stage.setTitle("Statistical Analysis");
            stage.setWidth(500);
            stage.setHeight(500);
     
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                    		new PieChart.Data("Nursing Home",10),
                    		new PieChart.Data("University", 25),
                            new PieChart.Data("Labor", 30),
                            new PieChart.Data("School", 35));
            final PieChart chart = new PieChart(pieChartData);
            chart.setTitle("Covid-19 Cases per Organization");
            //if (covid.app.gui.bool.ship.GuiClass.b == 0) 
            ((Group) scene.getRoot()).getChildren().add(chart);
            	stage.setScene(scene);
                stage.show();
        }*/
}
