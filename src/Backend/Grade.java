package Backend;

public class Grade {
    private int id;
    private double score;
    private String note;
    Grade(double score, String note){
        this.score = score;
        this.note = note;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}