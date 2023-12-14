package Talabat.Classes;

public class Review {
    private int rating;
    private String Comment;
    private int UserId;
    private String Date;

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setUser_id(int user_id) {
        UserId = user_id;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getRating() {

        return rating;
    }

    public String getComment() {
        return Comment;
    }

    public String getUser_id() {
        return User_id;
    }

    public String getDate() {
        return Date;
    }
}
