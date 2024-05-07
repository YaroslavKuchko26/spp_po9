// Конкретная реализация принтера - Струйный принтер
class InkjetPrinter extends Printer {
    public void print(String document) {
        System.out.println("Printing document '" + document + "' using an inkjet printer.");
        // Дополнительные действия, специфичные для струйного принтера
    }
}