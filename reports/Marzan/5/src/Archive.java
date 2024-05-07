import java.util.ArrayList;
import java.util.List;

public class Archive {
    private static List<Grade> grades = new ArrayList<>();

    public static void saveGrade(Student student, int grade) {
        grades.add(new Grade(student, grade));
    }

    public static List<Grade> getAllGrades() {
        return grades;
    }
}