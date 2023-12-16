package Talabat.Classes;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private double balance;
    private User user;
    private List<Payment> transaction;

    public Wallet(double balance,User user) {
        this.balance = balance;
        this.user =user;
        this.transaction = new ArrayList<>();

    }
    public Wallet() {
        this.balance = 0;
        this.user = null;
        this.transaction = new ArrayList<>();

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double baLanCe) {
        this.balance = baLanCe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Funds added successfully.");

        } else {
            System.out.println("Invalid amount for adding funds.");
        }
    }

    public Boolean deductFunds(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Funds deducted successfully. ");
            return true;
        } else {
            System.out.println("Invalid amount");
            return false;
        }
    }

    public List<Payment> getTransaction() {
        return transaction;
    }

}




