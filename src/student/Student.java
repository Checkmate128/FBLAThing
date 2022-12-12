package student;

public class Student {
    private int grade;
    private String firstName;
    private String lastName;
    private int points = 0;

    private boolean[] activities = {false, false, false, false, false, false, false, false, false, false};

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void setActivityCompletion(int activity, boolean value) {
        this.activities[activity] = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    public int getPoints() {
        return points;
    }

    public boolean[] getActivitiesCompletion() {
        return activities;
    }
}
