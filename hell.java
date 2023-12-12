package Talabat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class hell extends Application {
    public static void main(String[] args) {
        launch(args);
        AnchorPane d = new AnchorPane();
        System.out.println("yayyy23");
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
            try {
                File myObj = new File("C:\\Users\\hp\\Documents\\Programming projects\\Java Projects\\Talabat\\userInfo.txt");
                Scanner myReader = new Scanner(myObj);
                int i = 0;
                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split(",");
                    User.setUsers(Integer.parseInt(data[0]),data[1], data[2], data[3], data[4], data[5],Long.parseLong(data[6]), data[7]);
                    i++;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            Scene scene = new Scene(root, Color.LIGHTBLUE);
            primaryStage.setTitle("Hell");

            primaryStage.setScene(scene);
            primaryStage.show();
    }
}
