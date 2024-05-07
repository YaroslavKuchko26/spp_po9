package Task_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer("HP LaserJet Pro", 50, 10, 5);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("========== Printer Menu ==========");
            System.out.println("1. Print Document");
            System.out.println("2. Load Paper");
            System.out.println("3. Remove Paper Jam");
            System.out.println("4. Refill Ink");
            System.out.println("5. Check Printer Status");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printer.printDocument();
                    break;
                case 2:
                    System.out.print("Enter number of sheets to load: ");
                    int sheets = scanner.nextInt();
                    printer.loadPaper(sheets);
                    break;
                case 3:
                    printer.removeJam();
                    break;
                case 4:
                    printer.refillInk();
                    break;
                case 5:
                    printer.printStatus();
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
