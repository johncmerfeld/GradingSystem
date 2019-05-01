package model;

import java.util.List;

public class StudentInfo {
    private String note;
    private List< CategoryLevelGrade> categoryLevelGrades;
    public StudentInfo(String note,List<CategoryLevelGrade> categoryLevelGrades){
        this.note = note;
        this.categoryLevelGrades = categoryLevelGrades;
    }

    public double getRawScore(){
        double sum=0;
        for(CategoryLevelGrade c:categoryLevelGrades){
            sum+=c.getCompositeScore()*c.getCategory().getWeight();
        }
        return sum;
    }

    public String getNote() {
        return note;
    }

    public List<CategoryLevelGrade> getCategoryLevelGrades() {
    	System.out.println("Entered function getCategoryLevelGrades");
        return categoryLevelGrades;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setCategoryLevelGrades(List<CategoryLevelGrade> categoryLevelGrades) {
        this.categoryLevelGrades = categoryLevelGrades;
    }
}
