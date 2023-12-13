package Talabat.Classes;

import java.util.ArrayList;


public class Admin extends User {
    public ArrayList<Restaurant> deleteResturant(ArrayList<Restaurant> restaurant, int restId) {

        ArrayList<Restaurant> newRest = new ArrayList<>();

        System.out.println("Enter resturant id to delete ");

        for (Restaurant r : restaurant) {

            if (r.getRestaurantID() == restId) {
                r = null;
                break;
            }
        }

        for (Restaurant r : restaurant) {
            if (r == null) {
                continue;
            } else {
                newRest.add(r);
            }
        }
        return newRest;
    }

    public Restaurant setNewRestaurant()     //this method is a parameter for addRestaurantToRestaurants();
    {
        System.out.println("Enter restaurant name ");             //
        System.out.println("Enter restaurant phone number ");     //
        System.out.println("Enter restaurant Adress ");           //
        System.out.println("Enter restaurant category ");           //this will be in textbox
        System.out.println("Enter restaurant  ");                 //
        System.out.println("Enter restaurant name ");             //
        System.out.println("Enter restaurant name ");             //

        Restaurant restaurant = new Restaurant();
        return restaurant;
    }

    public ArrayList<Restaurant> addRestaurantToRestaurants(ArrayList<Restaurant> allRestaurants, Restaurant newRestaurant) {

        for (Restaurant r : allRestaurants) {
            if (r == null) {
                r = newRestaurant;
            }
        }
        return allRestaurants;
    }


    public ArrayList<Item> addItemToMenu(ArrayList<Restaurant> restaurant, int restaurantId, String itemName, String id, String description, int price, String category) {
        Item newItem = new Item(itemName, id, description, price, category);
        ArrayList<Item> newMenuAfterAddingItem = new ArrayList<>();

        for (Restaurant r : restaurant) {
            if (r.getRestaurantID() == restaurantId) {

                newMenuAfterAddingItem = r.getMenu();
                newMenuAfterAddingItem.add(newItem);
            }

        }
        return newMenuAfterAddingItem;

    }


    public ArrayList<Item> removeItemFromMenu(ArrayList<Item> item, String itemId) {
        ArrayList<Item> menuAfterDeletingItem = new ArrayList<>();
        int j = 0;

        for (Item i : item) {
            if (i.getId() == itemId) {
                i.setId(null);
                break;
            }

        }

        for (Item i : item) {
            if (i.getId() == null)
                continue;
            else
                menuAfterDeletingItem.add(i);

        }


        return menuAfterDeletingItem;
    }

    public void displayAllRestaurants(ArrayList<Restaurant> restaurant) {
        int j = 0;
        for (Restaurant r : restaurant) {
            if (r == null)
                continue;
            System.out.println((j + 1) + " " + r.getName());  //this will be in textbox
            j++;
        }
    }

    public void displayRestaurantMenu(Restaurant restaurant) {
        int j = 0;
        for (Item i : restaurant.getMenu()) {
            System.out.println((j + 1) + "- " + i.getName() + " Price -> " + i.getPrice());//this will be in textbox
        }

    }

    public int updateItemPrice(int newPrice) {

        return newPrice;
    }

    public void displayMostRatedResturant(ArrayList<Restaurant> restaurant) {

    }


}






