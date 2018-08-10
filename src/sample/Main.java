package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
static Stage FirstStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Email Sender");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        FirstStage=primaryStage;


}

        public static void main(String[]args){
            launch(args);
        }
    }


