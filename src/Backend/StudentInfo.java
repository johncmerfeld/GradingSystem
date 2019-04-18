package Backend;

import java.util.List;

public class StudentInfo {
    private String note;
    private List< CategoryLevelGrade> categoryLevelGrades;
    public StudentInfo(String note,List<CategoryLevelGrade> categoryLevelGrades){
        this.note = note;
        this.categoryLevelGrades = categoryLevelGrades;
    }

    int getRawScore(){
        return 0;
    }

}
