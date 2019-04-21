package controller;

import java.util.ArrayList;
import model.Course;
import model.Database;

public class CourseSelectionController implements CourseSelection{
	
	public CourseSelectionController()
	{}
	
	@Override
	public ArrayList<Course> getAllCourses() {
		ArrayList<Course> listOfCourses= Database.getAllCourses();
		return listOfCourses;
	}
}
