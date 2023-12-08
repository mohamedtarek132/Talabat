package Talabat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.ArrayList;

public class User {
    private String first_name;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private long phoneNumber;
    private ArrayList<String> address;
    private String country;
    private String id;
    private ArrayList<CreditCard> creditCards = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();

    @FXML
    public String getFirst_name() {
        return first_name;
    }

    @FXML

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @FXML

    public String getLastName() {
        return lastName;
    }

    @FXML

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @FXML

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @FXML

    public String getPassword() {
        return password;
    }

    @FXML

    public void setPassword(String password) {
        this.password = password;
    }

    @FXML

    public String getGender() {
        return gender;
    }

    @FXML

    public void setGender(String gender) {
        this.gender = gender;
    }

    @FXML

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @FXML

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @FXML

    public ArrayList<String> getAddress() {
        return address;
    }

    @FXML

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    @FXML

    public String getCountry() {
        return country;
    }

    @FXML

    public void setCountry(String country) {
        this.country = country;
    }

    @FXML

    public String getId() {
        return id;
    }

    @FXML

    public void setId(String id) {
        this.id = id;
    }

    @FXML

    public void addAddress(String address) {
        this.address.add(address);
    }

    @FXML
    public void signUp(String first_name, String lastName, String email, String password, String gender, long phoneNumber, String country, String id) throws SameEmailException,EmptyFieldException {
        boolean found = false;
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                found = true;
                break;
            }
        }
        if (found) {
            throw new SameEmailException();
        } else if(first_name == null){
           throw new EmptyFieldException("first name");
        }else if (lastName == null){
            throw new EmptyFieldException("last name");
        }else if(password == null){
            throw new EmptyFieldException("password");
        } else if (gender == null) {
            throw new EmptyFieldException("gender");
        } else if (phoneNumber == 0) {
            throw new EmptyFieldException("phone number");
        } else if (country == null) {
            throw new EmptyFieldException("country");
        }
        users.add(new User());
        users.get(users.size() - 1).setEmail(email);
        users.get(users.size() - 1).setPassword(password);

    }

    public void logOut() {
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

    @FXML
    public void signIn(String email, String password) throws EmailOrPasswordException {
        boolean found = false;
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (email.equals(users.get(i).getEmail()) && password.equals(users.get(i).getPassword())) {
                found = true;
                index = i;
                break;
            }
        }
        if (!found) {
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

    public ArrayList<Item> searchForItem(String name, ArrayList<Restaurant> restaurants) {
        ArrayList<Item> items = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            for (Item item : restaurant.getMenu()) {
                if (item.getName().contains(name)) {
                    items.add(item);
                }
            }
        }
        return items;
    }

    public void addCreditCard(String number, int cvv, String expiry_date, String cardHolder) {
        CreditCard newCreditCard = new CreditCard(number, cvv, cardHolder, expiry_date);
        this.creditCards.add(newCreditCard);
    }

    public static void setUsers(int index, String first_name, String lastName, String email, String password, String gender, long phoneNumber, String country, String id) {
        users.add(new User());
        users.get(index).first_name = first_name;
        users.get(index).lastName = lastName;
        users.get(index).email = email;
        users.get(index).password = password;
        users.get(index).gender = gender;
        users.get(index).phoneNumber = phoneNumber;
        users.get(index).country = country;
        users.get(index).id = id;
    }
}
