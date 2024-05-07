package Task_02;

public class Book {
    private String title;
    private int points;
    private double price;

    public Book(String title, int points, double price) {
        this.title = title;
        this.points = points;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPoints() {
        return points;
    }

    public double getPrice() {
        return price;
    }
}
