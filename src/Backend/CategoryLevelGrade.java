package Backend;

import java.util.ArrayList;
import java.util.List;

public class CategoryLevelGrade {
    private GradableCategory category;
    private List<StudentGrade> studentGrades;

    public CategoryLevelGrade(GradableCategory category){
        this.category = category;
        studentGrades = new ArrayList<>();
    }

    int getCompositeScore(){
        return 0;
    }

}
