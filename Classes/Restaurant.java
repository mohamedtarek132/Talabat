package Talabat.Classes;

import Talabat.Exceptions.NotAdminException;

import java.util.ArrayList;

public class Restaurant {
    private static final ArrayList<Restaurant> restaurants = new ArrayList<>();
    private String name;
    private String phoneNumber;
    private int restaurantID;
    private ArrayList<String> address = new ArrayList<>();
    private ArrayList<Item> menu = new ArrayList<>();
    private ArrayList<Review> reviews = new ArrayList<>();
    private int numberOfReviews;
    private int deliveryDuration;
    private String openingHour;
    private String closingHour;
    private String category;
    private float deliveryFee;

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static ArrayList<Item> searchForItem(String name) {
        ArrayList<Item> items = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            for (Item item : restaurant.getMenu()) {
                if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                    items.add(item);
                }
            }
        }
        return items;
    }

    public static void setRestaurants(int index, String name, String phoneNumber, int deliveryDuration,
                                      String openingHour, String closingHour, String category, float deliveryFee,
                                      int numberOfReviews, ArrayList<Review> reviews, ArrayList<Item> items) {
        restaurants.add(new Restaurant());
        restaurants.get(index).name = name;
        restaurants.get(index).phoneNumber = phoneNumber;
        restaurants.get(index).restaurantID = index;
        restaurants.get(index).deliveryDuration = deliveryDuration;
        restaurants.get(index).openingHour = openingHour;
        restaurants.get(index).closingHour = closingHour;
        restaurants.get(index).category = category;
        restaurants.get(index).deliveryFee = deliveryFee;
        restaurants.get(index).numberOfReviews = numberOfReviews;
        restaurants.get(index).reviews = reviews;
        restaurants.get(index).menu = items;
    }

    public static void setRestaurantsAddresses(int index, String address) {
        restaurants.get(index).addAddress(address);
    }

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

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address, User user) throws NotAdminException {
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

    public void setReviews(ArrayList<Review> reviews, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.reviews = reviews;
        } else {
            throw new NotAdminException();
        }
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
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

    public void addAddress(String address) {
        this.address.add(address);
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
}
