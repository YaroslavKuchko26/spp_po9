import java.util.ArrayList;

public class Reader {
    private FullName fullName;
    private ArrayList<Book> books;
    Reader() {
        this.fullName = new FullName();
        this.books = new ArrayList<>();
    }
    Reader(FullName fullName, ArrayList<Book> books) {
        this.fullName = fullName;
        this.books = books;
    }
    public FullName getFullName() { return this.fullName; }
    public ArrayList<Book> getBooks() { return this.books; }
    public void setFullName(FullName fullName) { this.fullName = fullName; }
    public void setBooks(ArrayList<Book> books) { this.books = books; }
    public void takeBook(Book book) { this.books.add(book); }
    public void print() {
        //System.out.print("Читатель: ");
        this.fullName.print();
        if(this.books.isEmpty()) { return; }
        System.out.print("Книги этой библиотеки читателя (название, год издания, автор):\n");
        for(int i = 0; i < this.books.size(); ++i) {
            System.out.print("\t" + (i + 1) + ". ");
            this.books.get(i).print();
        }
    }
}
