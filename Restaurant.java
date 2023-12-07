package Talabat;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String phoneNumber;
    private int restaurantID;
    private String [] address;
    private ArrayList<Item> menu;
    private ArrayList<Review> reviews;
    private int deliveryDuration;
    private String openingHour;
    private String closingHour;
    private String category;
    private float deliveryFee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public ArrayList<Item> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public int getDeliveryDuration() {
        return deliveryDuration;
    }

    public void setDeliveryDuration(int deliveryDuration) {
        this.deliveryDuration = deliveryDuration;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(String closingHour) {
        this.closingHour = closingHour;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public void displayMenu(){
        for (Item item: menu) {
            item.displayItem();
        }
    }

    public float calculateAverageReview(){
        float averageReview = 0, counter = 0;
        for (Review review: reviews) {
            averageReview += review.getRating();
            counter += 1f;
        }
        return (averageReview/counter);
    }

    public int[] displayNumberOfReviews(){
        int[] reviewsNumber = new int[5];
        for (Review review:reviews){
            reviewsNumber[review.getRating()-1] += 1;
        }
        return reviewsNumber;
    }

    public Item searchForItem(String itemName){
        boolean check = false;
        for (Item item: menu){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        System.out.println("No Items Found!");
        return null;
    }
}
