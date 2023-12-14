package Talabat.Classes;

import Talabat.Exceptions.NotAdminException;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String phoneNumber;
    private int restaurantID;
    private String[] address;
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

    public void setName(String name, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.name = name;
        } else {
            throw new NotAdminException();
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new NotAdminException();
        }
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.restaurantID = restaurantID;
        } else {
            throw new NotAdminException();
        }
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.address = address;
        } else {
            throw new NotAdminException();
        }
    }

    public ArrayList<Item> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Item> menu, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.menu = menu;
        } else {
            throw new NotAdminException();
        }
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Review reviews)  {
        this.reviews.add(reviews);
    }

    public int getDeliveryDuration() {
        return deliveryDuration;
    }

    public void setDeliveryDuration(int deliveryDuration, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.deliveryDuration = deliveryDuration;
        } else {
            throw new NotAdminException();
        }
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.openingHour = openingHour;
        } else {
            throw new NotAdminException();
        }
    }

    public String getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(String closingHour, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.closingHour = closingHour;
        } else {
            throw new NotAdminException();
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.category = category;
        } else {
            throw new NotAdminException();
        }
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.deliveryFee = deliveryFee;
        } else {
            throw new NotAdminException();
        }
    }

    public void displayMenu() {
        for (Item item : menu) {
            item.displayItem();
        }
    }

    public float calculateAverageReview() {
        float averageReview = 0, counter = 0;
        for (Review review : reviews) {
            averageReview += review.getRating();
            counter += 1f;
        }
        return (averageReview / counter);
    }

    public int[] displayNumberOfReviews() {
        int[] reviewsNumber = new int[5];
        for (Review review : reviews) {
            reviewsNumber[review.getRating() - 1] += 1;
        }
        return reviewsNumber;
    }

    public Item searchForItem(String itemName) {
        boolean check = false;
        for (Item item : menu) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        System.out.println("No Items Found!");
        return null;
    }
}
