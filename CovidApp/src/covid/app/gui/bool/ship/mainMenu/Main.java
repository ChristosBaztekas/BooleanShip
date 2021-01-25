package covid.app.gui.bool.ship.mainMenu;


import javax.swing.*;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        GuiClass wsFrame = new GuiClass();
        wsFrame.setBounds(400, 100, 900, 700);
        wsFrame.setVisible(true);
        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
