interface DigitalClock {
    void displayTime();
}
class DigitalClockImpl implements DigitalClock {
    @Override
    public void displayTime() {
        // Реализация вывода времени на цифровых часах
        System.out.println("Digital Clock: HH:MM:SS");
    }
}
class AnalogClock {
    private int hourDegree;

    private int secondDegree;

    public void setClock(int hour,int second) {
        // Установка времени на часах со стрелками
        this.hourDegree = hour;
        this.secondDegree = second;
    }

    public int getHourDegree() {
        return hourDegree;
    }

    public int getSecondDegree() {
        return secondDegree;
    }
}
class AnalogToDigitalClockAdapter implements DigitalClock {
    private AnalogClock analogClock;
    public AnalogToDigitalClockAdapter(AnalogClock analogClock) {
        this.analogClock = analogClock;
    }
    @Override
    public void displayTime() {
        int hour = analogClock.getHourDegree()/30;
        double tempMinute= (double) analogClock.getHourDegree() /30;
        int minute = (int)((tempMinute-hour) *60);
        int second = analogClock.getSecondDegree()/6;

        System.out.println("Digital Clock (Adapter): " + String.format("%02d:%02d:%02d", hour, minute, second));
    }
}
public class Lab6_2 {
    public static void main(String[] args) {

        AnalogClock analogClock = new AnalogClock();
        System.out.println("Degrees of rotation of the arrows: 310 hours,45 seconds");
        analogClock.setClock(310,  45);

        DigitalClock digitalClock = new AnalogToDigitalClockAdapter(analogClock);

        digitalClock.displayTime();
    }
}