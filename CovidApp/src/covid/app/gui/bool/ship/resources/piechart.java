package covid.app.gui.bool.ship.resources;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
 
public class piechart extends Application {
	// we will insert to this variables the total number of
	//cases per Organization
	private int nhcases = 55;
	private int uncases = 150;
	private int lbcases = 100;
	private int sccases = 222;
	
 
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Statistical Analysis");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Nursing Home", nhcases),
                new PieChart.Data("University", uncases),
                new PieChart.Data("Labor", lbcases),
                new PieChart.Data("School", sccases));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Covid-19 Cases per Organization");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
        //launch(covid.app.main.app.boolship.Main.a);
    }
 
}
