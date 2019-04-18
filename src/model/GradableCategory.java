package model;

public class GradableCategory {
    private int id;
    private String name;
    private int weight;
    public GradableCategory(String name, int weight){
        //create an id by some rule;
        this.name = name;
        this.weight = weight;
    }
}
