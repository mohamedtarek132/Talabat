package Talabat.Classes;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreditCard {

    private static User user;
    private String cardnumber;
    private int cvv;
    private String cardholdername;
    private String type;
    private String expirationdate;

    public CreditCard(String cardnumber, int cvv, String cardholdername, String expirationdate) {
        this.cvv = cvv;
        this.cardnumber = cardnumber;
        this.expirationdate = expirationdate;
        this.type = identifyCreditCardType(cardnumber);
        this.cardholdername = cardholdername;
    }


    public CreditCard() {

    }

    public static void setUser(User user1) {
        user = user1;
    }

    @FXML
    public String getCardNumber() {
        return cardnumber;
    }

    @FXML
    public void setCardNumber(String cardNumber) {
        this.cardnumber = cardNumber;
    }

    @FXML
    public long getCvv() {
        return cvv;
    }

    @FXML
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @FXML
    public String getCardholderName() {
        return cardholdername;
    }

    @FXML
    public void setCardholderName(String cardholderName) {
        this.cardholdername = cardholderName;
    }

    @FXML
    public String getExpirationDate() {
        return expirationdate;
    }

    @FXML
    public void setExpirationDate(String expirationDate) {
        this.expirationdate = expirationDate;
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
    public String getType() {
        return type;
    }

    private Boolean IsValidCardNumber(String cardnumber) {
        return !cardnumber.isEmpty() && cardnumber.matches("\\d+") && (cardnumber.length() == 16);
    }

    private Boolean IsValidCVV(int cvv) {
        String cvv_str = String.valueOf(cvv);
        return cvv_str.length() == 3;

    }

    private boolean isCardExist(String cardnumber) {
        for (User user : User.getUsers()) {
            for (CreditCard existingCard : user.getCreditCards()) {
                if (existingCard.getCardNumber().equals(cardnumber)) {
                    return true;
                }
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

    public void setcreditcard(int index, String cardnumber, int cvv, String cardholdername, String expirationdate) {
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

            user.addCreditCard(cardnumber, cvv, cardholdername, expirationdate);
        } catch (Exception E) {
            System.out.println("Error" + E);
        }
    }

}

