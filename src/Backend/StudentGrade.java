package Backend;

public class StudentGrade {
    private int id;
    private GradeableItem gradeableItem;
    private Grade grade;
    public StudentGrade(int id, GradeableItem gradeableItem, Grade grade){
        this.id = id;
        this.gradeableItem = gradeableItem;
        this.grade = grade;
    }

}
