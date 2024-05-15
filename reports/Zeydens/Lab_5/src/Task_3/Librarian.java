import java.util.ArrayList;

public class Librarian {
    private FullName fullname;
    private ArrayList<LibraryCard> cards;
    Librarian() {
        this.fullname = new FullName();
        this.cards = new ArrayList<>();
    }
    Librarian(FullName fullName, ArrayList<LibraryCard> cards) {
        this.fullname = fullName;
        this.cards = cards;
    }
    public FullName getFullname() { return this.fullname; }
    public ArrayList<LibraryCard> getCards() { return this.cards; }
    public void setCards(ArrayList<LibraryCard> cards) { this.cards = cards; }
    public void setFullName(FullName fullname) { this.fullname = fullname; }
    public void print() {
        this.fullname.print();
        for(int i = 0; i < this.cards.size(); ++i) {
            System.out.print("\t");
            this.cards.get(i).print();
        }
    }
    public static class LibraryCard {
        private FullName readersName;
        private ArrayList<IsBookReturned> returnedBooks;
        LibraryCard() {
            this.readersName = new FullName();
            this.returnedBooks = new ArrayList<>();
        }
        LibraryCard(FullName readersName, ArrayList<IsBookReturned> books) {
            this.readersName = readersName;
            this.returnedBooks = books;
        }
        public FullName getReadersName() { return this.readersName; }
        public ArrayList<IsBookReturned> getReturnedBooks() { return this.returnedBooks; }
        public void setReadersName(FullName readersName) { this.readersName = readersName; }
        public void setReturnedBooks(ArrayList<IsBookReturned> books) { this.returnedBooks = books; }
        public void add(IsBookReturned returnedBook) { this.returnedBooks.add(returnedBook); }
        public void print() {
            this.readersName.print();
            for(int i = 0; i < this.returnedBooks.size(); ++i) {
                System.out.print(i + 1 + ". ");
                this.returnedBooks.get(i).print();
            }
        }
        public static class IsBookReturned {
            private Book book;
            private boolean isBookReturned;
            IsBookReturned() {
                this.book = new ConcreteBook();
                this.isBookReturned = false;
            }
            IsBookReturned(Book book, boolean isBookReturned) {
                this.book = book;
                this.isBookReturned = isBookReturned;
            }
            public Book getBook() { return this.book; }
            public boolean getBookReturned() { return this.isBookReturned; }
            public void setBook(Book book) { this.book = book; }
            public void setBookReturned(boolean isBookReturned) { this.isBookReturned = isBookReturned; }
            public void print() {
                if (this.isBookReturned) { System.out.print("Возвращена книга: "); }
                else { System.out.print("Не возвращена книга: "); }
                this.book.print();
            }
        }

    }
}
