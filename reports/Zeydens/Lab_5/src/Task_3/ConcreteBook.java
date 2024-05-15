public class ConcreteBook extends Book {
    public ConcreteBook() {
        super();
    }
    public ConcreteBook(String name, FullName author, int year) {
        super(name, author, year);
    }

    @Override
    public void print() {
        System.out.printf(getName() + ". " + getYear() + ". ");
        getAuthor().print();
    }
}