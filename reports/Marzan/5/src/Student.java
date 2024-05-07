public class Student extends Person {
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void enroll(Course course) {
        course.addStudent(this);
        System.out.println("Student " + getFullName() + " enrolled in the course: " + course.getCourseName());
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void receiveGrade(int grade) {
        System.out.println("Received grade: " + grade);
    }
}