package Talabat.Controllers;

import Talabat.Classes.CreditCard;
import Talabat.Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserInformationPageController implements Initializable {
    @FXML
    private static User user;
    @FXML
    private TextField email;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField password;
    @FXML
    private TextField phoneNumber;
    @FXML
    private ChoiceBox<String> address;
    @FXML
    private TextField country;
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    @FXML
    private ChoiceBox<String> creditCard;

    public static void setUser(User user) {
        UserInformationPageController.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        email.setText(user.getEmail());
        password.setText(user.getPassword());
        phoneNumber.setText(Long.toString(user.getPhoneNumber()));
        country.setText(user.getCountry());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        genderChoiceBox.setValue(user.getGender());
        address.setValue(user.getAddress().get(0));
        for (String addresses : user.getAddress()) {
            System.out.println(addresses);
            address.getItems().add(addresses);
        }
        creditCard.setValue(user.getCreditCards().get(0).getCardNumber());
        for (CreditCard cardNumber : user.getCreditCards()) {
            creditCard.getItems().add(cardNumber.getCardNumber());
            System.out.println(cardNumber.getCardNumber());
            System.out.println(1);
        }
//        email.setFocusTraversable(false);
    }

    public void switchToMainMenu(ActionEvent ae) throws IOException {
        Stage stage;
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void editInfo(ActionEvent event) {
        boolean value = true;
        email.setEditable(value);
        password.setEditable(value);
        phoneNumber.setEditable(value);
        country.setEditable(value);
        firstName.setEditable(value);
        lastName.setEditable(value);
        genderChoiceBox.getItems().addAll("Male", "Female");
    }

    public void switchToCreditCard(ActionEvent event) throws IOException {
        CreditcardController.setUser(user);
        Stage stage;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/Creditcard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
