// Конкретная реализация автомобиля - внедорожник
class SUVCar extends Car {
    public SUVCar() {
        type = "SUV";
    }

    public void manufacture() {
        System.out.println("Manufacturing SUV car.");
        // Дополнительные действия, специфичные для производства внедорожников
    }
}