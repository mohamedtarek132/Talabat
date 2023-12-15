package Talabat;

import Talabat.Exceptions.NotAdminException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends User {
    public void addItemToCart(Cart current_cart, Item current_item, int quantity)
    {
        current_item.setQuantityInOrder(quantity);
        ArrayList<Item> nItems = current_cart.getItems();
        nItems.add(current_item);
    }

    public Order makeOrder(Cart current_cart, Payment payment, String orderTime,User user, String user_instructions) {
        Order c_order = new Order(current_cart,payment.getPayment_Method(), payment, orderTime,user, user_instructions);
        return c_order;
    }

    public void makeReview(Item current_item, User current_user, String comment, int rate)
    {
        Review review = new Review();
        LocalDate date = LocalDate.now();
        String New_Date = date.toString();
        review.setRating(rate);
        review.setComment(comment);
        review.setUser_id(current_user.getId());
        review.setRating(rate);
        review.setDate(New_Date);
        current_item.setReviews(review);
    }

    public void makeReview(Restaurant current_rest, User current_user, String comment, int rate)
    {
        Review review = new Review();
        LocalDate date = LocalDate.now();
        String New_Date = date.toString();
        review.setRating(rate);
        review.setComment(comment);
        review.setUser_id(current_user.getId());
        review.setRating(rate);
        review.setDate(New_Date);
        current_rest.setReviews(review);
    }

    public void makeReview(Order current_order, User current_user, String comment, int rate)
    {
        Review review = new Review();
        LocalDate date = LocalDate.now();
        String New_Date = date.toString();
        review.setRating(rate);
        review.setComment(comment);
        review.setUser_id(current_user.getId());
        review.setRating(rate);
        review.setDate(New_Date);
        current_order.setReview(review);
    }

    public void removeItemFromCart(Cart current_cart, Item current_item) {
        ArrayList<Item> nItems = current_cart.getItems();
        int size = nItems.size();
        for (int i = 0; i < size; i++)
        {
            if (nItems.get(i).getId().equals(current_item.getId()))
            {
                nItems.set(i, null);
            }
        }
        for (int i = 0; i < size; i++) {
            if (nItems.get(i) == null) {
                nItems.remove(i);
            }
        }
        current_cart.setItems(nItems);
    }

    public void removeItemFromCart(Cart current_cart, Item current_item, int quantity)
    {
        ArrayList <Item> nItems = current_cart.getItems();
        int size = nItems.size();
        int current_quantity = current_item.getQuantityInOrder();
        for (int i = 0; i < size; i++)
        {
            if (nItems.get(i).getId().equals(current_item.getId()))
            {
                current_quantity = current_quantity - quantity;
                nItems.get(i).setQuantityInOrder(current_quantity);
            }
        }
        current_cart.setItems(nItems);
    }

        public Payment choosePaymentMethod(CreditCard creditCard, User current_user, Cart current_cart)
        {
            Payment payment = new Payment();
            LocalDate date = LocalDate.now();
            String New_Date = date.toString();
            payment.setPayment_Method("credit card");
            payment.setPayment_Date(New_Date);
            payment.setUser(current_user);
            payment.Pay(current_cart.getTotalPrice(),creditCard);
            return payment;
        }

        public Payment choosePaymentMethod(Wallet wallet, User current_user, Cart current_cart)
        {
            Payment payment = new Payment();
            LocalDate date = LocalDate.now();
            String New_Date = date.toString();
            payment.setPayment_Method("wallet");
            payment.setPayment_Date(New_Date);
            payment.setUser(current_user);
            payment.Pay(current_cart.getTotalPrice(),wallet);
            return payment;
        }

        public Payment choosePaymentMethod(User current_user, Cart current_cart)
        {
            Payment payment = new Payment();
            LocalDate date = LocalDate.now();
            String New_Date = date.toString();
            payment.setPayment_Method("cash");
            payment.setPayment_Date(New_Date);
            payment.setUser(current_user);
            return payment;
        }

    public void cancelOrder(Order current_order, User user) throws NotAdminException {
        current_order.setOrderStatus("Cancelled", user);
    }

    public String getOrderStatus(Order current_order) {
        return current_order.getOrderStatus();
    }


}
