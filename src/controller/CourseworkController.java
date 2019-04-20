package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale.Category;
import model.Database;
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
	public HashMap<Integer, Category> getAllCourseworkCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createNewCourseWork(String courseWorkName, int categoryId, int maxPoints, int scoringMethodId) {
		GradableItem gradableItem = new GradableItem(courseWorkName, maxPoints, scoringMethodId, 0);
		Database.addGradedItem(gradableItem, categoryId);
	}

}
