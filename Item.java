package Talabat;

import java.util.ArrayList;

public class Item {

    private String name;
    private String id;
    private int price;
    private ArrayList<Review> reviews;
    private ArrayList<Item> optionalToppings;
    private ArrayList<Item> toppings;
    private int numberOfSales;
    private String description;
    private Boolean availability;
    private ArrayList<Item> optionalSideItems;
    private ArrayList<Item> sideItems;
    private String category;
    private int quantityInOrder;
    private float averageReview;


    public Item(String name, String id, String description, int price, String category) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
        this.category = category;
        this.numberOfSales = 0;
        this.quantityInOrder = 0;
        this.averageReview = 0f;
        this.availability = true;
        this.toppings = new ArrayList<>();
        this.sideItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Item> getOptionalToppings() {
        return optionalToppings;
    }

    public void setOptionalToppings(ArrayList<Item> optionalToppings) {
        this.optionalToppings = optionalToppings;
    }

    public ArrayList<Item> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Item> toppings) {
        this.toppings = toppings;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public ArrayList<Item> getOptionalSideItems() {
        return optionalSideItems;
    }

    public void setOptionalSideItems(ArrayList<Item> optionalSideItems) {
        this.optionalSideItems = optionalSideItems;
    }

    public ArrayList<Item> getSideItems() {
        return sideItems;
    }

    public void setSideItems(ArrayList<Item> sideItems) {
        this.sideItems = sideItems;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantityInOrder() {
        return quantityInOrder;
    }

    public void setQuantityInOrder(int quantityInOrder) {
        this.quantityInOrder = quantityInOrder;
    }

    public void addTopping(Item topping) {
        toppings.add(topping);
    }

    public void deleteTopping(String toppingName) {
        for (int i = toppings.size() - 1; i >= 0; i--) {
            if (toppings.get(i).getName().equals(toppingName)) {
                toppings.remove(i);
                break;
            }
        }
    }

    public void incrementNumberOfSales() {
        numberOfSales++;
    }

    public void calculateAverageReview(Review review) {
        float totalReviews = averageReview * numberOfSales;
        totalReviews += review.getRating();
        numberOfSales++;
        averageReview = totalReviews / numberOfSales;
    }

    public void addSideItem(Item sideItem) {
        sideItems.add(sideItem);
    }

    public void deleteSideItem(String sideItemName) {
        for (int i = sideItems.size() - 1; i >= 0; i--) {
            if (sideItems.get(i).getName().equals(sideItemName)) {
                sideItems.remove(i);
                break;
            }
        }
    }
    public String displayItem() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", reviews=" + reviews +
                ", numberOfSales=" + numberOfSales +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                ", category='" + category + '\'' +
                ", averageReview=" + averageReview +
                '}';
    }
}
