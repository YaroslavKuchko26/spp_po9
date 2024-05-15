abstract class Book {
    private String name;
    private FullName author;
    private int year;

    Book() {
        this.name = "";
        this.author = new FullName();
        this.year = -1;
    }

    Book(String name, FullName author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    Book(Book book) {
        this.name = book.name;
        this.author = book.author;
        this.year = book.year;
    }

    public String getName() {
        return this.name;
    }

    public FullName getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(FullName author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean equals(Book book) {
        boolean name = this.name.equals(book.name);
        boolean author = this.author.equals(book.author);
        boolean year = this.year == book.year;
        return name && author && year;
    }

    public abstract void print();
}