package Backend;

public class GradeItem {
    private int gradItemId;
    private String name;
    private String category;
    private int maxPoints;
    private boolean scalingMethod;//false means scale down, true means percentage.

    GradeItem(int gradItemId, String name, String category, int maxPoints, boolean scalingMethod){
        this.gradItemId = gradItemId;
        this.name = name;
        this.category = category;
        this.maxPoints = maxPoints;
        this.scalingMethod = scalingMethod;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public String getCategory() {
        return category;
    }

    public int getGradItemId() {
        return gradItemId;
    }

    public String getName() {
        return name;
    }

    public boolean getScalingMethod(){
        return scalingMethod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setGradItemId(int gradItemId) {
        this.gradItemId = gradItemId;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void setScalingMethod(boolean scalingMethod) {
        this.scalingMethod = scalingMethod;
    }
}
