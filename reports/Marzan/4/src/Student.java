public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
