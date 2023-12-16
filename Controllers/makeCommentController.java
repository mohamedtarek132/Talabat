package Talabat.Controllers;

import Talabat.Classes.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class makeCommentController implements Initializable {
    @FXML
    Label how_was;
    User user=new Customer();
    Restaurant restaurant=new Restaurant();
    Customer customer = new Customer();
    Order order;
    Review review=new Review();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextArea make_comment1;
    @FXML
    private TextArea make_comment_2;
    @FXML
    private TextField rate_restaurant;
    @FXML
    private TextField rate_order;
    @FXML
    private Button send;
    @FXML
    private Button back;
    @FXML
    Label to_make_shur1;
    private String comment_on_restaurant;
    private int restaurant_rate_as_number;
    private String comment_on_order;
    private int order_rate_as_number;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Cart getCart_3() {
        return cart_3;
    }

    public void setCart_3(Cart cart_3) {
        this.cart_3 = cart_3;
    }

    Cart cart_3=new Cart();

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void send_review(ActionEvent event) {

        comment_on_restaurant = make_comment1.getText();
        restaurant_rate_as_number = Integer.parseInt(rate_restaurant.getText());
        comment_on_order = make_comment_2.getText();
        order_rate_as_number = Integer.parseInt(rate_order.getText());
        customer.makeReview(order, user, comment_on_order, order_rate_as_number);
        customer.makeReview(restaurant, user, comment_on_restaurant, restaurant_rate_as_number);

    }

    public void switchToScene3(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        how_was.setText("How was your food from " + order.getCart().getRestaurant().getName());



    }
}
