	package model;

import java.util.ArrayList;
import java.util.List;

public class CategoryLevelGrade {
    private GradableCategory category;
    private List<StudentGrade> studentGrades;

    public CategoryLevelGrade(GradableCategory category){
        this.category = category;
        studentGrades = new ArrayList<>();
        ArrayList<GradableItem> list_ofgradable_items = Database.getGradedItemsInCategory(category.getId());
        for(GradableItem gi : list_ofgradable_items)
        {
        	studentGrades.addAll(Database.getGradesByGradedItem(gi.getId()));
        }
    }

    public double getCompositeScore(){
        double sum = 0;
        double max = 0;
        
      //Null check for studentGrades
    	if(studentGrades == null)
    		return 0;
    	
        for(StudentGrade s:studentGrades){
        	if(s == null)
        		continue;
        	sum += s.getGrade().getScore()*s.getGradableItem().getWeightage()/100;

        	/*if(s.getGradableItem().getScoringMethod() == GradableItem.DEDUCTION){
                sum += (s.getGradableItem().getMaxPoints() - s.getGrade().getScore())*s.getGradableItem().getWeightage();
            }
        	else if(s.getGradableItem().getScoringMethod() == GradableItem.PERCENTAGE){
                sum+= s.getGradableItem().getMaxPoints()*s.getGrade().getScore()*s.getGradableItem().getWeightage();
            }*/
            max += s.getGradableItem().getMaxPoints()*s.getGradableItem().getWeightage()/100;
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
