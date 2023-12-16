package Classes;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminFx extends Application {
@FXML
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/Controllers/AdminDashboard.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e)
        {
            System.out.println("there is a problem");
            e.printStackTrace();

        }


    }
}
