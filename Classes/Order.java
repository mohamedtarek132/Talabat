package Talabat.Classes;

import Talabat.Exceptions.NotAdminException;

public class Order {

    private final Cart cart;
    private final String paymentMethod;
    private final Payment payment;
    private final String preferredDeliveryTime;
    private final User user;
    private final String userInstructions;
    private String orderStatus;
    private String orderTime;
    private Review review;
    public Order(Cart cart, String paymentMethod, Payment payment, String preferredDeliveryTime,
                 User user, String userInstructions) {
        this.cart = cart;
        this.paymentMethod = paymentMethod;
        this.payment = payment;
        this.preferredDeliveryTime = preferredDeliveryTime;
        this.user = user;
        this.userInstructions = userInstructions;
    }

    public Payment getPayment() {
        return payment;
    }

    public Cart getCart() {
        return cart;
    }

    public String getPaymentMethod() {
        return paymentMethod;
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

    public void setOrderTime(String orderTime, User user) throws NotAdminException {
        if (user instanceof Admin) {
            this.orderTime = orderTime;
        } else {
            throw new NotAdminException();
        }
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
}
