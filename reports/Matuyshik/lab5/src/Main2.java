// Абстрактный класс Работник фирмы
abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Абстрактный метод для начисления зарплаты
    abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Метод для вывода входных данных
    public void displayInputData() {
        System.out.println("Имя: " + name + ", Базовая зарплата: " + baseSalary);
    }
}

// Подкласс Менеджер
class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return baseSalary + bonus;
    }
}

// Подкласс Аналитик
class Analyst extends Employee {
    private int completedProjects;
    private double bonusPerProject;

    public Analyst(String name, double baseSalary, int completedProjects, double bonusPerProject) {
        super(name, baseSalary);
        this.completedProjects = completedProjects;
        this.bonusPerProject = bonusPerProject;
    }

    @Override
    double calculateSalary() {
        return baseSalary + (completedProjects * bonusPerProject);
    }
}

// Подкласс Программист
class Programmer extends Employee {
    private int linesOfCode;
    private double bonusPerLineOfCode;

    public Programmer(String name, double baseSalary, int linesOfCode, double bonusPerLineOfCode) {
        super(name, baseSalary);
        this.linesOfCode = linesOfCode;
        this.bonusPerLineOfCode = bonusPerLineOfCode;
    }

    @Override
    double calculateSalary() {
        return baseSalary + (linesOfCode * bonusPerLineOfCode);
    }
}

// Пример использования
public class Main2 {
    public static void main(String[] args) {
        // Создаем массив объектов суперкласса и заполняем объектами подклассов
        Employee[] employees = new Employee[3];
        employees[0] = new Manager("John", 2000, 500); // Менеджер с базовой зарплатой 2000 и бонусом 500
        employees[1] = new Analyst("Alice", 1800, 5, 100); // Аналитик с базовой зарплатой 1800, завершенными проектами 5 и бонусом за проект 100
        employees[2] = new Programmer("Bob", 2500, 10000, 0.1); // Программист с базовой зарплатой 2500, строками кода 10000 и бонусом за строку кода 0.1

        // Используем объекты подклассов для моделирования реальных ситуаций
        for (Employee employee : employees) {
            employee.displayInputData(); // Выводим входные данные
            System.out.println("Конечная зарплата: " + employee.calculateSalary());
        }
    }
}
