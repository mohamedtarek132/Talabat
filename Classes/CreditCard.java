package Talabat.Classes;

public class CreditCard {
    private String cardNumber;
    private int cvv;
    private String cardholderName;
    //(visa,mastercard)نوع البطاقه
    private String type;

    private String expirationDate;

    public CreditCard(String cardNumber, int cvv, String cardholderName, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.type = type;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String identifyCreditCardTyBe(String cardNumber) {
        if (cardNumber.startsWith("4")) {
            return "Visa";
        } else if (cardNumber.startsWith("5")) {
            return "MasterCard";
        } else {
            return "Unknown";
        }

    }
}

