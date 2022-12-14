package tungsten_ui.ui.action;

import student.Student;
import student.StudentManager;

public class UIActionAddStudent extends UIAction {
    public UIActionAddStudent() {

    }

    public void run() {
        StudentManager.addStudent(new Student("", "", 9));
    }
}
