interface DigitalClock {
    void displayTime(int hours, int minutes);
}

class SimpleDigitalClock implements DigitalClock {
    @Override
    public void displayTime(int hours, int minutes) {
        System.out.println("Digital Clock: " + hours + ":" + minutes);
    }
}

class AnalogClock {
    private int hourRotation;
    private int minuteRotation;

    public AnalogClock() {
        this.hourRotation = 0;
        this.minuteRotation = 0;
    }

    public void setHourRotation(int rotation) {
        this.hourRotation = rotation;
    }

    public void setMinuteRotation(int rotation) {
        this.minuteRotation = rotation;
    }

    public int getHourRotation() {
        return hourRotation;
    }

    public int getMinuteRotation() {
        return minuteRotation;
    }
}

class AnalogToDigitalAdapter implements DigitalClock {
    private AnalogClock analogClock;

    public AnalogToDigitalAdapter(AnalogClock analogClock) {
        this.analogClock = analogClock;
    }

    @Override
    public void displayTime(int hours, int minutes) {
        int hourRotation = analogClock.getHourRotation();
        int minuteRotation = analogClock.getMinuteRotation();
        hours = hourRotation / 30;
        minutes = (minuteRotation / 6) % 60;

        System.out.println("Digital Time: " + hours + ":" + minutes);
    }
}

public class Task2 {
    public static void main(String[] args) {
        SimpleDigitalClock digitalClock = new SimpleDigitalClock();
        AnalogClock analogClock = new AnalogClock();

        analogClock.setHourRotation(90);
        analogClock.setMinuteRotation(180);

        System.out.println("Using digital clock directly:");
        digitalClock.displayTime(12,30);

        System.out.println("\nUsing analog clock via adapter:");
        DigitalClock adapter = new AnalogToDigitalAdapter(analogClock);
        adapter.displayTime(90, 180);
    }
}