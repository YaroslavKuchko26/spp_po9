// Конкретная реализация фабрики для создания струйных принтеров
class InkjetPrinterFactory extends PrinterFactory {
    public Printer createPrinter() {
        return new InkjetPrinter();
    }
}