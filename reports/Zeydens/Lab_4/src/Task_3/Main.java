import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static boolean chanceToTrigger(int chanceToTrigger) {
        Random random = new Random();
        int currentChance = random.nextInt(Constants.MAX_CHANCE) + Constants.MIN_CHANCE;//1-100
        return chanceToTrigger >= currentChance;
    }

    public static void simulateYearInLibrary() {
        //final int[] MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final int[] MONTHS = {31, 28, 31};
        final String[] LIBRARY_NAME = {"Библиотека исторических откровений", "Библиотека тайных знаний",
                "Библиотека путей к мудрости", "Библиотека судебных перипетий", "Библиотека временных ритмов",
                "Библиотека сновидений", "Библиотека предков и мифов", "Библиотека безграничного мира",
                "Библиотека разумных игр", "Библиотека затерянных тайн"};
        final FullName[] LIBRARIAN_FULL_NAME = {
                new FullName("Белова", "Елена", "Николаевна"),
                new FullName("Михайлова", "Ирина", "Алексеевна"),
                new FullName("Волкова", "Анастасия", "Павловна"),
                new FullName("Андреева", "Маргарита", "Игоревна"),
                new FullName("Кузнецова", "Виктория", "Сергеевна")
        };
        final FullName[] ADMINISTRATOR_FULL_NAME = {
                new FullName("Иванов", "Алексей", "Петрович"),
                new FullName("Смирнова", "Елена", "Александровна"),
                new FullName("Козлов", "Дмитрий", "Сергеевич"),
                new FullName("Петрова", "Ольга", "Ивановна"),
                new FullName("Соколов", "Андрей", "Викторович")
        };
        final String[] BOOK_NAMES = {"Тени прошлого", "Забытый секрет", "Путь к совершенству",
                "Перекресток судеб", "Ритмы времени", "Пленники снов", "Зов предков",
                "Мир без границ", "Игры разума", "Тайны затерянного мира"};
        final FullName[] AUTHOR_FULL_NAMES = {
                new FullName("Толстой", "Лев", ""),
                new FullName("Достоевский", "Федор", ""),
                new FullName("Оруэлл", "Джордж", ""),
                new FullName("Остин", "Джейн", ""),
                new FullName("Хемингуэй", "Эрнест", ""),
                new FullName("Гарсиа Маркес", "Габриэль", ""),
                new FullName("Ли", "Харпер", ""),
                new FullName("Брэдбери", "Рей", ""),
                new FullName("Роулинг", "Джоан", ""),
                new FullName("Гессе", "Герман", "")
        };
        final int[] BOOK_YEARS = {2005, 1998, 2012, 1987, 2016, 2003, 1995, 2010, 1982, 2008};
        final FullName[] READER_FULL_NAMES = {
                new FullName("Николаева", "Мария", "Петровна"),
                new FullName("Алексеева", "Алексей", "Сергеевич"),
                new FullName("Григорьева", "Екатерина", "Дмитриевна"),
                new FullName("Сергеев", "Даниил", "Александрович"),
                new FullName("Павлова", "Анна", "Ивановна"),
                new FullName("Волкова", "София", "Алексеевна"),
                new FullName("Кузьмин", "Илья", "Николаевич"),
                new FullName("Андреева", "Елена", "Дмитриевна"),
                new FullName("Орлова", "Дарья", "Сергеевна"),
                new FullName("Марков", "Максим", "Андреевич")
        };
        Random random = new Random();
        Library library = new Library();
        library.setName(LIBRARY_NAME[random.nextInt(LIBRARY_NAME.length)]);
        //Добалвение библиотекаря в библиотеку
        library.setLibrarian(
                new Librarian(
                        LIBRARIAN_FULL_NAME[random.nextInt(LIBRARIAN_FULL_NAME.length)],
                        new ArrayList<>()
                )
        );
        //Добавление администратора в библиотеку
        library.setAdministrator(
                new Administrator(
                        ADMINISTRATOR_FULL_NAME[random.nextInt(ADMINISTRATOR_FULL_NAME.length)],
                        new ArrayList<>()
                )
        );
        //Создание каталога книг
        for(int i = 0; i < Constants.NUMBER_OF_BOOKS; ++i) {
            library.getCatalog().addBook(
                    new Book(
                            BOOK_NAMES[random.nextInt(BOOK_NAMES.length)],
                            AUTHOR_FULL_NAMES[random.nextInt(AUTHOR_FULL_NAMES.length)],
                            BOOK_YEARS[random.nextInt(BOOK_YEARS.length)]
                    )
            );
        }
        System.out.print("\n-------------------Сводка по библиотеке-------------------\n");
        library.print();
        //Создание читателей
        ArrayList<Reader> readers = new ArrayList<>();
        for(int i = 0; i < READER_FULL_NAMES.length; ++i) {
            readers.add(
                    new Reader(
                            READER_FULL_NAMES[i],
                            new ArrayList<>()
                    )
            );
        }
        int currentDay = 0;
        int numberOfReturnedBooks = 0;
        int numberOfNotReturnedBooks = 0;
        int numberOfBorrowedHomeBooks = 0;
        int numberOfBorrowedRoomBooks = 0;
        int numberOfAttendedDays = 0;
        int numberOfKickedReaders = 0;
        ArrayList<BorrowedBook> borrowedBooks = new ArrayList<>();
        System.out.print("\n-------------------Год работы в библиотеке-------------------\n");
        //Эмулировать год работы библиотеки
        for(int m = 0; m < MONTHS.length; ++m) {
            for(int n = 0; n < MONTHS[m]; ++n) {
                System.out.print("\tДень " + (currentDay + 1) + ". ");
                boolean isLibraryAttended = false;
                //Есть книги, которые нужно вернуть
                if(!borrowedBooks.isEmpty()) {
                    for(int i = 0; i < borrowedBooks.size(); ++i) {
                        //Сегодня не нужно вернуть эту книгу
                        if(borrowedBooks.get(i).getReturnDay() != currentDay) {
                            continue;
                        }
                        //Книгу вернут
                        if(chanceToTrigger(Constants.RETURN_BOOK_CHANCE)) {
                            library.getCatalog().addBook(
                                    new Book(
                                            borrowedBooks.get(i).getName(),
                                            borrowedBooks.get(i).getAuthor(),
                                            borrowedBooks.get(i).getYear()
                                    )
                            );
                            //Изменить состояние конкретной книги конкретного читателя на возвращённую (фу)
                            for(int j = 0; j < library.getLibrarian().getCards().size(); ++j) {
                                //Нашли абонемент конкретного читателя
                                if(library.getLibrarian()
                                        .getCards()
                                        .get(j)
                                        .getReadersName()
                                        .equals(borrowedBooks.get(i).getReader())
                                ) {
                                    for(int k = 0; k < library.getLibrarian().getCards().get(j).getReturnedBooks().size(); ++k) {
                                        //Нашли конкретную книгу в абонементе конкретного читателя
                                        if(library.getLibrarian()
                                                .getCards()
                                                .get(j)
                                                .getReturnedBooks()
                                                .get(k)
                                                .getBook().equals(borrowedBooks.get(i))
                                        ) {
                                            //Долг возвращён
                                            library.getLibrarian().getCards().get(j).getReturnedBooks().get(k).setBookReturned(true);
                                            //Вывести изменённый абонемент
                                            System.out.print("Читатель вернул книгу: ");
                                            library.getLibrarian().getCards().get(j).print();
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            borrowedBooks.remove(i);
                            --i;
                            ++numberOfReturnedBooks;
                            continue;
                        }
                        //Книгу не вернули - в тетрадь
                        else if(chanceToTrigger(Constants.ADD_TO_BLACK_LIST_CHANCE)) {
                            System.out.print("Книга не была возвращена читателем: ");
                            borrowedBooks.get(i).getReader().print();
                            System.out.print("Читатель был занесён в чёрный список администратором:  ");
                            library.getAdministrator().addToBlackList(borrowedBooks.get(i).getReader());
                            library.getAdministrator().print();
                            borrowedBooks.remove(i);
                            --i;
                            ++numberOfNotReturnedBooks;
                            continue;
                        }
                        //Книгу не вернули, ну и ладно, простим дурачка
                        System.out.print("Читатель: ");
                        borrowedBooks.get(i).getReader().print();
                        System.out.print("Не вернул книгу:\n");
                        borrowedBooks.get(i).printBook();
                        borrowedBooks.remove(i);
                        --i;
                        ++numberOfNotReturnedBooks;
                    }
                }
                //Читатель посетил библиотеку (у нас тут не проходной двор, читатели редко заглядывают)
                if(chanceToTrigger(Constants.READER_COME_CHANCE)) {
                    ++numberOfAttendedDays;
                    Reader currentReader = readers.get(random.nextInt(readers.size()));
                    System.out.print("Библиотеку посетил читатель: ");
                    currentReader.print();
                    boolean isReaderKickedOut = false;
                    //Читатель в тетради администратора - выгнать
                    for (int i = 0; i < library.getAdministrator().getBlackList().size(); ++i) {
                        //Пришедший читатель найден в тетради администратора
                        if (currentReader.getFullName().equals(library.getAdministrator().getBlackList().get(i))) {
                            isReaderKickedOut = true;
                            ++numberOfKickedReaders;
                        }
                    }
                    //Читателя выгнали, день закончен
                    if (isReaderKickedOut) {
                        System.out.print("Читатель был выгнан: ");
                        currentReader.print();
                        ++currentDay;
                        continue;
                    }
                    //Создание заказа на книгу
                    int indexOfBookToOrder = random.nextInt(library.getCatalog().getBooks().size());
                    Book currentBook = library.getCatalog().getBooks().get(indexOfBookToOrder);
                    Order order = new Order(
                            currentReader.getFullName(),
                            currentBook,
                            Constants.BOOK_TO_READING_ROOM
                    );
                    //Книгу заказали на абонемент (взять домой)
                    if (chanceToTrigger(Constants.BOOK_TO_HOME_CHANCE)) {
                        order.setPlace(Constants.BOOK_TO_HOME);
                        library.getCatalog().getBooks().remove(indexOfBookToOrder);
                        ArrayList<Librarian.LibraryCard> cards = library.getLibrarian().getCards();
                        //Если абонемент есть, то найти и добавить
                        int indexOfAddedCard = -1;
                        for (int i = 0; i < cards.size(); ++i) {
                            //Абонемент был найден, создавать его не нужно, просто добавить
                            if (currentReader.getFullName().equals(cards.get(i).getReadersName())) {
                                cards.get(i).add(
                                        new Librarian.LibraryCard.IsBookReturned(currentBook, false)
                                );
                                indexOfAddedCard = i;
                                break;
                            }
                        }
                        //Если абонемента нет, то создать и добавить
                        if (indexOfAddedCard == -1) {
                            cards.add(
                                    new Librarian.LibraryCard(
                                            currentReader.getFullName(),
                                            new ArrayList<>(Arrays.asList(
                                                    new Librarian.LibraryCard.IsBookReturned(
                                                            currentBook,
                                                            false
                                                    )
                                            ))
                                    )
                            );
                            indexOfAddedCard = cards.size() - 1;
                        }
                        library.getLibrarian().setCards(cards);
                        //Добавить день возврата книги (читатели приходят в последний момент)
                        borrowedBooks.add(
                                new BorrowedBook(
                                        currentBook,
                                        currentDay + Constants.DAYS_TO_READ_BOOK,
                                        currentReader.getFullName()
                                )
                        );
                        order.print();
                        System.out.print("День возврата книги: " + (currentDay + 1 + Constants.DAYS_TO_READ_BOOK) + "\n");
//                        System.out.print("Абонемент читателя: ");
//                        cards.get(indexOfAddedCard).print();
                        ++numberOfBorrowedHomeBooks;
                    }
                    //Книга взята в читальный зал, значит будет оставлена в библиотеке, иначе это кража
                    else {
                        order.print();
                        ++numberOfBorrowedRoomBooks;
                    }
                    isLibraryAttended = true;
                }
                if(!isLibraryAttended) { System.out.print("Никто не пришёл\n"); }
                ++currentDay;
            }
        }
        System.out.print("\n-------------------Сводка за год-------------------\n");
        System.out.print("Количество дней, когда пришёл читатель: " + numberOfAttendedDays + "\n");
        System.out.print("Количество взятых в читальный зал книг: " + numberOfBorrowedRoomBooks + "\n");
        System.out.print("Количество взятых на абонемент книг: " + numberOfBorrowedHomeBooks + "\n");
        System.out.print("Количество возвращённых книг: " + numberOfReturnedBooks + "\n");
        System.out.print("Количество не возвращённых книг: " + numberOfNotReturnedBooks + "\n");
        System.out.print("Люди в чёрном списке администратора: ");
        library.getAdministrator().print();
        System.out.print("Количество попыток читателя в списке посетить библиотеку: " + numberOfKickedReaders + "\n");
        System.out.print("Книги в каталоге (название, год издания, автор):\n");
        library.getCatalog().print();
        System.out.print("Абонементы читателей библиотекаря: ");
        library.getLibrarian().print();
    }

    public static void main(String[] args) {
        simulateYearInLibrary();
    }
}