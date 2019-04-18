package controller;

import java.util.HashMap;
import java.util.Locale.Category;

import model.Course;

public interface Coursework {
	public HashMap<Integer, String> getAllScoringMethods();
	public HashMap<Integer, Category> getAllCourseworkCategories();
	public Course createNewCourseWork(String courseWorkName, int categoryId, int maxPoints, int scoringMethodId);
}
