package Talabat.Controllers;

import Talabat.Classes.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserInformationPageController implements Initializable {
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
    private static User user;
    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        email.setText(user.getEmail());
        password.setText(user.getPassword());
        phoneNumber.setText(Long.toString(user.getPhoneNumber()));
        country.setText(user.getCountry());
        firstName.setText(user.getFirst_name());
        lastName.setText(user.getLastName());
        genderChoiceBox.setValue(user.getGender());
        address.setValue(user.getAddress().get(0));
        for (String addresses: user.getAddress() ) {
            System.out.println(addresses);
            address.getItems().add(addresses);
        }
//        email.setFocusTraversable(false);
    }

    public static void setUser(User user) {
        UserInformationPageController.user = user;
    }
}
