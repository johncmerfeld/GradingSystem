package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Database;
import model.GradableCategory;
import model.GradableItem;

public class GradingRubricController implements GradingRubric{

	private HashMap<GradableCategory, ArrayList<GradableItem>> gradingRubric;
	private int courseId;
	
	public GradingRubricController(int courseId)
	{
		this.courseId = courseId;
		setRubric(courseId);
	}
	
	public void setRubric(int courseId)
	{
		ArrayList<GradableCategory> listOfCategories = Database.getCategoriesInCourse(courseId);
		
		for(GradableCategory gc : listOfCategories)
		{
			ArrayList<GradableItem> listOfGradableItems = Database.getGradedItemsInCategory(gc.getId());
			this.gradingRubric.put(gc, listOfGradableItems);
		}
	}
	
	@Override
	public HashMap<GradableCategory, ArrayList<GradableItem>> getGradingRubric() 
	{
		return this.gradingRubric;
	}

	@Override
	public HashMap<GradableCategory, ArrayList<GradableItem>> updateGradingRubric(HashMap<GradableCategory, ArrayList<GradableItem>> new_gradingRubric) 
	{
		for (Map.Entry<GradableCategory, ArrayList<GradableItem>> entry : new_gradingRubric.entrySet()) 
		{
			GradableCategory gc = entry.getKey();
			Database.updateCategory(gc);
			ArrayList<GradableItem> listOfGradableItems = entry.getValue();
			for(GradableItem gi : listOfGradableItems)
			{
				Database.updateGradableItem(gi);
			}
		}
		
		setRubric(courseId);
		return this.gradingRubric;
	}

}
