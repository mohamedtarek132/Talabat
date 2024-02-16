package Talabat.Controllers;

import Talabat.Classes.Item;
import Talabat.Classes.Restaurant;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchForItemsController implements Initializable {
    public Label searchForItemsTitle;
    public TextField itemNameTextField;
    public Label itemNameTextFieldLabel;
    public ListView<String> itemsListView;
    public Button searchButton;
    public Label noItemsLabel;
    public Button listOfRestaurantsButton;
    String itemName;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<String> itemsData = new ArrayList<>();

    public void goToListOfRestaurants(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Fxmls/ListOfRestaurants.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void search(javafx.event.ActionEvent event) {
        itemName = itemNameTextField.getText();
        items = Restaurant.searchForItem(itemName);
        for (Item item : items) {
            String itemAvailability = "Available";
            if (!item.getAvailability()) {
                itemAvailability = "Not Available";

            }
            itemsData.add("Name: " + item.getName() + "\t  " + "Category: " + item.getCategory() + "\t  " +
                    "Description: " + item.getDescription() + "\t  " + "Price: " + item.getPrice() +
                    "$\t  Sold " + item.getNumberOfSales() + " times\t  Average Reviews: " +
                    item.getAvailability());
        }
        noItemsLabel.setVisible(false);
        if (itemsData.isEmpty()) noItemsLabel.setVisible(true);
        itemsListView.getItems().clear();
        itemsListView.getItems().addAll(itemsData);
        itemsData.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemsListView.getItems().addAll(itemsData);
    }
}