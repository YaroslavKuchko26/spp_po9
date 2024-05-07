// Конкретная реализация фабрики для производства внедорожников
class SUVCarFactory extends CarFactory {
    public Car createCar() {
        return new SUVCar();
    }
}