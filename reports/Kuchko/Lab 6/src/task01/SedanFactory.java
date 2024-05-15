package org.example.task01;

public class SedanFactory implements CarAbstractFactory {
    @Override
    public Car createCar() {
        return new SedanCar();
    }
}
