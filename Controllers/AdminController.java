package Talabat.Controllers;

import Talabat.Classes.*;
import Talabat.Exceptions.NotAdminException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AdminController implements Initializable {
   private Restaurant restaurant =new Restaurant();
   private Admin admin =new Admin() ;
    @FXML

    private Parent root;
    private Scene scene;

@FXML
private AnchorPane scenepane;
@FXML
private  Button logout;
Stage stage;
    public void logout(ActionEvent e)
    {
        stage= (Stage)scenepane.getScene().getWindow();
        System.out.println("logout");
        stage.close();

    }

    public void switchtoadmin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/AdminDashboard.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoaddres(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Addrest.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtodisres(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Displayrest.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
@FXML
    private TextField t3;
@FXML
    private TextField t4;
@FXML
    private TextField t5;
@FXML
    private TextField t6;
    String name;
    String category;
    String []address = new String[3];
    String phonenumber;
    float dfees;
    int dtime;


    @FXML
    private ChoiceBox<String> cb;

    public void saveRestaurant(ActionEvent e) throws NotAdminException, IOException {
        try {
            address[0] = t3.getText();
           this.restaurant.setName( t1.getText(),admin);
            this.restaurant.setCategory(t2.getText(),admin);
            this.restaurant.setAddress(address,admin);
            this.restaurant.setPhoneNumber( t4.getText(),admin);
            this.restaurant.setDeliveryFee(Float.parseFloat(t5.getText()),admin);
            this.restaurant.setDeliveryDuration(Integer.parseInt(t6.getText()),admin);

        }catch (NumberFormatException nfe)
        {
            System.out.println("enter number in delivery fees and delivery duration");
        }
        catch(Exception ex)
        {
            System.out.println("enter all restaurant information");
        }

        admin.setNewRestaurant(this.restaurant);

        System.out.println("restaurant added successfully");


        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/AdminDashboard.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try
        {
            cb.getItems().addAll(admin.getRestaurantNameFromAdmin());
        }catch (NullPointerException e)
        {
            System.out.println("null value");
        }


    }
    public void DeleteRestaurant(ActionEvent e)  {
        String restName = cb.getValue();
        if(restName != null) {
            int i = 0;
            for (Restaurant r : admin.getRestaurant()) {
                if (r.getName().equals(restName)) {
                    admin.deleteRestaurant(i);
                    cb.getItems().remove(i);
                }
                i++;
            }
        }
        else {
            System.out.println("Please choose a value");
        }

    }

}
