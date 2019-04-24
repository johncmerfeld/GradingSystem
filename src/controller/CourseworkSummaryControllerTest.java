package controller;

public class CourseworkSummaryControllerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CourseworkSummaryController c1 = new CourseworkSummaryController(1);
		System.out.println(c1.getCourse(1).getCourseName());
		System.out.println(c1.getCourse(1).getCourseSemester());
		
		

	}

}
