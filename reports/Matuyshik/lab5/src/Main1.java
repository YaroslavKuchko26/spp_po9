// Интерфейс Транспортное Средство
interface Transport {
    void move();
}

// Абстрактный класс Общественный Транспорт реализует интерфейс Transport
abstract class PublicTransport implements Transport {
    abstract void passengers();
}

// Класс Троллейбус наследует абстрактный класс Общественный Транспорт
class Trolleybus extends PublicTransport {
    @Override
    public void move() {
        System.out.println("Троллейбус двигается по линии.");
    }

    @Override
    void passengers() {
        System.out.println("В троллейбусе много пассажиров.");
    }
}

// Класс Автобус наследует абстрактный класс Общественный Транспорт
class Bus extends PublicTransport {
    @Override
    public void move() {
        System.out.println("Автобус двигается по маршруту.");
    }

    @Override
    void passengers() {
        System.out.println("В автобусе разное количество пассажиров.");
    }
}

// Класс Метро наследует абстрактный класс Общественный Транспорт
class Metro extends PublicTransport {
    @Override
    public void move() {
        System.out.println("Метро двигается по маршруту.");
    }

    @Override
    void passengers() {
        System.out.println("В метро большое количество пассажиров.");
    }
}

// Пример использования полиморфизма
public class Main1 {
    public static void main(String[] args) {
        // Создание экземпляра класса Троллейбус и вызов его методов
        Trolleybus trolleybus = new Trolleybus();
        trolleybus.move();
        trolleybus.passengers();

        // Создание экземпляра класса Автобус и вызов его методов
        Bus bus = new Bus();
        bus.move();
        bus.passengers();

        // Создание экземпляра класса Метро и вызов его методов
        Metro metro = new Metro();
        metro.move();
        metro.passengers();

        // Полиморфизм: создание массива Общественных Транспортов и вызов их методов
        PublicTransport[] transports = new PublicTransport[3];
        transports[0] = new Trolleybus();
        transports[1] = new Bus();
        transports[2] = new Metro();

        for (PublicTransport transport : transports) {
            transport.move();
            transport.passengers();
        }
    }
}
