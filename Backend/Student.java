package Backend;

public class Student{
    private int studetnId;
    private Name name;
    private String email;
    private boolean isGradStudent;
    Student(int studetnId, Name name, String email,boolean isGradStudent){
        this.studetnId = studetnId;
        this.name = name;
        this.email = email;
        this.isGradStudent = isGradStudent;
    }

    public int getStudetnId() {
        return studetnId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isGradStudent() {
        return isGradStudent;
    }
}
