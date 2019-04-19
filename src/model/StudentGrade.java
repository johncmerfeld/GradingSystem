package model;

public class StudentGrade {
    private int studentId;
    private GradableItem gradableItem;
    private Grade grade;
    public StudentGrade(int id, GradableItem gradableItem, Grade grade){
        this.studentId = id;
        this.gradableItem = gradableItem;
        this.grade = grade;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setGradableItem(GradableItem gradableItem) {
        this.gradableItem = gradableItem;
    }

    public int getStudentId() {
        return studentId;
    }

    public GradableItem getGradableItem() {
        return gradableItem;
    }

    public Grade getGrade() {
        return grade;
    }
}
