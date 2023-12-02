package Talabat;

public class User implements Cloneable{
    private String first_name;
    private  String lastName;
    private  String email;
    private  String password;
    private  String gender;
    private  int phoneNumber;
    private  String [] address;
    private  String country;
    private  String id;

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

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
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
        String [] new_address = new String [this.address.length + 1];
        System.arraycopy(this.address, 0, new_address, 0, this.address.length);
        new_address [this.address.length] = address;
        this.address = new_address;
    }
    public User[] signUp(String email, String password, User []users){
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
            new_users = new User[users.length + 1];
            System.arraycopy(users, 0, new_users, 0, users.length);
            new_users[users.length].email = email;
            new_users[users.length].password = password;
            return new_users;
        }
        catch(SameEmailException exp){
            System.out.println(exp.getMessage());
        }
        return users;
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
    public void signIn(String email, String password, User []users) throws EmailOrPasswordException{
        boolean found = false;
        int index = -1;
        for(int i = 0; i < users.length; i++){
            if(email.equals(users[i].getEmail()) && password.equals(users[i].getPassword())){
                found = true;
                index = i;
                break;
            }
        }
        if(!found){
            throw new EmailOrPasswordException();
        }
        this.address = users[index].address.clone();
        this.country = users[index].country;
        this.email = users[index].email;
        this.gender = users[index].gender;
        this.id = users[index].id;
        this.first_name = users[index].first_name;
        this.lastName = users[index].lastName;
        this.password = users[index].password;
        this.phoneNumber = users[index].phoneNumber;
    }
    public Object clone() throws CloneNotSupportedException {
        User clone = (User) super.clone();
        clone.address = this.address.clone();
        return clone;
    }
}
