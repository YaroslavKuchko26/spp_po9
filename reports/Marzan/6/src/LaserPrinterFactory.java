// Конкретная реализация фабрики для создания лазерных принтеров
class LaserPrinterFactory extends PrinterFactory {
    public Printer createPrinter() {
        return new LaserPrinter();
    }
}