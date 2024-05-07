public class Grade {
    private Student student;
    private int grade;

    public Grade(Student student, int grade) {
        this.student = student;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public int getGrade() {
        return grade;
    }
}
