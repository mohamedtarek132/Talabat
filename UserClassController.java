package Talabat;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UserClassController {
    @FXML
    private TextField email;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField password;
    @FXML
    private TextField gender;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField address;
    @FXML
    private TextField country;
    @FXML
    private Text wrongEmail;
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
    private User user = new User();
    @FXML
    public void signUp(ActionEvent event){
        boolean numberformatexception = false;
        String exception = "";
        long phoneNumber1 = 0;
        try {
            user.signUp(firstName.getText(),lastName.getText(), email.getText(), password.getText(),gender.getText(),
                    phoneNumber.getText(),country.getText(), address.getText());
        }catch(NumberFormatException exception1){
            phoneNumberEmptyField.setText("You can not enter characters here only numbers");

            numberformatexception = true;
        }
        catch (SignUpException emptyFieldException) {
            exception = emptyFieldException.getMessage();
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
            emailEmptyField.setOpacity(1);
        } else if (exception.contains("same email")){
            emailEmptyField.setText("This email is used by another user!");
            emailEmptyField.setOpacity(1);
        }else {
            emailEmptyField.setOpacity(0);
        }
        if (exception.contains("phone number")) {
            phoneNumberEmptyField.setOpacity(1);
        } else if (exception.contains("char in number")) {
            phoneNumberEmptyField.setText("You can not enter characters here only numbers");
        } else {
            phoneNumberEmptyField.setOpacity(0);
        }
        if (exception.contains("address")) {
            addressEmptyField.setOpacity(1);
        } else {
            addressEmptyField.setOpacity(0);
        }

    }
}
