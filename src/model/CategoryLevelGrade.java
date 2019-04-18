package model;

import java.util.ArrayList;
import java.util.List;

public class CategoryLevelGrade {
    private GradableCategory category;
    private List<StudentGrade> studentGrades;

    public CategoryLevelGrade(GradableCategory category){
        this.category = category;
        studentGrades = new ArrayList<>();
    }

    public double getCompositeScore(){
        double sum = 0;
        double max = 0;
        for(StudentGrade s:studentGrades){
            if(s.getGradeableItem().getScoringMethod() == GradeableItem.ScoringMethod.Deduction){
                sum += (s.getGradeableItem().getMaxPoints() - s.getGrade().getScore())*s.getGradeableItem().getWeightage();
            }
            if(s.getGradeableItem().getScoringMethod() == GradeableItem.ScoringMethod.Percentage){
                sum+= s.getGradeableItem().getMaxPoints()*s.getGrade().getScore()*s.getGradeableItem().getWeightage();
            }
            max += s.getGradeableItem().getMaxPoints()*s.getGradeableItem().getWeightage();
        }
        return sum/max;
    }

    public GradableCategory getCategory() {
        return category;
    }

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setCategory(GradableCategory category) {
        this.category = category;
    }

    public void setStudentGrades(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }
}
