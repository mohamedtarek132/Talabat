package Talabat;

public class SameEmailAsAnotherUserException extends Exception{
    public SameEmailAsAnotherUserException(String email){
        super("This email is used by another user!");
    }
}
