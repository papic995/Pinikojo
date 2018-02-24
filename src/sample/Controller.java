package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import util.GetPancake;
import util.GetRandomNumber;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML private Button submit;
    @FXML private TextField prilozi;
    @FXML private ToggleGroup izbor;
    @FXML private CheckBox trueRandom;
    @Override
    public void initialize (URL location, ResourceBundle resources) {

        System.out.println(trueRandom.isSelected());
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Try catch for any sort of bad user input
                try {
                    //I'll just leave this one everyone needs one ternary operator by project
                    int number = (trueRandom.isSelected()) ? GetRandomNumber.RandomNumber(7) : Integer.parseInt(prilozi.getText());
                    //Can't find better way if its JavaFX Select Toggle, and since it's i don't want to make changes to GUI, and XML file, fuck it will just cast it to anything I want. ONLY GOD CAN JUDGE ME!
                    String type =  ((RadioButton) izbor.getSelectedToggle()).getText().toLowerCase();
                    GetPancake.getMyPancake(type, number);
                } catch (Exception e) {
                    e.printStackTrace();
                    //Meh don't know what you fucked up and got this, just try again
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Doslo je do greske, probaj ponovo");
                    alert.setTitle("You fucked up!");
                    alert.showAndWait();

                }
            }
        });
    }
}
