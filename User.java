package Talabat;

import javafx.fxml.FXML;

import java.util.ArrayList;

public class User {
    private String first_name;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private long phoneNumber;
    private ArrayList<String> address = new ArrayList<>();
    private String country;
    private int id;
    private ArrayList<CreditCard> creditCards = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static User user;
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

    public int getId() {
        return id;
    }

    @FXML

    public void setId(int id) {
        this.id = id;
    }

    @FXML

    public void addAddress(String address) {
        this.address.add(address);
    }

    @FXML
    public void signUp(String first_name, String lastName, String email, String password,
                       String gender, String phoneNumber, String country, String address) throws SignUpException {
        boolean found = false;
        String errors = "";
        long phoneNumber1 = 0;
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                found = true;
                break;
            }
        }
        if (found) {
            errors+="same email";
        }
        if(first_name.isEmpty()){
            errors+="first name";
        }
        if (lastName.isEmpty()){
            errors+="last name";
        }
        if(password.isEmpty()){
            errors+="password";
        }
        if (gender == null) {
            errors+="gender";
        }
        if (phoneNumber.isEmpty() ) {
            errors+="phone number";
        } else {
            try{
                phoneNumber1 = Long.parseLong(phoneNumber);
                if (phoneNumber1 / (long)1000000000 !=1){
                    errors+="not a valid number";
                }
            }catch (NumberFormatException exception){
                errors+="char in number";
            }
        }
        if (country.isEmpty()) {
            errors+="country";
        }
        if (email.isEmpty()) {
            errors+="email";
        } else if (!email.contains("@")&& !email.contains(".com")) {
            errors+="@ or .com";
        }
        if (address.isEmpty()){
            errors+="address";
        }
        if (!errors.isEmpty()){
            throw new SignUpException(errors);
        }
        users.add(new User());
        users.get(users.size() - 1).setEmail(email);
        users.get(users.size() - 1).setPassword(password);
        users.get((users.size() - 1)).setLastName(lastName);
        users.get((users.size() - 1)).setCountry(country);
        users.get((users.size() - 1)).setGender(gender);
        users.get((users.size() - 1)).setFirst_name(first_name);
        users.get((users.size() - 1)).setPhoneNumber(phoneNumber1);
        users.get((users.size() - 1)).addAddress(address);
        this.country = country;
        this.email = email;
        this.gender = gender;
        this.first_name = first_name;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber1;
        this.getAddress().add(address);
    }

    public void logOut() {
        this.address = null;
        this.country = null;
        this.email = null;
        this.gender = null;
        this.id = -1;
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

    public static void setUsers(int index, String first_name, String lastName, String email,
                                String password, String gender, long phoneNumber, String country) {
        users.add(new User());
        users.get(index).first_name = first_name;
        users.get(index).lastName = lastName;
        users.get(index).email = email;
        users.get(index).password = password;
        users.get(index).gender = gender;
        users.get(index).phoneNumber = phoneNumber;
        users.get(index).country = country;
        users.get(index).id = index;
    }
}
