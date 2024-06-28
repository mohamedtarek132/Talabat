package Talabat.Controllers;

import Talabat.Classes.Payment;
import Talabat.Classes.Wallet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controllerwallet  {
    @FXML
   private TextField amountmonyTextfield;
    @FXML
   private Label balancelabel;
    @FXML
   private ListView<String>mylistview;
    @FXML
    private Label Errorlabel;
    private List<Payment>TransactionsList=new ArrayList<>();
    Double baLance;
    private Wallet wallet = new Wallet();
    public void Addmoney(ActionEvent event) {
        try {

            String amountstr = amountmonyTextfield.getText();
            double amount = Double.parseDouble(amountmonyTextfield.getText());
            if(amount>0) {
                wallet.addFunds(amount);
                String balance = String.valueOf(getbalance());
                Errorlabel.setText("");
                balancelabel.setText("EGB\t" + balance);
            }
            else {
                Errorlabel.setText("Please Enter a valid positive amount");
            }

        } catch (Exception E) {
            Errorlabel.setText("Please Enter valid amount");
            System.out.println(E);
        }
    }


    public void Transactions(ActionEvent o){
        List<Payment> transactionList = wallet.getTransaction();
        mylistview.getItems().clear();

        for (Payment transaction : transactionList) {
            mylistview.getItems().add(transaction.toString());
        }
    }

    public double getbalance()
    {
        return wallet.getBalance();
    }
}
