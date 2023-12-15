package Talabat.Classes;
import java.util.Scanner;

public class AdminDashBoard {

    public  AdminDashBoard () throws NotAdminException {
        Admin admin = new Admin();/////IN ADMIN CONSTRUCTOR WE SHOULD PUT THE ARRAYLIST OF RESTAURANT !!!
        Scanner scanner = new Scanner(System.in);
        int choose =-1;

    while(choose != 0) {

        System.out.println("\n\t\t\t(--- Admin Dashboard ---)");
        System.out.println("\n Choose Your Action: Press the corresponding number");
        System.out.println("\n1 - Display Restaurants");
        System.out.println("\n2 - Display Most Rated Restaurant");
        System.out.println("\n3 - Add new Restaurant");
        System.out.println("\n0 - Exit");
        try {
            choose = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Enter a valid number !");
        }
        switch (choose) {
            case 1:
                admin.displayAllRestaurants();
                break;
            case 2:
                admin.setNewRestaurant();
                break;
            case 3: admin.displayMostRatedRestaurant();
            default:
                System.out.println("Enter a valid number !");
        }


    }



        ///*******WHAT FILES SHOULD WE PUT HERE TO SAVE & CLOSE ?******////

        System.out.println("\t\t\t**** HAVE A NICE DAY ****");
    }
}
