public class Teacher extends Person implements Registrable {
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void announceRegistration(Course course) {
        System.out.println("Registration is now open for the course: " + course.getCourseName());
    }

    public void gradeStudent(Student student, int grade) {
        System.out.println("Grade " + grade + " assigned to student: " + student.getFullName());
        Archive.saveGrade(student, grade);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}