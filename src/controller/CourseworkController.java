package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale.Category;
import model.Database;
import model.GradableCategory;
import model.GradableItem;
import model.ScoringMethod;

public class CourseworkController implements Coursework{

	public CourseworkController(){}
	
	@Override
	public ArrayList<ScoringMethod> getAllScoringMethods() {
		ArrayList<ScoringMethod> listOfScoringMethods = Database.getScoringMethods();
		return listOfScoringMethods;
	}

	@Override
	public ArrayList<GradableCategory> getAllCourseworkCategories(int courseId) {
		ArrayList<GradableCategory> categories = Database.getCategoriesInCourse(courseId);
		return categories;
	}

	@Override
	public void createNewCourseWork(String courseWorkName, int categoryId, int maxPoints, int scoringMethodId) {
		GradableItem gradableItem = new GradableItem(courseWorkName, maxPoints, scoringMethodId, 0);
		Database.addGradedItem(gradableItem, categoryId);
	}

}
