import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1 --------------------------------------------
        Account account = new Account("1");

        account.deposit(1000);
        account.withdrawal(500);
        account.payment(200);

        account.printTransactions();
        System.out.println();

        // 2 --------------------------------------------
        Motherboard motherboard = new Motherboard();
        DiskDrive diskDrive = new DiskDrive();
        RAM ram = new RAM();

        Computer computer = new Computer(motherboard, diskDrive, ram);

        computer.powerOn();
        computer.readData();
        computer.powerOff();
        System.out.println();

        // 3 --------------------------------------------
        Course course = new Course("Java Programming");
        Teacher teacher = new Teacher("John", "Doe");

        course.setTeacher(teacher);

        Student student1 = new Student("Alice", "Smith");
        Student student2 = new Student("Bob", "Johnson");

        student1.enroll(course);
        student2.enroll(course);

        teacher.announceRegistration(course);

        teacher.gradeStudent(student1, 90);
        teacher.gradeStudent(student2, 85);

        List<Grade> allGrades = Archive.getAllGrades();
        for (Grade grade : allGrades) {
            Student student = grade.getStudent();
            int gradeValue = grade.getGrade();
            student.receiveGrade(gradeValue);
        }
    }
}
