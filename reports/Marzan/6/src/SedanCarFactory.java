// Конкретная реализация фабрики для производства седанов
class SedanCarFactory extends CarFactory {
    public Car createCar() {
        return new SedanCar();
    }
}