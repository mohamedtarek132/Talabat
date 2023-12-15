package Talabat.Classes;

import Talabat.Exceptions.EmailOrPasswordException;
import Talabat.Exceptions.SignUpException;

import java.util.ArrayList;

public abstract class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private long phoneNumber;
    private ArrayList<String> address = new ArrayList<>();
    private String country;
    private int id;
    private final ArrayList<CreditCard> creditCards = new ArrayList<>();
    private static final ArrayList<User> users = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String first_name) {
        this.firstName = first_name;
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


    public long getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(long phoneNumber) {
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


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void addAddress(String address) {
        this.address.add(address);
    }

    public void signUp(String first_name, String lastName, String email, String password,
                       String gender, String phoneNumber, String country, String address) throws SignUpException {
        boolean foundEmail = false;
        boolean foundPhoneNumber = false;
        String errors = "";
        long phoneNumber1 = 0;
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                foundEmail = true;
                break;
            }
        }


        if (first_name.isEmpty()) {
            errors += "first name";
        }
        if (lastName.isEmpty()) {
            errors += "last name";
        }
        if (password.isEmpty()) {
            errors += "password";
        }
        if (gender == null) {
            errors += "gender";
        }
        if (phoneNumber.isEmpty()) {
            errors += "phone number";
        } else {
            try {
                phoneNumber1 = Long.parseLong(phoneNumber);
                if (phoneNumber1 / (long) 1000000000 != 1) {
                    errors += "not a valid number";
                } else {
                    for (User user : users) {
                        if (phoneNumber1 == user.getPhoneNumber()) {
                            errors += "same number";
                            break;
                        }
                    }
                }
            } catch (NumberFormatException exception) {
                errors += "char in number";
            }
        }
        if (country.isEmpty()) {
            errors += "country";
        }
        if (email.isEmpty()) {
            errors += "email";
        } else if (!email.contains("@") && !email.contains(".com")) {
            errors += "@ or .com";
        } else if (foundEmail) {
            errors += "same e";
        }
        if (address.isEmpty()) {
            errors += "address";
        }
        if (!errors.isEmpty()) {
            throw new SignUpException(errors);
        }
        users.add(new Customer());
        users.get(users.size() - 1).setEmail(email);
        users.get(users.size() - 1).setPassword(password);
        users.get((users.size() - 1)).setLastName(lastName);
        users.get((users.size() - 1)).setCountry(country);
        users.get((users.size() - 1)).setGender(gender);
        users.get((users.size() - 1)).setFirstName(first_name);
        users.get((users.size() - 1)).setPhoneNumber(phoneNumber1);
        users.get((users.size() - 1)).addAddress(address);
        users.get(users.size() - 1).setId(users.size() - 1);
        this.country = country;
        this.email = email;
        this.gender = gender;
        this.firstName = first_name;
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
        this.firstName = null;
        this.lastName = null;
        this.password = null;
        this.phoneNumber = 0;
    }

    public static User signIn(String email, String password) throws EmailOrPasswordException {
        boolean found = false;
        User user;
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
        if (index > 0) {
            user = new Customer();
        } else {
            user = new Admin();
        }
        user.address = users.get(index).address;
        user.country = users.get(index).country;
        user.email = users.get(index).email;
        user.gender = users.get(index).gender;
        user.id = users.get(index).id;
        user.firstName = users.get(index).firstName;
        user.lastName = users.get(index).lastName;
        user.password = users.get(index).password;
        user.phoneNumber = users.get(index).phoneNumber;
        return user;
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
        if (index < 0) {
            users.add(new Admin());
        } else {
            users.add(new Customer());
        }
        users.get(index).firstName = first_name;
        users.get(index).lastName = lastName;
        users.get(index).email = email;
        users.get(index).password = password;
        users.get(index).gender = gender;
        users.get(index).phoneNumber = phoneNumber;
        users.get(index).country = country;
        users.get(index).id = index;
    }

    public static void setUsersAddresses(int index, String address) {
        users.get(index).addAddress(address);
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
