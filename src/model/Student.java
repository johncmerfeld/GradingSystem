package model;

public class Student{
    private int BU_Id;
    private Name name;
    private String email;
    private boolean isGradStudent;
    Student(int Id, Name name, String email,boolean isGradStudent){
        this.BU_Id = Id;
        this.name = name;
        this.email = email;
        this.isGradStudent = isGradStudent;
    }

    public int getBUId() {
        return BU_Id;
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

    public void setGradStudent(boolean gradStudent) {
        isGradStudent = gradStudent;
    }

    public void setBU_Id(int BU_Id) {
        this.BU_Id = BU_Id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
