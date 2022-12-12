package student;

import java.util.ArrayList;

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student s) {
        students.add(s);
    }

    public static void removeStudent(Student s) {
        students.remove(s);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }
}
