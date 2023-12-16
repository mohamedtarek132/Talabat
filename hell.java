package Talabat;

import Talabat.Classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class hell extends Application {
    public static void main(String[] args) {
        launch(args);
        AnchorPane d = new AnchorPane();
        writeFiles();
    }

    public void readingFiles() {
        try {
            File file = new File("C:\\Users\\Anyone\\Documents\\Talabat-main\\Data\\userInfo.txt");
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                User.setUsers(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Long.parseLong(data[6]), data[7]);
                i++;
            }
            scanner.close();

            file = new File("C:\\Users\\Anyone\\Documents\\Talabat-main\\Data\\userAddress.txt");
            scanner = new Scanner(file);
            i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                User.setUsersAddresses(Integer.parseInt(data[0]), data[1]);
                i++;
            }
            scanner.close();

            Review[] reviews = new Review[2];
            reviews[0] = new Review();
            reviews[0].setUser_id(0);
            reviews[0].setComment("Amazing");
            reviews[0].setDate("14/DEC/2023");
            reviews[0].setRating(4);
            reviews[1] = new Review();
            reviews[1].setUser_id(0);
            reviews[1].setComment("Not Satisfying");
            reviews[1].setDate("15/DEC/2023");
            reviews[1].setRating(2);

            ArrayList<Item> items = new ArrayList<>();
            items.add( new Item("ChickenShawerma", "0", "Chicken Shawerma Wrap", 75, "Sandwich"));
            items.add( new Item("GrilledChicken", "1", "Grilled Chicken with Rice", 150, "Grills"));
            items.add( new Item("Koshari", "2", "Koshari Large", 40, "Koshari"));

            Payment[] payments = new Payment[1];
            payments[0] = new Payment();
            payments[0].setTransaction_id("0");

            file = new File("C:\\Users\\Anyone\\Documents\\Talabat-main\\Data\\restaurantInfo.txt");
            scanner = new Scanner(file);
            i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int numberOfReviews = Integer.parseInt(data[8]);
                int numberOfItems = Integer.parseInt(data[9 + numberOfReviews]);
                ArrayList<Review> restaurantReviews = new ArrayList<>();
                ArrayList<Item> restaurantMenu = new ArrayList<>();

                for(int idx = 0; idx < numberOfReviews; idx++) {
                    restaurantReviews.add(reviews[Integer.parseInt(data[idx + 9])]);
                }

                for(int idx = 0; idx < numberOfItems; idx++) {
                    restaurantMenu.add(items.get(Integer.parseInt(data[idx + numberOfReviews + 10])));
                }

                Restaurant.setRestaurants(Integer.parseInt(data[0]), data[1], data[2],
                        Integer.parseInt(data[3]), data[4], data[5], data[6],
                        Float.parseFloat(data[7]), numberOfReviews, restaurantReviews, restaurantMenu);
                i++;
            }
            scanner.close();

            file = new File("C:\\Users\\Anyone\\Documents\\Talabat-main\\Data\\restaurantAddress.txt");
            scanner = new Scanner(file);
            i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                Restaurant.setRestaurantsAddresses(Integer.parseInt(data[0]),data[1]);
                i++;
            }
            scanner.close();

            Cart[] carts = new Cart[1];
            carts[0] = new Cart();
            carts[0].setCartId(0);
            carts[0].setRestaurant(Restaurant.getRestaurants().get(0));
            carts[0].setItems(items);
            carts[0].setTotalPrice(100);
            carts[0].setNumberOfItems(2);

            file = new File("C:\\Users\\Anyone\\Documents\\Talabat-main\\Data\\orderInfo.txt");
            scanner = new Scanner(file);
            i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                Payment payment = payments[0];//Payment.getPayments().get(Integer.parseInt(data[2]));
                User user = User.getUsers().get(Integer.parseInt(data[6]));
                Review review = reviews[0];//Review.getReviews().get(Integer.parseInt(data[8]));
                Cart cart = carts[0];//Cart.getCarts().get(Integer.parseInt(data[9]));

                Order.setOrders(Integer.parseInt(data[0]), data[1], payment, data[3], data[4], data[5],
                        user, data[7], review, cart);
                i++;
            }
            scanner.close();

//file = new File("D:\\Talabat\\Talabat\\main\\java\\Talabat\\Data\\Items.txt");
//            scanner = new Scanner(file);
//            i = 0;
//            while (scanner.hasNextLine()) {
//                String[] data = scanner.nextLine().split(",");
//
//                Item.setItem(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), data[4]);
//                i++;
//            }
//            scanner.close();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFiles() {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\hp\\Documents\\Programming projects\\Java Projects\\Talabat\\Data\\userInfo.txt");
            for (User user : User.getUsers()) {
                myWriter.write(user.getId() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getEmail() + "," + user.getPassword()
                        + "," + user.getGender() + "," + user.getPhoneNumber() + "," + user.getCountry());
                myWriter.write("\n");
                System.out.println(1);
            }
            myWriter.close();

            myWriter = new FileWriter("C:\\Users\\hp\\Documents\\Programming projects\\Java Projects\\Talabat\\Data\\userAddress.txt");
            for (User user : User.getUsers()) {
                for (String address : user.getAddress()) {
                    System.out.println(address);
                    myWriter.write(user.getId() + "," + address);
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        readingFiles();
        Parent root = FXMLLoader.load(getClass().getResource("Fxmls/SignIn.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hell");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
