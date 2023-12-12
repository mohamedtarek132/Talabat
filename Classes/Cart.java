package Talabat.Classes;

public class Cart {
    private int numberOfItems;
    private Item[] items;
    private int totalPrice;
    private Restaurant restaurant;

    // Getters and setters
    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
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
        items = new Item[0];
        totalPrice = 0;
        restaurant = null;
    }
}
