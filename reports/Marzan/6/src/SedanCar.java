// Конкретная реализация автомобиля - седан
class SedanCar extends Car {
    public SedanCar() {
        type = "Sedan";
    }

    public void manufacture() {
        System.out.println("Manufacturing Sedan car.");
        // Дополнительные действия, специфичные для производства седанов
    }
}