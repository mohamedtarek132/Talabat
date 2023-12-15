//
//package Talabat.Classes;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class Admin extends User {
//User user;
//    private ArrayList<Restaurant> restaurant = new ArrayList<>();
//    private Scanner input = new Scanner(System.in);
//    public Admin(){};
//    public Admin( ArrayList<Restaurant> restaurant){this.restaurant= restaurant;}
//
//    public void setResturantsForAdmin(ArrayList<Restaurant>r)
//    {
//        this.restaurant = r;
//    }
//
//
//
//
//    public void deleteRestaurant() {
//        int index=0,i=0;
//        displayAllRestaurants();
//        if(this.restaurant.isEmpty())
//        {
//            System.out.println("No restaurant to delete !");
//        }
//        else
//        {
//            System.out.println("Enter the Index of the Restaurant");
//            try {
//                index = input.nextInt();
//                this.restaurant.remove(index-1);
//
//            }
//            catch (ArrayIndexOutOfBoundsException e)
//            {
//                System.out.println("invalid index");
//            }
//            catch(Exception e)
//            {
//                System.out.println("invalid input");
//            }
//
//
//        }
//
//
//
//
//    }
//
//    public void setNewRestaurant() throws NotAdminException     //this method is a parameter for addRestaurantToRestaurants();
//    {
//        Restaurant newRestaurant = new Restaurant();
//        String string ;
//        String[] address = new String[3];
//        int number=0;
//
//        System.out.println("Enter restaurant name :");
//        string = input.nextLine();
//        newRestaurant.setName(string,user);
//
//        System.out.println("Enter restaurant phone number :");
//        string= input.nextLine();
//        newRestaurant.setPhoneNumber(string,user);
//
//        System.out.println("Enter restaurant  first Address :");
//        address[0]= input.nextLine();
//        //System.out.println("Enter restaurant  second Address :");
//        //address[1]= input.nextLine();
//        //System.out.println("Enter restaurant  third Address :");
//        //address[2]= input.nextLine();
//
//        newRestaurant.setAddress(address,user);
//
//        System.out.println("Enter restaurant category ");
//        string= input.nextLine();
//        newRestaurant.setCategory(string,user);
//
//        System.out.println("Restaurant added setup a menu");
//        this.restaurant.add(newRestaurant);
//
//
//
//    }
//
//    public void addRestaurantToRestaurants( Restaurant newRestaurant) {
//
//        this.restaurant.add(newRestaurant);
//
//    }
//
//
//    public void addItemToMenu() throws NotAdminException { //argument in
//
//        ArrayList<Item> newMenuAfterAddingItem = new ArrayList<>();
//        String string1,string2,string3,string4,string5;
//        int tempNumber = 0,id =0;
//        boolean flag = false;
//        displayAllRestaurants();
//        System.out.println("Enter restaurant index");
//        do {
//            try {
//                tempNumber = input.nextInt();
//                this.restaurant.get(tempNumber-1);
//            } catch (Exception e) {
//                System.out.println("invalid input");
//                flag= true;
//            }
//        }while (flag == true);
//        flag = false;
//
//
//        System.out.println("Enter item name");
//        string1= input.nextLine();
//        do {
//            System.out.println("Enter item price");
//            try {
//                tempNumber = input.nextInt();
//            } catch (Exception e) {
//                System.out.println("Enter an integer");
//                flag =true;
//            }
//        }while(flag==true);
//
//
//            System.out.println("Enter item description");
//        string2 = input.nextLine();
//
//        System.out.println("Enter item category");
//        string3 = input.nextLine();
//        id = this.restaurant.get(tempNumber-1).getMenu().size();
//
//        Item newItem = new Item(string1,id,string2,tempNumber,string3);
//        newMenuAfterAddingItem = this.restaurant.get(tempNumber-1).getMenu();
//        newMenuAfterAddingItem.add(newItem);
//        this.restaurant.get(tempNumber-1).setMenu(newMenuAfterAddingItem ,user);
//
//    }
//
//
//    public void removeItemFromMenu( int restaurantId, int itemId) {
//
//        ArrayList<Item> menuAfterDeletingItem = new ArrayList<>();
//        /*int index = 0;
//        boolean flag = false;
//
//        displayAllRestaurants();
//        System.out.println("Enter restaurant index");
//
//        do {
//            try {
//                index = input.nextInt();
//                this.restaurant.get(index-1);
//
//            } catch (Exception e) {
//                System.out.println("invalid input");
//                flag= true;
//            }
//        }while (flag == true);
//        flag =false;
//        this.restaurant.get(index-1).displayMenu();
//        System.out.println("choose the item Index to remove");
//
//*/
//
////////////////
//        for (Restaurant r : this.restaurant) {
//            if (r.getRestaurantID() == restaurantId) {
//                r.getMenu().removeIf(i -> i.getId() == itemId);
//            }
//        }
//    }
//
//    public void displayAllRestaurants() {
//        int j = 0;
//        if(this.restaurant.isEmpty())
//        {
//            System.out.println("No restaurant to display");
//        }
//        else {
//            for (Restaurant r : restaurant) {
//                System.out.println((j + 1) + " " + r.getName());  //this will be in textbox
//                j++;
//            }
//        }
//    }
//
//    public void displayRestaurantMenu() {
//
//        int index= 0;
//
//        System.out.println("Enter the restaurant Index ");
//        try {
//            index = input.nextInt();
//            this.restaurant.get(index-1).displayMenu();
//        }
//        catch (ArrayIndexOutOfBoundsException e)
//        {
//            System.out.println("invalid index");
//        }
//        catch(Exception e)
//        {
//            System.out.println("invalid input");
//        }
//
//    }
//
//
//
//    public int updateItemPrice(int newPrice) {
//
//        return newPrice;
//    }
//
//    public void displayMostRatedRestaurant() {
//        float max = 0f;
//        String maxRestaurantName = new String();
//        for (Restaurant r : this.restaurant) {
//            if (r.calculateAverageReview() >= max) {
//                max =r.calculateAverageReview();
//                maxRestaurantName = r.getName();
//            }
//        }
//
//        System.out.println("The Highest Rated Restaurant is : "+maxRestaurantName+"With Rating : "+ max );
//    }
//
//
//
//
//
//
//
//}
//
//
//
//
//
//
//
