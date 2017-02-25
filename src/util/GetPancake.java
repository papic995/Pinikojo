package util;

import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Johnny on 2/18/2017.
 */
public class GetPancake {

    private String palacinak = "";
    private int id = 0;
    private ResultSet resultSet = null;
    private DbConnection dbh = DbConnection.getDbConnection();
    private ArrayList<Integer> randomedIds = new ArrayList<Integer>();
    public static void selectedChecker(ToggleGroup izbor, int number) throws Exception {
        boolean result = ((((RadioButton) izbor.getSelectedToggle()).getText().equals("Slatka") ? new GetPancake().getSweet(number) : ((RadioButton) izbor.getSelectedToggle()).getText().equals("Samo nek je random") ? new GetPancake().getRandom(number) : new GetPancake().getSalty(number)));
    }

    private boolean getSweet(int number) throws Exception{
        this.id = GetRandomNumber.RandomNumber(4);
        this.resultSet = this.dbh.selectQuery("SELECT name FROM main_slatki WHERE id ='" + this.id + "';");
        while (this.resultSet.next()) {
            String columnValue = this.resultSet.getString("name");
            this.palacinak += columnValue +", ";
        }
        while (number !=0) {
            do {
                this.id = GetRandomNumber.RandomNumber(7);
            }while (this.randomedIds.contains(this.id) == true);
            this.randomedIds.add(this.id);
            this.resultSet = this.dbh.selectQuery("SELECT name FROM add_slatki WHERE id ='" + this.id + "';");
            while (this.resultSet.next()) {
                String columnValue = this.resultSet.getString("name");
                this.palacinak += columnValue +", ";
            }
            number--;
        }
        this.palacinak = this.palacinak.substring(0,this.palacinak.length() - 2);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,this.palacinak);
        alert.setTitle("Izabrana palacinka");
        alert.showAndWait();
        return true;
    }

    private boolean getSalty(int number) throws Exception{
        this.id = GetRandomNumber.RandomNumber(3);
        this.resultSet = this.dbh.selectQuery("SELECT name FROM main_slani WHERE id ='" + this.id + "';");
        while (this.resultSet.next()) {
            String columnValue = this.resultSet.getString("name");
            this.palacinak += columnValue +", ";
        }
        while (number !=0) {
            do {
                this.id = GetRandomNumber.RandomNumber(6);
            }while (this.randomedIds.contains(this.id) == true);
            this.randomedIds.add(this.id);
            this.resultSet = this.dbh.selectQuery("SELECT name FROM add_slani WHERE id ='" + this.id + "';");
            while (this.resultSet.next()) {
                String columnValue = this.resultSet.getString("name");
                this.palacinak += columnValue +", ";
            }
            number--;
        }
        this.palacinak = this.palacinak.substring(0,this.palacinak.length() - 2);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,palacinak);
        alert.setTitle("Izabrana palacinka");
        alert.showAndWait();
        return true;
    }

    private boolean getRandom(int number) throws Exception {
        int mainRand = GetRandomNumber.RandomNumber(10);
        if (mainRand < 5) {
            this.id = GetRandomNumber.RandomNumber(3);
            this.resultSet = this.dbh.selectQuery("SELECT name FROM main_slani WHERE id ='" + this.id + "';");
            while (this.resultSet.next()) {
                String columnValue = this.resultSet.getString("name");
                this.palacinak += columnValue + ", ";
            }
        }else {
            this.id = GetRandomNumber.RandomNumber(4);
            this.resultSet = this.dbh.selectQuery("SELECT name FROM main_slatki WHERE id ='" + this.id + "';");
            while (this.resultSet.next()) {
                String columnValue = this.resultSet.getString("name");
                this.palacinak += columnValue +", ";
            }
        }
        int sideRand = 0;
        while (number !=0) {
            sideRand = GetRandomNumber.RandomNumber(10);
            if (sideRand < 5) {
                do {
                    this.id = GetRandomNumber.RandomNumber(6);
                } while (this.randomedIds.contains(this.id) == true);
                this.randomedIds.add(this.id);
                this.resultSet = this.dbh.selectQuery("SELECT name FROM add_slani WHERE id ='" + this.id + "';");
                while (resultSet.next()) {
                    String columnValue = resultSet.getString("name");
                    this.palacinak += columnValue + ", ";
                }
            } else {
                do {
                    this.id = GetRandomNumber.RandomNumber(6);
                } while (this.randomedIds.contains(this.id) == true);
                this.randomedIds.add(this.id);
                this.resultSet = this.dbh.selectQuery("SELECT name FROM add_slatki WHERE id ='" + this.id + "';");
                while (this.resultSet.next()) {
                    String columnValue = this.resultSet.getString("name");
                    this.palacinak += columnValue + ", ";
                }
            }
            number--;
        }
        this.palacinak = this.palacinak.substring(0,this.palacinak.length() - 2);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,palacinak);
        alert.setTitle("Izabrana palacinka");
        alert.showAndWait();
        return true;
    }
}
