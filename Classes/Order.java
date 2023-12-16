package Talabat.Classes;

import Talabat.Exceptions.NotAdminException;

import java.util.ArrayList;

public class Order {
    private final int orderID;
    private final Cart cart;
    private final String paymentMethod;
    private final Payment payment;
    private String orderStatus;
    private final String orderTime;
    private final String preferredDeliveryTime;
    private final User user;
    private final String userInstructions;
    private Review review;
    private static ArrayList<Order> orders = new ArrayList<>();

    public Order(int orderID, Cart cart, String paymentMethod, Payment payment, String orderTime,
                 String preferredDeliveryTime, User user, String userInstructions) {
        this.orderID = orderID;
        this.cart = cart;
        this.paymentMethod = paymentMethod;
        this.payment = payment;
        this.orderTime = orderTime;
        this.preferredDeliveryTime = preferredDeliveryTime;
        this.user = user;
        this.userInstructions = userInstructions;
    }

    public int getOrderID() {
        return orderID;
    }

    public Cart getCart() {
        return cart;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Payment getPayment() {
        return payment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.orderStatus = orderStatus;
        } else {
            throw new NotAdminException();
        }
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getPreferredDeliveryTime() {
        return preferredDeliveryTime;
    }

    public User getUser() {
        return user;
    }

    public String getUserInstructions() {
        return userInstructions;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static void setOrders(int index, String paymentMethod,
                                 Payment payment, String orderStatus, String orderTime,
                                 String preferredDeliveryTime, User user, String userInstructions,
                                 Review review, Cart cart) {
        orders.add(new Order(index, cart, paymentMethod, payment,
                preferredDeliveryTime, orderTime, user, userInstructions));
        orders.get(index).orderStatus = orderStatus;
        orders.get(index).review = review;
    }
}
