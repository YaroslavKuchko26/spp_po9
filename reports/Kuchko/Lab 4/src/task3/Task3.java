package org.example.task3;

public class Task3 {
    public static void main(String[] args) {
        CityTransport cityTransport = new CityTransport();

        cityTransport.addVehicle(new Vehicle(VehicleTypeEnum.TROLLEYBUS, "Троллейбус №1", 0.30));
        cityTransport.addVehicle(new Vehicle(VehicleTypeEnum.TROLLEYBUS, "Троллейбус №2", 0.30));
        cityTransport.addVehicle(new Vehicle(VehicleTypeEnum.TROLLEYBUS, "Троллейбус №3", 0.00));
        cityTransport.addVehicle(new Vehicle(VehicleTypeEnum.TROLLEYBUS, "Троллейбус №4", 0.00));
        cityTransport.addVehicle(new Vehicle(VehicleTypeEnum.BUS, "Автобус №1", 0.30));
        cityTransport.addVehicle(new Vehicle(VehicleTypeEnum.BUS, "Автобус №2", 0.30));
        cityTransport.addVehicle(new Vehicle(VehicleTypeEnum.BUS, "Автобус №3", 0.00));
        cityTransport.addVehicle(new Vehicle(VehicleTypeEnum.BUS, "Автобус №4", 0.00));

        cityTransport.addRoute(new Route("Автобусный маршрут №1", VehicleTypeEnum.BUS, 10));
        cityTransport.addRoute(new Route("Автобусный маршрут №2", VehicleTypeEnum.BUS, 5));
        cityTransport.addRoute(new Route("Троллейбусный маршрут №1", VehicleTypeEnum.TROLLEYBUS, 4));
        cityTransport.addRoute(new Route("Троллейбусный маршрут №2", VehicleTypeEnum.TROLLEYBUS, 6));

        for (int i = 1; i <= 15; i++) {
            System.out.println("------------------\n" + "Итерация " + i + "\n------------------");
            cityTransport.update();
        }
    }
}