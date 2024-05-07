public class Teacher {
    private String firstName;
    private String lastName;

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void announceRegistration(Course course) {
        System.out.println("Registration is now open for the course: " + course.getCourseName());
    }

    public void gradeStudent(Student student, int grade) {
        System.out.println("Grade " + grade + " assigned to student: " + student.getFullName());
        Archive.saveGrade(student, grade);
    }
}