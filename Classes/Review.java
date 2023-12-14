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

    public int getUser_id() {
        return UserId;
    }

    public String getDate() {
        return Date;
    }
}
