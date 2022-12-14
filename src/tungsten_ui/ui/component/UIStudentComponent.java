package tungsten_ui.ui.component;

import student.Student;
import tungsten_ui.ui.action.UIActionDeleteStudent;
import tungsten_ui.ui.action.UIActionReloadDatabase;

import java.awt.*;

public class UIStudentComponent extends UICompoundComponent {
    private UITextFieldComponent firstNameField;
    private UITextFieldComponent lastNameField;
    private UIButtonComponent deleteButton;
    private UINumberFieldComponent gradeNumberField;
    private UITextComponent studentNameLabel;
    private UICheckBoxComponent activityCheckBox;
    private Student student;

    public UIStudentComponent(int x, int y, Student s, boolean isEditing) {
        super(x, y);
        this.student = s;
        firstNameField = new UITextFieldComponent(40, 0, 200, 60, 20);
        firstNameField.setText(s.getFirstName());
        lastNameField = new UITextFieldComponent(250, 0, 200, 60, 20);
        lastNameField.setText(s.getLastName());
        gradeNumberField = new UINumberFieldComponent(460, 0, 60, 60, 9, 12, 9);
        gradeNumberField.setText(s.getGrade() + "");
        deleteButton = new UIButtonComponent(540, 0, 60, 60, "X");
        deleteButton.addClickAction(new UIActionDeleteStudent(student));
        deleteButton.addClickAction(new UIActionReloadDatabase(0));
        studentNameLabel = new UITextComponent(40, 0, 460, 60, 20, s.getFirstName() + " " + s.getLastName());
        activityCheckBox = new UICheckBoxComponent(560, 10, 40, 40);
        if(isEditing) {
            studentNameLabel.setVisible(false);
            activityCheckBox.setVisible(false);
        } else {
            firstNameField.setVisible(false);
            lastNameField.setVisible(false);
            gradeNumberField.setVisible(false);
            deleteButton.setVisible(false);
        }
        addComponent(firstNameField);
        addComponent(lastNameField);
        addComponent(gradeNumberField);
        addComponent(deleteButton);
        addComponent(studentNameLabel);
        addComponent(activityCheckBox);
    }

    public void tick() {
        student.setFirstName(firstNameField.text);
        student.setLastName(lastNameField.text);
        student.setGrade(Integer.parseInt(gradeNumberField.text));
    }

//    public void render(Graphics2D g, int offsetX, int offsetY) {
//        firstNameField.render(g, x + offsetX, y + offsetY);
//        lastNameField.render(g, x + offsetX, y + offsetY);
//        gradeNumberField.render(g, x + offsetX, y + offsetY);
//        deleteButton.render(g, x + offsetX, y + offsetY);
//        studentNameLabel.render(g, x + offsetX, y + offsetY);
//        activityCheckBox.render(g, x + offsetX, y + offsetY);
//        g.setColor(Color.BLACK);
//        g.drawRect(x + offsetX, y + offsetY, width, height);
//    }
}
