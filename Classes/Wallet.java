package Talabat.Classes;

package com.example.demo1;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private User user;
    private double baLanCe;
    List<Payment> Transaction = new ArrayList<>();


    public Wallet(User user, double baLanCe) {
        this.baLanCe = baLanCe;
        this.user = user;
        this.Transaction = new ArrayList<>();

    }

    public Wallet() {

    }

    public double getBalance() {
        return baLanCe;
    }

    public void setBalance(double baLanCe) {
        this.baLanCe = baLanCe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addFunds(double amount) {

        this.baLanCe += amount;

    }

    public Boolean deductFunds(double amount) {
        if (this.baLanCe >= amount) {
            this.baLanCe -= amount;

            return true;
        } else {
            return false;
        }
    }

    public List<Payment> getTransaction() {
        return Transaction;
    }


}



