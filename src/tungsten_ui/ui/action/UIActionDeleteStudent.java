package tungsten_ui.ui.action;

import student.Student;
import student.StudentManager;

public class UIActionDeleteStudent extends UIAction {
    private Student student;

    public UIActionDeleteStudent(Student s) {
        this.student = s;
    }

    public void run() {
        StudentManager.removeStudent(student);
    }
}
