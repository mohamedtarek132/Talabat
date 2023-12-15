package Talabat;

import Talabat.Classes.CreditCard;
import Talabat.Classes.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class hell extends Application {
    public static void main(String[] args) {
        launch(args);
        AnchorPane d = new AnchorPane();
        writeFiles();
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
            myWriter = new FileWriter("C:\\Users\\hp\\Documents\\Programming projects\\Java Projects\\Talabat\\Data\\userCreditCard");
            for (User user : User.getUsers()) {
                for (CreditCard creditCard : user.getCreditCards()) {
                    myWriter.write(user.getId() + "," + creditCard.getCardNumber() + "," + creditCard.getCvv() + "," +
                            creditCard.getExpirationDate() + "," + creditCard.getCardholderName());
                    myWriter.write("\n");
                }
            }
            myWriter.close();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void readingFiles() {
        try {
            File file = new File("C:\\Users\\hp\\Documents\\Programming projects\\Java Projects\\Talabat\\Data\\userInfo.txt");
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                User.setUsers(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Long.parseLong(data[6]), data[7]);
                i++;
            }
            scanner.close();

            file = new File("C:\\Users\\hp\\Documents\\Programming projects\\Java Projects\\Talabat\\Data\\userAddress.txt");
            scanner = new Scanner(file);
            i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                User.setUsersAddresses(Integer.parseInt(data[0]), data[1]);
                i++;


//file = new File("D:\\Talabat\\Talabat\\main\\java\\Talabat\\Data\\Items.txt");
//            scanner = new Scanner(file);
//            i = 0;
//            while (scanner.hasNextLine()) {
//                String[] data = scanner.nextLine().split(",");
//                Item.setItem(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), data[4]);
//                i++;
//            }
//            scanner.close();
//
//
//
//
//
//
//
            }
            scanner.close();
            file = new File("C:\\Users\\hp\\Documents\\Programming projects\\Java Projects\\Talabat\\Data\\userCreditCard");
            scanner = new Scanner(file);
            i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                User.getUsers().get(Integer.parseInt(data[0])).addCreditCard(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
