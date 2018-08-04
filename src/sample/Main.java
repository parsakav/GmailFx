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

    /*    new Timer().schedule(new TimerTask() {

            public void run() {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Second.fxml"));

                    Parent root =(Parent) fxmlLoader.load();
                    Stage mainStage = new Stage();
                    mainStage.setTitle("");
                    mainStage.setScene(new Scene(root));

                    primaryStage.close();
                    mainStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //init stage

            }
        }, 3000); */

}

        public static void main(String[]args){
            launch(args);
        }
    }


