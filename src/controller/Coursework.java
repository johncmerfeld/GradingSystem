package controller;

import java.util.HashMap;
import java.util.Locale.Category;

import model.Course;

//Page : https://jus69c.axshare.com/#g=1&p=create_course_work-p6

public interface Coursework {
	public HashMap<Integer, String> getAllScoringMethods();
	public HashMap<Integer, Category> getAllCourseworkCategories();
	public Course createNewCourseWork(String courseWorkName, int categoryId, int maxPoints, int scoringMethodId);
}
