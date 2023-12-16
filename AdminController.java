package Controllers;

import Classes.*;
import Exceptions.NotAdminException;
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


public class AdminController {
    private Restaurant restaurant = new Restaurant();
    private static Admin admin = new Admin();
    private ArrayList<Item>  items = new ArrayList<>();
    private  Item item = new Item();

    @FXML

    private Parent root;
    private Scene scene;

    @FXML
    private AnchorPane scenepane;
    @FXML
    private Button logout;
    Stage stage;

    public void logout(ActionEvent e) {
        stage = (Stage) scenepane.getScene().getWindow();
        System.out.println("logout");
        stage.close();

    }

    public void switchtoadmin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/AdminDashboard.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoaddres(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Addrest.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtodisres(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Displayrest.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
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

    String[] address = new String[3];


    public void saveRestaurant(ActionEvent e) throws NotAdminException, IOException {

        try {
            address[0] = t3.getText();
            this.restaurant.setName(t1.getText(), admin);
            this.restaurant.setCategory(t2.getText(), admin);
            this.restaurant.setAddress(address, admin);
            this.restaurant.setPhoneNumber(t4.getText(), admin);
            this.restaurant.setDeliveryFee(Float.parseFloat(t5.getText()), admin);
            this.restaurant.setDeliveryDuration(Integer.parseInt(t6.getText()), admin);

        } catch (NumberFormatException nfe) {
            System.out.println("enter number in delivery fees and delivery duration");
        } catch (Exception ex) {
            System.out.println("enter all restaurant information");
        }

        this.admin.setNewRestaurant(this.restaurant);

        System.out.println("restaurant added successfully");


        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/AdminDashboard.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    @FXML
    private TextField tf;

    public void DeleteRestaurant(ActionEvent e) {

        if (!this.admin.getRestaurant().isEmpty()) {
            try {
                int index = Integer.parseInt(tf.getText());
                this.admin.deleteRestaurant(index - 1);
            } catch (ArrayIndexOutOfBoundsException aofi) {
                System.out.println("Enter a valid index !");
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number");
            //} catch (Exception e1) {
             //   System.out.println("Try again with valid input");
            }
        } else System.out.println("you don't have any restaurant !");
    }

    public void displayRestaurantInConsole(ActionEvent e) {
        if (this.admin.getRestaurant().isEmpty()) {
            System.out.println("no restaurants to display");
        } else {
            this.admin.displayAllRestaurants();
        }
    }
    @FXML
    TextField tf1;
    @FXML
    TextField tf2;

    public void editRestaurantMenu(ActionEvent e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/EditMenu.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void displayRestaurantMenu(ActionEvent e) {
        int restindex = 0 ;
        restindex = Integer.parseInt(tf1.getText());

        try {
            if (!admin.getRestaurant().get(restindex - 1).getMenu().isEmpty()){
                for (int i =0 ;i<admin.getRestaurant().get(restindex - 1).getMenu().size();i++) {
                    System.out.println("Item name\tCategory\tPrice");
                    System.out.println((i+1)+"- "+admin.getRestaurant().get(restindex - 1).getMenu().get(i).getName()
                            +"\t"+admin.getRestaurant().get(restindex - 1).getMenu().get(i).getCategory()+
                            "\t"+admin.getRestaurant().get(restindex - 1).getMenu().get(i).getPrice()+
                            admin.getRestaurant().get(restindex - 1).getMenu().get(i).getDescription()+"\n************************************************"
                    );
                }


            System.out.println("end of menu");
        }
        else
        {
            System.out.println("no menu found !");

        } } catch (ArrayIndexOutOfBoundsException aofi) {
        System.out.println("Enter a valid index !");
    } catch (NumberFormatException nfe) {
        System.out.println("Enter a number !");
    } catch (Exception e1) { System.out.println("Enter a new item first  write 0 in  text field no. 2");
    }


    }
    @FXML
    TextField name;
    @FXML
    TextField cat;
    @FXML
    TextField dis;
    @FXML
    TextField price;


    public void  addItem(ActionEvent e) throws NotAdminException {
        int b = Integer.parseInt(tf2.getText());
        int restindex= Integer.parseInt(tf1.getText());
        try {
            if (b == 0) {

                item.setName(name.getText());
                item.setCategory(cat.getText());
                item.setDescription(dis.getText());
                item.setPrice(Integer.parseInt(price.getText()));

                items.add(item);

                admin.getRestaurant().get(restindex-1).setMenu(items,admin);
                System.out.println("Add successfully");

            } else {
                System.out.println("can't add while editing");
            }
        }catch (Exception e2)
        {
            System.out.println("Ana asef");
        }

    }

    public void  editItem(ActionEvent e) throws NotAdminException
    {
        int itemindex =0 ;
        ArrayList<Item>itemArrayList = new ArrayList<>();
        Item edititem = new Item();
        try
        {
            itemindex= Integer.parseInt(tf2.getText());

          itemArrayList = admin.getRestaurant().get(Integer.parseInt(tf1.getText())-1).getMenu();
          itemArrayList.remove(itemindex-1);
          item.setName(name.getText());
          item.setPrice(Integer.parseInt(price.getText()));
            item.setCategory(cat.getText());
            item.setDescription(dis.getText());
            itemArrayList.add(item);
            admin.getRestaurant().get(Integer.parseInt(tf1.getText())-1).setMenu(itemArrayList,admin);
            System.out.println("Edit successfully");
        }
        catch (ArrayIndexOutOfBoundsException aofi) {
            System.out.println("Enter a valid index !");
        } catch (NumberFormatException nfe) {
            System.out.println("Enter a number !");
        }catch (Exception e1) {
            System.out.println("Try again with valid input");
       }

    }


    public void deleteItem(ActionEvent e) throws NotAdminException {
        int itemindex;
       itemindex = Integer.parseInt(tf2.getText());
        try {
            admin.getRestaurant().get(Integer.parseInt(tf1.getText())-1).getMenu().remove(itemindex-1);

        } catch (ArrayIndexOutOfBoundsException aofi) {
            System.out.println("Enter a valid index !");
        } catch (NumberFormatException nfe) {
            System.out.println("Enter a number !");
        } catch (Exception e1) {
        System.out.println("Try again with valid input");
        }
    }


    public void displayRestwiththemostrating(ActionEvent e)
    {
        try {
            if (admin.getRestaurant().isEmpty()) {
                System.out.println("no Restaurant to view");
            } else {
                admin.displayMostRatedRestaurant();
            }
        }catch (NullPointerException e1)
        {
            System.out.println(" no restaurant has any rating");
        }
    }


}