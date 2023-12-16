package Talabat.Controllers;

import Talabat.Classes.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListOfRestaurantsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void goToSearchForItem(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Fxmls/SearchForItems.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public Label restaurantsPageTitle;
    public ListView<String> restaurantsListView;
    public ChoiceBox<String> restaurantAddresses;
    public Label restaurantAddressesLabel;
    public ListView<String> reviewsListView;
    public Label reviewsListViewLabel;
    public Button toMenuButton;
    public Button searchForItemButton;
    private ArrayList<String> restaurants = new ArrayList<>();
    private int currentRestaurant;
    private int numberOfRestaurants = Restaurant.getRestaurants().size();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < numberOfRestaurants; i++){
            restaurants.add(Restaurant.getRestaurants().get(i).getName() + "\t  " +
                    Restaurant.getRestaurants().get(i).getPhoneNumber() + "\t  " +
                    Restaurant.getRestaurants().get(i).getCategory() + "\t  " +
                    Restaurant.getRestaurants().get(i).getCategory() + "\t  Open from " +
                    Restaurant.getRestaurants().get(i).getOpeningHour() + " - " +
                    Restaurant.getRestaurants().get(i).getClosingHour() +
                    "\t  Delivers in approximately " +
                    Restaurant.getRestaurants().get(i).getDeliveryDuration() + " mins");
        }

        restaurantsListView.getItems().addAll(restaurants);

        restaurantsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                restaurantAddresses.getItems().clear();
                currentRestaurant = restaurantsListView.getSelectionModel().getSelectedIndex();
                ArrayList<String> reviews = new ArrayList<>();

                for (Review review: Restaurant.getRestaurants().get(currentRestaurant).getReviews()){
                    reviews.add(User.getUsers().get(review.getUser_id()).getFirstName() +
                            " " + User.getUsers().get(review.getUser_id()).getLastName() +
                            " : \"" + review.getComment() + "\"    Rating : " + review.getRating() +
                            " " + review.getDate());
                }

                for (String addresses: Restaurant.getRestaurants().get(currentRestaurant).getAddress()){
                    restaurantAddresses.getItems().add(addresses);
                }
                for (int i = 0; i < reviews.size(); i++){
                    reviewsListView.getItems().setAll(reviews);
                }
            }
        });
    }
}
