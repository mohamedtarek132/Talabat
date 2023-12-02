package Talabat;

public class SameEmailException extends Exception{
    public SameEmailException(){
        super("This email is used by another user!");
    }
}
