package org.example.task3;

import java.util.List;

public class Route {

    private final String name;

    private final VehicleTypeEnum vehicleType;
    private int interval;
    private int currentInterval;
    private Vehicle vehicle;

    public Route(String name, VehicleTypeEnum vehicleType, int interval) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.interval = interval;
        currentInterval = 0;
    }

    public boolean update() {
        currentInterval--;

        if (vehicle == null) {
            System.out.println("[" + name + " / " + interval + "]: нет транспорта.");
            return false;
        }

        vehicle.move();

        if (vehicle.isBroken()) {
            System.out.println("[" + name + " / " + interval + "]: " + vehicle.getName() + " сломан.");
            return false;
        }

        if (currentInterval <= 0) {
            currentInterval = interval;
            System.out.println("[" + name + " / " + interval + "]: " + vehicle.getName() + " начал движение по маршруту.");
        }

        return true;
    }

    public boolean assignVehicle(List<Vehicle> freeVehicles) {
        Vehicle vehicle = freeVehicles.stream()
                .filter(v -> v.getVehicleType().equals(vehicleType))
                .findFirst().orElse(null);

        if (vehicle != null) {
            freeVehicles.remove(vehicle);
            this.vehicle = vehicle;
            System.out.println("[" + name + " / " + interval + "]: " + vehicle.getName() + " назначен на маршрут.");
            return true;
        } else {
            this.vehicle = null;
            interval++;
            currentInterval++;
            return false;
        }
    }

}
