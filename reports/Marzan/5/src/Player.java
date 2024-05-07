abstract class Player implements Technic {
    private boolean powerOn;

    public void turnOn() {
        powerOn = true;
        System.out.println("Player is turned on.");
    }

    public void turnOff() {
        powerOn = false;
        System.out.println("Player is turned off.");
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public abstract void play();
}