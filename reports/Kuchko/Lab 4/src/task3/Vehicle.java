package org.example.task3;

public class Vehicle {

    private final VehicleTypeEnum vehicleType;

    private final String name;
    private final double breakProbability;
    private boolean isBroken = false;

    public Vehicle(VehicleTypeEnum vehicleType, String name, double breakProbability) {
        this.vehicleType = vehicleType;
        this.name = name;
        this.breakProbability = breakProbability;
    }

    public void move() {
        isBroken = getRandomBoolean(breakProbability);
    }

    public VehicleTypeEnum getVehicleType() {
        return vehicleType;
    }

    public String getName() {
        return name;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public static boolean getRandomBoolean(double probability) {
        double randomValue = Math.random();
        return randomValue <= probability;
    }
}
