package Talabat;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageController implements Initializable {
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
    private TextField address;
    @FXML
    private TextField country;
    @FXML
    private Text emailEmptyField;
    @FXML
    private Text firstNameEmptyField;
    @FXML
    private Text lastNameEmptyField;
    @FXML
    private Text passwordEmptyField;
    @FXML
    private Text genderEmptyField;
    @FXML
    private Text phoneNumberEmptyField;
    @FXML
    private Text addressEmptyField;
    @FXML
    private Text countryEmptyField;
    @FXML
    private Text tying;
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    private User user = new User();
    @FXML
    public void signUp(ActionEvent event){
        String exception = "";
        long phoneNumber1 = 0;
        try {
            user.signUp(firstName.getText(),lastName.getText(), email.getText(), password.getText(),genderChoiceBox.getValue(),
                    phoneNumber.getText(),country.getText(), address.getText());
            tying.setOpacity(1);
        }
        catch (SignUpException signUpException) {
            exception = signUpException.getMessage();
        }
        if (exception.contains("first name")) {
            firstNameEmptyField.setOpacity(1);
        } else {
            firstNameEmptyField.setOpacity(0);
        }
        if (exception.contains("last name")) {
            lastNameEmptyField.setOpacity(1);
        } else {
            lastNameEmptyField.setOpacity(0);
        }
        if (exception.contains("password")) {
            passwordEmptyField.setOpacity(1);
        } else {
            passwordEmptyField.setOpacity(0);
        }
        if (exception.contains("country")) {
            countryEmptyField.setOpacity(1);
        } else {
            countryEmptyField.setOpacity(0);
        }
        if (exception.contains("gender")) {
            genderEmptyField.setOpacity(1);
        } else {
            genderEmptyField.setOpacity(0);
        }
        if (exception.contains("email")) {
            emailEmptyField.setText("This field can't be empty!");
            emailEmptyField.setOpacity(1);
        } else if (exception.contains("@ or .com")) {
            emailEmptyField.setText("Please enter a valid email!");
            emailEmptyField.setOpacity(1);
        }else if (exception.contains("same e")){
            emailEmptyField.setText("This email is used by another user!");
            emailEmptyField.setOpacity(1);
        }else {
            emailEmptyField.setOpacity(0);
        }
        if (exception.contains("phone number")) {
            phoneNumberEmptyField.setText("This field can't be empty!");
            phoneNumberEmptyField.setOpacity(1);
        } else if (exception.contains("char in number")) {
            phoneNumberEmptyField.setText("You can not enter characters here only numbers");
            phoneNumberEmptyField.setOpacity(1);
        } else if (exception.contains("not a valid number")) {
            phoneNumberEmptyField.setText("Please eneter a valid number");
            phoneNumberEmptyField.setOpacity(1);
        } else if (exception.contains("same number")) {
            phoneNumberEmptyField.setText("This number is used by another user!");
            phoneNumberEmptyField.setOpacity(1);
        } else {
            phoneNumberEmptyField.setOpacity(0);
        }
        if (exception.contains("address")) {
            addressEmptyField.setOpacity(1);
        } else {
            addressEmptyField.setOpacity(0);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderChoiceBox.getItems().addAll("Male", "Female");
    }
    public void switchTo(ActionEvent ae){

    }
}
