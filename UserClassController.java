package Talabat;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
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
    private User user = new User();
    @FXML
    public void signUp(ActionEvent event){
        try {
            user.signUp((String) email.getText(), (String) password.getText());
            user.setGender(gender.getText());
            user.setCountry(country.getText());
            user.setFirst_name(firstName.getText());
            user.setLastName(lastName.getText());
        }catch (SameEmailException exception){
            wrongEmail.setOpacity(1);
        }catch(EmptyFieldException exception){
            if(exception.getMessage().equals("first name")){

            }
        }
    }
}
