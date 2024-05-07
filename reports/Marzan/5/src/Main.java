import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1 -----------------------------------------------
        VideoPlayer videoPlayer = new VideoPlayer();

        videoPlayer.turnOn();
        videoPlayer.play();

        videoPlayer.turnOff();
        videoPlayer.play();
        System.out.println();

        // 2 -----------------------------------------------
        Carrier[] carriers = new Carrier[3]; // Массив объектов суперкласса
        carriers[0] = new Airplane("Boeing 747", "APL001", 900, 10);
        carriers[1] = new Train("Express Train", "TRN001", 120, 5);
        carriers[2] = new Car("Sedan Car", "CAR001", 80, 7);

        int distance = 500; // Расстояние для перевозки

        for (Carrier carrier : carriers) {
            System.out.println("Carrier: " + carrier.getName());
            System.out.println("Identifier: " + ((Identifiable) carrier).getIdentifier());
            System.out.println("Time: " + carrier.calculateTime(distance) + " hours");
            System.out.println("Cost: $" + carrier.calculateCost(distance));
            System.out.println();
        }

        // 3 -----------------------------------------------
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
