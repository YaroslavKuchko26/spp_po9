
public class Order {
    private FullName fullName;
    private Book book;
    private int place;
    Order() {
        this.fullName = new FullName();
        this.book = new ConcreteBook();
        this.place = -1;
    }
    Order(FullName fullName, Book book, int place) {
        this.fullName = fullName;
        this.book = book;
        this.place = place;
    }
    public FullName getFullName() { return this.fullName; }
    public Book getBook() { return this.book; }
    public int getPlace() { return this.place; }
    public void setFullName(FullName fullName) { this.fullName = fullName; }
    public void setBook(Book book) { this.book = book; }
    public void setPlace(int place) { this.place = place; }
    public void print() {
        System.out.print("Заказ совершён читателем: ");
        this.fullName.print();
        System.out.print("Взята книга: ");
        this.book.print();
        if(place == Constants.BOOK_TO_HOME) {
            System.out.printf("На дом\n");
        }
        else if (place == Constants.BOOK_TO_READING_ROOM) {
            System.out.print("В читальный зал\n");
        }
    }
}
