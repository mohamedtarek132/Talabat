package Talabat.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToMainMenuScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRestaurantScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RestaurantScene.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOrderScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("OrderScene.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCartScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Fxmls/SignUp.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserInfoScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Fxmls/UserInformationPage.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
