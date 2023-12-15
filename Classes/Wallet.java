package Talabat.Classes;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private double balance;
   private User user;

   private List<Payment> transaction;
  public static   List<Wallet>wallets=new ArrayList<>();

    public Wallet(double balance ){
        this.balance =balance;
        this.user=null;
        this.transaction =new ArrayList<>();

    }
    public Wallet(User user,double balance){
        this.balance=balance;
        this.user=user;
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

        }
        else{
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
    public void setWallets(int index ,double baLanCe){
        wallets.add(new Wallet(balance));
    }


}



