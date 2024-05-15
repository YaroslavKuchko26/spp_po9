import java.util.function.Consumer;

class BorrowedBook extends Book {
    private int returnDay;
    private FullName reader;

    public BorrowedBook(Book book, int returnDay, FullName reader) {
        super(book);
        this.returnDay = returnDay;
        this.reader = reader;
    }

    public int getReturnDay() {
        return this.returnDay;
    }

    public FullName getReader() {
        return this.reader;
    }

    public void setReturnDay(int returnDay) {
        this.returnDay = returnDay;
    }

    public void setReader(FullName reader) {
        this.reader = reader;
    }

    @Override
    public void print() {
        System.out.print("Читатель: ");
        this.reader.print();
        System.out.print("Должен вернуть книгу в день: " + (this.returnDay + 1) + "\n");
        System.out.printf(getName() + ". " + getYear() + ". ");
        getAuthor().print();
    }

    public void printBook() {
        System.out.printf(getName() + ". " + getYear() + ". ");
        getAuthor().print();
    }
}