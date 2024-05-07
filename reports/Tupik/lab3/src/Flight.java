import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Flight {
    private String destination;
    private String flightNumber;
    private String aircraftType;
    private LocalDateTime departureTime;
    private List<String> daysOfWeek;

    public Flight(String destination, String flightNumber, String aircraftType, LocalDateTime departureTime, List<String> daysOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.daysOfWeek = daysOfWeek;
    }

    // Геттеры дял доступа к полям класса Flights
    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    // Пример использования классов
    public static void main(String[] args) {
        List<Flight> flights = readFlightsFromFile("src/flights.txt");
        FlightManager manager = new FlightManager(flights);

        // Вывод списка всех рейсов
        System.out.println("Список всех рейсов:");
        manager.printFlights(flights);

        // Вывод списка рейсов для заданного пункта назначения
        String destination = "Москва";
        System.out.println("Рейсы в " + destination + ":");
        List<Flight> flightsToDestination = manager.getFlightsByDestination(destination);
        manager.printFlights(flightsToDestination);

        // Вывод списка рейсов для заданного дня недели
        String dayOfWeek = "Пн";
        System.out.println("Рейсы на " + dayOfWeek + ":");
        List<Flight> flightsOnDay = manager.getFlightsByDayOfWeek(dayOfWeek);
        manager.printFlights(flightsOnDay);

        // Вывод списка рейсов для заданного дня недели, время вылета для которых больше заданного
        int hour = 10;
        int minute = 0;
        System.out.println("Рейсы на " + dayOfWeek + ", вылет после " + hour + ":" + minute + ":");
        List<Flight> flightsOnDayAfterTime = manager.getFlightsByDayAndTimeAfter(dayOfWeek, hour, minute);
        manager.printFlights(flightsOnDayAfterTime);

        // Все рейсы самолетов некоторого типа
        String aircraftType = "Boeing 747";
        System.out.println("Рейсы на самолете типа " + aircraftType + ":");
        List<Flight> flightsByAircraftType = manager.getFlightsByAircraftType(aircraftType);
        manager.printFlights(flightsByAircraftType);

        // Группировка рейсов по числу пассажиров
        System.out.println("Группировка рейсов по числу пассажиров:");
        manager.printGroupedFlightsByPassengerCapacity();
    }

    // Метод для чтения рейсов из файла
    private static List<Flight> readFlightsFromFile(String filename) {
        List<Flight> flights = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String destination = parts[0];
                String flightNumber = parts[1];
                String aircraftType = parts[2];
                LocalDateTime departureTime = LocalDateTime.parse(parts[3]);
                List<String> daysOfWeek = new ArrayList<>();
                for (int i = 4; i < parts.length; i++) {
                    daysOfWeek.add(parts[i]);
                }
                flights.add(new Flight(destination, flightNumber, aircraftType, departureTime, daysOfWeek));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flights;
    }
}

    class FlightManager {
        private List<Flight> flights;

        public FlightManager(List<Flight> flights) {
            this.flights = flights;
        }

        // Метод для получения списка рейсов для заданного пункта назначения
        public List<Flight> getFlightsByDestination(String destination) {
            return flights.stream()
                    .filter(flight -> flight.getDestination().equalsIgnoreCase(destination))
                    .collect(Collectors.toList());
        }

        // Метод для получения списка рейсов для заданного дня недели
        public List<Flight> getFlightsByDayOfWeek(String dayOfWeek) {
            return flights.stream()
                    .filter(flight -> flight.getDaysOfWeek().contains(dayOfWeek))
                    .collect(Collectors.toList());
        }

        // Метод для получения списка рейсов для заданного дня недели и времени вылета после указанного
        public List<Flight> getFlightsByDayAndTimeAfter(String dayOfWeek, int hour, int minute) {
            return flights.stream()
                    .filter(flight -> flight.getDaysOfWeek().contains(dayOfWeek))
                    .filter(flight -> flight.getDepartureTime().getHour() > hour ||
                            (flight.getDepartureTime().getHour() == hour &&
                                    flight.getDepartureTime().getMinute() > minute))
                    .collect(Collectors.toList());
        }

        // Метод для получения списка рейсов для заданного типа самолета
        public List<Flight> getFlightsByAircraftType(String aircraftType) {
            return flights.stream()
                    .filter(flight -> flight.getAircraftType().equalsIgnoreCase(aircraftType))
                    .collect(Collectors.toList());
        }

        // Метод для группировки рейсов по числу пассажиров
        public Map<String, List<Flight>> groupFlightsByPassengerCapacity() {
            Map<String, List<Flight>> groupedFlights = new HashMap<>();
            List<Flight> smallFlights = new ArrayList<>();
            List<Flight> mediumFlights = new ArrayList<>();
            List<Flight> largeFlights = new ArrayList<>();

            for (Flight flight : flights) {
                int capacity = calculatePassengerCapacity(flight.getAircraftType());
                if (capacity <= 100) {
                    smallFlights.add(flight);
                } else if (capacity <= 200) {
                    mediumFlights.add(flight);
                } else {
                    largeFlights.add(flight);
                }
            }

            groupedFlights.put("Маломестные рейсы (1-100 чел)", smallFlights);
            groupedFlights.put("Среднеместные рейсы (100-200 чел)", mediumFlights);
            groupedFlights.put("Крупные рейсы (200-350 чел)", largeFlights);

            return groupedFlights;
        }

        // Метод для расчета вместимости самолета по типу
        private int calculatePassengerCapacity(String aircraftType) {
            if (aircraftType.equalsIgnoreCase("Boeing 747")) {
                return 150;
            } else if (aircraftType.equalsIgnoreCase("Airbus A340")) {
                return 295;
            } else {
                return 90;
            }
        }

        // Метод для вывода группированных рейсов по числу пассажиров
        public void printGroupedFlightsByPassengerCapacity() {
            Map<String, List<Flight>> groupedFlights = groupFlightsByPassengerCapacity();
            for (Map.Entry<String, List<Flight>> entry : groupedFlights.entrySet()) {
                System.out.println(entry.getKey());
                for (Flight flight : entry.getValue()) {
                    System.out.println(flight.getFlightNumber() + " - " + flight.getAircraftType());
                }
            }
        }

        // Метод для вывода списка рейсов
        public void printFlights(List<Flight> flights) {
            for (Flight flight : flights) {
                StringBuilder days = new StringBuilder();
                for (String dayAbbreviation : flight.getDaysOfWeek()) {
                    // Получаем объект DayOfWeek на основе целочисленного значения
                    DayOfWeek dayOfWeek = DayOfWeek.of(getDayOfWeekValue(dayAbbreviation));
                    // Получаем полное название дня недели
                    String fullDayName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
                    days.append(fullDayName).append(", ");
                }
                if (days.length() > 0) {
                    days.delete(days.length() - 2, days.length()); // Убираем лишнюю запятую и пробел в конце
                }
                System.out.println("Номер рейса: " + flight.getFlightNumber());
                System.out.println("Пункт назначения: " + flight.getDestination());
                System.out.println("Тип самолета: " + flight.getAircraftType());
                System.out.println("Время вылета: " + flight.getDepartureTime());
                System.out.println("Дни недели: " + days);
                System.out.println();
            }
        }

        // Метод для преобразования сокращенного названия дня недели в целочисленное значение
        private int getDayOfWeekValue(String abbreviation) {
            switch (abbreviation.toUpperCase()) {
                case "ПН":
                    return 1;
                case "ВТ":
                    return 2;
                case "СР":
                    return 3;
                case "ЧТ":
                    return 4;
                case "ПТ":
                    return 5;
                case "СБ":
                    return 6;
                case "ВС":
                    return 7;
                default:
                    throw new IllegalArgumentException("Неверное сокращенное название дня недели: " + abbreviation);
            }
        }
    }
