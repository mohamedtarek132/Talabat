package Talabat.Controllers;

import Talabat.Classes.CreditCard;
import Talabat.Classes.User;
import Talabat.Exceptions.SignUpException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
    @FXML
    private TextField editableAddress;
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
    private Button confirm;
    @FXML
    private Button editInfoButton;
    @FXML
    private Rectangle areYouSurePage;
    @FXML
    private Button yesButtonAddress;
    @FXML
    private Button yesButtonCreditCard;
    @FXML
    private Button noButton;
    @FXML
    private Text text1;
    @FXML
    private Text text2;
    private boolean addAddressChecker = false;

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
        if (!user.getCreditCards().isEmpty()) {
            creditCard.setValue(user.getCreditCards().get(0).getCardNumber());
        }
        for (CreditCard cardNumber : user.getCreditCards()) {
            creditCard.getItems().add(cardNumber.getCardNumber());
            System.out.println(cardNumber.getCardNumber());
            System.out.println(1);
        }
        editableAddress.setVisible(false);
        confirm.setVisible(false);
        areYouSurePage.setVisible(false);
        text1.setVisible(false);
        text2.setVisible(false);
        yesButtonCreditCard.setVisible(false);
        yesButtonAddress.setVisible(false);
        noButton.setVisible(false);
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
        confirm.setVisible(true);
        editInfoButton.setVisible(false);
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

    public void addAddress(ActionEvent event) {
        address.setVisible(false);
        editableAddress.setVisible(true);
        addAddressChecker = true;
        editInfo(event);
    }

    public void confirm(ActionEvent event) {
        String exception = "";
        long phoneNumber1 = 0;
        try {
            if (addAddressChecker) {
                user.signUp(firstName.getText(), lastName.getText(), email.getText(), password.getText(), genderChoiceBox.getValue(),
                        phoneNumber.getText(), country.getText(), editableAddress.getText(), false);
            } else {
                user.signUp(firstName.getText(), lastName.getText(), email.getText(), password.getText(), genderChoiceBox.getValue(),
                        phoneNumber.getText(), country.getText(), address.getValue(), false);
            }
            UserInformationPageController.setUser(user);
            reset(event);
        } catch (SignUpException signUpException) {
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
        } else if (exception.contains("same e")) {
            emailEmptyField.setText("This email is used by another user!");
            emailEmptyField.setOpacity(1);
        } else {
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

    public void removeAddress(ActionEvent event) {
        areYouSurePage.setVisible(true);
        text1.setVisible(true);
        text2.setVisible(true);
        yesButtonCreditCard.setVisible(false);
        yesButtonAddress.setVisible(true);
        noButton.setVisible(true);
        text2.setText("this address?");
        boolean value = false;
        email.setEditable(value);
        password.setEditable(value);
        phoneNumber.setEditable(value);
        country.setEditable(value);
        firstName.setEditable(value);
        lastName.setEditable(value);

    }

    public void removeCreditCard(ActionEvent event) {
        areYouSurePage.setVisible(true);
        text1.setVisible(true);
        text2.setVisible(true);
        yesButtonCreditCard.setVisible(true);
        yesButtonAddress.setVisible(false);
        noButton.setVisible(true);
        text2.setText("this credit card?");

        boolean value = false;
        email.setEditable(value);
        password.setEditable(value);
        phoneNumber.setEditable(value);
        country.setEditable(value);
        firstName.setEditable(value);
        lastName.setEditable(value);


    }

    public void removeCreditCard1(ActionEvent event) {
        int index = 0;
        for (int i = 0; i < user.getCreditCards().size(); i++) {
            if (user.getCreditCards().get(i).getCardNumber().equals(creditCard.getValue())) {
                index = i;
                break;
            }

        }
        user.getCreditCards().remove(index);
        reset(event);
    }

    public void removeAddress1(ActionEvent event) {
        int index = 0;
        for (int i = 0; i < user.getAddress().size(); i++) {
            if (user.getAddress().get(i).equals(address.getValue())) {
                index = i;
                break;
            }

        }
        user.getAddress().remove(index);
        reset(event);
    }

    public void reset(ActionEvent event) {
        email.setText(user.getEmail());
        password.setText(user.getPassword());
        phoneNumber.setText(Long.toString(user.getPhoneNumber()));
        country.setText(user.getCountry());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        genderChoiceBox.setValue(user.getGender());
        address.getItems().clear();
        if (!user.getAddress().isEmpty()) {
            address.setValue(user.getAddress().get(0));
        }
        for (String addresses : user.getAddress()) {
            System.out.println(addresses);
            address.getItems().add(addresses);
        }
        creditCard.getItems().clear();
        if (!user.getCreditCards().isEmpty()) {
            creditCard.setValue(user.getCreditCards().get(0).getCardNumber());
        }
        for (CreditCard cardNumber : user.getCreditCards()) {
            creditCard.getItems().add(cardNumber.getCardNumber());
            System.out.println(cardNumber.getCardNumber());
            System.out.println(1);
        }
        address.setVisible(true);
        editInfoButton.setVisible(true);
        editableAddress.setVisible(false);
        confirm.setVisible(false);
        areYouSurePage.setVisible(false);
        text1.setVisible(false);
        text2.setVisible(false);
        yesButtonCreditCard.setVisible(false);
        yesButtonAddress.setVisible(false);
        noButton.setVisible(false);
        addAddressChecker = false;
    }
}
