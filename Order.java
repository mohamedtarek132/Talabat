package Talabat;

public class Order {
    private Cart cart;
    private String paymentMethod;
    private Payment paymentStatus;
    private String orderStatus;
    private String orderTime;
    private String preferredDeliveryTime;
    private User user;
    private String userInstructions;
    private Review review;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Payment getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Payment paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPreferredDeliveryTime() {
        return preferredDeliveryTime;
    }

    public void setPreferredDeliveryTime(String preferredDeliveryTime) {
        this.preferredDeliveryTime = preferredDeliveryTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserInstructions() {
        return userInstructions;
    }

    public void setUserInstructions(String userInstructions) {
        this.userInstructions = userInstructions;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
