// Интерфейс принтера
interface Printer {
    void print(String document);
}

// Конкретная реализация принтера для обычной печати
class RegularPrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing document on a regular printer: " + document);
    }
}

// Конкретная реализация принтера для цветной печати
class ColorPrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing document in color on a color printer: " + document);
    }
}

// Фабрика для создания принтеров
interface PrinterFactory {
    Printer createPrinter();
}

// Фабрика для создания обычных принтеров
class RegularPrinterFactory implements PrinterFactory {
    @Override
    public Printer createPrinter() {
        return new RegularPrinter();
    }
}

// Фабрика для создания цветных принтеров
class ColorPrinterFactory implements PrinterFactory {
    @Override
    public Printer createPrinter() {
        return new ColorPrinter();
    }
}

// Пример использования
public class Main3 {
    public static void main(String[] args) {
        // Создание фабрик для разных типов принтеров
        PrinterFactory regularPrinterFactory = new RegularPrinterFactory();
        PrinterFactory colorPrinterFactory = new ColorPrinterFactory();

        // Создание принтеров с использованием соответствующих фабрик
        Printer regularPrinter = regularPrinterFactory.createPrinter();
        Printer colorPrinter = colorPrinterFactory.createPrinter();

        // Печать документов
        regularPrinter.print("Document 1");
        colorPrinter.print("Document 2");
    }
}
