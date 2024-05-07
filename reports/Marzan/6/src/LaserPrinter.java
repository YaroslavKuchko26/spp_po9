// Конкретная реализация принтера - Лазерный принтер
class LaserPrinter extends Printer {
    public void print(String document) {
        System.out.println("Printing document '" + document + "' using a laser printer.");
        // Дополнительные действия, специфичные для лазерного принтера
    }
}