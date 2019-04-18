package model;

public class GradeableItem {
    private int id;
    private String name;
    private int maxPoints;
    private String scoringMethod;
    private int weightage;
    public GradeableItem(String name, int maxPoints, String scoringMethod, int weightage){
        this.name = name;
        this.maxPoints = maxPoints;
        this.scoringMethod = scoringMethod;
        this.weightage = weightage;
    }
}
