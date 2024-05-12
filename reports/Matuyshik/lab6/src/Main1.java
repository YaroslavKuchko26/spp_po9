// Абстрактный класс для завода автомобилей
abstract class CarFactory {
    public abstract Car createCar();
}

// Конкретные заводы и их реализации
class VolkswagenFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new VolkswagenCar();
    }
}

class AudiFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new AudiCar();
    }
}

// Абстрактный класс для автомобиля
interface Car {
    void drive();
}

// Конкретные реализации автомобилей
class VolkswagenCar implements Car {
    @Override
    public void drive() {
        System.out.println("Volkswagen car is driving.");
    }
}

class AudiCar implements Car {
    @Override
    public void drive() {
        System.out.println("Audi car is driving.");
    }
}

public class Main1 {
    public static void main(String[] args) {
        CarFactory volkswagenFactory = new VolkswagenFactory();
        CarFactory audiFactory = new AudiFactory();

        Car volkswagenCar = volkswagenFactory.createCar();
        Car audiCar = audiFactory.createCar();

        volkswagenCar.drive();
        audiCar.drive();
    }
}
