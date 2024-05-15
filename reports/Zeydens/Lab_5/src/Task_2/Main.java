// Абстрактный класс Работник фирмы
abstract class Employee {
    private String name;
    private int employeeId;
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public abstract double calculateSalary();
}
// Подкласс Менеджер
class Manager extends Employee {
    private double baseSalary;
    private double bonus;
    public Manager(String name, int employeeId, double baseSalary, double bonus) {
        super(name, employeeId);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}
// Подкласс Аналитик
class Analyst extends Employee {
    private double baseSalary;
    public Analyst(String name, int employeeId, double baseSalary) {
        super(name, employeeId);
        this.baseSalary = baseSalary;
    }
    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
// Подкласс Программист
class Programmer extends Employee {
    private double baseSalary;
    private int hoursWorked;
    private double hourlyRate;
    public Programmer(String name, int employeeId, double baseSalary, int hoursWorked, double hourlyRate) {
        super(name, employeeId);
        this.baseSalary = baseSalary;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return baseSalary + (hoursWorked * hourlyRate);
    }
}
// Подкласс Тестировщик
class Tester extends Employee {
    private double baseSalary;
    private int bugsFound;
    private double bugRate;
    public Tester(String name, int employeeId, double baseSalary, int bugsFound, double bugRate) {
        super(name, employeeId);
        this.baseSalary = baseSalary;
        this.bugsFound = bugsFound;
        this.bugRate = bugRate;
    }
    @Override
    public double calculateSalary() {
        return baseSalary + (bugsFound * bugRate);
    }
}
// Подкласс Дизайнер
class Designer extends Employee {
    private double baseSalary;
    private int projectsCompleted;
    private double projectBonus;
    public Designer(String name, int employeeId, double baseSalary, int projectsCompleted, double projectBonus) {
        super(name, employeeId);
        this.baseSalary = baseSalary;
        this.projectsCompleted = projectsCompleted;
        this.projectBonus = projectBonus;
    }
    @Override
    public double calculateSalary() {
        return baseSalary + (projectsCompleted * projectBonus);
    }
}
// Подкласс Бухгалтер
class Accountant extends Employee {
    private double baseSalary;
    private double taxRate;
    public Accountant(String name, int employeeId, double baseSalary, double taxRate) {
        super(name, employeeId);
        this.baseSalary = baseSalary;
        this.taxRate = taxRate;
    }
    @Override
    public double calculateSalary() {
        return baseSalary - (baseSalary * taxRate);
    }
}
public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[6];
        employees[0] = new Manager("John", 1, 5000, 1000);
        employees[1] = new Analyst("Alice", 2, 4000);
        employees[2] = new Programmer("Bob", 3, 3000, 160, 20);
        employees[3] = new Tester("Eve", 4, 2500, 50, 10);
        employees[4] = new Designer("Mia", 5, 3500, 5, 100);
        employees[5] = new Accountant("Oliver", 6, 4500, 0.1);

        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getName());
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("Salary: $" + employee.calculateSalary());
            System.out.println("-----------------------------------");
        }
    }
}