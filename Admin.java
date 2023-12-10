
public class Admin extends User {
public  Resturant  deleteResturant (Resturant resturant) {
    int restId;
    ArrayList<Restaurant> newRest = new ArrayList<>[];

    System.out.println("Enter resturant id to delete ");

    for (Restaurant r : resturant) {

        if (r.shopId == restId) {
            r = null;
            break;
        }
    }

    for (int i = 0; i < resturant.length; i++) {
        if(resturant[i]==null)
            continue;
        else
            newRest[i] = resturant[i];
    }
    return newRest;
}

public Restaurant setNewRestaurant()     //this method is a parameter for addRestaurantToRestaurants();
{
    System.out.println("Enter restaurant name ");             //
    System.out.println("Enter restaurant phone number ");     //
    System.out.println("Enter restaurant Adress ");           //
    System.out.println("Enter restaurant category ");           //this will be in textbox
    System.out.println("Enter restaurant  ");                 //
    System.out.println("Enter restaurant name ");             //
    System.out.println("Enter restaurant name ");             //

    Restaurant restaurant = new Restaurant();
    return restaurant;
}

public Restaurant addRestaurantToRestaurants(ArrayList<Restaurant> allRestaurants,Restaurant newRestaurant){

    for (Restaurant r:allRestaurants) {
        if(r == null)
        {
            r=newRestaurant;
        }
    }
    return allRestaurants;
}


public  Item addItemToMenu( Restaurant restaurant,int restaurantId,String itemName,int itemPrice)
{
 for (Restaurant i :restaurant) {
  if(i.shopId == restaurantId)
  {
   Item newItem = new Item(itemName,itemPrice);
   Item[] arrOfItem = new Item[restaurant.menu.length+1];
      for (int i = 0; i < arrOfItem.length; i++) {
          arrOfItem[i]= restaurant.menu[i];
      }
      arrOfItem[arrOfItem.length-1] = newItem;
   restaurant.menu = arrOfItem;
   break;
  }

 }
 return restaurant.menu;

}



public Item removeItemFromMenu(Item[] item , int itemIndex)
{
    Item newItem = new Item[item.length];
    item[itemIndex]= null;
    int j=0;
    for (int i = 0; i < item.length; i++) {
        if(item[i]==null)
            continue;
        newItem[j]= item[j];
        j++;
    }
return newItem;
}

 public  void displayAllRestaurants ()
 {
int j=0;
   for(Restaurant i : restaurant)
   {
       if(restaurant[i] == null)
           continue;
       System.out.println((j+1) +" "+ restaurant[i].name);  //this will be in textbox
       j++;
   }
 }

 }

public  int updateItemPrice(int newPrice)
{

  return newPrice;
}

public  void displayRestaurantMenu(Restaurant)
{
    int j =0;
 for (Item i : restaurant.menu)
  {
  System.out.println((j+1)+"- "+i.name+" Price -> "i.price);//this will be in textbox
  }

}



public  Void  DisplayMostRatedRestaurant(ArrayList<Restaurant> restaurant )
{
    int i=0;

    Collection.sort(restaurant.review.rating);

    for(Restaurant r : restaurant)
     {
       System.out.println((i+1)+"- "+r.name);
     }

}
