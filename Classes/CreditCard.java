package Talabat.Classes;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Creditcard {

    private String cardnumber;
        private int cvv;
        private String cardholdername;
        //(visa,mastercard)نوع البطاقه
        private String type;
        private User user;


        private String expirationdate;
        public static List<Creditcard>creditcards=new ArrayList<>();

        public Creditcard(String cardnumber,  int cvv, String cardholdername, String expirationdate) {
            this.cvv = cvv;
            this.cardnumber = cardnumber;
            this.expirationdate = expirationdate;
            this.type = identifyCreditCardType(cardnumber);
        }

    public Creditcard() {

    }

    public static void setcreditcard(int index, String datum, String datum1, String datum2, String datum3) {
    }

    @FXML
    public void setCardNumber(String cardNumber) {
            this.cardnumber = cardNumber;
        }
@FXML
        public String getCardNumber() {
            return cardnumber;
        }
@FXML
        public void setCvv(int cvv) {
            this.cvv = cvv;
        }
@FXML
        public long getCvv() {
            return cvv;
        }
@FXML
        public void setCardholderName(String cardholderName) {
            this.cardholdername = cardholderName;
        }
@FXML
        public String getCardholderName() {
            return cardholdername;
        }
@FXML
        public void setExpirationDate(String expirationDate) {
            this.expirationdate = expirationDate;
        }
@FXML
        public String getExpirationDate() {
            return expirationdate;
        }

@FXML
        private String identifyCreditCardType(String cardnumber) {
            if (cardnumber.startsWith("4")) {
                return "Visa";
            } else if (cardnumber.startsWith("5")) {
                return "Mastercard";
            } else {
                return "Unknown";
            }

        }
        @FXML
        public String getType(){
            return type;
        }
        private Boolean IsValidCardNumber(String cardnumber){
         boolean n;
            n = !cardnumber.isEmpty() && cardnumber.matches("\\d+") && (cardnumber.length() == 16);
            return n;
        }
        private Boolean IsValidCVV(int cvv) {
            String cvvstr = String.valueOf(cvv);
            boolean c = !cvvstr.isEmpty() && cvvstr.length() == 3;
            return c;
        }
    private boolean isCardExist(String cardnumber) {
        for (Creditcard existingCard : creditcards) {
            if (existingCard.getCardNumber().equals(cardnumber)) {
                return true;
            }
        }
        return false;
    }
    private boolean isValidDateFormat(String expirationdate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            LocalDate.parse(expirationdate, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isExpired(String expirationdate) {
        if (!isValidDateFormat(expirationdate)) {
            return false;
        }
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        LocalDate expirationDate = LocalDate.parse(expirationdate, formatter);
        return currentDate.isAfter(expirationDate);
    }
    public  void  setcreditcard(int index, String cardnumber, int cvv, String cardholdername, String expirationdate) {
       try {


           if (!IsValidCardNumber(cardnumber)) {
               throw new Exception("Invalid card number, The card number should be a 16-digit numeric value.");
           }
           if (!IsValidCVV(cvv)) {
               throw new Exception("Invalid CVV, The CVV should be a 3-digit numeric value.");
           }
           if (isCardExist(cardnumber)) {
               throw new Exception("This card already exists.");

           }
           if (!isValidDateFormat(expirationdate)) {
               throw new Exception("Invalid date format,Please use MM/yy format.");
           }

           if (isExpired(expirationdate)) {
               throw new Exception("The credit card has expired.");
           }

           if (user == null) {
               throw new Exception("User is not initialized,Please set a user before adding a credit card.");
           }

           creditcards.add(new Creditcard(cardnumber, cvv, cardholdername, expirationdate));
           user.addCreditCard(cardnumber, cvv, cardholdername, expirationdate);
       }
       catch (Exception E){
           System.out.println("Error"+E);
       }
    }

}
