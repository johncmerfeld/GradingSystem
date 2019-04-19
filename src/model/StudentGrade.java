package model;

public class StudentGrade {
    private int studentId;
    private GradeableItem gradeableItem;
    private Grade grade;
    public StudentGrade(int id, GradeableItem gradeableItem, Grade grade){
        this.studentId = id;
        this.gradeableItem = gradeableItem;
        this.grade = grade;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setGradeableItem(GradeableItem gradeableItem) {
        this.gradeableItem = gradeableItem;
    }

    public int getStudentId() {
        return studentId;
    }

    public GradeableItem getGradeableItem() {
        return gradeableItem;
    }

    public Grade getGrade() {
        return grade;
    }
}
