package model; 

public class GradableCategory {
    private int id;
    private String name;
    private double weight;
    public GradableCategory(String name, double weight){

        //create an id by some rule;
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
