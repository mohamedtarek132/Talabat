package Talabat.Controllers;

import Talabat.Classes.Payment;
import Talabat.Classes.Wallet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WalletController {
    Double baLance;
    @FXML
    private TextField amountmonyTextfield;
    @FXML
    private Label balancelabel;
    @FXML
    private ListView<String> mylistview;
    @FXML
    private Label Errorlabel;
    private final List<Payment> TransactionsList = new ArrayList<>();
    private final Wallet wallet = new Wallet();

    public void Addmoney(ActionEvent event) {
        try {

            String amountstr = amountmonyTextfield.getText();
            double amount = Double.parseDouble(amountmonyTextfield.getText());
            if (amount > 0) {
                wallet.addFunds(amount);
                String balance = String.valueOf(getbalance());
                Errorlabel.setText("");
                balancelabel.setText("EGB\t" + balance);
            } else {
                Errorlabel.setText("Please Enter a valid positive amount");
            }

        } catch (Exception E) {
            Errorlabel.setText("Please Enter valid amount");
            System.out.println(E);
        }
    }


    public void Transactions(ActionEvent o) {
        List<Payment> transactionList = wallet.getTransaction();
        mylistview.getItems().clear();

        for (Payment transaction : transactionList) {
            mylistview.getItems().add(transaction.toString());
        }
    }

    public double getbalance() {
        return wallet.getBalance();
    }

    public void switchToMainMenu(ActionEvent ae) throws IOException {
        Stage stage;
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
