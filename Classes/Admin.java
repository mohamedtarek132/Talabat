package Talabat.Classes;

import java.util.ArrayList;
import java.util.Scanner;

import Talabat.Exceptions.NotAdminException;


public class Admin extends User {
    private final Scanner input = new Scanner(System.in);
    User user;
    private ArrayList<Restaurant> restaurant = new ArrayList<>();

    public Admin() {
    }

    public Admin(ArrayList<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }

    public void setRestaurantsForAdmin(ArrayList<Restaurant> r) {
        this.restaurant = r;
    }

    public ArrayList<String> getRestaurantNameFromAdmin() {
        ArrayList<String> names = new ArrayList<>();
        for (Restaurant r : this.restaurant) {
            names.add(r.getName());
        }
        return names;
    }

    public ArrayList<Restaurant> getRestaurant() {
        return this.restaurant;
    }





    public void deleteRestaurant(int restaurantIndex) {
        this.restaurant.remove(restaurantIndex);
    }

    public void setNewRestaurant(Restaurant restaurant) throws NotAdminException {
        this.restaurant.add(restaurant);

    }


    public void addItemToMenu(int restaurantIndex) throws NotAdminException { //argument in

        ArrayList<Item> newMenuAfterAddingItem = new ArrayList<>();
        String string1, string2, string3, string4, string5;
        int tempNumber = 0, id = 0;
        boolean flag = false;


        System.out.println("Enter item name");
        string1 = input.nextLine();
        do {
            System.out.println("Enter item price");
            try {
                tempNumber = input.nextInt();
            } catch (Exception e) {
                System.out.println("Enter an integer");
                flag = true;
            }
        } while (flag);


        System.out.println("Enter item description");
        string2 = input.nextLine();

        System.out.println("Enter item category");
        string3 = input.nextLine();
        id = this.restaurant.get(tempNumber - 1).getMenu().size();

        Item newItem = new Item(string1, "dd", string2, tempNumber, string3);
        newMenuAfterAddingItem = this.restaurant.get(restaurantIndex).getMenu();
        newMenuAfterAddingItem.add(newItem);
        this.restaurant.get(restaurantIndex).setMenu(newMenuAfterAddingItem, user);

    }


    public void removeItemFromMenu(int restaurantIndex) {

        int itemIndex = 0;

        System.out.println("Select the Item to delete : Press 0 to cancel");

        displayRestaurantMenu(restaurantIndex);
        itemIndex = input.nextInt();
        if (itemIndex != 0) {
            try {
                this.restaurant.get(restaurantIndex).getMenu().remove(itemIndex);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid index !");
            } catch (Exception e) {
                System.out.println("Invalid input !");
            }
        }
    }


    public void displayAllRestaurants() throws NotAdminException {
        int j = 0;
        if (this.restaurant.isEmpty()) {
            System.out.println("No restaurant to display");
            System.out.println("Add new Restaurant ?  Press 1 (or) any key to return");
            j = input.nextInt();
            if (j == 1) {
                // setNewRestaurant();
            }
        } else {
            for (Restaurant r : restaurant) {
                System.out.println((j + 1) + " " + r.getName());  //this will be in textbox
                j++;
            }
            System.out.println("Choose Restaurant number to preform action :Press 0 to Exit");
            int index;
            int choose = input.nextInt();
            index = choose;
            if (choose != 0) {
                try {
                    System.out.println("Choose Action to be done on " + this.restaurant.get(choose - 1).getName());
                    System.out.println("1- view menu    2- Add Item to menu \n 3- Remove Item from menu  4- Delete Restaurant");
                    choose = input.nextInt();
                    switch (choose) {
                        case 1:
                            displayRestaurantMenu(index - 1);
                            break;
                        case 2:
                            addItemToMenu(index - 1);
                            break;
                        case 3:
                            removeItemFromMenu(index - 1);
                            break;
                        case 4:
                            deleteRestaurant(index - 1);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("invalid index");
                }

            }


        }
    }

    public void displayRestaurantMenu(int restaurantIndex) {

        try {

            this.restaurant.get(restaurantIndex).displayMenu();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("invalid index");
        }

    }


    public int updateItemName(int newPrice) {

        return newPrice;
    }

    public int updateItemPrice(int newPrice) {

        return newPrice;
    }


    public void displayMostRatedRestaurant() {
        float max = 0f;
        String maxRestaurantName = "";

        if (this.restaurant.isEmpty()) {
            System.out.println("There is no Restaurants to Display !");

        } else {

            for (Restaurant r : this.restaurant) {
                if (r.calculateAverageReview() >= max) {
                    max = r.calculateAverageReview();
                    maxRestaurantName = r.getName();
                }
            }

            System.out.println("The Highest Rated Restaurant is :\n " + maxRestaurantName + "  With Rating : " + max);
        }
    }


}







