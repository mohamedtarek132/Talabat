//package Talabat;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public class Customer extends User {
//    public void addItemToCart(Cart c_cart, Item c_item, int quant) {
//        c_item.qunatityInOrder = setquantityInOrder(quant);
//        Item[] nItems = c_cart.getItems();
//        int size = nItems.length;
//        for (int i = 0; i < size; i++) {
//            if (nItems == NULL) {
//                nItems[i] = c_item;
//            }
//        }
//        c_item.setItems(nItems);
//    }
//
//    public Order makeOrder(Cart c_cart, Payment paym, int orderTime, String user_instructions) {
//        Order c_order;
//        c_order.setCart(c_cart);
//        c_order.setPayementMethod(paym.payementMethod);
//        c_order.setpayementStatus(paym.payementStatus);
//        c_order.setuser(paym.user);
//        c_order.setoderTime(orderTime);
//        c_order.setuserInstructions(user_instructions);
//        return c_order;
//    }
//
//    public void makeReview(Item c_item, User c_user, String comment, int rate) {
//        ArrayList<Review> nReviews = c_item.getReviews();
//        int size = nReviews.length;
//        LocalDate date = LocalDate.now();
//        for (int i = 0; i < size; i++) {
//            if ((Review) nReviews[i] == null) {
//                nReviews[i].rating = rate;
//                nReviews[i].comment = comment;
//                nReviews[i].userId = c_user.getId();
//                nReviews[i].date = date;
//            }
//        }
//        c_item.setReviews(nReviews);
//    }
//
//    public void makeReview(Restaurant c_rest, User c_user, String comment, int rate) {
//        Review[] nReviews = c_rest.getReviews();
//        int size = nReviews.length;
//        LocalDate date = LocalDate.now();
//        for (int i = 0; i < size; i++) {
//            if (nReviews[i] == NULL) {
//                nReviews[i].rating = rate;
//                nReviews[i].comment = comment;
//                nReviews[i].userId = c_user.getId();
//                nReviews[i].date = date;
//            }
//        }
//        c_rest.setReviews(nReviews);
//    }
//
//    public void makeReview(Order c_order, User c_user, String comment, int rate) {
//        Review[] nReviews = c_order.getReviews();
//        int size = nReviews.length;
//        LocalDate date = LocalDate.now();
//        for (int i = 0; i < size; i++) {
//            if (nReviews[i] == NULL) {
//                nReviews[i].rating = rate;
//                nReviews[i].comment = comment;
//                nReviews[i].userId = c_user.getId();
//                nReviews[i].date = date;
//            }
//        }
//        c_order.setReviews(nReviews);
//    }
//
//    public void removeItemFromCart(Cart c_cart, Item c_item) {
//        Item[] nItems = c_cart.getItems();
//        int size = nItems.length;
//        Item[] cItems = new Item[size - 1];
//        for (int i = 0; i < size; i++) {
//            if (nItems[i].id.equals(c_item.getId())) {
//                nItems[i] = NULL;
//            }
//        }
//        for (int i = 0; i < size; i++) {
//            if (nItems[i] != NULL) {
//                cItems[i] = nItems[i];
//            }
//        }
//        c_cart.setItems(cItems);
//    }
//
//    public void removeItemFromCart(Cart c_cart, Item c_item, int quant) {
//        Item[] nItems = c_cart.getItems();
//        int size = nItems.length;
//        int c_quant = c_item.getquantityInOrder();
//        for (int i = 0; i < size; i++) {
//            if (nItems[i].id.equals(c_item.getId())) {
//                c_quant = c_quant - quant;
//                nItems[i].qunatityInOrder = c_quant;
//            }
//        }
//        c_cart.setItems(nItems);
//    }
//
//    public void cancelOrder(Order ord) {
//        ord.deleteOrder();
//    }
//
//    public String gtOrderStatus(Order c_order) {
//        String status = c_order.getOrderStatus();
//        return status;
//    }
//
//    public Item[] searchForItem(String name) {
//        Item c_item;
//        Item[] nitems = c_item.getItems();
//        int size = nitems.length;
//        Item[] vItems = new Item[size];
//        int current = 0;
//        for (int i = 0; i < size; i++) {
//            if (nItems[i].name.equals(name)) {
//                vItems[current] = nItems[i];
//                current++;
//            }
//        }
//        current = 0;
//        return vItems[];
//    }
//
//
//}
