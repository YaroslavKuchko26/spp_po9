public class Library {
    private String name;
    private Administrator administrator;
    private Librarian librarian;
    private Catalog catalog;
    Library() {
        this.name = "";
        this.administrator = new Administrator();
        this.librarian = new Librarian();
        this.catalog = new Catalog();
    }
    Library(String name, Administrator administrator, Librarian librarian, Catalog catalog) {
        this.name = name;
        this.administrator = administrator;
        this.librarian = librarian;
        this.catalog = catalog;
    }
    public String getName() { return this.name; }
    public Administrator getAdministrator() { return this.administrator; }
    public Librarian getLibrarian() { return this.librarian; }
    public Catalog getCatalog() { return this.catalog; }
    public void setName(String name) { this.name = name; }
    public void setAdministrator(Administrator administrator) { this.administrator = administrator; }
    public void setLibrarian(Librarian librarian) { this.librarian = librarian; }
    public void setCatalog(Catalog catalog) { this.catalog = catalog; }
    public void print() {
        System.out.print("Название библиотеки: " + this.name + "\n");
        System.out.print("Текущий администратор: ");
        this.administrator.print();
        System.out.print("Текущий библиотекарь: ");
        this.librarian.print();
        System.out.print("Книги в каталоге (название, год издания, автор):\n");
        this.catalog.print();
    }
}
