package model;
public class DatabaseTest {

	public static void main(String[] args) {
		
		Database.removeStudentFromCourse(1001, 4);
		Student s = new Student(1001, new Name("Jojo", 'J', "Jojoson"), "JJJ@bu.edu", false);
		Database.addStudentToCourse(s, 4);
		
		Course c = new Course(6, "Learning to write a letter", "Spring 1901");
		Database.addCourse(c);
		
		
	}

}
