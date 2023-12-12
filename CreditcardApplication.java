package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreditApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Creditcard creditcard = new Creditcard("1234567891234567", "123", "Mohammed Allam", "12/23");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));
        Parent root = loader.load();
        CreditcardController controller = loader.getController();
       //controller.setCreditcard(creditcard);
        primaryStage.setTitle("CreditCard");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }

    public static void main (String[]args){
        launch(args);
    }

}
