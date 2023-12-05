package Talabat;
import java.util.ArrayList;
public class User{
    private String first_name;
    private  String lastName;
    private  String email;
    private  String password;
    private  String gender;
    private  int phoneNumber;
    private  ArrayList<String> address;
    private  String country;
    private  String id;
    private ArrayList<CreditCard> creditCards;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void addAddress(String address){
        this.address.add(address);
    }
    public void signUp(String email, String password, ArrayList<User> users){
        User [] new_users;
        boolean found = false;
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                found = true;
                break;
            }
        }
        try{
            if(found){
               throw new SameEmailException();
            }
            users.add(new User());
            users.get(users.size() - 1).setEmail(email);
            users.get(users.size() - 1).setPassword(password);
        }
        catch(SameEmailException exp){
            System.out.println(exp.getMessage());
        }
    }
    public void logOut(){
        this.address = null;
        this.country = null;
        this.email = null;
        this.gender = null;
        this.id = null;
        this.first_name = null;
        this.lastName = null;
        this.password = null;
        this.phoneNumber = 0;
    }
    public void signIn(String email, String password, ArrayList<User> users) throws EmailOrPasswordException{
        boolean found = false;
        int index = -1;
        for(int i = 0; i < users.size(); i++){
            if(email.equals(users.get(i).getEmail()) && password.equals(users.get(i).getPassword())){
                found = true;
                index = i;
                break;
            }
        }
        if(!found){
            throw new EmailOrPasswordException();
        }
        this.address = users.get(index).address;
        this.country = users.get(index).country;
        this.email = users.get(index).email;
        this.gender = users.get(index).gender;
        this.id = users.get(index).id;
        this.first_name = users.get(index).first_name;
        this.lastName = users.get(index).lastName;
        this.password = users.get(index).password;
        this.phoneNumber = users.get(index).phoneNumber;
    }
    public ArrayList<Item> searchForItem(String name,ArrayList<Restaurant> restaurants){
        ArrayList<Item> items = new ArrayList<>();
        for(Restaurant restaurant: restaurants){
            for(Item item: restaurant.getMenu()){
                if(item.getName().contains(name)){
                    items.add(item);
                }
            }
        }
        return items;
    }
    public void addCreditCard(String number, int cvv, String expiry_date, String cardHolder){
        CreditCard newCreditCard = new CreditCard(number, cvv, cardHolder, expiry_date);
        this.creditCards.add(newCreditCard);
    }
}
