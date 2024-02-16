package Talabat.Controllers;

import Talabat.Classes.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PreviousOrdersController implements Initializable {
    public Label ordersPageTitle;
    public Label orderReviewLabel;
    public ListView<String> itemsListView;
    public Label itemsListViewLabel;
    public TextArea orderReview;
    public ListView<String> ordersListView;
    private final ArrayList<String> orders = new ArrayList<>();
    private int currentOrder;
    private final int numberOfOrders = Order.getOrders().size();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < numberOfOrders; i++) {
            orders.add("Name: " + Order.getOrders().get(i).getUser().getFirstName() +
                    " " + Order.getOrders().get(i).getUser().getLastName() + "  |  Restaurant: " +
                    Order.getOrders().get(i).getCart().getRestaurant().getName() + "  |  " +
                    Order.getOrders().get(i).getOrderTime() + "\nStatus: " +
                    Order.getOrders().get(i).getOrderStatus() + "  |  Preferred delivery time: " +
                    Order.getOrders().get(i).getPreferredDeliveryTime() + "  |  Instructions: " +
                    Order.getOrders().get(i).getUserInstructions() + "\nPayment: " +
                    Order.getOrders().get(i).getPaymentMethod() + "  |  Total Price: " +
                    Order.getOrders().get(i).getCart().getTotalPrice() + "$\t   ");
        }

        ordersListView.getItems().addAll(orders);

        ordersListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentOrder = ordersListView.getSelectionModel().getSelectedIndex();
                ArrayList<String> items = new ArrayList<>();

                for (Item item : Order.getOrders().get(currentOrder).getCart().getItems()) {
                    items.add("Item: " + item.getName() + " | " + item.getCategory() + " | " +
                            item.getDescription() + " | " + item.getPrice() + "$");
                }
                String userName = User.getUsers().get(Order.getOrders().get(currentOrder).getReview().getUser_id()).getFirstName() +
                        " " + User.getUsers().get(Order.getOrders().get(currentOrder).getReview().getUser_id()).getLastName();
                orderReview.setText(userName + " : \"" + Order.getOrders().get(currentOrder).getReview().getComment() +
                        "\"\nRating : " + Order.getOrders().get(currentOrder).getReview().getRating() +
                        " " + Order.getOrders().get(currentOrder).getReview().getDate());
                itemsListView.getItems().setAll(items);
            }
        });
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