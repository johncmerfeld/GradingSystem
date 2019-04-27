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
        	//Null check for gradableItem
        	if(s.getGradableItem() == null)
        		continue;
        	else if(s.getGradableItem().getScoringMethod() == GradableItem.DEDUCTION){
                sum += (s.getGradableItem().getMaxPoints() - s.getGrade().getScore())*s.getGradableItem().getWeightage();
            }
        	else if(s.getGradableItem().getScoringMethod() == GradableItem.PERCENTAGE){
                sum+= s.getGradableItem().getMaxPoints()*s.getGrade().getScore()*s.getGradableItem().getWeightage();
            }
            max += s.getGradableItem().getMaxPoints()*s.getGradableItem().getWeightage();
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
