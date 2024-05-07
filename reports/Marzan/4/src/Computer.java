public class Computer {
    private Motherboard motherboard;
    private DiskDrive diskDrive;
    private RAM ram;

    public Computer(Motherboard motherboard, DiskDrive diskDrive, RAM ram) {
        this.motherboard = motherboard;
        this.diskDrive = diskDrive;
        this.ram = ram;
    }

    public void powerOn() {
        motherboard.powerOn();
        diskDrive.powerOn();
        ram.powerOn();
        System.out.println("Computer powered on.");
    }

    public void powerOff() {
        motherboard.powerOff();
        diskDrive.powerOff();
        ram.powerOff();
        System.out.println("Computer powered off.");
    }

    public void readData() {
        if (diskDrive.isPoweredOn()) {
            System.out.println("Reading data from disk drive.");
        } else {
            System.out.println("Disk drive is not powered on.");
        }
    }
}

