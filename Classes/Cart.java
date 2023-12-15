package Talabat.Classes;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class Cart {
    private int numberOfItems;

    private ArrayList<Item> items = new ArrayList<>();

    private int totalPrice;
    private Restaurant restaurant;

    // Constructor
    public Cart() {
        this.items = new ArrayList<>();
    }

    // Getters and setters
    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // Other methods
    public void displayItems() {
        for (Item item : items) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }
    }

    public void calculateFullPrice() {
        totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
    }

    public void deleteCart() {
        numberOfItems = 0;
        items.clear();
        totalPrice = 0;
        restaurant = null;
    }
}
