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
        private Creditcard creditcard;

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    private List<Creditcard> creditcards=new ArrayList<>();
        public void setCreditcard(Creditcard creditcard) {
            this.creditcard = creditcard;


        }

        public void Submit(ActionEvent event) {
            try {

                String cardnumber = cardnumberTextField.getText();
                String cardholders = cardholdernameTextField.getText();
                String cvvtex = cvvTextField.getText();
                String expirationdate=expirationdateTextField.getText();
                String cardtype = identifyCreditCardType(cardnumber);
                cardTypeLabel.setText(cardtype);
                userinputcardnumber=cardnumber;
       if(cardnumber.isEmpty()){
           cardnumberlabel.setText("Card Number is required");
       }
              else  if (cardnumber.length() < 16||!cardnumber.matches("\\d+")) {
                    cardnumberlabel.setText("Card number is invalid.");
                }
                else {
                    cardnumberlabel.setText("");
                }
                if (cardholders.isEmpty()) {
                    cardholderslabel.setText("Cardholder name is required.");
                } else {
                    cardholderslabel.setText("");
                }
                if(expirationdate.isEmpty()){
                    expirationdatelabel.setText("Expiration Date is required");
                }
               else if(expirationdate.length() != 5){
                    expirationdatelabel.setText("Expiration Date is invalid");

                }
                else{
                    expirationdatelabel.setText("");
                }
                if(cvvtex.isEmpty()){
                    cvvlabel.setText("CVV is require");
                }
             else if (cvvtex.length() != 3){
                    cvvlabel.setText("CVV is invalid");
                }
                else{
                    cvvlabel.setText("");
                }
                int cvv=Integer.parseInt(cvvtex);
                for (Creditcard existingCard : creditcards) {

                    if (existingCard.getCardNumber().equals(cardnumber)) {
                        cardnumberlabel.setText("This card already exists.");

                    }
                }
                creditcard = new Creditcard(cardnumber, cvv, cardholders, expirationdate);
                creditcards.add(creditcard);
                user.addCreditCard(cardnumber,cvv,cardholders,expirationdate);
                cardnumberlabel.setText("");
                return;
            }
            catch (Exception e){
                System.out.println(e);
            }


            }




        public Creditcard getCreditcard() {
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
