package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ToFxml {

    public void ToFxml(String fxmlname, String name,Stage First) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlname));

            Parent root = (Parent) fxmlLoader.load();
            //init stage
            Stage mainStage = new Stage();
            mainStage.setTitle(name);
            mainStage.setScene(new Scene(root));
            First.close();
            mainStage.show();
        } catch (IOException e) {

        }
    }
}
