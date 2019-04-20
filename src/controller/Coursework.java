package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale.Category;

import model.Course;
import model.ScoringMethod;

//Page : https://jus69c.axshare.com/#g=1&p=create_course_work-p6

public interface Coursework {
	public ArrayList<ScoringMethod> getAllScoringMethods();
	public HashMap<Integer, Category> getAllCourseworkCategories();
	public void createNewCourseWork(String courseWorkName, int categoryId, int maxPoints, int scoringMethodId);
}
