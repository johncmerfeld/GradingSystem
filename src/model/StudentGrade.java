package model;

public class StudentGrade {
    private int id;
    private GradeableItem gradeableItem;
    private Grade grade;
    public StudentGrade(int id, GradeableItem gradeableItem, Grade grade){
        this.id = id;
        this.gradeableItem = gradeableItem;
        this.grade = grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setGradeableItem(GradeableItem gradeableItem) {
        this.gradeableItem = gradeableItem;
    }

    public int getId() {
        return id;
    }

    public GradeableItem getGradeableItem() {
        return gradeableItem;
    }

    public Grade getGrade() {
        return grade;
    }
}
