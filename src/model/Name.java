package model;

public class Name {
    String firstName = "";
    char middleInitial = ' ';
    String lastName = "";
    Name(){}
    public Name(String firstName, char middleInitial, String lastName){
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }

    Name(String firstName, String lastName){
        this.firstName = firstName;
        //this.middleInitial = middleInitial;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
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

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getName(){
        if(this.firstName.equals(""))
            return "";
        if(middleInitial == ' '){
            return firstName+" "+lastName;
        }
        return firstName+" "+middleInitial+" "+lastName;
    }
}
