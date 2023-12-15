package Talabat.Classes;

public class Review {
    private int rating;
    private String Comment;
    private int UserId;
    private String Date;

    public int getRating() {

        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getUser_id() {
        return UserId;
    }

    public void setUser_id(int user_id) {
        UserId = user_id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
