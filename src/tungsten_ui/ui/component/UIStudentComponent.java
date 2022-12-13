package tungsten_ui.ui.component;

import student.Student;

public class UIStudentComponent extends UIComponent {
    private UITextFieldComponent firstNameField;
    private UITextFieldComponent lastNameField;
    private UIButtonComponent deleteButton;
    private UINumberFieldComponent gradeNumberField;
    private Student student;

    public UIStudentComponent(int x, int y, Student s) {
        super(x, y);
        this.student = s;
        firstNameField = new UITextFieldComponent(40, 0, 200, 60, 20);
        lastNameField = new UITextFieldComponent(220, 0, 200, 60, 20);
        gradeNumberField = new UINumberFieldComponent(460, 0, 60, 60, 9, 12, 9);
        deleteButton = new UIButtonComponent(540, 0, 60, 60, "X");
    }
}
