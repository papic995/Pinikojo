package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pancake Picker pre alpha");
        FXMLLoader fxmlLoader = new FXMLLoader();
        primaryStage.setScene(new Scene(root, 600, 400));
        Controller Controller = fxmlLoader.getController();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
