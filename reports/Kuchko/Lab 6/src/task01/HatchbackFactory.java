package org.example.task01;

public class HatchbackFactory implements CarAbstractFactory{
    @Override
    public Car createCar() {
        return new HatchbackCar();
    }
}
