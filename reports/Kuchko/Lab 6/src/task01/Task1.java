package org.example.task01;

public class Task1 {
    public static void main(String[] args) {
        CarAbstractFactory factory = new SedanFactory();
        Car car = factory.createCar();
        System.out.println(car);

        factory = new HatchbackFactory();
        car = factory.createCar();
        System.out.println(car);
    }
}
