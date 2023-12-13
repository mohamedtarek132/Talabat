package Talabat.Controllers;

import Talabat.Classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class CreditcardController {
    @FXML
    private Button Submit;
    @FXML
    private Label cardnumberlabel;
    @FXML
    private Label cardholderslabel;
    @FXML
    private Label expirationdatelabel;
    @FXML
    private Label cardTypeLabel;
    @FXML
    private Label cvvlabel;
    @FXML
    private TextField cardnumberTextField; // Add these fields
    @FXML
    private TextField cvvTextField;
    @FXML
    private TextField expirationdateTextField;
    @FXML
    private TextField cardholdernameTextField;
    String userinputcardnumber;
    @FXML
    private TextField cardtypeTextField;
    private CreditCard creditcard;
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    private final List<CreditCard> creditcards = new ArrayList<>();

    public void setCreditcard(CreditCard creditcard) {
        this.creditcard = creditcard;


    }

    public void Submit(ActionEvent event) {
        try {
            String cardnumber = cardnumberTextField.getText();
            String cardholders = cardholdernameTextField.getText();
            String cvv = cvvTextField.getText();
            String expirationdate = expirationdateTextField.getText();
            String cardtype = identifyCreditCardType(cardnumber);
            cardTypeLabel.setText(cardtype);
            userinputcardnumber = cardnumber;

            if (cardnumber.length() < 16 || !cardnumber.matches("\\d+")) {
                cardnumberlabel.setText("Card number is invalid.");
                return;
            } else {
                cardnumberlabel.setText("");
            }
            if (cardholders.isEmpty()) {
                cardholderslabel.setText("Cardholder name is required.");
                return;
            } else {
                cardholderslabel.setText("");
            }
            if (expirationdate.length() != 5) {
                expirationdatelabel.setText("Expiration Date is invalid");
                return;
            } else {
                expirationdatelabel.setText("");
            }
            if (cvv.length() != 3) {
                cvvlabel.setText("CVV is invalid");
            } else {
                cvvlabel.setText("");
            }
            for (CreditCard existingCard : creditcards) {
                if (existingCard.getCardNumber().equals(cardnumber)) {
                    cardnumberlabel.setText("This card already exists.");
                    return;
                }
            }
            // Create a new credit object
            creditcard = new CreditCard(cardnumber, Integer.parseInt(cvv), cardholders, expirationdate);
            // Add the new card to the list
            creditcards.add(creditcard);
            user.addCreditCard(cardnumber, Integer.parseInt(cvv), cardholders, expirationdate);
            cardnumberlabel.setText("");
            // cardholdernameTextField.clear();
            //cardnumberTextField.clear();
            ///expirationdateTextField.clear();
            // cardTypeLabel.setText("");
            //cvvTextField.clear();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public CreditCard getCreditcard() {
        return creditcard;
    }

    public String getCardNumber() {
        return userinputcardnumber;
    }

    private String identifyCreditCardType(String cardNumber) {
        if (cardNumber.startsWith("4")) {
            return "Visa";
        } else if (cardNumber.startsWith("5")) {
            return "Mastercard";
        } else {
            return "Unknown";
        }

    }

}
