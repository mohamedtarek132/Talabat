package Talabat.Controllers;

import Talabat.Classes.Admin;
import Talabat.Classes.Customer;
import Talabat.Exceptions.EmailOrPasswordException;
import Talabat.Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInPageController {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Text errorMessage;
    private User user;

    @FXML
    public void signIn(ActionEvent event) {
        try {
            user = User.signIn(email.getText(), password.getText());
            errorMessage.setOpacity(0);
            UserInformationPageController.setUser(user);
            if(user instanceof Customer){
                switchToMainMenu(event);
            }else if(user instanceof Admin){
                System.out.println(1);
                switchToAdminDashboard(event);
            }
        } catch (EmailOrPasswordException emailOrPasswordException) {
            errorMessage.setOpacity(1);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void switchToSignUpPage(ActionEvent ae) throws IOException {
        Stage stage;
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/SignUp.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainMenu(ActionEvent ae) throws IOException {
        Stage stage;
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAdminDashboard(ActionEvent ae) throws IOException {
        Stage stage;
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/AdminDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}