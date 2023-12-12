package Talabat;

public class NotAdminException extends Exception{
    public NotAdminException(){
        super("You are not authorized to modify this field.");
    }
}
