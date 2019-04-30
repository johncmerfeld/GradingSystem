package model;

public class Name {
    String firstName = "";
    String middleName = "";
    String lastName = "";
    Name(){}
    public Name(String firstName, String middleInitial, String lastName){
        this.firstName = firstName;
        this.middleName = middleInitial;
        this.lastName = lastName;
    }

    Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleInitial) {
        this.middleName = middleInitial;
    }

    public String getName(){
        if(this.firstName.equals(""))
            return "";
        if(middleName == null){
            return firstName + " " + lastName;
        }
        return firstName + " " + middleName + " " + lastName;
    }
}
