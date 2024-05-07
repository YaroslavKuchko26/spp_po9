public class Main {
    public static void main(String[] args) {
        // 1 -----------------------------------------------
        // Создаем фабрику для производства седанов
        CarFactory sedanFactory = new SedanCarFactory();
        // Создаем седан
        Car sedan = sedanFactory.createCar();
        sedan.manufacture();

        // Создаем фабрику для производства внедорожников
        CarFactory suvFactory = new SUVCarFactory();
        // Создаем внедорожник
        Car suv = suvFactory.createCar();
        suv.manufacture();

        System.out.println();

        // 2 -----------------------------------------------
        UniversalCardFacade cardFacade = new UniversalCardFacade();

        // Получение персональной информации
        cardFacade.getPersonalInformation();

        // Получение деталей страхового полиса
        cardFacade.getInsuranceDetails();

        // Выполнение платежа
        cardFacade.performPayment(100.0);

        System.out.println();

        // 3 -----------------------------------------------
        // Создаем фабрику для создания лазерных принтеров
        PrinterFactory laserPrinterFactory = new LaserPrinterFactory();
        // Создаем лазерный принтер
        Printer laserPrinter = laserPrinterFactory.createPrinter();
        laserPrinter.print("Sample Document");

        // Создаем фабрику для создания струйных принтеров
        PrinterFactory inkjetPrinterFactory = new InkjetPrinterFactory();
        // Создаем струйный принтер
        Printer inkjetPrinter = inkjetPrinterFactory.createPrinter();
        inkjetPrinter.print("Another Document");
    }
}