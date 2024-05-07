public class DiskDrive {
    private boolean poweredOn;

    public void powerOn() {
        poweredOn = true;
        System.out.println("Disk drive powered on.");
    }

    public void powerOff() {
        poweredOn = false;
        System.out.println("Disk drive powered off.");
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }
}
