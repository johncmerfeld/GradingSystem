package Backend;

public class GradeableItem {
    private int id;
    private String name;
    private int maxPoints;
    enum ScoringMethod {
        Deduction,Percentage
    }
    private ScoringMethod scoringMethod = ScoringMethod.Deduction;
    private double weight;
    public GradeableItem(String name, int maxPoints, ScoringMethod scoringMethod, double weight){
        this.name = name;
        this.maxPoints = maxPoints;
        this.scoringMethod = scoringMethod;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public double getWeightage() {
        return weight;
    }

    public ScoringMethod getScoringMethod() {
        return scoringMethod;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void setScoringMethod(ScoringMethod scoringMethod) {
        this.scoringMethod = scoringMethod;
    }

    public void setWeightage(double weightage) {
        this.weight = weight;
    }
}
