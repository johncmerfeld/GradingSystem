package Backend;

public class Grade {
    private int gid;
    private int sid;
    private double score;
    Grade(int gid,int sid, double score){
        this.gid = gid;
        this.sid = sid;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public int getGid() {
        return gid;
    }

    public int getSid() {
        return sid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
