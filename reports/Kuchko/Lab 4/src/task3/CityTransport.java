package org.example.task3;

import java.util.ArrayList;
import java.util.List;

public class CityTransport {

    private final List<Route> routes = new ArrayList<>();
    private final List<Vehicle> freeVehicles = new ArrayList<>();

    public boolean addRoute(Route route) {
        routes.add(route);
        return (route.assignVehicle(freeVehicles));
    }

    public boolean addVehicle(Vehicle vehicle) {
        return freeVehicles.add(vehicle);
    }

    public void update() {
        for (Route route : routes) {
            if (!route.update()) {
                route.assignVehicle(freeVehicles);
            }
        }
    }

}
