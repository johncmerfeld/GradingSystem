package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Category {
    private String categoryName;
    private ArrayList<GradeItem> GradeItems;
    private Map<Integer,Double> rubric;//gid, percentage

    Category(String categoryName){
        this.categoryName = categoryName;
        this.GradeItems = new ArrayList<>();
        this.rubric = new HashMap<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<GradeItem> getGradeItems() {
        return GradeItems;
    }

    public Map<Integer, Double> getRubric() {
        return rubric;
    }

    public void addGradItem(GradeItem gi){
        GradeItems.add(gi);
        rubric.put(gi.getGradItemId(), (double) 0);
    }

    public void removeGradItem(int id){
        for(int i = 0; i<GradeItems.size();i++){
            if(GradeItems.get(i).getGradItemId() == id){
                GradeItems.remove(i);
                rubric.remove(id);
            }
        }
    }
}
