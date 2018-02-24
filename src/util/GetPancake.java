package util;

import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Johnny on 2/18/2017.
 */
public class GetPancake {

    private String palacinak = "";
    private int id = 0;
    private ArrayList<Integer> randomedIds = new ArrayList<Integer>();


    public static boolean getMyPancake(String type, int number){
        DbConnection dbh = DbConnection.getDbConnection();
        //Query used for selecting side stuff
        String sideQuery = "SELECT name FROM " + type + "_side ORDER BY RANDOM() LIMIT ?";
        try {
            //Gets main stuff from table, limited to one
            ResultSet resultSet = dbh.selectQuery("SELECT name FROM " + type + "_main ORDER BY RANDOM() LIMIT 1");
            String main = resultSet.getString(1);
            //Using wrapper for Prepare Statement, and returns result set
            ResultSet sideResults = dbh.prepareStatementQuery(sideQuery, number);
            String side = "";
            while (sideResults.next()) {
                String columnValue = sideResults.getString("name");
                side += columnValue +", ";
            }
            //Removes last coma from string
            side = side.substring(0, side.length() - 2);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,main + ", " + side);
        alert.setTitle("Izabrana palacinka");
        alert.showAndWait();

        } catch (SQLException e) {
            //Again if you fucked up
            Alert alert = new Alert(Alert.AlertType.ERROR,"Doslo je do greske, probaj ponovo");
            alert.setTitle("You fucked up!");
            alert.showAndWait();
            e.printStackTrace();
        }
        return true;
    }}
