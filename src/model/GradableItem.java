package model;

public class GradableItem {
	
    
    public static int DEDUCTION = 1;
    public static int PERCENTAGE = 2;
	
    private int id;
    private String name;
    private int maxPoints; // TODO might need to change to double
    private double weight;
    private int scoringMethod;
    // TODO does this need an include flag?
    
    public GradableItem(String name, int maxPoints, int scoringMethod, double weight){
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

    public int getScoringMethod() {
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

    public void setScoringMethod(int scoringMethod) {
        this.scoringMethod = scoringMethod;
    }

    public void setWeightage(double weightage) {
        this.weight = weight;
    }
}
