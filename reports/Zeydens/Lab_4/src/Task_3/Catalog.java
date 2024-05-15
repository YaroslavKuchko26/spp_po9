import java.util.ArrayList;

public class Catalog {
    private ArrayList<Book> books;
    Catalog (){ this.books = new ArrayList<>(); }
    Catalog (ArrayList<Book> books) { this.books = books; }
    public ArrayList<Book> getBooks() { return this.books; }
    public void setBooks(ArrayList<Book> books) { this.books = books; }
    public void addBook(Book book) { this.books.add(book); }
    public void deleteBook(Book book) { this.books.remove(book); }
    public void print() {
        for(int i = 0; i < this.books.size(); ++i) {
            System.out.print("\t" + (i + 1) + ". ");
            this.books.get(i).print();
        }
    }
}
