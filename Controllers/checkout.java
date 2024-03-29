package Talabat.Controllers;
import Talabat.Classes.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class checkout implements Initializable {
    @FXML
    Label total;
    @FXML
    Label item;
    @FXML
    Label number_of_items;
    @FXML
    Label shiping;
    @FXML
    RadioButton rb_credit;
    @FXML
    RadioButton rb_wallet;
    @FXML
    RadioButton cash;
    @FXML
    Label order_details;
    @FXML
    Label Total_4;
    @FXML
    Label payment_method_3;
    @FXML
    Label addres_3;
    @FXML
    Button next;
    @FXML
    Button checkout_to_make_shur;
    CreditCard creditCard;
    Restaurant restaurant = new Restaurant();
    User user_2 = new Customer();

    public Cart getCart_2() {
        return cart_2;
    }


    Cart cart_2=new Cart();
    @FXML

    Payment payment = new Payment();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ChoiceBox<String> choose_credit_card;
    @FXML
    private ChoiceBox<String> choose_addres;
    private String stats;
    Customer customer=new Customer();
    ArrayList <Item> array=cart_2.getItems();
    int lenth = array.size();

    public void setUser_2(User user_2) {
        this.user_2 = user_2;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setCart_2(Cart newcart) {
        this.cart_2 = newcart;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void select(ActionEvent event) {
        if (rb_credit.isSelected()) {
            for (CreditCard creditCard : user_2.getCreditCards()) {
                choose_credit_card.getItems().add(creditCard.getCardNumber());
            }
            customer.choosePaymentMethod(creditCard, user_2, cart_2);
            stats = "Successfully paid  ";
        }
        else if (rb_wallet.isSelected()) {
//            customer.choosePaymentMethod(user.getWallet(), user_2, cart_2);
            if (payment.getPayment_Status() .equals("Sorry you don`t have enough money ") ) {
                stats = " Failed sorry you don`t have enough money change the payment method please ";
            } else
                stats = "Successfully paid ";
        }
        else if (cash.isSelected()) {
            customer.choosePaymentMethod(user_2, cart_2);
            stats = "Successfully paid ";
        }
        next.setVisible(true);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        total.setText("Total price : " + cart_2.getTotalPrice());
        for (Item item : array) {
            System.out.println(item.getName());
        }
        number_of_items.setText("Number of items : " + cart_2.getNumberOfItems());
        shiping.setText("Shipping : " + restaurant.getDeliveryFee());
        order_details.setText("Order details : " + "(" + stats + ")");
        Total_4.setText("Total price : " + cart_2.getTotalPrice());
        payment_method_3.setText("Payment method : " + payment.getPayment_Method());
//        addres_3.setText("Address : " + User.getAddress());
//        if (!User.getAddress().isEmpty()){
//            choose_addres.setValue(User.getAddress().get(0));
//        }
//        for (String addresses : User.getAddress()) {
//             System.out.println(addresses);
//            choose_addres.getItems().add(addresses);
//
//
//         }


    }
}
