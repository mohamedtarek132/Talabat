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


//    public void switchToMainMenuScene(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("MainMenuScene.fxml"));
//        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    public void switchToRestaurantScene(ActionEvent event) throws IOException {
        System.out.println(getClass().getResource("../Fxmls/ListOfRestaurants.fxml"));
        root = FXMLLoader.load(getClass().getResource("../Fxmls/ListOfRestaurants.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOrderScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Fxmls/PreviousOrders.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCartScene(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("../Fxmls/SignUp.fxml"));
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

    public void SwitchTOSighInPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Fxmls/SignIn.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToWalletScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Fxmls/Wallet.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
