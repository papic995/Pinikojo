package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
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
                try {
                    int number = (trueRandom.isSelected()) ? GetRandomNumber.RandomNumber(5) : Integer.parseInt(prilozi.getText());
                    GetPancake.selectedChecker(izbor, number);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
